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
public abstract class OperacionesEnBD {

    public final String tableName;

    public OperacionesEnBD(String table) {
        tableName = table;
    }

    public void seleccionar(String statement) {

    }

    public void insertar(String statement) {

    }

    public void eliminar(String id) {

    }

    public void actualizar(String id) {

    }

}
