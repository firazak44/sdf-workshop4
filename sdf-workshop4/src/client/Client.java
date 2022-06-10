import java.util.*;
import java.io.*;
import java.net.*;

public class Client {
    private static String hostName;
    public static void main(String[] args){
        Socket CLsocket = new Socket("localhost", 12345);

        try(OutputStream os = CLsocket.getOutputStream()){
            BufferedOutputStream bos = new BufferedOutputStream(os);
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            dos.writeUTF("get-cookie");
            dos.flush();

        }catch(IOException e){
            socket.close();
        }
    }
}
