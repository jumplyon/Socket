import java.net.*;
import java.io.*;

public class Socket2 {
    public static void main( String[] args ) {
        try {
            Socket sock = new Socket("www.google.com.br", 80);
            PrintWriter out = new PrintWriter(sock.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
            String linha="";
             out.println("GET / HTTP/1.0\n");
             while ((linha = in.readLine()) != null) {



        }

    }
}