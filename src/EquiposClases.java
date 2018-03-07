
import java.util.Scanner;

public class EquiposClases {

    // EQUIPOS
    // En esta accion lo que hacemos es primeramente , que te pregunte los equipos que quiere crear ,
    // luego los almacena en un array de strings los nombres de los equipos (el numero de este dependera
    // de el valor que se ha introducido previamente). Finalmente preguntara el numero de personas que
    // forman el equipo , este se almacenara en una variable que dira el numero de veces que se ejecutara
    // la accion 'introdatos'

    public static void Equipos() {
        Scanner sc = new Scanner(System.in);
        int a;
        System.out.println("Cuantos equipos quieres crear?");
        int numero = sc.nextInt();
        String [] nombreequipo = new String[numero];

        for (int i = 0; i < numero ; i++) {
            System.out.println("Introduce el nombre del equipo");
            nombreequipo[i] = sc.next();

            System.out.println("Introduce el numero de personas que forman el equipo");
            a = sc.nextInt();

            introdatos(a);

        }
    }

    //INTRO_DATOS
    // Como su nombre indica , esta accion nos permite introduccir los datos de cada uno de los jugadores
    // este incluye el nombre , edad y genero. Una vez recolectados todos los datos , llama a "edad" y
    // "genero".

    public static void introdatos(int a){
        Scanner sc = new Scanner(System.in);
        int mayor, menor, masculino, femenino, otro, resultath, resultatm, resultato;
        mayor = 0;
        menor = 0;
        masculino = 0;
        femenino = 0;
        otro = 0;
        resultath = 0;
        resultatm = 0;
        resultato = 0;
        int npersonas[] = new int[a];
        int edad[] = new int[a];
        String nombres[] = new String[a];
        int genero[] = new int[a];


        for (int b = 0; b < npersonas.length; b++) {


            System.out.println("Intorduce el nombre");
            nombres[b] = sc.next();


            System.out.println("Introduce la edad del sujeto");
            edad[b] = sc.nextInt();


            System.out.println("Selecciona el genero");
            System.out.println("1.Masculino");
            System.out.println("2.Femenino");
            System.out.println("3.Otro");
            genero[b] = sc.nextInt();


        }

        edad(edad,mayor,menor,a);

        genero(genero,masculino,femenino,otro,resultath,resultatm,resultato,a);

    }

    // EDAD
    // La accion edad lo que hace es mirar mediante los datos insertados en "INTRO_DATOS" quales són
    // mayores de edad y menores . Luego imprime los resultados.

    public static void edad (int []edad,int mayor ,int menor, int a ){

        for (int d = 0; d < edad.length; d++) {

            if (edad[d] >= 18) {
                mayor = mayor + 1;
            }
            if (edad[d] < 18) {
                menor = menor + 1;
            }
        }

        mayor = (mayor * 100) / a;
        System.out.println("El " + mayor + "% de los integrantes del equipo són mayores de edad \n");
        menor = (menor * 100) / a;
        System.out.println("El " + menor + "% de los integrantes del equipo són menores de edad \n");
    }

    // GENERO
    // Esta accion hace un uso similar a la anterior (EDAD) , de manera que distribuye las personas
    // dependiendo del genero de estos. Una vez imprimira los resultados dependiendo de si se identifican
    // gon el genero masculino , femenino o otro.

    public static void genero (int []genero, int masculino, int femenino, int otro, int resultath, int resultatm, int resultato, int a){

        for (int e = 0; e < genero.length; e++) {

            if (genero[e] == 1) {
                masculino = masculino + 1;
            }
            if (genero[e] == 2) {
                femenino = femenino + 1;
            }
            if (genero[e] == 3) {
                otro = otro + 1;
            }
        }
        resultath = (masculino * 100) / a;
        resultatm = (femenino * 100) / a;
        resultato = (otro * 100) / a;

        System.out.println("El " + resultath + "% del equipo  són hombres \n");
        System.out.println("El " + resultatm + "% del equipo  són mujeres \n");
        System.out.println("El " + resultato + "% del equipo  són otros \n");
    }


}