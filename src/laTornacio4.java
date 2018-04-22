import java.util.*;

public class laTornacio4 {

    Scanner sc=new Scanner(System.in);
    int [][] clasi;
    String [] equipos;
    double numeroEquipos;
    int numeroEquiposGuardado;
    double numeroPartidos;
    String[][]matrizPartidos;
    int di=0;

    public static void main(String[] args) {
        laTornacio4 cuerpo = new laTornacio4();
        cuerpo.Cuerpo();
    }
    public void Cuerpo() {
        int valor;
        int again;
        int cuerpo = 0;

        //Hacer una selección entre - Nuevo equipo - Clasificación - Partidos de Jornada
        while (cuerpo==0) {
            System.out.println("---------------------------------------------------------------------------");
            System.out.println("                 1: Nuevos equipos");
            System.out.println("                 2: Crear temporada");
            System.out.println("                3: Ver clasificacion");
            System.out.println("---------------------------------------------------------------------------");
            valor =sc.nextInt();
            switch (valor) {
                case 1:

                    EquiposClases.EquiposClases();

                    break;
                case 2:
                    /*if (di==0) {
                        CompetiClases.JornadasClasi();
                        break;
                    }

                    if (di==1){
                        CompetiClases.OrdenarClasificacion();
                        CompetiClases.ImprimirClasificacion();*/
                        CompetiClases.JornadasClasi();
                        //CompetiClases.CargarEquipos();
                        break;
                    //}
                case 3:
                    CompetiClases.ImprimirClasificacion();
                    break;

                default:
                    System.out.println("ERROR");


            }
            System.out.println("\nDesea realizar alguna otra opción?");
            System.out.println("1. Si");
            System.out.println("2. No");
            again =sc.nextInt();
            while (again!=1&&again!=2) {
                System.out.println("Opcion incorrecta por favor selecciona una opcion correcta: ");
                System.out.println("1. Continuar");
                System.out.println("2. No continuar");
                again = sc.nextInt();
            }
            if (again==2) {
                System.out.println("Hasta pronto");
                System.exit(0);
            }
        }
        System.out.println("Hasta pronto.");
    }


    /*
    Se crea un Array (“Partidos”)con ‘n’ filas y 2 columnas, 1 por equipo en cada partido.
    Para hallar ‘n’ debemos calcular el número de partidos, o, el número de combinaciones sin repetición.
     */

}


