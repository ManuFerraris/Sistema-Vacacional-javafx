package src.logica;

//Clase hija: Logistica
public class Logistica extends Empleado {
    public Logistica(String nombre, String apellido) {
        super(nombre, apellido);
    }

    @Override
    public int obtenerDiasVacaciones(int antiguedad) {
        if (antiguedad == 1) {
            return 7;
        } else if (antiguedad >= 2 && antiguedad <= 6) {
            return 15;
        } else {
            return 22;
        }
    }
}