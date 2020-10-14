//A Java program for a Client 
import java.net.*;
import java.io.*;

public class Client {
	// initialize socket and input output streams
	private Socket socket = null;
	private BufferedReader input = null;
	private PrintWriter out = null;

	// establish a connection
	public Client(String address, int port) {
		try {
			socket = new Socket(address, port);
			System.out.println("Connected - Enter file path");
			// takes input from terminal
			input = new BufferedReader(new InputStreamReader(System.in));
			// sends output to the socket
			out = new PrintWriter(socket.getOutputStream(), true);
		} catch (UnknownHostException u) {
			System.out.println(u);
		} catch (IOException i) {
			System.out.println(i);
		}

		try {
			String line = input.readLine();
			out.println(line);
		} catch (IOException i) {
			System.out.println(i);
		}
		
		
		// close the connection
		try {
			input.close();
			out.close();
			socket.close();
		} catch (IOException i) {
			System.out.println(i);
		}
	}

	public static void main(String args[]) {
		Client client = new Client("127.0.0.1", 8080);
	}
}