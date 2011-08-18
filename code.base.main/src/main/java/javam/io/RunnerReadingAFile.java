package javam.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;

/**
 * @author Deniz KALFA
 *
 */
public class RunnerReadingAFile {
	public static void main(String[] args) throws URISyntaxException, IOException {
		File file = new File("src/main/resources/temp/temp.txt");
		FileReader fileReader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String readLine = null;
		while((readLine = bufferedReader.readLine()) != null) {
			System.out.println(readLine);
		}
		
		File file2 = new File("src/main/resources/temp/temp.txt");
		FileInputStream fileInputStream = new FileInputStream(file2);
		InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF8");
		BufferedReader bufferedReader2 = new BufferedReader(inputStreamReader);
		readLine = null;
		while((readLine = bufferedReader2.readLine()) != null) {
			System.out.println(readLine);
		}
		
		InputStream inputStream = RunnerReadingAFile.class.getClassLoader().getResourceAsStream("temp/temp.txt");
		InputStreamReader inputStreamReader2 = new InputStreamReader(inputStream, "UTF8");
		BufferedReader bufferedReader3 = new BufferedReader(inputStreamReader2);
		readLine = null;
		while((readLine = bufferedReader3.readLine()) != null) {
			System.out.println(readLine);
		}
	}
}
