public class Jugadores {

    String nombre;
    int edad;
    String genero;



    public Jugadores(String nombre,int edad, String genero){

        this.nombre=nombre;
        this.edad=edad;
        this.genero=genero;

    }

    public Jugadores(){
        this.nombre="";
        this.edad=18;
        this.genero="";

    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Jugadores{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", genero='" + genero + '\'' +
                '}';
    }
}
