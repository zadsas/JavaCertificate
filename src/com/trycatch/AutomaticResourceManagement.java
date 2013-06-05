package com.trycatch;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class AutomaticResourceManagement {

	public static void main(String[] args) throws IOException {
		
		String input = "HOLA";
		String output;
		
		try (InputStream in = new ByteArrayInputStream(input.getBytes());
			 OutputStream out = new ByteArrayOutputStream()) {
			
			byte[] buf = new byte[8192];
			int n;
			while ((n = in.read(buf)) >= 0) out.write(buf, 0, n);
			output = out.toString();
		} 
		
		System.out.println(output);
		
	}
}
