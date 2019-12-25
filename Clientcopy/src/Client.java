import java.net.*; 
import java.io.*; 

public class Client {
	private Socket clientsocket = null;
	private Reader clientinput = null;
    private DataOutputStream clientoutput = null;
    
    @SuppressWarnings("deprecation")
	public Client(String ip, int port) {
    	try {
			clientsocket = new Socket (ip, port);
			//clientinput  = new DataInputStream(System.in);
			clientoutput = new DataOutputStream(clientsocket.getOutputStream());
			System.out.println("hi ishan");
			String input = "";
	    	BufferedReader br = new BufferedReader(new InputStreamReader(clientsocket.getInputStream()));
	    	while(!input.equals("Hello Ishan")) {
	    		try {
					input = br.readLine();
					clientoutput.writeUTF(input);
				} catch (IOException e) {
					System.out.println(e);
				}
	    	}
		} catch (UnknownHostException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}
    	
    }
    
    public static void main(String args[]) { 
        Client client = new Client("127.0.0.1", 5001); 
    } 
}