public class Tablero {
    private String [][] tablero;
    int columnas;
    int filas;
    private int turno;
    private char x = 'X';
    private char o = 'O';

    public Tablero(){
        this.filas=3;
        this.columnas=3;
        tablero = new String[filas][columnas];
        turno=1;
    }

    public String[][] getTablero() {
        return tablero;
    }

    public int getColumnas() {
        return columnas;
    }

    public int getFilas() {
        return filas;
    }

    public void iniciarTablero(){
        for(int i=0;i<tablero.length;i++){
            for(int j=0;j<tablero[i].length;i++){
                tablero[i][j]="_";
                System.out.println(tablero[i][j]+" ");
            }
            System.out.println();
        }
    }
    /*public int getTurno{
        return this.turno;
    }*/
    public int cambiarTurno(){
        if(turno==1){
            turno=2;
        }else{
            turno=1;
        }
        return turno;
    }

}
