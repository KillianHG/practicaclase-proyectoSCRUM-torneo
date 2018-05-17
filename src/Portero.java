 public class Portero extends Jugadores {

        private int numero_paradas;
        private String guantes ;

        public Portero(){

        }

     public Portero(String nombre, int edad, String genero, int numero_paradas, String guantes) {
         super(nombre, edad, genero);
         this.numero_paradas = numero_paradas;
         this.guantes = guantes;
     }

     public int getNumero_paradas() {
         return numero_paradas;
     }

     public void setNumero_paradas(int numero_paradas) {
         this.numero_paradas = numero_paradas;
     }

     public String getGuantes() {
            return guantes;
        }

        public void setGuantes(String guantes) {
            this.guantes = guantes;
        }
    }






