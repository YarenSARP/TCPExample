package server;
 
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
 
public class EchoServer {
private ServerSocket echoServer;
private PrintStream outputsStream;
private Socket clientSocket;
 
public EchoServer(int port) {
try {
echoServer = new ServerSocket(port);
System.out.println("Server Builded");
} catch (IOException e) {
System.out.println("Port Error!!!");
e.printStackTrace();
}
}
 
public boolean openConnection() {
try {
clientSocket = echoServer.accept();
outputsStream = new PrintStream(clientSocket.getOutputStream());
System.out.println("Connection Establised!");
 
return true;
} catch (IOException e) {
System.out.println("Connection Error!!!");
e.printStackTrace();
return false;
}
}
 
public void putStringToSocket(String msg) {
outputsStream.println(msg);
}
 
public boolean closeConnection() {
try {
clientSocket.close();
System.out.println("Connection Closed!!!");
return true;
} catch (IOException e) {
System.out.println("Closing Error!!!");
e.printStackTrace();
}
return false;
}
 
public ServerSocket getEchoServer() {
return echoServer;
}
 
public void setEchoServer(ServerSocket echoServer) {
this.echoServer = echoServer;
}
 
public PrintStream getOutputsStream() {
return outputsStream;
}
 
public void setOutputsStream(PrintStream outputsStream) {
this.outputsStream = outputsStream;
}
 
public Socket getClientSocket() {
return clientSocket;
}
 
public void setClientSocket(Socket clientSocket) {
this.clientSocket = clientSocket;
}
 
}