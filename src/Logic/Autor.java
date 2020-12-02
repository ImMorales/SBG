package Logic;

public class Autor extends Persona {

    private Autor(String nombre, String paterno) {
        this.nombre = nombre;
        this.paterno = paterno;
    }

    private Autor(String nombre, String paterno, String materno) {
        this.nombre = nombre;
        this.paterno = paterno;
        this.materno = materno;
    }

    private Autor(String id, String nombre, String paterno, String materno) {
        this.identificador = id;
        this.nombre = nombre;
        this.paterno = paterno;
        this.materno = materno;
    }

    public static Autor getAutorInstance(String nombre, String paterno, String materno) {
        return new Autor(nombre, paterno, materno);
    }

    public static Autor getAutorInstance(String nombre, String paterno) {
        return new Autor(nombre, paterno);
    }

    public static Autor getAutorInstanceWithId(String id, String nombre, String paterno, String materno) {
        return new Autor(id, nombre, paterno, materno);
    }

    public static Autor getAutorInstanceWithId(String id, String nombre, String paterno) {
        Autor a = new Autor(nombre, paterno);
        a.setIdentificador(id);
        return a;
    }

    @Override
    public String toString() {
        return "Autor{"
                + " ID: " + identificador
                + ", Nombre: " + nombre
                + ", Apellido paterno: " + paterno
                + ", Apellido materno: " + materno
                + '}';
    }

}
