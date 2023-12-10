import java.io.*;
import java.net.Socket;

public class AtenderPeticion extends Thread{

    Socket sc= null;
    Socket sc2 = null;
    InputStream in;
    OutputStream out;
    InputStream in2;
    OutputStream out2;
    static char[][] tablero = new char[3][3];
    static char[][] tablero2 = new char[3][3];
    private Juego j = new Juego();
    char J1='X';
    char J2='O';
    char vacio='-';


    public AtenderPeticion(InputStream in,OutputStream out,InputStream in2, OutputStream out2,Socket sc,Socket sc2){
        this.in=in;
        this.out=out;
        this.in2=in2;
        this.out2=out2;
        this.sc=sc;
        this.sc2=sc2;
    }
    public void run() {
        j.rellenarMatriz(tablero,vacio);
        if(sc2!=null) {//si hay 2 clientes
            //primer cliente
            try {
                tablero = (char[][]) ((ObjectInputStream) in).readObject();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            //segundo cliente
            try {
                tablero = (char[][]) ((ObjectInputStream) in).readObject();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            //se le pone al primer cliente q es el J1
            try {
                ((ObjectOutputStream) out).writeInt(1);
                out.flush();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            //se le pone al segundo cliente q es el J2
            try {
                ((ObjectOutputStream) out).writeInt(1);
                out.flush();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            j.jugar();//no se conectar con los inputs y outputs de los 2 clientes
        }

    }
}
