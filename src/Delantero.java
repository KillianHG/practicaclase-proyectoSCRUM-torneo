public class Delantero extends Jugadores {

    private double velocitatm;
    private int gols;
    private String piernafavorable;

    public Delantero(String nombre, int edad, String genero, double velocitatm, int gols, String piernafavorable) {
        super(nombre, edad, genero);
        this.velocitatm = velocitatm;
        this.gols = gols;
        this.piernafavorable = piernafavorable;
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

    public String getPiernafavorable() {
        return piernafavorable;
    }

    public void setPiernafavorable(String piernafavorable) {
        this.piernafavorable = piernafavorable;
    }

    @Override
    public String toString() {
        return "Delantero{" +
                "velocitatm=" + velocitatm +
                ", gols=" + gols +
                ", piernafavorable='" + piernafavorable + '\'' +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", genero='" + genero + '\'' +
                '}';
    }
}
