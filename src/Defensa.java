public class Defensa extends Jugadores{

    private double distancia_recorrida;
    private int numero_faltas;


    public Defensa(){

    }

    public Defensa(String nombre, int edad, String genero, double distancia_recorrida, int numero_faltas) {
        super(nombre, edad, genero);
        this.distancia_recorrida = distancia_recorrida;
        this.numero_faltas = numero_faltas;
    }

    public double getDistancia_recorrida() {
        return distancia_recorrida;
    }

    public void setDistancia_recorrida(double distancia_recorrida) {
        this.distancia_recorrida = distancia_recorrida;
    }

    public int getNumero_faltas() {
        return numero_faltas;
    }

    public void setNumero_faltas(int numero_faltas) {
        this.numero_faltas = numero_faltas;
    }
}
