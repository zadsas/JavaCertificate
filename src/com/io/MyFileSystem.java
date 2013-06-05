package com.io;

import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MyFileSystem {

	public static void main(String[] args) {
		// Reference to the filesystem accessible by the JVM
		java.nio.file.FileSystem fs = FileSystems.getDefault();

		System.out.println("SEPARATOR: " + fs.getSeparator());

		Iterable<Path> rootDirectories = fs.getRootDirectories();
		for (Path path : rootDirectories) {
			System.out.println("ROOT: " + path);
		}

		Iterable<FileStore> fileStores = fs.getFileStores();
		for (FileStore fstore : fileStores) {
			System.out.println("File store: " + fstore);
		}

		// Absolute paths
		System.out.println("\nABSOLUTE PATHS");
		Path path = fs.getPath("C:/Users/fbg/Desktop/file.txt");
		System.out.println("ROOT: " + path.getRoot());
		System.out.println("Exists?: " + Files.exists(path));
		System.out.println("ABSOLUTE PATH: " + path.toAbsolutePath());
		try {
			System.out.println("REAL PATH: " + path.toRealPath());
		} catch (IOException e) {
			System.out.println("NO REAL PATH BECAUSE THE FILE DOESNT EXIST");
		}
		System.out.println("FILENAME: " + path.getFileName());
		for (Path part : path) {
			System.out.println(part);
		}

		// Relative paths
		System.out.println("\nRELATIVE PATHS");
		path = fs.getPath("bin/com/io/FileSystem.class");
		System.out.println("ROOT: " + path.getRoot());
		System.out.println("Exists?: " + Files.exists(path));
		System.out.println("ABSOLUTE PATH: " + path.toAbsolutePath());
		try {
			System.out.println("REAL PATH: " + path.toRealPath());
		} catch (IOException e) {
			System.out.println("NO REAL PATH BECAUSE THE FILE DOESNT EXIST");
		}
		System.out.println("FILENAME: " + path.getFileName());
		for (Path part : path) {
			System.out.println(part);
		}

		// Normalize paths
		System.out.println("\nNORMALIZE PATHS");
		path = Paths.get("/home/docs/../music/SpaceMachine A.mp3"); 
		System.out.println("Absolute path: " + path.toAbsolutePath());
		System.out.println("URI: " + path.toUri());
		System.out.println("Normalized Path: " + path.normalize());
		System.out.println("Normalized URI: " + path.normalize().toUri());

		// Resolve paths
		System.out.println("\nRESOLVE PATHS");
		Path rootPath = Paths.get("/home/docs");
		Path partialPath = Paths.get("users.txt");
		Path resolvedPath = rootPath.resolve(partialPath);
		System.out.println("rootPath: " + rootPath);
		System.out.println("partialPath: " + partialPath);
		System.out.println("resolvedPath: " + resolvedPath);
		System.out.println("Resolved absolute path: "
				+ resolvedPath.toAbsolutePath());
	}
}
