package javam.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Console;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.io.Reader;
import java.io.Serializable;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.net.URL;
import java.net.URLConnection;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Deniz KALFA
 * 
 */
public class RunnerReadingAFile {
	public static void main(String[] args) throws Exception {
		// ////////////////////////////////////////////////
		// READING FROM
		// ////////////////////////////////////////////////

		//
		// BufferedReader - StringReader
		//
		Reader stringReader = new StringReader("abc\nbca");
		BufferedReader bufferedReader = new BufferedReader(stringReader);
		String readLine = null;
		while ((readLine = bufferedReader.readLine()) != null) {
			System.out.println(readLine);
		}
		bufferedReader.close();

		//
		// BufferedReader-FileReader
		//
		File file = new File("src/main/resources/temp/temp_read.txt");
		FileReader fileReader = new FileReader(file);
		BufferedReader bufferedReader1 = new BufferedReader(fileReader);
		readLine = null;
		while ((readLine = bufferedReader1.readLine()) != null) {
			System.out.println(readLine);
		}
		bufferedReader1.close();

		//
		// BufferedReader-InputStreamReader-FileInputStream
		//
		File file2 = new File("src/main/resources/temp/temp_read.txt");
		FileInputStream fileInputStream = new FileInputStream(file2);
		InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF8");
		BufferedReader bufferedReader2 = new BufferedReader(inputStreamReader);
		readLine = null;
		while ((readLine = bufferedReader2.readLine()) != null) {
			System.out.println(readLine);
		}
		bufferedReader2.close();

		//
		// BufferedReader-InputStreamReader-ClassLoader.getResourceAsStream()
		//
		InputStream inputStream = RunnerReadingAFile.class.getClassLoader().getResourceAsStream("temp/temp_read.txt");
		InputStreamReader inputStreamReader2 = new InputStreamReader(inputStream, "UTF8");
		BufferedReader bufferedReader3 = new BufferedReader(inputStreamReader2);
		readLine = null;
		while ((readLine = bufferedReader3.readLine()) != null) {
			System.out.println(readLine);
		}
		bufferedReader3.close();

		//
		// BufferedReader-System.in - IO Redirection-I
		//
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter some text: ");
		String str = "";
		while ((str = in.readLine()) != null) {
			System.out.println("You wrote: " + str);
		}

		//
		// BufferedReader-System.in-System.out - IO Redirection-II
		//
		PrintStream console = System.out;
		BufferedInputStream inputStream1 = new BufferedInputStream(new FileInputStream(
				"src/main/resources/temp/temp_read.txt"));
		PrintStream outputStream = new PrintStream(new BufferedOutputStream(new FileOutputStream(
				"src/main/resources/temp/temp_write.txt")));
		System.setIn(inputStream1);
		System.setOut(outputStream);
		System.setErr(outputStream);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String readLine2;
		while ((readLine2 = br.readLine()) != null)
			System.out.println(readLine2);
		outputStream.close(); // Remember this!
		System.setOut(console);

		//
		// Scanner
		//
		Scanner scanner = new Scanner(new FileInputStream("src/main/resources/temp/temp_read.txt"), "UTF8");
		while (scanner.hasNextLine()) {
			System.out.println(scanner.nextLine());
		}
		scanner.close();

		//
		// Scanner-System.in - Reading User input
		//
		Scanner scanner1 = new Scanner(System.in);
		System.out.println("Enter some text: ");
		while (scanner1.hasNextLine()) {
			System.out.println("You wrote: " + scanner1.next());
		}

		//
		// Scanner-String.split()
		//
		Scanner scanner2 = new Scanner(new File("src/main/resources/temp/temp_read.txt"));
		while (scanner2.hasNextLine()) {
			String[] tokens = scanner2.nextLine().split(" ");
			for (String token : tokens) {
				System.out.println(token);
			}
		}
		scanner2.close();

		//
		// Scanner-URLConnection-connection.getInputStream-Web page scanner
		//
		URLConnection connection = new URL("http://www.google.com").openConnection();
		String text = new Scanner(connection.getInputStream()).useDelimiter("\\Z").next();
		System.out.println("Result: " + text);

		//
		// Scanner - next() with delimiter
		//
		Scanner scanner3 = new Scanner("abc=bca");
		scanner3.useDelimiter("=");
		if (scanner3.hasNext()) {
			String name = scanner3.next();
			String value = scanner3.next();

			System.out.println("name: " + name + ", value: " + value);
		}

		//
		// Scanner - next() with delimiter
		//
		String content = new Scanner(new File("src/main/resources/temp/temp_read.txt")).useDelimiter("\n").next();
		System.out.println(content);

		//
		// Console - Reading User input [System.in]
		// NOT VERIFIED
		Console console1 = System.console();
		String username = console1.readLine("Username: ");
		char[] password = console1.readPassword("Password: ");

		if (username.equals("admin") && String.valueOf(password).equals("secret")) {
			console1.printf("Welcome to Java Application %1$s.\n", username);
			Arrays.fill(password, ' ');
		} else {
			console1.printf("Invalid username or password.\n");
		}

		//
		// ByteArrayOutputStream - Getting Bytes from file
		//
		byte[] buffer = new byte[4096];
		InputStream fis = new FileInputStream("src/main/resources/temp/temp_read.txt");
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		int read = 0;
		while ((read = fis.read(buffer)) != -1) {
			baos.write(buffer, 0, read);
		}
		fis.close();
		baos.close();

		//
		// FileInputStream - Getting Bytes from file without while loop-I
		//
		byte[] buffer3 = new byte[(int) file.length()];
		InputStream ios = new FileInputStream(file);
		if (ios.read(buffer3) == -1) {
			throw new IOException("EOF reached while trying to read the whole file");
		}
		ios.close();
		// return buffer3

		//
		// Getting Bytes from file with commons.io
		//
		// byte[] org.apache.commons.io.FileUtils.readFileToByteArray(File file)
		// byte[] org.apache.commons.io.IOUtils.toByteArray(InputStream input)
		//
		//
		//

		// ////////////////////////////////////////////////
		// WRITING TO
		// ////////////////////////////////////////////////

		//
		// StringWriter
		//
		Writer stringWriter = new StringWriter();
		stringWriter.write("test");
		System.out.println(stringWriter.toString());
		stringWriter.close();

		//
		// BufferedWriter-FileWriter-I
		//
		File file3 = new File("src/main/resources/temp/temp_write.txt");
		FileWriter fileWriter = new FileWriter(file3);
		BufferedWriter bufferedWriter1 = new BufferedWriter(fileWriter);
		bufferedWriter1.write("test");
		bufferedWriter1.flush();
		bufferedWriter1.close();

		//
		// BufferedWriter-FileWriter-II
		//
		FileWriter fileWriter2 = new FileWriter("src/main/resources/temp/temp_write.txt");
		BufferedWriter bufferedWriter2 = new BufferedWriter(fileWriter2);
		bufferedWriter2.write("test2");
		bufferedWriter2.flush();
		bufferedWriter2.close();

		//
		// BufferedWriter-FileWriter-III with append
		//
		boolean append = true;
		FileWriter fileWriter3 = new FileWriter("src/main/resources/temp/temp_write.txt", append);
		BufferedWriter bufferedWriter3 = new BufferedWriter(fileWriter3);
		bufferedWriter3.write("test3");
		bufferedWriter3.flush();
		bufferedWriter3.close();

		//
		// BufferedOutputStream-FileOutputStream
		//
		boolean append2 = false;
		FileOutputStream fos = new FileOutputStream("src/main/resources/temp/temp_write.txt", append2);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		bos.write("test4".getBytes());
		bos.flush();
		bos.close();

		//
		// PrintWriter
		//
		boolean append3 = false;
		PrintWriter printWriter = new PrintWriter(new FileWriter("src/main/resources/temp/temp_write.txt", append3));
		printWriter.println("test");
		printWriter.println("test1");
		printWriter.flush();
		printWriter.close();

		//
		// ObjectOutputStream-FileOutputStream - Storing objects to a file
		//
		FileOutputStream fos2 = new FileOutputStream("src/main/resources/temp/temp_write.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos2);

		Book book = new Book("0-07-222565-3", "Hacking Exposed J2EE & Java", "Art Taylor, Brian Buege, Randy Layman");
		System.out.println(book.toString());
		oos.writeObject(book);
		oos.flush();
		oos.close();

		FileInputStream fis2 = new FileInputStream("src/main/resources/temp/temp_write.txt");
		ObjectInputStream ois = new ObjectInputStream(fis2);

		book = (Book) ois.readObject();
		System.out.println(book.toString());
		ois.close();

		// ////////////////////////////////////////////////
		// READ - WRITE
		// ////////////////////////////////////////////////

		//
		// FileInputStream-FileOutputStream - Copying a file
		//
		FileInputStream fis1 = new FileInputStream("src/main/resources/temp/temp_read.txt");
		FileOutputStream fos1 = new FileOutputStream("src/main/resources/temp/temp_write.txt");
		byte[] buffer2 = new byte[4096];
		int read2;
		while ((read2 = fis1.read(buffer2)) != -1) {
			fos1.write(buffer2, 0, read2);
		}
		fis1.close();
		fos1.close();

		//
		// FileInputStream-FileOutputStream-FileChannel - Copying a file
		//
		FileChannel sourceChannel = new FileInputStream("src/main/resources/temp/temp_read.txt").getChannel();
		FileChannel targetChannel = new FileOutputStream("src/main/resources/temp/temp_write.txt").getChannel();

		ByteBuffer buffer1 = ByteBuffer.allocate(1024);
		int read1;
		while ((read1 = sourceChannel.read(buffer1)) != -1) {
			buffer1.flip();
			targetChannel.write(buffer1);
			buffer1.clear();
		}
		sourceChannel.close();
		targetChannel.close();

		//
		// FileInputStream-FileOutputStream-FileChannel.transferFrom - Copying a
		// file
		//
		File source = new File("src/main/resources/temp/temp_read.txt");
		File target = new File("src/main/resources/temp/temp_write.txt");
		FileChannel sourceChannel1 = new FileInputStream(source).getChannel();
		FileChannel targetChannel1 = new FileOutputStream(target).getChannel();

		targetChannel1.transferFrom(sourceChannel1, 0, sourceChannel1.size());
		sourceChannel1.close();
		targetChannel1.close();

		// ////////////////////////////////////////////////
		// RANDOM ACCESS
		// ////////////////////////////////////////////////

		//
		// RandomAccessFile-I
		//
		File f = new File("src/main/resources/temp/temp_read.txt");
		RandomAccessFile raf = new RandomAccessFile(f, "rw");

		char ch = raf.readChar(); // Read a character
		raf.seek(f.length()); // Seek to end of file
		raf.writeChars("aString"); // Append to the end

		raf.seek(0);
		String readLine1;
		while ((readLine1 = raf.readLine()) != null) {
			System.out.println(readLine1);
		}

		//
		// RandomAccessFile-II
		//
		RandomAccessFile raf1 = new RandomAccessFile("src/main/resources/temp/temp_write.txt", "rw");
		raf1.writeDouble(3.1415);
		raf1.writeInt(42);
		raf1.seek(0);
		System.out.println(raf1.readDouble() + " " + raf1.readInt());
		raf1.close();

		//
		// RandomAccessFile-III
		//
		RandomAccessFile raf2 = new RandomAccessFile("src/main/resources/temp/temp_write.txt", "rw");
		String books[] = new String[5];
		books[0] = "Professional JSP";
		books[1] = "The Java Application Programming Interface";
		books[2] = "Java Security";
		books[3] = "Java Security Handbook";
		books[4] = "Hacking Exposed J2EE & Java";

		for (int i = 0; i < books.length; i++) {
			raf2.writeUTF(books[i]);
		}

		raf2.seek(raf2.length()); // Write another data at the end of the file.
		raf2.writeUTF("Servlet & JSP Programming");

		raf2.seek(0);
		while (raf2.getFilePointer() < raf2.length()) {
			System.out.println(raf2.readUTF());
		}

		// ////////////////////////////////////////////////
		// OTHERS
		// ////////////////////////////////////////////////

		//
		// LineNumberReader-I
		//
		FileReader fileReader1 = new FileReader("src/main/resources/temp/temp_read.txt");
		LineNumberReader lnr = new LineNumberReader(fileReader1);
		
		String line = "";
		while ((line = lnr.readLine()) != null) {
			System.out.println("Line Number " + lnr.getLineNumber() + ": " + line);
		}

		//
		// LineNumberReader-II
		// If file does not end with EOF char, it counts 1 less line!!!
		FileReader fileReader2 = new FileReader("src/main/resources/temp/temp_read.txt");
		LineNumberReader lnr1 = new LineNumberReader(fileReader2);
		lnr1.skip(Long.MAX_VALUE);
		
		System.out.println("Number of lines: " + lnr1.getLineNumber());

		//
		// InputStream-StringWriter - Converting stream to string
		//
		FileInputStream fileInputStream2 = new FileInputStream("src/main/resources/temp/temp_read.txt");
		Reader reader = new BufferedReader(new InputStreamReader(fileInputStream2, "UTF-8"));
		Writer writer = new StringWriter();

		char[] buffer4 = new char[1024];
		int n;
		while ((n = reader.read(buffer4)) != -1) {
			writer.write(buffer4, 0, n);
		}
		fileInputStream2.close();
		System.out.println(writer.toString());

		//
		// ByteArrayInputStream-String - Converting string to stream
		//
		String text1 = "Converting String to InputStream Example";
		InputStream bais = new ByteArrayInputStream(text1.getBytes("UTF-8"));
		BufferedInputStream bufferedInputStream = new BufferedInputStream(bais);

		FileOutputStream fileOutputStream = new FileOutputStream("src/main/resources/temp/temp_write.txt");
		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

		byte[] buffer5 = new byte[1024];
		int read3;
		while ((read3 = bufferedInputStream.read(buffer5)) != -1) {
			bufferedOutputStream.write(buffer5, 0, read3);
		}

		//
		// MappedByteBuffer - Mapping an entire file into memory for reading
		//
		File file4 = new File("src/main/resources/temp/temp_read.txt");
		FileChannel channel = new FileInputStream(file4).getChannel();
		MappedByteBuffer mappedByteBuffer = channel.map(FileChannel.MapMode.READ_ONLY, 0, file4.length());
		int i = 0;
		while (i < file4.length())
			System.out.print((char) mappedByteBuffer.get(i++));

		//
		// MappedByteBuffer - Creating a very large file using mapping with
		// read-write mod
		//
		int length = 0x8FFFFFF; // 128 Mb
		FileChannel channel2 = new RandomAccessFile("src/main/resources/temp/temp_write.txt", "rw").getChannel();
		MappedByteBuffer mappedByteBuffer2 = channel2.map(FileChannel.MapMode.READ_WRITE, 0, length);
		for (int i1 = 0; i1 < length; i1++)
			mappedByteBuffer2.put((byte) 'x');
		System.out.println("Finished writing");
		for (int i2 = length / 2; i2 < length / 2 + 6; i2++)
			System.out.print((char) mappedByteBuffer2.get(i2));
	}

	public static class Book implements Serializable {
		private String isbn;
		private String title;
		private String author;

		public Book(String isbn, String title, String author) {
			this.isbn = isbn;
			this.title = title;
			this.author = author;
		}

		public String toString() {
			return "[Book: " + isbn + ", " + title + ", " + author + "]";
		}
	}
}
