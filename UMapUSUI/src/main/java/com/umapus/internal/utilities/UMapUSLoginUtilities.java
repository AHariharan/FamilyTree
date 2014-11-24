package com.umapus.internal.utilities;

import java.math.BigInteger;
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
		String genid = UUID.randomUUID().toString()+UUID.randomUUID().toString()+UUID.randomUUID().toString();
		byte[] encodedString = encoder.digest(genid.getBytes());
		BigInteger number = new BigInteger(1, encodedString);
        String hashtext = number.toString(16);
        while (hashtext.length() < 32) {
            hashtext = "0" + hashtext;
        }
        return hashtext;
		
	}
	
}
