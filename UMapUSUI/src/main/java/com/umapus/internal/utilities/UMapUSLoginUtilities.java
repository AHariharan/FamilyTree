package com.umapus.internal.utilities;

import java.security.MessageDigest;
import java.util.UUID;

public class UMapUSLoginUtilities {
	
	
    private static String encodingType = "MD5";
	private static MessageDigest encoder;
	
	public UMapUSLoginUtilities()
	{
		try
		{
			encoder = MessageDigest.getInstance(encodingType);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public static String generateActivationLink()
	{
		String genid = UUID.randomUUID().toString();
		byte[] encodedString = encoder.digest(genid.getBytes());
		return new String(encodedString);
	}
	
}
