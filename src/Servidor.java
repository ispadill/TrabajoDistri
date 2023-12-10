import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String [] args) {

        Socket sc = null;
        Socket sc2 = null;

        try(ServerSocket servidor = new ServerSocket(5000)){

            System.out.println("Servidor iniciado");
            try {
                while(true) {
                    sc = servidor.accept();
                    ObjectInputStream in = new ObjectInputStream(sc.getInputStream());
                    ObjectOutputStream out = new ObjectOutputStream(sc.getOutputStream());
                    System.out.println("Conexion 1 aceptada");

                    //aceptamos 2o cliente y ObjectOutPutStreams
                    sc2 = servidor.accept();
                    ObjectInputStream in2 = new ObjectInputStream(sc.getInputStream());
                    ObjectOutputStream out2 = new ObjectOutputStream(sc.getOutputStream());
                    System.out.println("Conexion 2 aceptada");

                    AtenderPeticion ap = new AtenderPeticion(in,out,in2,out2,sc,sc2);
                    ap.start();



                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
