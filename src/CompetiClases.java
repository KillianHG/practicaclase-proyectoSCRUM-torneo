import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class CompetiClases {

    public static String PATH;
    public static int  numeroEquipos;
    public static int numeroEquiposGuardado;
    public static String[] equipos;
    public static int numeroPartidos;
    public static String[][] matrizPartidos;
    public static int [][] resultadosnum;
    public static String [] equipos1;
    public static int[][] clasi;
    public static ArrayList<ObjEquipos> aL_Equipos = new ArrayList<ObjEquipos>();
    public static int temporadaAcabada = 0;

    /**
     * Crea una nueva temporada, a partir de los ficheros en la carpeta equipos.
     */
    public static void CrearTemporada() {

        try {
            Scanner sc = new Scanner(System.in);
            File directorio = new File(PATH + "/Temporada/Jornadas.txt");
            if (!directorio.exists()) {
            directorio.mkdirs();
            directorio.delete();
            directorio.createNewFile();
            }

            numeroEquipos = aL_Equipos.size();
            numeroEquiposGuardado = numeroEquipos;

            //Generador de total de partidos sin repetir (vuelta x 2)
            numeroPartidos = ((aL_Equipos.size() / 2)+(numeroEquipos) % 2) * (numeroEquipos - 1);

            //Matriz de Equipos, Partidos y Puntos.
            int totalPartidos = numeroPartidos;
            matrizPartidos = new String[totalPartidos][2];

            int x = 0;
            int y = 1;
            int z = 1;

            //Generador Partidos 2.0
            for (int i = 0; i < numeroPartidos; i++) {

                matrizPartidos[i][0] = aL_Equipos.get(x).getNomEquip();
                matrizPartidos[i][1] = aL_Equipos.get(y).getNomEquip();

                x++;
                y++;
                if (y == numeroEquipos) {
                    z++;
                    y = z;
                    x = 0;
                }
            }


            int validarOpcion = 0;

            String vuelta = "asd";

            while (validarOpcion == 0) {
                System.out.println("¿Quieres simular partidos de vuelta?   Si / No");
                vuelta = sc.nextLine();
                if (vuelta.toLowerCase().equals("si")) {
                    validarOpcion++;
                } else if (vuelta.toLowerCase().equals("no")) {
                    validarOpcion++;
                } else {
                    System.out.println("No te hemos entendido.");
                }
            }
            try {
                //Mostramos el calendario por jornadas
                for (int i = 0; i < numeroPartidos; i++) {
                    int j = i+1;
                    System.out.println("-----");
                    System.out.println("JORNADA  " + j+ "  --->   " + matrizPartidos[i][0] + " VS "
                            + matrizPartidos[i][1]);

                    BufferedWriter bw = new BufferedWriter(new FileWriter(PATH+"/Temporada/Jornadas.txt", true));
                    bw.write(matrizPartidos[i][0] + " * " + matrizPartidos[i][1] +" *\n");
                    bw.close();
                }
                if (vuelta.equalsIgnoreCase("si")) {
                    System.out.println("");
                    System.out.println("------------------");
                    System.out.println("Partidos de vuelta");
                    System.out.println("------------------");
                    System.out.println("");

                    for (int i = 0; i < numeroPartidos; i++) {
                        int j=numeroPartidos+i+1;
                        System.out.println("-----");
                        System.out.println("JORNADA " + j + "  --->   " + matrizPartidos[i][1] + " VS "
                                + matrizPartidos[i][0]);

                        BufferedWriter bw = new BufferedWriter(new FileWriter(PATH+"/Temporada/Jornadas.txt", true));
                        bw.write(matrizPartidos[i][1] + " * " + matrizPartidos[i][0]+" *\n");
                        bw.close();
                    }
                }
            } catch (Exception e) {
                System.out.println("error" + e);
            }

        }catch (Exception e){
            System.out.println("error" + e);
        }

    }

    /**
     * Juega la siguiente jornada de la temporada.
     * Entra en el fichero y empieza a recorrer linea por linea hasta encontrar una linea
     * que contenga "*" da el nombre de los equipos y pregunta el resultado, busca en los equipos
     * cual tiene los mismos nombres y actualiza sus puntuaciones.
     */
    public static void JugarJornada() {
        Scanner sc = new Scanner(System.in);

        int jornadasMax = 0;
        int jornadasM = ((aL_Equipos.size() / 2)+(aL_Equipos.size()) % 2) * (aL_Equipos.size() - 1);
        try {
            BufferedReader br = new BufferedReader(new FileReader(PATH + "/Temporada/Jornadas.txt"));
            String linea;
            while ((linea=br.readLine())!=null) {
                jornadasMax++;
            }
            br.close();
        } catch (Exception e) {

        }

        //System.out.println("Quieres Introducir los resultados de la siguiente jornada jornada?");
        int primerResultado = 0;
        int segundoResultado = 0;
        String[] partido = new String[4];
                clasi= new int[numeroEquiposGuardado][4];
        try {
            BufferedReader br = new BufferedReader(new FileReader(PATH+"/Temporada/Jornadas.txt"));


            int salir = 0;
            String linea = "";
            String textoJornadas = "";
            int jor = 1;
            for (int i=0;i<jornadasMax && salir == 0;i++) {
                linea = br.readLine();
                if (linea.contains("*")) {
                    partido = linea.split(" ");
                    System.out.println("JORNADA " + jor + "  --->   " + partido[0] + " VS " + partido[2]);
                    System.out.println("-----");
                    System.out.println("Introduce el resultado del partido:");
                    primerResultado = sc.nextInt();
                    segundoResultado = sc.nextInt();
                    partido[1] = Integer.toString(primerResultado);
                    partido[3] = Integer.toString(segundoResultado);

                    linea = (partido[0] + " " + partido[1] + " " + partido[2] + " " + partido[3]);
                    salir = 1;
                }
                    textoJornadas += linea + "\n";

                jor++;
                if (jor > jornadasMax) {
                    System.out.println("La temporada ha finalizado");
                    temporadaAcabada = 1;
                }
                if (jor == jornadasM && jornadasM*2==jornadasMax) {
                    System.out.println("Han finalizado las jornadas de ida");
                }
            }
            for (int i = 0; i < jornadasMax && salir == 1; i++) {
                linea = br.readLine();
                if (linea!=null) {
                    textoJornadas += linea + "\n";
                }
            }

            br.close();
            BufferedWriter bw = new BufferedWriter(new FileWriter(PATH+"/Temporada/Jornadas.txt"));
            bw.write(textoJornadas);
            bw.close();
        }
        catch (Exception e){

        }

        //Se suman los puntos a los objetos y se actualizan los ficheros de los equipos
        if (primerResultado > segundoResultado) {
            for (ObjEquipos equipo :aL_Equipos) {
                if (partido[0].equals(equipo.getNomEquip())) {
                    equipo.setVictorias(equipo.getVictorias()+1);
                    equipo.setPuntos(equipo.getPuntos()+3);

                    ActualizarEquipos(equipo);
                } else if (partido[2].equals(equipo.getNomEquip())) {
                    equipo.setDerrotas(equipo.getDerrotas()+1);

                    ActualizarEquipos(equipo);
                }
            }
        } else if (primerResultado < segundoResultado) {
            for (ObjEquipos equipo :aL_Equipos) {
                if (partido[2].equals(equipo.getNomEquip())) {
                    equipo.setVictorias(equipo.getVictorias()+1);
                    equipo.setPuntos(equipo.getPuntos()+3);

                    ActualizarEquipos(equipo);
                } else if (partido[0].equals(equipo.getNomEquip())) {
                    equipo.setDerrotas(equipo.getDerrotas()+1);

                    ActualizarEquipos(equipo);
                }
            }
        } else {
            for (ObjEquipos equipo :aL_Equipos) {
                if (partido[0].equals(equipo.getNomEquip())) {
                    equipo.setEmpates(equipo.getEmpates()+1);
                    equipo.setPuntos(equipo.getPuntos()+1);

                    ActualizarEquipos(equipo);
                } else if (partido[2].equals(equipo.getNomEquip())) {
                    equipo.setEmpates(equipo.getEmpates()+1);
                    equipo.setPuntos(equipo.getPuntos()+1);

                    ActualizarEquipos(equipo);
                }
            }
        }

        //al acabar la jornada, se ordena la clasificacion y se muestra.
        Collections.sort(aL_Equipos, ObjEquipos.compararPuntos);
        ImprimirClasificacion();
    }

    /**
     * Actualiza los ficheros de l equipo
     * @param equipo el equipo del cual queremos actualizar su fichero
     */
    public static void ActualizarEquipos(ObjEquipos equipo) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(PATH+"/Equipos/" + equipo.getNomEquip() + ".txt"));
            String datosEquipo = "";
            datosEquipo+=equipo.getVictorias() + " " + equipo.getEmpates() + " " + equipo.getDerrotas() + " " +equipo.getPuntos() + "\n";
            for (Jugadores jugador: equipo.getJugadores()) {
                datosEquipo += jugador.getNombre() + " " + jugador.getEdad() + " " + jugador.getGenero() + "\n";
            }
            bw.write(datosEquipo);
            bw.close();
        } catch (Exception e) {

        }
    }

    /**
     * Carga todos los equipos dentro del directorio del cual esten y despues los ordena segun los puntosç
     *
     * Lo que hace es crear objetos por cada fichero que haya en la carpeta que contenga los equipos
     * y asignar todos los atributos del equipo tal cual se quedaron la ultima vez que se actualizaron
     * Para ello el fichero se crea con una primera linea de 4 numeros separados por espacios que
     * representan "victorias" "empates" "derrotas" "puntos", seguido de lineas que representan
     * todos y cada uno de los jugadores.
     */
    public static void CargarEquipos() {
        File equipos = new File(PATH+"/Equipos");
        int index = 0;
        for (File equipo:equipos.listFiles()) {
            try {
                BufferedReader br = new BufferedReader(new FileReader(equipo));
                String nombre = equipo.getName().replace(".txt","");
                String linea = br.readLine();
                String [] eq_puntaje = linea.split(" ");

                ArrayList <Jugadores> aL_Jugadores = new ArrayList<>();


                while ((linea = br.readLine())!=null) {
                    String [] jugador_info = linea.split(" ");
                    aL_Jugadores.add(new Jugadores(jugador_info[0],Integer.parseInt(jugador_info[1]),(jugador_info[2])));
                }

                br.close();

                aL_Equipos.add(new ObjEquipos(nombre,aL_Jugadores));

                aL_Equipos.get(index).setVictorias(Integer.parseInt(eq_puntaje[0]));
                aL_Equipos.get(index).setEmpates(Integer.parseInt(eq_puntaje[1]));
                aL_Equipos.get(index).setDerrotas(Integer.parseInt(eq_puntaje[2]));
                aL_Equipos.get(index).setPuntos(Integer.parseInt(eq_puntaje[3]));

                index++;
            } catch (Exception e) {
                System.out.println("No se han podido cargar el equipo correctamente");
            }
        }
        Collections.sort(aL_Equipos, ObjEquipos.compararPuntos);
    }

    /**
     * Sirve para imprimira la clasificacion.
     */
    public static void ImprimirClasificacion(){
        System.out.print("\nCLASIFICACION\n");
        for (int x=1;x<=aL_Equipos.size();x++) {
            int i=x-1;
            System.out.print("\n"+x+". "+aL_Equipos.get(i).getNomEquip()+" - "+aL_Equipos.get(i).getVictorias()+" victorias - "+aL_Equipos.get(i).getEmpates()+" empates - "+aL_Equipos.get(i).getDerrotas()+" derrotas - "+aL_Equipos.get(i).getPuntos()+" puntos");
        }
       System.out.println();
    }

    public static void CrearTorneo() {
        Scanner sc = new Scanner(System.in);
        ArrayList <ObjEquipos> aL_Playoff = new ArrayList<>();
        for (ObjEquipos e:aL_Equipos) {

           aL_Playoff.add(e);

        }
        int rondas=0;
        int index = aL_Playoff.size();
        while (index!=1) {
            index = index / 2;
            rondas++;
        }

        for (int i = 0; i < aL_Playoff.size()-1; i++) {
            System.out.println(aL_Playoff.get(i).getNomEquip());
            i++;
            System.out.println(" VS ");
            System.out.println(aL_Playoff.get(i).getNomEquip());
            System.out.println("---------------------");
        }

        int primerResultado = 0;
        int segundoResultado = 0;
        while (rondas != 0) {
            for (int i = 0; i < aL_Playoff.size()-1; i++) {
                System.out.println(aL_Playoff.get(i).getNomEquip());
                i++;
                System.out.println(" VS ");
                System.out.println(aL_Playoff.get(i).getNomEquip());
                boolean c = false;
                System.out.println("··································");
                while (!c) {
                System.out.println("Introduce el resultado del partido:");
                primerResultado = sc.nextInt();
                segundoResultado = sc.nextInt();


                 if (primerResultado > segundoResultado) {
                     aL_Playoff.remove(i);
                     c=true;
                     i--;
                     System.out.println("··································");
                 } else if (primerResultado < segundoResultado) {
                     i--;
                     aL_Playoff.remove(i);
                     c=true;
                     System.out.println("··································");
                 } else {
                     System.out.println("----------- Tiempo Extra ---------");
                 }

                }
            }
            rondas--;
            if (rondas!=0) {
                System.out.println("####################");
                System.out.println("Ronda finalizada");
                System.out.println("####################");
                System.out.println("··································");

            } else {
                System.out.println("####################");
                System.out.println("Torneo finalizado");
                System.out.println("El equipo campeon es: " +aL_Playoff.get(0).getNomEquip());
                System.out.println("####################");
            }

        }
    }

}
