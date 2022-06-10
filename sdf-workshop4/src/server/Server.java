import java.util.*;
import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[]args){

        try(ServerSocket SVsocket = new ServerSocket(12345);){
            System.out.println("Server listening on port 12345");
            while(true){
                Socket CLsocket = SVsocket.accept();
                System.out.println("New client connected");
            }
        }catch(IOException e){
            System.out.println("Server unavailable");
            e.printStackTrace();
        }
    }
}
