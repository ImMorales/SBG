/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

/**
 *
 * @author luis-ccc
 */
public class Estudiante extends Persona {

    private int grado;
    private String grupo;

    public int getGrado() {
        return grado;
    }

    public void setGrado(int grado) {
        this.grado = grado;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    @Override
    public String toString() {
        return "Estudiante { \n"
                + "\tId: " + getIdentificador() + "\n"
                + "\tNombre: " + getNombre() + "\n"
                + "\tA. Paterno: " + getPaterno() + "\n"
                + "\tA. Materno: " + getMaterno() + "\n"
                + "\tGrado: " + getGrado() + "\n"
                + "\tGrupo: " + getGrupo() + "\n}";
    }

}
