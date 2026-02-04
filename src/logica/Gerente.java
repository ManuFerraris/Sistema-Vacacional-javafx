package src.logica;

//Clase hija: Gerente.
public class Gerente extends Empleado {

    public Gerente(String nombre, String apellido) {
        super(nombre, apellido);
    }

    @Override
    public int obtenerDiasVacaciones(int antiguedad) {
        // Formula de Gerente
        if (antiguedad == 1) {
            return 10;
        } else if (antiguedad >= 2 && antiguedad <= 6) {
            return 20;
        } else {
            return 30;
        }
    }
}