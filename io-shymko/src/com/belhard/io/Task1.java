package com.belhard.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Task1 {

	public static void main(String[] args) throws IOException {
		String inputTxt = Util.readFile("resources/in/text.txt");
		String editedTxt = inputTxt.replaceAll("\\ +", " ").trim()
				.replaceAll("\\t+", " ")
				.replaceAll("\\n{2,}", "########")
				.replaceAll("\\n", " ")
				.replaceAll("\\ +", " ")
				.replaceAll("\\ \\.", ".")
				.replaceAll("\\ \\,", ",")
				.replaceFirst("^", "\t");
		String[] editedArrayTxt = editedTxt.split("(?<=\\G.{120})");
		editedTxt = String.join("\n", editedArrayTxt);

		editedTxt = editedTxt.replaceAll("(#{8}\\s)|#{8}", "\n\t"); 
		
		Files.createDirectories(Paths.get("resources/out"));

		Util.fileWriteOver(editedTxt, "resources\\out\\formattedText.txt");

		System.out.println(editedTxt);
	}

}
