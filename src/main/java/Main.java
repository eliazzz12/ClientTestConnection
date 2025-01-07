import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String host = "sectamermelada.ddns.net";
        int port = 10100;

        try (Scanner sc = new Scanner(System.in);
             Socket socket = new Socket(host, port)) {
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            DataInputStream dis = new DataInputStream(socket.getInputStream());

            String mensaje_server = dis.readUTF();
            System.out.println("El servidor mermelada dice: " + mensaje_server);

            System.out.println("Escribe un mensaje para enviar al servidor:\n");
            String mensaje_client = sc.nextLine();
            System.out.println("Enviando \""+mensaje_client +"\"");

            dos.writeUTF(mensaje_client);

            mensaje_server = dis.readUTF();
            System.out.println("Respuesta del servidor mermelada: "+mensaje_server);


        } catch (IOException e) {
            System.out.println("CLIENT: Error con el socket -> " + e.getMessage());
        }
    }
}
