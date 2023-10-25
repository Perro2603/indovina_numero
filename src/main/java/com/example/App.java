package com.example;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Hello world!
 *
 */
public class App 
{
    
    public static void main( String[] args )
    {
        try {
            
            ServerSocket s= new ServerSocket(3000);
            Socket client = s.accept();

            System.out.println("client conesso");

            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            
            DataOutputStream out = new DataOutputStream(client.getOutputStream());


            int NumeroRand = (int) (Math.random()*100)+1;
           
            System.out.println(NumeroRand);

            out.writeBytes("prova a indovinare "+'\n');

            int risposta;
            int tentativi=0;

                do {

                    risposta = Integer.parseInt(in.readLine());
                    tentativi++;
                    if(risposta < NumeroRand){

                        System.out.println(1);

                        out.writeBytes("1"+'\n');
                    }else if(risposta > NumeroRand){

                        System.out.println(2);

                        out.writeBytes("2"+'\n');

                    }else {
                        System.out.println(3);
                    out.writeBytes("3"+'\n');
                    out.writeBytes(tentativi +"'\n'");

                    }
                 
                } while (risposta != NumeroRand);

        client.close();
        s.close();

        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
