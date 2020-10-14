//A Java program for a Server 
import java.net.*;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.io.*;

public class Server {
	// initialize socket and input stream
	private Socket client = null;
	private ServerSocket server = null;
	private DataInputStream in = null;
	private ArrayList<ClientHandler> clients = new ArrayList<>();
	// Setting number of threads to 10, nothing but number of clients who can talk to server	
	private static ExecutorService pool = Executors.newFixedThreadPool(10);

	// constructor with port
	public Server(int port) {
		// starts server and waits for a connection
		try {
			server = new ServerSocket(port);
			System.out.println("Server started");
			while (true) {
				System.out.println("Waiting for a client ...");
				client = server.accept();
				System.out.println("Client accepted");
				ClientHandler clientThread = new ClientHandler(client);
				clients.add(clientThread);
				pool.execute(clientThread);
			}
		} catch (IOException i) {
			System.out.println(i);
		}
	}

	public static void main(String args[]) {
		Server server = new Server(8080);
	}
}