package src.logica;

public class AtencionAlCliente extends Empleado {

    public AtencionAlCliente(String nombre, String apellido) {
        super(nombre, apellido);
    }

    @Override
    public int obtenerDiasVacaciones(int antiguedad) {
        if (antiguedad == 1) {
            return 6;
        } else if (antiguedad >= 2 && antiguedad <= 6) {
            return 14;
        } else {
            return 20;
        }
    }
}