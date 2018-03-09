import java.io.*;
import java.util.Scanner;
import java.util.function.LongToIntFunction;

public class Main {

    public static Scanner sc = new Scanner(System.in);
    //public static String PATH = "C:\\Users\\Hamza IQBAL\\IdeaProjects\\LaTornacio-master-28f1de9cb809eb72f764bdff9f793e129e8b9b7e\\src\\LaTornacio";
    public static String PATH = "/home/26633902v/IdeaProjects/LaTornacio-master-28f1de9cb809eb72f764bdff9f793e129e8b9b7e/src/LaTornacio";
    public static File LaTornacio = new File(PATH) ;
    public static File DentrodeLaTorna [] = LaTornacio.listFiles();
    public static String ArraysdeNombres [];


    public static void main(String[] args) {
        LectorDeNombresEquipo();
    }

    public static void CreacionDeDirectiorio() {
        String NomDelDirectori = "Partidos";

        File Crecion = new File(PATH + "/" + NomDelDirectori);
        if (!Crecion.exists()) {
            Crecion.mkdir();
            System.out.println("S'ha pogut crear correctament Partidos.");
            CrecionDeFitcheros();
        } else {
            System.out.println("HEYYYY!!! FIXAT!!! JA EXISTEIX...");
            LectorDeNombresEquipo();

        }
    }

    public static void CrecionDeFitcheros (){

        File Jornadas = new File(PATH+"/"+"Partidos"+"/"+"Jornadas.txt");
        File Classificaion = new File(PATH+"/"+"Partidos"+"/"+"Classificacion.txt");

        try {
            if (!Jornadas.exists() || !Classificaion.exists()) {
                Jornadas.createNewFile();
                Classificaion.createNewFile();
                LectorDeNombresEquipo();
            }

        }catch (IOException e) {
            System.out.println("S'ha produit un error");
        }

    }

    public static void LectorDeNombresEquipo () {


        File pathEquipos = new File("/home/26633902v/IdeaProjects/LaTornacio-master-28f1de9cb809eb72f764bdff9f793e129e8b9b7e/src/LaTornacio/Equipos");
        File[] asdfasdf = pathEquipos.listFiles();
        String nombreEquipos[] = new String[asdfasdf.length];

        for (int i = 0; i <nombreEquipos.length ; i++) {
            nombreEquipos[i] = asdfasdf[i].getName();
            nombreEquipos[i]= nombreEquipos[i].replace(".txt","");
            System.out.println(nombreEquipos[i]);
        }



                /*for (File nombreees: ContenedordeEquipo) {
                    for (int i = 0; i <cantidad ; i++) {
                        Arraysnom[i]=nombreees.getName().toString();
                    }
                    for (int i = 0; i <Arraysnom.length ; i++) {
                        System.out.println(ArraysdeNombres[i]);*/
                    }






                }
