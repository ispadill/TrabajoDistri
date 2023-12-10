import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {


    static Scanner entrada = new Scanner(System.in);
    private static char tablero[][] = new char[3][3];
    private static Socket sc;
    private static Juego j = new Juego();

    public static void main(String[] args) {

        try {

            sc = new Socket("localhost", 5000);
            System.out.println("Vamos a empezar el tres en raya (online)");

            j.rellenarMatriz(tablero, '_');
            ObjectInputStream in = new ObjectInputStream(sc.getInputStream());
            ObjectOutputStream out = new ObjectOutputStream(sc.getOutputStream());

            System.out.println("esperando a que otro jugador se conecte...");
            tablero = getTablero();
            out.writeObject(getTablero());
            out.flush();


        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static char[][] getTablero() {
        return tablero;
    }
}