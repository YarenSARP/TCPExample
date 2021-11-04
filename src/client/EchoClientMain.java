package client;
 
public class EchoClientMain {
 
 public static void main(String[] args) {
EchoClient client = new EchoClient();
client.openConnection("localhost", 2222);
for(int i = 0 ; i < 10000 ; ++i)
System.out.println(client.getStringFromServer());
client.closeConnection();
 }
 
}