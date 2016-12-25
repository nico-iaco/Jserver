/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.net.*;
import java.io.*;
import java.util.*;
/**
 *
 * @author Nicola-pc
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        ServerSocket server=null;
        Socket client=null;
        String stringaRicevuta=null;
        BufferedReader inDalClient;
        DataOutputStream outVersoClient;
        System.out.println("Server in esecuzione");
        while(true){
            server=new ServerSocket(6789);
            client=server.accept();
            server.close();
            inDalClient=new BufferedReader(new InputStreamReader(client.getInputStream()));
            outVersoClient=new DataOutputStream(client.getOutputStream());
            stringaRicevuta=inDalClient.readLine();
            int scelta=Integer.valueOf(stringaRicevuta);
            switch(scelta){
                case 1:
                    Calendar cal = Calendar.getInstance();
                    String ora=cal.getTime().toGMTString();
                    outVersoClient.writeBytes(ora);
                    break;
                case 2:
                    int numero=(int) (Math.random()*100);
                    String Snumero=String.valueOf(numero);
                    outVersoClient.writeBytes(Snumero);
                    break;
                case 3:
                    String indirizzo=InetAddress.getLocalHost().getHostAddress();
                    outVersoClient.writeBytes(indirizzo);
                    break;
            }
            client.close();
        }
    }
    
}
