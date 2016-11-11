package com.podiumcr.jpa.resources;

import java.util.Random;

public class CodeGenerator {
	
	private static final Random random = new Random();
	private static final String CHARS = "ABCDEFGHJKLMNOPQRSTUVWXYZ1234567890";

	public CodeGenerator(){}
	
	public String getToken(int length) {
	    StringBuilder token = new StringBuilder(length);
	    for (int i = 0; i < length; i++) {
	        token.append(CHARS.charAt(random.nextInt(CHARS.length())));
	    }
	    return token.toString();
	}
	
}
