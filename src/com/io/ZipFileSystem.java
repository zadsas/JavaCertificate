package com.io;

import java.net.URI;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class ZipFileSystem {
	public static void main(String[] args) throws Exception {

		Map<String, String> attributes = new HashMap<>();
		attributes.put("create", "true");
		URI zipFile = URI.create("jar:file:///C:/Users/fbg/test.zip");

		try (FileSystem zipFileSys = FileSystems.newFileSystem(zipFile, attributes);) {
			Path path = zipFileSys.getPath("docs");
			Files.createDirectory(path);
			try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(zipFileSys.getPath("/"));) {
				for (Path file : directoryStream) {
					System.out.println(file.getFileName());
				}
			}
		}
	}
}
