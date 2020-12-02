package Logic;

import java.util.ArrayList;
import java.util.List;

public abstract class Persona {

    protected String identificador;
    protected String nombre;
    protected String paterno;
    protected String materno;

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

    public boolean areDatosCorrectos() {
        return isIdentificadorValido()
                && isNombreValido()
                && isPaternoValido()
                && isMaternoValido();
    }

    public List<String> elementosFaltantes() {
        List<String> faltantes = new ArrayList<>(4);
        if (!isIdentificadorValido()) {
            faltantes.add("Identificador");
        }
        if (!isNombreValido()) {
            faltantes.add("Nombre");
        }
        if (!isPaternoValido()) {
            faltantes.add("Apellido paterno");
        }
        if (!isMaternoValido()) {
            faltantes.add("Apellido materno");
        }
        return faltantes;
    }

    @Override
    public String toString() {
        return "Persona{"
                + "\n   Identificador: " + identificador
                + "\n   Nombre: " + nombre
                + "\n   Apellido paterno: " + paterno
                + "\n   Apellido materno: " + materno
                + "\n}";
    }

    private boolean isIdentificadorValido() {
        return !identificador.equals("");
    }

    private boolean isNombreValido() {
        // TODO: hacer que este metodo devuelva false si el atributo contiene numeros
        return !nombre.equals("");
    }

    private boolean isPaternoValido() {
        // TODO: hacer que este metodo devuelva false si el atributo contiene numeros
        return !paterno.equals("");
    }

    private boolean isMaternoValido() {
        // TODO: hacer que este metodo devuelva false si el atributo contiene numeros
        return !materno.equals("");
    }

}
