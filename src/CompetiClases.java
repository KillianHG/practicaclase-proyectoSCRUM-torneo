import java.util.Scanner;
public class CompetiClases {
    public static void JornadasClasi() {
        int [] dmaj = new int[4];
        int jornada = 1;
        Jornadas(dmaj, jornada);
        Partidos(dmaj, jornada);
        Clasificacion();
    }
   public static int  numeroEquipos;
   public static int numeroEquiposGuardado;
   public static String[] equipos;
   public static int numeroPartidos;
   public static String[][] matrizPartidos;
   public static int[][] clasi;
   public static int di = 0;
    //Algoritmo y automatizar vienen cogidos de la mano.
    //Para generar las jornadas debemos demostrar la formula anterior, generando cada uno de los casos posibles.
    //Para eso, usamos el siguiente algoritmo:

    public static void Jornadas(int[]dmaj, int jornada) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el numero de equipos");
        numeroEquipos = sc.nextInt();
        numeroEquiposGuardado =(int) numeroEquipos;
        //Depuradora
        String a = sc.nextLine();
        equipos = new String[numeroEquiposGuardado];


        //Nombramos los Equipos
        System.out.println("Introduce el nombre de los equipos");
        System.out.println("");
        System.out.println("");
        for (int i = 0; i <equipos.length ; i++) {
            int ii=i+1;
            System.out.println("    EQUIPO " + ii +":   ");
            equipos[i] = sc.nextLine();
            //equipos[i] = (int)(Math.random()*1000);
        }


        //Generador de total de partidos sin repetir (vuelta x 2)
        numeroPartidos = (numeroEquipos/2)*(numeroEquipos-1);


        //Matriz de Equipos, Partidos y Puntos.
        int totalPartidos = (int) numeroPartidos;
        matrizPartidos = new String[totalPartidos][2];


        int x = 0;
        int y = 1;
        int z = 1;

        //Generador Partidos 2.0
        for (int i = 0; i <numeroPartidos ; i++) {

            matrizPartidos[i][0] = equipos[x];
            matrizPartidos[i][1] = equipos[y];

            x++;
            y++;
            if(y == numeroEquipos){
                z++;
                y = z;
                x = 0;
            }
        }

        //Fechas
        jornada = 1;
        int dia = 0;
        int mes = 0;
        int año = 2017;


        System.out.println("¿Quieres usar fechas aleatorias?");
        boolean fechasAleatorias=true;
        String fechas;
        int validarFecha = 0;
        int validarOpcion = 0;
        //String c = sc.nextLine();

        while(validarOpcion == 0){
            fechas = sc.nextLine();
            if(fechas.toLowerCase().equals("si")){
                validarOpcion++;
                while(validarFecha == 0){
                    //Randomizador de fechas
                    dia = (int)(Math.random()*30);
                    mes = (int)(Math.random()*12);
                    año = (int)(Math.random()*100)+1917;
                    validarFecha=FechaInicioJornadas(dia, mes, validarFecha, fechasAleatorias);
                }

            }
            else if(fechas.toLowerCase().equals("no")){
                fechasAleatorias=false;
                validarOpcion++;
                System.out.println("introduce la fecha de inicio  dd / mm / 2017");
                // Validamos la fecha

                while(validarFecha == 0){
                    dia = sc.nextInt();
                    mes = sc.nextInt();
                    FechaInicioJornadas(dia, mes, validarFecha, fechasAleatorias);
                    validarFecha=FechaInicioJornadas(dia, mes, validarFecha, fechasAleatorias);
                    String w = sc.nextLine();
                }
            }else{
                System.out.println("No te hemos entendido");
                System.out.println("");
                System.out.println("¿Quieres usar una fecha aleatoria?");
            }
        }

        validarOpcion = 0;


        System.out.println("¿Quieres simular partidos de vuelta?   Si / No");

        String vuelta = "asd";

        while(validarOpcion == 0){
            vuelta = sc.nextLine();
            if(vuelta.toLowerCase().equals("si")){
                validarOpcion++;
            }
            else if(vuelta.toLowerCase().equals("no")){
                validarOpcion++;
            }else{
                System.out.println("No te hemos entendido.");
                System.out.println("¿Quieres simular partidos de vuelta?   Si / No");

            }
        }
        dmaj[0]=dia;
        dmaj[1]=mes;
        dmaj[2]=año;
        dmaj[3]=jornada;
        switch (vuelta.toLowerCase()){
            case "si":
                //Mostramos el calendario por jornadas
                for (int i = 0; i <numeroPartidos ; i++) {
                    System.out.println("-----");
                    System.out.println("JORNADA  " + dmaj[3] + "  --->   " + matrizPartidos[i][0] + " VS "
                            + matrizPartidos[i][1] + "    "  +dmaj[0]+ " / " + dmaj[1] + " / " + dmaj[2]  );

                    CalendarioJornadas(dmaj);

                }
                dmaj[0] = dmaj[0] + 7;
                dmaj[3] = 1;
                System.out.println("");
                System.out.println("      ------      ");
                System.out.println("Partidos de vuelta");
                System.out.println("      ------      ");
                System.out.println("");

                for (int i = 0; i <numeroPartidos ; i++) {
                    System.out.println("-----");
                    System.out.println("JORNADA DE VUELTA " + dmaj[3] + "  --->   " + matrizPartidos[i][1] + " VS "
                            + matrizPartidos[i][0] + "    "  +dmaj[0]+ " / " + dmaj[1] + " / " + dmaj[2]  );
                    CalendarioJornadas(dmaj);
                }
                break;
            case "no":
                //Mostramos el calendario por jornadas
                jornada = 1;
                for (int i = 0; i <numeroPartidos ; i++) {
                    System.out.println("-----");
                    System.out.println("JORNADA  " + jornada + "  --->   " + matrizPartidos[i][0] + " VS "
                            + matrizPartidos[i][1] + "    "  +dia+ " / " + mes + " / " + año  );

                    dia = dia + (int)(Math.random()*3)+1;
                    jornada++;

                    //Calendario
                    if(dia==31){
                        dia = 1;
                        mes = mes +1;
                    }
                    if(dia == 32){
                        dia = 2;
                        mes = mes + 1 ;
                    }
                    if(dia >= 33){
                        dia = 3;
                        mes = mes +1;
                    }
                    if(mes == 13){
                        año = año + 1;
                        mes = 1;
                    }
                    if(dia == 6 || dia ==13 || dia ==20 || dia ==27){
                        dia = dia +2;
                    }
                    if(dia == 7 || dia ==14 || dia ==21 || dia ==28){
                        dia++;
                    }
                    if(dia ==29 && mes == 2){
                        dia = dia +2;
                    }
                    if (dia == 30 && mes == 2){
                        dia++;
                    }
                    if(dia == 25 && mes == 12){
                        dia++;
                    }
                    if(dia == 1 && mes == 1){
                        dia++;
                    }
                }
        }

    }

    //Creacion de fechas (festivos, etc)
    public static int FechaInicioJornadas(int dia, int mes, int validarFecha, boolean fechasAleatorias){
        if(dia == 6 || dia ==7 || dia ==13 || dia ==14 || dia ==20 || dia ==21 || dia ==27 || dia ==28){
            System.out.println("No se juega en fines de semana");
        }
        else if(dia > 30){
             System.out.println("Recuerda que por ahora, los meses solo tienen 30 dias");
        }
        else if(dia == 25 && mes == 12){
             System.out.println("No se juega en festivos");
        }
        else if(dia == 1 && mes == 1){
             System.out.println("No se juega en festivos");
        }
        else if(mes == 7 || mes == 8){
            System.out.println("No se juega en Verano");
        }
        else if(dia >=29 && mes == 2){
            System.out.println("Febrero sí tiene 28 dias");
        }
        else if(dia <= 0 || mes <= 0){
            System.out.println("Introduce una fecha valida, por favor.");
        }
        else{
            validarFecha++;
        }
        return validarFecha;
    }

    public static int[] CalendarioJornadas (int []dmaj) {

        dmaj[0] = dmaj[0] + (int) (Math.random() * 3) + 1;
        dmaj[3]++;

        //Calendario
        if (dmaj[0] == 31) {
            dmaj[0] = 1;
            dmaj[1] = dmaj[1] + 1;
        }
        if (dmaj[0] == 32) {
            dmaj[0] = 2;
            dmaj[1] = dmaj[1] + 1;
        }
        if (dmaj[0] >= 33) {
            dmaj[0] = 3;
            dmaj[1] = dmaj[1] + 1;
        }
        if (dmaj[1] == 13) {
            dmaj[2] = dmaj[2] + 1;
            dmaj[1] = 1;
        }
        if (dmaj[0] == 6 || dmaj[0] == 13 || dmaj[0] == 20 || dmaj[0] == 27) {
            dmaj[0] = dmaj[0] + 2;
        }
        if (dmaj[0] == 7 || dmaj[0] == 14 || dmaj[0] == 21 || dmaj[0] == 28) {
            dmaj[0]++;
        }
        if (dmaj[0] == 29 && dmaj[1] == 2) {
            dmaj[0] = dmaj[0]+ 2;
        }
        if (dmaj[0] == 30 && dmaj[1] == 2) {
            dmaj[0]++;
        }
        if (dmaj[0]== 25 && dmaj[1] == 12) {
            dmaj[0]++;
        }
        if (dmaj[0] == 1 && dmaj[1] == 1) {
            dmaj[0]++;
        }
        return dmaj;
    }

    public static void Partidos(int []dmaj, int jornada) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Quieres Introducir los resultados de los partidos?");
        String resultados = "asd";
        int validarOpcion = 0;
        int primerResultado;
        int segundoResultado;
        clasi= new int[numeroEquiposGuardado][4];
        /*int[] puntosEquipo = new int[numeroEquiposGuardado];
        int[] victorias = new int[numeroEquiposGuardado];
        int[] derrotas = new int[numeroEquiposGuardado];
        int[] empates = new int[numeroEquiposGuardado];*/


        //Victorias [][0], Empates[][1], Derrotas [][2], Puntos [][3]
        for (int i = 0; i <numeroEquiposGuardado ; i++) {
            clasi[i][3] = 0;
        }
        int x = 0;
        int y = 1;
        int z = 1;
        jornada = 1;
        while(validarOpcion == 0){
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
        }

        switch (resultados.toLowerCase()){
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

                break;
            case "no":
                System.out.println("ADEU :D");
                break;
        }
    }

/*A partir de una matriz de int(donde estan las victorias, empates, derrotas y puntos de cada equipo)
y una array de String (donde estan los nombres de cada equipo), este metodo los ordena de mayor a menor
segun el numero de puntos que tenga cada equipo*/
/*para ordenar la matriz comparo puntos empezando por el final de la matriz y en caso de ser mayor que el
valor de una posicion anterior se intercambian utilizando un auxiliar que en este caso es el valor "aux" o
"auxstr" el cual se usa como auxiliar para strings
el indice "i" del bucle for representa la posicion actual la cual quieres comparar, y el indice "j"
es la posicion con la cual quieres comprara que empieza siendo =i-1 para que no se compare dos posiciones iguales*/

/*Para intercambiar valores compara matriz[i][3] (la columna en la posicion 3 representa los puntos) con
matriz[j][3], en caso de que el valor cuyo indice es "i" sea mayor al valor de indice "j" pasamos el valor
de indice "i" a un auxiliar y el el valor de indice "i" pasa a ser igual al valor de indice "j" y como ultimo
paso, el valor de indice "j" pasa a ser igual al valor del auxiliar y dentro del mismo if, tambien intercambiamos
las posiciones de la matriz que representen las victorias, empates y derrota y hacemos lo mismo con los
nombres de los equipos*/

//numeroEquiposGuardado es el numero de equipos que hay en la liga, y se utiliza para establecer el tamaño del bucle for
//clasi[][] es la matriz de 4 columnas que contienen [victorias,empates,derrotas,puntos] de cada equipo y las filas representan a cada equipo.


    public static void Clasificacion()  {
        //ordenar automaticamente todos los equipos
        int ne=numeroEquiposGuardado-1;
        for (int i=ne; i>=0; i--){
            for (int aux=i-1; aux>=0; aux--) {
                if (clasi[i][3]>clasi[aux][3]) {
                    int s=clasi[i][3];

                    clasi[i][3]=clasi[aux][3];
                    clasi[aux][3]=s;
                    s=clasi[i][2];
                    clasi[i][2]=clasi[aux][2];
                    clasi[aux][2]=s;
                    s=clasi[i][1];
                    clasi[i][1]=clasi[aux][1];
                    clasi[aux][1]=s;
                    s=clasi[i][0];
                    clasi[i][0]=clasi[aux][0];
                    clasi[aux][0]=s;
                    String ss=equipos[i];
                    equipos[i]=equipos[aux];
                    equipos[aux]=ss;
                }
            }
        }

        //imprimir clasificacion ordenada
        System.out.print("\nCLASIFICACION DE FUTBOL\n");
        for (int x=1;x<=numeroEquiposGuardado;x++) {
            int y=x-1;
            System.out.print("\n"+x+". "+equipos[y]+" - "+clasi[y][0]+" victorias - "+clasi[y][1]+" empates - "+clasi[y][2]+" derrotas - "+clasi[y][3]+" puntos");
        }
        di=1;
    }
    public static void OrdenarClasificacion() {
        int ne=numeroEquiposGuardado-1;
        for (int i=ne; i>=0; i--){
            for (int aux=i-1; aux>=0; aux--) {
                if (clasi[i][3]>clasi[aux][3]) {
                    int s=clasi[i][3];

                    clasi[i][3]=clasi[aux][3];
                    clasi[aux][3]=s;
                    s=clasi[i][2];
                    clasi[i][2]=clasi[aux][2];
                    clasi[aux][2]=s;
                    s=clasi[i][1];
                    clasi[i][1]=clasi[aux][1];
                    clasi[aux][1]=s;
                    s=clasi[i][0];
                    clasi[i][0]=clasi[aux][0];
                    clasi[aux][0]=s;
                    String ss=equipos[i];
                    equipos[i]=equipos[aux];
                    equipos[aux]=ss;
                }
            }
        }
    }
    public static void ImprimirClasificacion(){
        System.out.print("\nCLASIFICACION DE FUTBOL\n");
        for (int x=1;x<=numeroEquiposGuardado;x++) {
            int y=x-1;
            System.out.print("\n"+x+". "+equipos[y]+" - "+clasi[y][0]+" victorias - "+clasi[y][1]+" empates - "+clasi[y][2]+" derrotas - "+clasi[y][3]+" puntos");
        }
        di=1;
    }


}
