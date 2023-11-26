import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Cliente {
    public static void main(String[] args) throws IOException {
        final String HOST="127.0.0.1";
        final int PUERTO=5000;
        DataInputStream in = null;
        DataOutputStream out = null;
        try {
            Socket sc = new Socket(HOST,PUERTO);
            in = new DataInputStream(sc.getInputStream());
            out = new DataOutputStream(sc.getOutputStream());
            
            out.writeUTF("Hola desde el cliente. ");
            String mensaje = in.readUTF();
            System.out.println("Mensaje del servidor: "+mensaje);
            
            sc.close();
            System.out.println("Cliente desconectado del servidor ");
            
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            in.close();
            out.close();
        }


    }
}
