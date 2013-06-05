package com.io;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReadDir {

	public static void main(String[] args) {
		try (DirectoryStream<Path> ds=Files.newDirectoryStream(Paths.get("c:"))) {
			for (Path p : ds) System.out.println(p.getFileName());
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
}
