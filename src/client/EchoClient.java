package client;
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
 
public class EchoClient {
private Socket clientSocket = null;
private BufferedReader bufferedReader = null;
 
public String getStringFromServer() {
try {
String responsString;
responsString = bufferedReader.readLine();
return responsString;
} catch (IOException e) {
System.out.println("IO Exception -- WriteBytes");
e.printStackTrace();
}
return null;
}
 
public boolean isConnected() {
return clientSocket == null && bufferedReader == null;
}
 
public void openConnection(String hostName, int port) {
try {
clientSocket = new Socket(hostName, port);
bufferedReader = new BufferedReader(new InputStreamReader(
clientSocket.getInputStream()));
 
} catch (UnknownHostException e) {
System.out.println("Unknown Host Exception");
e.printStackTrace();
} catch (IOException e) {
System.out.println("IO Exception");
e.printStackTrace();
}
}
 
public Socket getClientSocket() {
return clientSocket;
}
 
public void setClientSocket(Socket clientSocket) {
this.clientSocket = clientSocket;
}
 
public BufferedReader getBufferedReader() {
return bufferedReader;
}
 
public void setBufferedReader(BufferedReader bufferedReader) {
this.bufferedReader = bufferedReader;
}
 
public void closeConnection() {
try {
clientSocket.close();
} catch (IOException e) {
e.printStackTrace();
}
}
 
}