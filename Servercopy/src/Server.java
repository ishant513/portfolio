import java.net.*;
import java.io.*;

public class Server {
	private Socket serversock = null; 
    private ServerSocket server = null; 
    private DataInputStream input=  null; 
    
    public Server(int port) {
    	try {
			server = new ServerSocket(port);
			serversock = server.accept();
			System.out.println("accepted");
			input = new DataInputStream(new BufferedInputStream(serversock.getInputStream()));
			String reader = "";
			while (!reader.equals("Hi Ishan")) {
				try {
					reader = input.readUTF(); 
					System.out.println(reader);
				} catch(IOException e) {
					System.out.println(e);
				}
			}
			serversock.close(); 
            input.close();
		} catch (IOException e) {
			System.out.println(e);
		}
    }
    
    public static void main(String args[]) 
    { 
        Server server = new Server(5001); 
    } 
}
