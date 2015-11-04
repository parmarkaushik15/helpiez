package com.kaushik.helpiez.webservice;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

public final class PasswordUtility {
	private static final Random RANDOM = new SecureRandom();
	private static final int PASSWORD_LENGTH = 8;
	
	public static String generatePassword()
	{
		String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890abcdefghijklmnopqrstuvwxyz";

	      String password = "";
	      for (int i=0; i<PASSWORD_LENGTH; i++)
	      {
	          int index = (int)(RANDOM.nextDouble()*letters.length());
	          password += letters.substring(index, index+1);
	      }
	      return password;
	}
	public static String tokenGeneration()
	{
		String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890abcdefghijklmnopqrstuvwxyz";

	      String token = "";
	      for (int i=0; i<30; i++)
	      {
	          int index = (int)(RANDOM.nextDouble()*letters.length());
	          token += letters.substring(index, index+1);
	      }
	      return token;
	}
	public static String generateKey()
	{
		SecureRandom sr;
		byte[] salt = new byte[16];
		try{
			sr = SecureRandom.getInstance("SHA1PRNG");
	        sr.nextBytes(salt);
		}catch (NoSuchAlgorithmException e){
			e.printStackTrace();
		}
		return salt.toString();
	}
	public static String digestPassword(String password, String key)
	{ 
		String generatePassword=null;
		try{
			MessageDigest messageDigest = MessageDigest.getInstance("SHA-512");
			messageDigest.update(key.getBytes());
			byte[] bytes = messageDigest.digest(password.getBytes());
			StringBuilder sb = new StringBuilder();
			for(int i=0; i< bytes.length ;i++)
	        {
	            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
	        }
	        generatePassword = sb.toString();
		}catch(NoSuchAlgorithmException ex){
			ex.printStackTrace();
		}
		return generatePassword;
	}
}
