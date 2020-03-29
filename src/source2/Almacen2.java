/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package source2;

import javax.swing.JOptionPane;
import source.Producto;

/**
 *
 * @author f_fig
 */
public class Almacen2 {

    public Producto[] productos;

    public Almacen2() {
        this.productos = new Producto[1000];
    }

    public void insertar(Producto p) {
        int i = 0;
        while (productos[i] != null) {
            i++;

        }
        productos[i] = p;

    }

    public void eliminar(int pos) {
        productos[pos] = null; //Como no existe referencia al objeto que estaba guardado aquí
        //será eliminado de memoria por el garbage collector

        //Es necesario desplazar todos los elementos siguientes a la posicion eliminada para
        //no dejar una posicion intermedia con valor null
        int i = pos;
        while (productos[i + 1] != null) {
            productos[i] = productos[i + 1];
            i++;
        } 
        productos [i] = null;

    }

}


