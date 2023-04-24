import edu.princeton.cs.stdlib.StdIn;
import edu.princeton.cs.stdlib.StdOut;

public class Main {
    public static void main(String[] args) {
        /*
        =================================
        = jorge.rivera01@alumnos.ucn.cl =
        =================================
         */

        tragamonedas();
    }

    public static void tragamonedas(){
        boolean jugando = true; //variable booleana que indica si se esta jugando o no
        int saldo = 1000;
        int[] ruedas = new int[3];

        while(jugando){
            StdOut.println("Su saldo actual es $"+saldo+" ¿Cuanto desea apostar? ");
            int apuesta = StdIn.readInt();

            if(0<apuesta&&apuesta<=saldo){
                if(apuesta==0){
                    StdOut.println("Muchas graciaspor jugar. Su saldo final es de $"+saldo);
                    jugando=false;
                    break;
                }

                saldo-=apuesta;
                ruedas[0]=(int)Math.random()* 10;
                ruedas[1]=(int)Math.random()* 10;
                ruedas[2]=(int)Math.random()* 10;

                pantalla(ruedas);

                int premio = dineroGanado(ruedas,apuesta);
                if(0<premio){
                    StdOut.println("Usted obtiene $"+premio);
                    saldo+=premio;
                }

                if(saldo<=0){
                    StdOut.println("Muchas Gracias por jugar. Mejor suerte la proxima vez.");
                    jugando=false;
                    break;
                }
            }
        }
    }

    public static void pantalla(int[] ruedas){
        StdOut.println("+---+---+---+");
        for(int i=0;i< ruedas.length;i++){
            if(ruedas[i]==0){
                StdOut.print("| * ");
            }else{
                StdOut.print("| "+ruedas[i]+" ");
            }
        }
        StdOut.println("|");
        StdOut.println("+---+---+---+");
    }

    public static int dineroGanado(int[] ruwdas,int apuesta){
        if(ruwdas[0]==ruwdas[1]&&ruwdas[0]==ruwdas[2]&ruwdas[0]!=0){return ruwdas[0]*apuesta;}

        int contador = 0;

        for(int i=0;i< ruwdas.length;i++){
            if (ruwdas[i]==0){contador++;}
        }

        switch (contador){
            case 1:
                return 50;
            case 2:
                return 300;
            case 3:
                return 500;
            default:
                return 0;
        }
    }
}