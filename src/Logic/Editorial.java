package Logic;

public class Editorial {

    private String nombre;
    private int id;

    public Editorial(String nombre) {
        this.nombre = nombre;
    }

    public Editorial(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Editorial{" + "nombre: " + nombre + ", id: " + id + '}';
    }

}
