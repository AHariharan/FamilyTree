package com.umapus.controller.domain.util;

import java.math.BigInteger;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.MessageFormat;
import java.util.UUID;

import com.umapus.common.domain.entity.UMapUsConstants;

public class HelperTools {

	private static MessageDigest encoder;
	private String baseActivationUrl;

	public String getBaseActivationUrl() {
		return this.baseActivationUrl;
	}

	public void setBaseActivationUrl(String baseActivationUrl) {
		this.baseActivationUrl = baseActivationUrl;
	}

	public String generateActivationCode() {
		String hashtext = null;
		String genid = UUID.randomUUID().toString()
				+ UUID.randomUUID().toString() + UUID.randomUUID().toString();
		try {
			encoder = MessageDigest
					.getInstance(UMapUsConstants.ActivationAuthHashType);
			byte[] encodedString = encoder.digest(genid.getBytes());
			BigInteger number = new BigInteger(1, encodedString);
			hashtext = number.toString(16);
			while (hashtext.length() < 32) {
				hashtext = "0" + hashtext;
			}

		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return hashtext;

	}

	public URI generateActivationUrl(String userId, String activationCode) {
		String stringActivationUrl = MessageFormat.format(baseActivationUrl
				+ "/activate/account?id={0}&authtoken={1}", userId,
				activationCode);
		URI activationuri = null;
		try {
			activationuri = new URI(stringActivationUrl);

		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return activationuri;

	}
}
