import java.util.*;

public class ObjEquipos {

    private String nomEquip;
    private int victorias;
    private int empates;
    private int derrotas;
    private int puntos;
    private ArrayList<Jugadores> jugadores = new ArrayList<Jugadores>();

    @Override
    public String toString() {
        return "ObjEquipos{" +
                "nomEquip='" + nomEquip + '\'' +
                ", jugadores=" + jugadores +
                '}';
    }

    public ObjEquipos(String nomEquip,ArrayList<Jugadores> jugadores) {
        this.nomEquip = nomEquip;
        this.victorias = 0;
        this.empates = 0;
        this.derrotas = 0;
        this.puntos = 0;
        this.jugadores = jugadores;
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

    public void setJugadores(ArrayList<Jugadores> jugadores) {

        this.jugadores = jugadores;
    }

}
