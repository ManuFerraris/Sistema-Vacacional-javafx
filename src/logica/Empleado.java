package src.logica;

//Clase padre abstracta:
public abstract class Empleado {
    protected String nombre;
    protected String apellido;

    public Empleado(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    // El padre obliga a los hijos a implementar esto:
    public abstract int obtenerDiasVacaciones(int antiguedad);
}