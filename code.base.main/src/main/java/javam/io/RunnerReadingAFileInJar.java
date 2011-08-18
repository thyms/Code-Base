package javam.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;

/**
 * @author Deniz KALFA
 *
 */
public class RunnerReadingAFileInJar {
	public static void main(String[] args) throws URISyntaxException, IOException {
		File file = new File("src/main/resources/temp/temp.txt");
		FileReader fileReader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String readLine = bufferedReader.readLine();
		System.out.println(readLine);
		
		InputStream inputStream = RunnerReadingAFileInJar.class.getClassLoader().getResourceAsStream("temp/temp.txt");
		InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
		BufferedReader bufferedReader3 = new BufferedReader(inputStreamReader);
		String readLine2 = bufferedReader3.readLine();
		System.out.println(readLine2);
	}
}
