import java.io.File;
import java.io.IOException;



public class Files {

    public static String PATH = "/home/26633902v/IdeaProjects/LaTornacio-master-28f1de9cb809eb72f764bdff9f793e129e8b9b7e/src/LaTornacio";
    public static File LaTornacio = new File(PATH) ;
    public static File DentrodeLaTorna [] = LaTornacio.listFiles();

    public static void CreacionDeDirectiorio() {
        String NomDelDirectori = "Partidos";

        File Crecion = new File(PATH + "/" + NomDelDirectori);
        if (!Crecion.exists()) {
            Crecion.mkdir();
            System.out.println("S'ha pogut crear correctament Partidos.");
            CrecionDeFitcheros();
        } else {
            System.out.println("HEYYYY!!! FIXAT!!! JA EXISTEIX...");


        }
    }

    public static void CrecionDeFitcheros (){

        File Jornadas = new File(PATH+"/"+"Partidos"+"/"+"Jornadas.txt");
        File Classificaion = new File(PATH+"/"+"Partidos"+"/"+"Classificacion.txt");

        try {
            if (!Jornadas.exists() || !Classificaion.exists()) {
                Jornadas.createNewFile();
                Classificaion.createNewFile();

            }

        }catch (IOException e) {
            System.out.println("S'ha produit un error");
        }

    }
}
