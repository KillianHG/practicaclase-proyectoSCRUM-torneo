public class Medio extends Jugadores {

    private double velocitatm;
    private int gols;

    public Medio(String nombre, int edad, String genero, double velocitatm, int gols) {
        super(nombre, edad, genero);
        this.velocitatm = velocitatm;
        this.gols = gols;
    }

    public double getVelocitatm() {
        return velocitatm;
    }

    public void setVelocitatm(double velocitatm) {
        this.velocitatm = velocitatm;
    }

    public int getGols() {
        return gols;
    }

    public void setGols(int gols) {
        this.gols = gols;
    }

    @Override
    public String toString() {
        return "Medio{" +
                "velocitatm=" + velocitatm +
                ", gols=" + gols +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", genero='" + genero + '\'' +
                '}';
    }
}
