package com.belhard.io;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;

public class Task2 {

	public static void main(String[] args) throws IOException {

		Files.createDirectories(Paths.get("resources/out"));
		String log = null;
		String date = new Date().toString();

		File inputPath = new File("resources\\in\\");
		File outputPath = new File("resources\\out\\");
		FilenameFilter filter = new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				return name.endsWith(".jpg");
			}
		};
		File[] matchingFiles = inputPath.listFiles(filter);
		for (int i = 0; i < matchingFiles.length; i++) {
			outputPath = new File("resources\\out\\" + matchingFiles[i].getName());
			Util.copyFileUsingStream(matchingFiles[i], outputPath);

			log = "\nCopy date is: " + date + "\nSource name is: " + matchingFiles[i].getName().toString()
					+ "\nNewFile name is: " + outputPath.getName().toString() + "\nFile Size is: " + matchingFiles[i].length();
			Util.fileWriter(log, "resources\\out\\copyLogFile.txt");

		}

	}

}
