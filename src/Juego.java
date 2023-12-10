import java.util.Scanner;

public class Juego {

    static Scanner entrada = new Scanner(System.in);

    public void jugar() {
        char J1='X';
        char J2='O';
        char vacio='-';

        boolean turno= true;

        char tablero[][] = new char[3][3];

        rellenarMatriz(tablero,vacio);//rellenar matriz con toodoo -

        int fila, columna;

        boolean posValida, correcto;



        while(!finPartida(tablero,vacio)){

            do {

                mostrarTurnoActual(turno);
                mostrarMatriz(tablero);
                correcto = false;

                fila = pedirInteger("Dame la fila");

                columna = pedirInteger("Dame la columna");

                posValida = validarPosicion(tablero, fila, columna);

                if (posValida) {
                    if (hayValorPosicion(tablero, fila, columna, vacio)) {
                        correcto=true;
                    }else {
                        System.out.println("ya hay una marca en esa posicion");
                    }
                }else{
                        System.out.println("la posicion no es valida");
                    }

            }while(!correcto);     //si no es correcto, no pasas de aqui

            if(turno){
                insertarEn(tablero, fila, columna,J1);
            }else{
                insertarEn(tablero, fila, columna,J2);
            }

            turno=!turno; //siempre te va a dar el contrario
        }

        mostrarMatriz(tablero);
        mostrarGanador(tablero,J1,J2,vacio);
    }
    public void mostrarGanador(char[][] matriz, char J1,char J2, char simDef){
        char simbolo = coincidenciaLinea(matriz,simDef);
        if(simbolo!=simDef) {
            if (simbolo == J1) {
                System.out.println("Ha ganado el jugador 1 por linea");
            } else {
                System.out.println("Ha ganado el jugador 2 por linea");
            }
        }
        simbolo = coincidenciaColumna(matriz,simDef);
        if(simbolo!=simDef) {
            if (simbolo == J1) {
                System.out.println("Ha ganado el jugador 1 por columna");
            } else {
                System.out.println("Ha ganado el jugador 2 por columna");
            }
        }
        simbolo = coincidenciaDiagonal(matriz,simDef);
        if(simbolo!=simDef) {
            if (simbolo == J1) {
                System.out.println("Ha ganado el jugador 1 por diagonal");
            } else {
                System.out.println("Ha ganado el jugador 2 por diagonal");
            }
        }

    }
    public void insertarEn(char[][] matriz, int fila, int columna,char simbolo){
        matriz[fila][columna]=simbolo;
    }
    public void mostrarTurnoActual(boolean turno){
        if(turno){
            System.out.println("Le toca al jugador 1");
        }else{
            System.out.println("Le toca al jugador 2");
        }
    }
    public int pedirInteger(String mensaje){
        System.out.println(mensaje);
        int numero=entrada.nextInt();
        return numero;
    }
    public void rellenarMatriz(char[][] matriz, char simbolo){
        for(int i=0;i<matriz.length;i++){
            for(int j=0;j< matriz.length;j++){
                matriz[i][j] = simbolo;
            }
        }
    }
    public boolean validarPosicion(char[][] tablero, int fila, int columna){
        if(fila>=0 && fila< tablero.length && columna>=0 && columna<tablero.length){
            return true;
        }
        return false;
    }
    public boolean hayValorPosicion(char[][] matriz, int fila, int columna, char simboloDef){
        if(matriz[fila][columna] != simboloDef){
            return false;
        }
        return true; //que haya una X o un O
    }

    public boolean finPartida(char[][] matriz, char simboloDef){
        if(matrizLlena(matriz, simboloDef) ||
                coincidenciaLinea(matriz,simboloDef) !=simboloDef ||
                coincidenciaColumna(matriz,simboloDef)!=simboloDef  ||
                coincidenciaDiagonal(matriz,simboloDef)!=simboloDef ){
            return true;
        }
        return  false;
    }
    public void mostrarMatriz(char[][] matriz){
        for(int i=0;i<matriz.length;i++){
            for(int j=0;j< matriz.length;j++){
                System.out.print(matriz[i][j]+" ");
            }
            System.out.println("");
        }

    }
    public char coincidenciaLinea(char[][] matriz, char simboloDef){
        char simbolo;
        boolean coincidencia;

        for(int i=0;i<matriz.length;i++){

            coincidencia=true;
            simbolo = matriz[i][0];
            if(simbolo!=simboloDef){ //si es distinto a una X o a un O
                for(int j=1;j< matriz[0].length;j++){
                    if(simbolo != matriz[i][j]){
                        coincidencia=false;
                    }
                }
                if(coincidencia){
                    return simbolo;
                }
            }

        }

        return simboloDef;
    }
    public  boolean matrizLlena(char[][] matriz, char simboloDef){
        for(int i=0;i<matriz.length;i++){
            for(int j=0;j< matriz.length;j++){
                if(matriz[i][j]==simboloDef){
                    return false; //si me encuentro un simbolo por defecto, no va a estar llena
                }
            }
        }
        return true;
    }
    public char coincidenciaColumna(char[][] matriz, char simboloDef){
        char simbolo;
        boolean coincidencia;

        for(int j=0;j<matriz.length;j++){ //asocio la j a la columna

            coincidencia=true;
            simbolo = matriz[0][j];
            if(simbolo!=simboloDef){ //si es distinto a una X o a un O
                for(int i=1;i< matriz[0].length;i++){
                    if(simbolo != matriz[i][j]){
                        coincidencia=false;
                    }
                }
                if(coincidencia){
                    return simbolo;
                }
            }

        }

        return simboloDef;
    }
    public char coincidenciaDiagonal(char[][] matriz, char simboloDef){
        char simbolo;
        boolean coincidencia=true;

        //Diagonal principal
        simbolo=matriz[0][0];
        if(simbolo!=simboloDef){
            for(int i=1;i< matriz.length;i++) { //no hace falta j, porque va a ser lo mismo que la i
                if(simbolo!=matriz[i][i]){
                    coincidencia=false;
                }
            }
            if(coincidencia){
                return simbolo;
            }
        }
        //
        //Diagonal inversa
        simbolo=matriz[0][2];
        if(simbolo!=simboloDef){
            for(int i=1, j=1 ; i < matriz.length ; i++, j--) { //no hace falta j, porque va a ser lo mismo que la i
                if(simbolo!=matriz[i][j]){
                    coincidencia=false;
                }
            }
            if(coincidencia){
                return simbolo;
            }
        }



        return simboloDef;
    }

}
