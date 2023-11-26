import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String [] args) throws IOException {
        ServerSocket servidor = null;
        Socket sc = null;
        DataInputStream in = null;
        DataOutputStream out = null;
        final int PUERTO = 5000;

        try {
            servidor = new ServerSocket(PUERTO);
            System.out.println("Servidor iniciado");

            while(true) {
                sc = servidor.accept();
                in = new DataInputStream(sc.getInputStream());
                out = new DataOutputStream(sc.getOutputStream());
                String msgCli = in.readUTF();
                //aqui vamos a hacer las operaciones con el cliente
                System.out.println("Mensaje del cliente: "+ msgCli);//de momoento muestro el mensaje

                out.writeUTF("Hola desde el servidor");

                //cerramos conexion con el cliente
                sc.close();
                System.out.println("Cliente descone");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            in.close();
            out.close();
            sc.close();
            servidor.close();
        }

    }
}
