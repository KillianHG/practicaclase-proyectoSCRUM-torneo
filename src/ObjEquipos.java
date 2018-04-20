import java.util.ArrayList;
import java.util.Comparator;


public class ObjEquipos {

    private String nomEquip;
    private ArrayList<Jugadores> jugadores = new ArrayList<Jugadores>();
    private int victorias;
    private int derrotas;
    private int empates;
    private int puntos;

    @Override
    public String toString() {
        return "ObjEquipos{" +
                "nomEquip='" + nomEquip + '\'' +
                ", jugadores=" + jugadores +
                ", victorias=" + victorias +
                ", derrotas=" + derrotas +
                ", empates=" + empates +
                ", puntos=" + puntos +
                '}';
    }

    public ObjEquipos(String nomEquip, ArrayList<Jugadores> jugadores) {
        this.nomEquip = nomEquip;
        this.jugadores = jugadores;
        this.victorias = 0;
        this.derrotas = 0;
        this.empates = 0;
        this.puntos = 0;
    }

    public String getNomEquip() {
        return nomEquip;
    }

    public ArrayList<Jugadores> getJugadores() {
        return jugadores;
    }

    public void setNomEquip(String nomEquip) {
        this.nomEquip = nomEquip;
    }

    public void setVictorias(int victorias) {
        this.victorias = victorias;
    }

    public void setDerrotas(int derrotas) {
        this.derrotas = derrotas;
    }

    public void setEmpates(int empates) {
        this.empates = empates;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public int getVictorias() {

        return victorias;
    }

    public int getDerrotas() {
        return derrotas;
    }

    public int getEmpates() {
        return empates;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setJugadores(ArrayList<Jugadores> jugadores) {

        this.jugadores = jugadores;

    }

    public static Comparator<Equipos> compararPuntos = new Comparator<Equipos>() {
        public int compare(Equipos e1, Equipos e2) {
            int equipo1 = e1.getPuntos();
            int equipo2 = e2.getPuntos();

            //ordre ascendent
            if (equipo2>=equipo1) return 1;
            else return -1;
            //ordre descendent
            //return alumneNom2.compareTo(alumneNom1);
        }};

}
