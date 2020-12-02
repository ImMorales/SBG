package Logic;

public abstract class Persona {

    private String nombre;
    private String paterno;
    private String materno;
    private String identificador;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    public String getMaterno() {
        return materno;
    }

    public void setMaterno(String materno) {
        this.materno = materno;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    @Override
    public String toString() {
        return "Persona{ " + "nombre: " + nombre + ", paterno: " + paterno + ", materno: " + materno + ", identificador: " + identificador + '}';
    }

}
