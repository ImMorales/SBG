package Logic;

import java.util.ArrayList;
import java.util.List;

public class Libro {

    private String nombre;
    private String desc;
    private String tipo;
    private String subgenero;
    private int cantidad;
    private int numDePaginas;
    private int id;
    private List<Autor> autor;
    private Editorial editorial = new Editorial();

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getSubgenero() {
        return subgenero;
    }

    public void setSubgenero(String subgenero) {
        this.subgenero = subgenero;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getNumDePaginas() {
        return numDePaginas;
    }

    public void setNumDePaginas(int numDePaginas) {
        this.numDePaginas = numDePaginas;
    }

    public List<Autor> getAutor() {
        return autor;
    }

    public void setAutor(List<Autor> autor) {
        this.autor = autor;
    }

    public Editorial getEditorial() {
        return editorial;
    }

    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Libro {"
                + "\n    Id: " + id
                + "\n    Nombre: " + nombre
                + "\n    Descripción: " + desc
                + "\n    Tipo: " + tipo
                + "\n    Subgenero: " + subgenero
                + "\n    Cantidad: " + cantidad
                + "\n    NumDePaginas: " + numDePaginas
                + "\n    " + autor
                + "\n    " + editorial
                + "\n}";
    }

    public boolean areDatosCorrectos() {
        return isAutorValido()
                && isEditorialValido()
                && isNombreValido()
                && isDescValido()
                && isTipoValido()
                && isSubgeneroValido()
                && isNumPaginasValido();
    }

    public List<String> elementosFaltantes() {
        List<String> faltante = new ArrayList<>(6);
        if (!isNombreValido()) {
            faltante.add("Nombre");
        }
        if (!isDescValido()) {
            faltante.add("Descripción");
        }
        if (!isSubgeneroValido()) {
            faltante.add("Subgenero");
        }
        if (!isTipoValido()) {
            faltante.add("Tipo");
        }
        if (!isNumPaginasValido()) {
            faltante.add("Número de páginas");
        }
        if (!isAutorValido()) {
            faltante.add("Autor(es)");
        }
        if (!isEditorialValido()) {
            faltante.add("Editorial");
        }
        return faltante;
    }

    private boolean isNombreValido() {
        return !nombre.equals("");
    }

    private boolean isDescValido() {
        return !desc.equals("");
    }

    private boolean isTipoValido() {
        return !tipo.equals("Seleccionar");
    }

    private boolean isNumPaginasValido() {
        return numDePaginas != 1;
    }

    private boolean isAutorValido() {
        return autor != null;
    }

    private boolean isEditorialValido() {
        return editorial != null;
    }

    private boolean isSubgeneroValido() {
        return !subgenero.equals("Seleccionar");
    }

}
