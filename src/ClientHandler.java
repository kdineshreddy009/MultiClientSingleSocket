package src;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ClientHandler implements Runnable {
	private Socket client;
	private BufferedReader in;
	private PrintWriter out;

	public ClientHandler(Socket clientSocket) throws IOException {
		this.client = clientSocket;
		in = new BufferedReader(new InputStreamReader(client.getInputStream()));
		out = new PrintWriter(client.getOutputStream(), true);
	}

	@Override
	public void run() {
		String line = "";
		try {
			line = in.readLine();
			String source = line;
			String zipFileName = line.substring(line.lastIndexOf("/") + 1) + ".zip";
			try {
				ClientHandler.zipSingleFile(source, zipFileName);
			} catch (IOException e) {
				e.printStackTrace();
			}

		} catch (IOException i) {
			System.err.println(i);
		} finally {
			System.out.println("Closing connection of this client");
			out.close();
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// module for zipping a file to specific title
	synchronized public static void zipSingleFile(String source, String zipFileName) throws IOException {
		try {
			FileOutputStream fos = new FileOutputStream(zipFileName);
			ZipOutputStream zipOut = new ZipOutputStream(fos);
			File fileToZip = new File(source);
			FileInputStream fis = new FileInputStream(fileToZip);
			ZipEntry zipEntry = new ZipEntry(fileToZip.getName());
			zipOut.putNextEntry(zipEntry);
			byte[] bytes = new byte[1024];
			int length;
			while ((length = fis.read(bytes)) >= 0) {
				zipOut.write(bytes, 0, length);
			}
			zipOut.close();
			fis.close();
			fos.close();
			System.out.println("Zipped file:" + source);
			System.out.println("Stored at path:-" + System.getProperty("user.dir"));
		} catch (Exception e) {
			System.err.println("Failed zipping:- " + e.getMessage());
		}
	}

}
