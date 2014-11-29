package com.umapus.controller.infrastructure.dao;

import java.util.List;
import java.util.UUID;

import javax.naming.Name;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.BasicAttribute;
import javax.naming.directory.BasicAttributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.ModificationItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.AttributesMapper;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.filter.AndFilter;
import org.springframework.ldap.filter.EqualsFilter;
import org.springframework.ldap.support.LdapNameBuilder;

import com.umapus.common.domain.entity.LDAPUser;
import com.umapus.common.domain.entity.SignUpRequest;
import com.umapus.common.domain.entity.SignUpResponse;
import com.umapus.common.domain.entity.UMapUsConstants;
import com.umapus.controller.domain.entity.SignUpStatus;
import com.umapus.controller.domain.util.HelperTools;
import com.umapus.controller.domain.util.UMapUsMapper;

public class LdapDaoImpl implements LdapDao {
	private LdapTemplate ldapTemplate;

	@Autowired
	private UMapUsConstants umapsusConstants;

	@Autowired
	private UMapUsMapper umapsusMapper;

	@Autowired
	private SignUpResponse signUpResponse;

	@Autowired
	private HelperTools helper;

	private LdapTemplate groupldapTemplate;

	public void setLdapTemplate(LdapTemplate ldapTemplate) {
		this.ldapTemplate = ldapTemplate;
	}

	public SignUpStatus CreateLDAPUser(SignUpRequest signUpRequest) {

		// List userList = this.findUserByUserId(signUpRequest.getEmail());
		LDAPUser ldapuser = this.findUserByUserId(signUpRequest.getEmail());

		if (ldapuser != null) {
			if (ldapuser.getIsuseractive().equalsIgnoreCase("false")) {
				System.out.println("User already exist and inactive");
				return new SignUpStatus(signUpResponse.ALREADY_EXISTS_INACTIVE,
						null);
			} else {
				System.out.println("User already exist and active");

				return new SignUpStatus(signUpResponse.ALREADY_EXISTS, null);
			}
		}

		String entryDN = "uid=" + signUpRequest.getEmail();

		Attribute cn = new BasicAttribute(UMapUsConstants.CN, "USER");
		Attribute sn = new BasicAttribute(UMapUsConstants.SN,
				signUpRequest.getFamilyName());
		Attribute uid = new BasicAttribute(UMapUsConstants.UID,
				signUpRequest.getEmail());
		Attribute mail = new BasicAttribute(UMapUsConstants.MAIL,
				signUpRequest.getEmail());
		Attribute userPassword = new BasicAttribute(
				UMapUsConstants.USERPASSWORD, signUpRequest.getPassword());
		Attribute graphid = new BasicAttribute(UMapUsConstants.GRAPHID, UUID
				.randomUUID().toString());
		String activationCode = helper.generateActivationCode();
		Attribute activationcode = new BasicAttribute(
				UMapUsConstants.ACTIVATIONCODE, activationCode);
		Attribute isuseractive = new BasicAttribute(
				UMapUsConstants.ISUSERACTIVE, "false");

		Attribute oc = new BasicAttribute(UMapUsConstants.OBJECTCLASS);

		oc.add(UMapUsConstants.TOP);
		oc.add(UMapUsConstants.PERSON);
		oc.add(UMapUsConstants.ORGANIZATIONALPERSON);
		oc.add(UMapUsConstants.INETORGPERSON);
		oc.add(UMapUsConstants.UMAPUSMEMBERS);

		BasicAttributes attributes = new BasicAttributes();
		attributes.put(cn);
		attributes.put(sn);
		attributes.put(mail);
		attributes.put(uid);
		attributes.put(userPassword);
		attributes.put(graphid);
		attributes.put(activationcode);
		attributes.put(isuseractive);
		attributes.put(oc);

		ldapTemplate.bind(entryDN, null, attributes);
		// addUsertoGroup(signUpRequest.getEmail());

		return new SignUpStatus(signUpResponse.SUCCESS, activationCode);

	}

	public boolean activateUser(String userId, String activationCode) {
		LDAPUser ldapuser = this.findUserByUserId(userId);

		if (ldapuser != null) {
			if (ldapuser.getIsuseractive().equalsIgnoreCase("false")) {
				System.out.println("User already exist and inactive");
				addUsertoGroup(userId);
				updateActivationAttribute(userId);
				return true;
			}
		}

		return false;
	}

	private void addUsertoGroup(String uid) {

		String DN = "uid=" + uid + ",dc=umapus,dc=com";
		String baseDn = "cn=umapusmembers";

		Name dn = LdapNameBuilder.newInstance().add("cn", "umapusmembers")
				.build();
		Attribute attr = new BasicAttribute(UMapUsConstants.UNIQUEMEMBER, DN);
		ModificationItem item = new ModificationItem(DirContext.ADD_ATTRIBUTE,
				attr);
		ldapTemplate.modifyAttributes(dn, new ModificationItem[] { item });
	}

	private void updateActivationAttribute(String uid) {

		String userdn = "uid=" + uid;
		// + ",dc=umapus,dc=com";
		// String baseDn = "cn=umapusmembers";

		Name dn = LdapNameBuilder.newInstance().add(userdn).build();
		Attribute attr = new BasicAttribute(UMapUsConstants.ISUSERACTIVE,
				"true");
		ModificationItem item = new ModificationItem(
				DirContext.REPLACE_ATTRIBUTE, attr);
		ldapTemplate.modifyAttributes(dn, new ModificationItem[] { item });
	}

	public  LDAPUser findUserByUserId(String userId) {

		List<LDAPUser> userList = this.findUserListByLDAPUserId(userId);

		if (userList.size() != 0) {

			int i = 0;

			while (userList.iterator().hasNext()) {

				LDAPUser ldapuser = (LDAPUser) userList.get(i);
				i++;

				if (ldapuser.getMail().equalsIgnoreCase(userId)) {
					return ldapuser;
				}
			}
		}

		return null;
	}

	public List findUserListByLDAPUserId(String userId) {

		AndFilter filter = new AndFilter();
		filter.and(new EqualsFilter(UMapUsConstants.OBJECTCLASS,
				UMapUsConstants.UMAPUSMEMBERS));
		filter.and(new EqualsFilter(UMapUsConstants.UID, userId));
		return ldapTemplate.search("", filter.encode(),
				new LDAPUserAttributesMapper());
	}

	private class LDAPUserAttributesMapper implements AttributesMapper {
		public Object mapFromAttributes(Attributes attrs)
				throws NamingException {
			LDAPUser ldapuser = new LDAPUser();
			ldapuser.setGraphid((String) attrs.get(UMapUsConstants.GRAPHID)
					.get());
			ldapuser.setIsuseractive((String) attrs.get(
					UMapUsConstants.ISUSERACTIVE).get());
			ldapuser.setMail((String) attrs.get(UMapUsConstants.MAIL).get());
			ldapuser.setActivationCode((String) attrs.get(
					UMapUsConstants.ACTIVATIONCODE).get());

			return ldapuser;
		}
	}

}
