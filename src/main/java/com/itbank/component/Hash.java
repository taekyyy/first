package com.itbank.component;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.stereotype.Component;

@Component
public class Hash {
	
	 public String getHash(String input) {
	      try {
	         MessageDigest md = MessageDigest.getInstance("SHA-512");
	         md.reset();
	         md.update(input.getBytes("UTF-8"));
	         String hashNumber = String.format("%0128x", new BigInteger(1, md.digest()));
	         hashNumber.substring(0, 12);
	         return hashNumber;
	         
	      } catch(NoSuchAlgorithmException | UnsupportedEncodingException e) {
	         e.printStackTrace();
	         System.out.println("알고리즘/인코딩 문제");
	      }
	      	return null;
	   }

}
