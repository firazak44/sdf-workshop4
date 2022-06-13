package vtpday4workshop.client;

import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args){
        System.out.println("Client on Standby");
        String[] arr = args[0].split(":");

        try{
            Socket CLsocket = new Socket(arr[0], Integer.parseInt(arr[1]));
            //Get stream of in and out of server
            InputStream inpStr = CLsocket.getInputStream();
            DataInputStream dis = new DataInputStream(inpStr);
            OutputStream outStr = CLsocket.getOutputStream();
            DataOutputStream dos = new DataOutputStream(outStr);

            Console con = System.console();
            String input = con.readLine("Transmit to server > ");
            dos.writeUTF(input);
            dos.flush();
            String response = dis.readUTF();
            System.out.println(response);

            inpStr.close();
            outStr.close();
            CLsocket.close();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
