import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;


public class EquiposClases {

    public static  Scanner sc = new Scanner(System.in);

    public static String ruta ="/home/41011561p/IdeaProjects/LaTornacio/LaTornacio";//path Killian

    public static void main(String[] args) {

        EquiposClases();

    }

    public static void EquiposClases() {

        ArrayList<ObjEquipos> objEquipos = new ArrayList<ObjEquipos>();

        File directorio = new File(ruta + "/"+ "Equipos");
        if (!directorio.exists()){
            directorio.mkdir();
        }

        int limit = 0;
        while (limit == 0){

            System.out.println("Que vols fer?");
            System.out.println("1.Crear equip");
            System.out.println("2.Imprimir todos los equipos");
            System.out.println("3.Mostrar datos de equipo");
            System.out.println("4.Sortir");

            int opcio = sc.nextInt();
            switch (opcio) {

                case 1 :
                    ArrayList<Jugadores> jugadores2 = new ArrayList<Jugadores>();

                    int limitante = 0;
                    String nombreequipo = "jabon";
                    while (limitante == 0) {
                        int bucle = 0;
                        System.out.println("Introduce el nombre del equipo");
                        nombreequipo = sc.next();

                        for (int i = 0; i < objEquipos.size() ; i++) {

                            if (objEquipos.get(i).getNomEquip().equalsIgnoreCase(nombreequipo)){
                                System.out.println("Este nombre esta repetido");
                                bucle = 1;
                            }
                        }
                        if (bucle == 0){
                            limitante = 1;
                        }

                    }
                    String temp = ruta + "/" + "Equipos" + "/" + nombreequipo + ".txt";
                    try{
                        File equipo = new File(ruta + "/" + "Equipos" + "/" + nombreequipo + ".txt");
                        equipo.createNewFile();
                        BufferedWriter bw = new BufferedWriter(new FileWriter(temp, true));
                        bw.write("0 0 0 0" + "\n");
                        bw.close();
                    }
                    catch (Exception e) {
                        System.out.println("Error 1");
                    }


                    System.out.println("Equipo creado correctamente");
                    int limit2 = 0;
                    int jugadoresminimos = 2;
                    int jugadoresmaximos = 4;
                    int jugadoresactuales = 0;
                    try{
                        BufferedWriter bw = new BufferedWriter(new FileWriter(temp, true));
                        bw.write("Jugadores");
                    }
                    catch (Exception e) {
                        System.out.println("Error");
                    }
                    while (limit2 == 0){


                        System.out.println("Creacion jugadores :");
                        System.out.println("1.Crear Jugador");
                        System.out.println("2.Salir");


                        int opcio2 = sc.nextInt();


                        switch (opcio2) {

                            case 1:

                                System.out.println("Introduce el nombre del jugador");
                                String nombrejugador = sc.next();
                                System.out.println("Introduce la edad del jugador");
                                int edad = sc.nextInt();
                                String genero = "m";
                                int verdad = 0;
                                while (verdad == 0) {
                                    System.out.println("Introduce el genero del jugador");
                                    genero = sc.next();
                                    if (genero.equalsIgnoreCase("hombre") || genero.equalsIgnoreCase("mujer")
                                            || genero.equalsIgnoreCase("otro")){
                                        verdad = 1;
                                    }
                                    else {
                                        System.out.println("Genero erroneo , vuelve a introducir");
                                    }
                                }
                                try{
                                    BufferedWriter bw = new BufferedWriter(new FileWriter(temp, true));
                                    bw.write(nombrejugador + " " + edad + " " + genero + "\n");
                                    bw.close();
                                }
                                catch (Exception e) {
                                    System.out.println("Error");
                                }
                                jugadores2.add(new Jugadores(nombrejugador,edad,genero));

                                jugadoresactuales = jugadoresactuales+1;

                                break;

                            case 2:

                                if (jugadoresactuales >= jugadoresminimos){
                                    if (jugadoresactuales <= jugadoresmaximos){

                                        objEquipos.add(new ObjEquipos(nombreequipo,jugadores2));
                                        limit2 = 1;
                                    }
                                }
                                else {
                                    System.out.println("No cumples los requisitos minimos/maximos");
                                }


                                break;

                        }
                    }

                    break;

                case 4 :

                    limit = 1;

                    break;

                case 2 :

                    for (int i = 0; i < objEquipos.size(); i++) {

                        System.out.println(objEquipos.get(i).toString());
                    }
                    break;

                case 3:

                    System.out.println("De que equipo quieres conocer los datos?");
                    String equip = sc.next();

                    for (int i = 0; i < objEquipos.size(); i++) {

                        if (equip.equalsIgnoreCase(objEquipos.get(i).getNomEquip())) {

                            int hombres = 0;
                            int mujeres = 0;
                            int otros = 0;
                            int total = 0;

                            for (int j = 0; j < objEquipos.get(i).getJugadores().size(); j++) {

                                if  (objEquipos.get(i).getJugadores().get(j).genero.equalsIgnoreCase("hombre")){
                                    hombres++;
                                }
                                else if  (objEquipos.get(i).getJugadores().get(j).genero.equalsIgnoreCase("mujer")){
                                    mujeres++;
                                }
                                else {
                                    otros++;
                                }
                                total++;
                            }

                            System.out.println(" Hombres : " + (hombres*100)/total + "%");
                            System.out.println(" Mujeres : " + (mujeres*100)/total + "%");
                            System.out.println(" Otros : " + (otros*100)/total + "%");

                            int mayor = 0;
                            int menor = 0;
                            int tot = 0;

                            for (int j = 0; j < objEquipos.get(i).getJugadores().size(); j++) {

                                if (objEquipos.get(i).getJugadores().get(j).edad >= 18){
                                    mayor++;
                                }
                                else {
                                    menor++;
                                }
                                tot++;
                            }

                            System.out.println(" Mayores de edad : " + (mayor*100)/tot  + "%");
                            System.out.println(" Menores de edad : " + (menor*100)/tot  + "%");
                            System.out.println("\n");

                        }

                    }


                    break;


            }
        }



    }


}
