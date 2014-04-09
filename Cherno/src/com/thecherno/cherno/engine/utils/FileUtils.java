package com.thecherno.cherno.engine.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileUtils {

	private FileUtils() {
	}

	public static String loadText(String path) {
		String result = "";
		try {
			BufferedReader reader = new BufferedReader(new FileReader(path));
			String buffer;
			while ((buffer = reader.readLine()) != null) {
				result += buffer + "\n";
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
}
