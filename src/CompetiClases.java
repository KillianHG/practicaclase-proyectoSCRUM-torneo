import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class CompetiClases {
    //public static String PATH = "/home/26633902v/IdeaProjects/LaTornacio-master-28f1de9cb809eb72f764bdff9f793e129e8b9b7e/src/LaTornacio/Partidos/";
    public static String PATH = "C:\\Users\\Usuario\\IdeaProjects\\LaTornacio\\LaTornacio";//path Killian
    public static int  numeroEquipos;
    public static int numeroEquiposGuardado;
    public static String[] equipos;
    public static int numeroPartidos;
    public static String[][] matrizPartidos;
    public static int [][] resultadosnum;
    public static String [] equipos1;
    public static int[][] clasi;
    public static ArrayList<ObjEquipos> aL_Equipos = new ArrayList<ObjEquipos>();

    //Algoritmo y automatizar vienen cogidos de la mano.
    //Para generar las jornadas debemos demostrar la formula anterior, generando cada uno de los casos posibles.
    //Para eso, usamos el siguiente algoritmo:



    public static void CrearTemporada() {

        try {
            Scanner sc = new Scanner(System.in);
            File directorio = new File(PATH + "/Temporada/Jornadas.txt");
            if (!directorio.exists()) {
            directorio.mkdirs();
            directorio.delete();
            directorio.createNewFile();
            }

            //System.out.println("Introduce el numero de equipos");
            numeroEquipos = aL_Equipos.size();
            numeroEquiposGuardado = numeroEquipos;
            //Depuradora
            //String a = sc.nextLine();



            //Nombramos los Equipos
            /*System.out.println("Introduce el nombre de los equipos");
            System.out.println("");
            System.out.println("");*/



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

                    BufferedWriter bw = new BufferedWriter(new FileWriter(PATH+"\\Temporada\\Jornadas.txt", true));
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

    public static void Partidos() {
        Scanner sc = new Scanner(System.in);

        //System.out.println("Quieres Introducir los resultados de los partidos?");
        String resultados = "asd";
        int validarOpcion = 0;
        int primerResultado = 0;
        int segundoResultado = 0;
        String[] partido = new String[4];
                clasi= new int[numeroEquiposGuardado][4];
        /*int[] puntosEquipo = new int[numeroEquiposGuardado];
        int[] victorias = new int[numeroEquiposGuardado];
        int[] derrotas = new int[numeroEquiposGuardado];
        int[] empates = new int[numeroEquiposGuardado];*/


        //Victorias [][0], Empates[][1], Derrotas [][2], Puntos [][3]
        /*for (int i = 0; i <numeroEquiposGuardado ; i++) {
            clasi[i][3] = 0;
        }*/
        int x = 0;
        int y = 1;
        int z = 1;
        /*while(validarOpcion == 0){
            resultados =sc.nextLine();
            if(resultados.toLowerCase().equals("si")){
                validarOpcion++;
            }
            else if(resultados.toLowerCase().equals("no")){
                validarOpcion++;
            }else{
                System.out.println("No te hemos entendido.");
                System.out.println("¿Quieres introducir los resultado de los partidos?   Si / No");

            }
        }*/

        try {
            BufferedReader br = new BufferedReader(new FileReader(PATH+"\\Temporada\\Jornadas.txt"));


            int salir = 0;
            String linea;
            String textoJornadas = "";
            int jor = 1;
            while ((linea = br.readLine()) != null && salir == 0) {
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
            }
            while ((linea = br.readLine()) != null && salir == 1) {
                textoJornadas += linea + "\n";
            }

            br.close();
            BufferedWriter bw = new BufferedWriter(new FileWriter(PATH+"\\Temporada\\Jornadas.txt"));
            bw.write(textoJornadas);
            bw.close();
        }
        catch (Exception e){

        }

        //Se suman los puntos a los objetos
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

        Collections.sort(aL_Equipos, ObjEquipos.compararPuntos);
        ImprimirClasificacion();

        /*switch (resultados.toLowerCase()){
            case "si":
                for (int i = 0; i <numeroPartidos ; i++) {
                    System.out.println("-----");
                    System.out.println("JORNADA  " + jornada + "  --->   " + matrizPartidos[i][0] + " VS "
                            + matrizPartidos[i][1] + "    " + dmaj[0] + " / " + dmaj[1] + " / " + dmaj[2]);
                    dmaj[0] = dmaj[0] + (int) (Math.random() * 3) + 1;
                    jornada++;
                    System.out.println("Resultado del partido");
                    primerResultado = sc.nextInt();
                    segundoResultado = sc.nextInt();

                    resultadosnum = new int[numeroPartidos][2];
                    resultadosnum[i][0]=primerResultado;
                    resultadosnum[i][1]=segundoResultado;


                    //AQUI VA LO DE DEFINIR LO DE PARTIDOS PUNTUAJES


                    if(primerResultado > segundoResultado){
                        clasi[x][3] = clasi[x][3] + 3;
                        clasi[x][0] = clasi[x][0] +1;
                        clasi[y][2] = clasi[y][2] +1;
                    }
                    else if(segundoResultado > primerResultado){
                        clasi[y][3] = clasi[y][3]+3;
                        clasi[y][0] = clasi[y][0]+1;
                        clasi[x][2] = clasi[x][2] +1;
                    }else{
                        clasi[x][3] = clasi[x][3] + 1;
                        clasi[y][3] = clasi[y][3] + 1;
                        clasi[x][1] = clasi[x][1] +1;
                        clasi[y][1] = clasi[y][1] +1;
                    }
                    x++;
                    y++;
                    if(y == numeroEquipos){
                        z++;
                        y = z;
                        x = 0;
                    }
                }
                try {
                    RandomAccessFile rf = new RandomAccessFile(PATH +"/Temporada/Jornadas.txt", "rw");

                    //
                    // NO ME SALEEEEEE
                    // Lo que he intentado es; que lea por linea que lo divida por espacios mientras contenga
                    // "*" que iguale la posicion (que simpre es impar) a la matriz  pero nada....
                    //LUEGO Lo meto todo en una String per nada...
                    int o = 0;
                    int p = 0;
                    int d = 1;
                    String linea;
                    String azs = null;
                    while ((linea = rf.readLine()) != null) {

                        if (linea.contains("*")) {
                            equipos1 = linea.split(" ");
                            equipos1[d] = Integer.toString(resultadosnum[o][p]);
                            if (p == 1) {
                                o++;
                            }
                            p++;
                            d = d + 2;
                        }
                    }
                    for (int i = 0; i < equipos1.length ; i++) {
                        if (azs == null){
                            azs += equipos1;
                        }else
                            azs = azs + " " + equipos1;
                    }
                    rf.writeChars(azs);


                    rf.close();

                }catch (Exception e){
                    System.out.println("ERROR " +e);
                }

                break;
            case "no":
                System.out.println("ADEU :D");
                break;
        }*/
    }

    public static void ActualizarEquipos(ObjEquipos equipo) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(PATH+"\\Equipos\\" + equipo.getNomEquip() + ".txt"));
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

                System.out.println("Equipo cargado correctamente");
            } catch (Exception e) {
                System.out.println("No se han podido cargar el equipo correctamente");
            }
        }
        System.out.println("Mostramos los equipos tal cual se han introducido:");
        for (int i=0; i<aL_Equipos.size(); i++){
            System.out.println(aL_Equipos.get(i) + " ");
        }
        Collections.sort(aL_Equipos, ObjEquipos.compararPuntos);

        System.out.println("Mostramos los equipos ordenados:");
        for (int i=0; i<aL_Equipos.size(); i++){
            System.out.println(aL_Equipos.get(i) + " ");
        }

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


}
