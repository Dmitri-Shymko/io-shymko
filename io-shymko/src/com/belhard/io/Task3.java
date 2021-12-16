package com.belhard.io;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;

public class Task3 {

	public static void main(String[] args) throws IOException {

		Files.createDirectories(Paths.get("resources/out"));
		String log = null;
		String date = new Date().toString();

		Path source = Paths.get("resources\\in\\");
		Path newdir = Paths.get("resources\\out\\");
		try (DirectoryStream<Path> stream = Files.newDirectoryStream(source, "*.jpg")) {
			for (Path entry : stream) {
				
				Files.copy(entry, newdir, StandardCopyOption.REPLACE_EXISTING);
				long size = Files.size(entry.getFileName());
				log = date + "\nSource name is: " + entry.getFileName().toString() + "\nNewFile name is: "
						+ newdir.getFileName().toString() + "\nFile Size is: " + size;
				System.out.println(entry.getFileName());
			}
		} catch (IOException x) {
			System.err.println(x);
		}

		Util.fileWriter(log, "resources\\out\\copyLogFileNio.txt");

	}

}
