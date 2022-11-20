package com.RefurbishedMart.util;

import java.util.Random;
import java.util.UUID;

import org.springframework.stereotype.Component;

@Component
public class UUIDUtil {
	
	public static String randomUUID(){
		UUID uuid = UUID.randomUUID();
        return uuid.toString();
	}
	
	public static String  shortRandomUUID()
	{
		Random rnd = new Random();
		int n = 100000 + rnd.nextInt(900000);
		return String.valueOf(n);
		
	}
}
