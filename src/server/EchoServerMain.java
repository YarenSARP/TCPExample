package server;
 
public class EchoServerMain {
public static void main(String[] args) {
EchoServer server = new EchoServer(2222);
server.openConnection();
for(int i = 0 ; i < 10000; ++i){
server.putStringToSocket("Hello World!!!  " + i);
}
server.closeConnection();
}
}