import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class AtenderPeticion extends Thread{

    Socket sc= null;
    Socket sc2 = null;
    InputStream in;
    OutputStream out;
    InputStream in2;
    OutputStream out2;
    static char[][] tablero = new char[3][3];

    public AtenderPeticion(InputStream in,OutputStream out,InputStream in2, OutputStream out2,Socket sc,Socket sc2){
        this.in=in;
        this.out=out;
        this.in2=in2;
        this.out2=out2;
        this.sc=sc;
        this.sc2=sc2;
    }
    public void run() {

    }
}
