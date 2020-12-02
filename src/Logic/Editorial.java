package Logic;

public class Editorial {

    private int id;
    private String nombre;

    public Editorial() {

    }

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

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Editorial{"
                + "\n    ID: " + id
                + "\n    Nombre: " + nombre
                + "\n    }";
    }

    public boolean isNombreEmpty() {
        return nombre.equals("");
    }

}
