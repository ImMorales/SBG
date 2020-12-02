package Logic;

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
    private Editorial editorial;

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
                + " \n\t nombre: " + nombre
                + ",\n\t descripción: " + desc
                + ",\n\t tipo: " + tipo
                + ",\n\t subgenero: " + subgenero
                + ",\n\t cantidad: " + cantidad
                + ",\n\t numDePaginas: " + numDePaginas
                + ",\n\t id: " + id
                + ",\n\t autor: " + autor
                + ",\n\t editorial: " + editorial + "\n}";
    }

}
