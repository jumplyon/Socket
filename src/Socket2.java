import javax.swing.*;
import java.net.*;
import java.io.*;

public class Socket2 {
    public static void main( String[] args ) {
        try {
            String host = JOptionPane.showInputDialog("Digite o endereço para realizar a conexão:"  );
            String portinha = JOptionPane.showInputDialog("Digite a porta:");
                Integer.parseInt(portinha);
                int porta = Integer.parseInt(portinha);
            Socket sock = new Socket( host, porta);
            PrintWriter out = new PrintWriter(sock.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
            String linha = "";
            out.println("GET /  HTTP/1.0\n");
            while ((linha = in.readLine()) != null) {
                System.out.println("Resposta do servidor: " + linha);
            }
        }catch (IOException e){
            System.err.println("Problemas de IO");

        }

    }
}