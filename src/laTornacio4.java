import java.io.File;
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
        //CompetiClases.PATH="/home/41011561p/IdeaProjects/LaTornacio/LaTornacio";
        //CompetiClases.PATH="/home/41011561p/IdeaProjects/LaTornacio/TestVacio";
        CompetiClases.PATH="/home/41011561p/IdeaProjects/LaTornacio/TestMitadTemporada";
        //CompetiClases.PATH="/home/41011561p/IdeaProjects/LaTornacio/TestFinalTemporada";

        int valor;
        int again;
        int cuerpo = 0;
        File jornadas = new File(CompetiClases.PATH+"/Temporada/Jornadas.txt");
        File equipos = new File(CompetiClases.PATH+"/Equipos");

        if (equipos.listFiles().length!=0) {
        CompetiClases.CargarEquipos();
        }

        //Hacer una selección entre - Nuevo equipo - Clasificación - Partidos de Jornada
        while (cuerpo==0) {
            System.out.println("---------------------------------------------------------------------------");
            System.out.println("                 1: Crear equipos");
            if (jornadas.exists()) {
                System.out.println("    2: Crear temporada (Ya hay una temporada activa) ");
            } else if (CompetiClases.aL_Equipos.size()<4) {
                System.out.println("    2: Crear temporada (No hay equipos suficientes) ");
            } else {
                System.out.println("                 2: Crear temporada ");
            }
            if (jornadas.exists()) {
                System.out.println("                3: Ver clasificacion");
            } else {
                System.out.println("    3: Ver clasificacion (No hay una temporada activa)");
            }
            if (jornadas.exists()) {
                System.out.println("              4: Jugar siguiente jornada");
            } else if (CompetiClases.temporadaAcabada==1) {
                System.out.println("  4: Jugar siguiente jornada (La temporada ya ha acabado)");
            } else {
                System.out.println("  4: Jugar siguiente jornada (No hay una temporada activa)");
            }
            System.out.println("                       5: Salir");
            System.out.println("---------------------------------------------------------------------------");
            valor =sc.nextInt();
            switch (valor) {
                case 1:
                    EquiposClases.EquiposClases();
                    CompetiClases.CargarEquipos();
                    break;
                case 2:
                    if (jornadas.exists()) {
                        System.out.println("Error, ya hay una temporada activa en este momento");
                    } else if (CompetiClases.aL_Equipos.size()<4) {
                        System.out.println("Error, no hay equipos suficientes para crear una temporada");
                } else {
                    CompetiClases.CrearTemporada();
                    }
                    break;
                case 3:
                    if (jornadas.exists()) {
                        CompetiClases.ImprimirClasificacion();
                    } else {
                        System.out.println("Error, no hay una temporada activa en este momento");
                    }
                    break;
                case 4:
                    if (jornadas.exists()) {
                        CompetiClases.JugarJornada();

                    }  else if (CompetiClases.temporadaAcabada==1) {
                        System.out.println("Error, la temporada ya ha finalizado");
                    } else {
                        System.out.println("Error, no hay una temporada activa en este momento");
                    }
                    break;
                case 5:
                    again=2;
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


