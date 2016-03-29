package network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class NetworkClient implements Runnable{
	
	private Thread thread;
	
	private static Socket socket = null;
	private static DataInputStream input = null;
	private static DataOutputStream output = null;
	
	private static String host = "localhost";
	private static int port = 9000;
	
	public NetworkClient() {
	}
	
	public void start(){
		
		thread = new Thread(this, "Client");
		try {
			openConn();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		thread.start();
	}
	
	private void openConn() throws IOException{
		socket = new Socket(host, port);  
		output = new DataOutputStream(socket.getOutputStream());		
		input = new DataInputStream(socket.getInputStream());
	}
	
	private void closeConn() throws IOException{
		socket.close();
	}
	
	public void sendUpdate(){
		System.err.println("UPDATE HIT");
		try {
			
			output.writeUTF("Move: 1");
			output.flush();
		} catch (IOException e) {
			System.err.println("Exception sending move update to server: " + e.getMessage());
		}
	}
	
	public void run(){
		System.out.println("Network Client started...");
		while(true){
			System.err.println("Waiting for input");
			try {
				String serverResponse = input.readUTF();
				output.flush();
				System.out.println(serverResponse);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}
	
}
