package vtpday4workshop.server;

import java.io.*;
import java.net.*;

public class Server {
    
    public static void main(String[]args){
        String serverPort = args[0];
        String cookieFilePath = args[1];

        try{
            ServerSocket SVsocket = new ServerSocket(Integer.parseInt(serverPort));
            System.out.println("Server listening on port %s" + SVsocket);

            Socket CLsocket = SVsocket.accept();
            System.out.println("Awaiting client");
            
            //Get Input stream from Client
            InputStream inpStr = CLsocket.getInputStream();
            DataInputStream dis = new DataInputStream(inpStr);
            String requestFromClient = dis.readUTF();
            System.out.printf("Received: %s\n", requestFromClient);

            //Get Output stream from Client
            OutputStream outStr = CLsocket.getOutputStream();
            DataOutputStream dos = new DataOutputStream(outStr);

            //Client requesting
            if(requestFromClient.equals("get-cookie")){
                System.out.printf("file -> %s\n", cookieFilePath);
                
                String randomCookie = fortunecookie.getRandomCookie(cookieFilePath);
                System.out.println(randomCookie);
                dos.writeUTF("cookie-text "+randomCookie);
            }else{
                dos.writeUTF("Invalid command !");
            }   

            inpStr.close();
            outStr.close();
            CLsocket.close();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }catch(IOException e){
            System.out.println("Server unavailable");
            e.printStackTrace();
        }
    }
}
