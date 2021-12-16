package com.belhard.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Util {
	public static String readFile(String filePath) {
		StringBuilder res = new StringBuilder();
		try (BufferedReader in = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = in.readLine()) != null) {
				res.append(line).append("\n");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return res.toString();
	}

	public static void fileWriteOver(String content, String filePath) {
		try (BufferedWriter out = new BufferedWriter(new FileWriter(filePath))) {
			out.write(content);
		} catch (IOException e) {

		}
	}

	public static void fileWriteOver(String content, File file) {
		try (BufferedWriter out = new BufferedWriter(new FileWriter(file))) {
			out.write(content);
		} catch (IOException e) {

		}
	}

	public static void fileWriter(String content, String filePath) {
		try (BufferedWriter out = new BufferedWriter(new FileWriter(filePath, true))) {
			out.write(content);
		} catch (IOException e) {

		}
	}

	public static void fileWriter(String content, File file) {
		try (BufferedWriter out = new BufferedWriter(new FileWriter(file, true))) {
			out.write(content);
		} catch (IOException e) {

		}
	}

	public static void copyFileUsingStream(File source, File dest) throws IOException {
		OutputStream os = new FileOutputStream(dest);
		try (InputStream is = new FileInputStream(source);) {
			byte[] buffer = new byte[1024];
			int length;
			while ((length = is.read(buffer)) > 0) {
				os.write(buffer, 0, length);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
