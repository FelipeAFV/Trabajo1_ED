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
    public int cantidadDatos = 0;

    public Almacen2() {
        this.productos = new Producto[1000];
    }

    public int posicionMayor() {

        int mayor = 0;

        for (int i = 0; i < productos.length; i++) {
            if (productos[i] == null) {

            } else if (productos[mayor].getPrecio() < productos[i].getPrecio()) {
                mayor = i;
            }
        }
        return mayor;
    }
    public int contarMayores(int pos){
        int contador = 0;
        for (int i = 0; i < cantidadDatos; i++){
            if(productos[i].getPrecio() > productos[pos].getPrecio()){
                contador ++;
            }
        }
        return contador;
    }
    public int contarMenores(int pos){
        int contador = 0;
        for (int i = 0; i < cantidadDatos; i++){
            if(productos[i].getPrecio() < productos[pos].getPrecio()){
                contador ++;
            }
        }
        return contador;
    }
    public int posicionMenor() {
        int menor = 0;

        for (int i = 0; i < productos.length; i++) {
            if (productos[i] == null) {

            } else if (productos[menor].getPrecio() > productos[i].getPrecio()) {
                menor = i;
            }
        }

        return menor;
    }

    public void insertar(Producto p) {
        int i = 0;
        while (productos[i] != null) {
            i++;

        }
        productos[i] = p;
        cantidadDatos++;

    }

    public Producto busqueda(String id) {

        for (int i = 0; i < cantidadDatos; i++) {
            if (id.equals(productos[i].getId())) {
                return productos[i];
            }

        }
        return null;

    }
    public int findIndex(String id){
        int i =0;
        while (!id.equals(productos[i].getId())){
            i++;
        }
        return i;
    }
    private double prom(){
        double valor = 0;
        for (int i = 0; i<cantidadDatos; i++) {
            valor = valor + productos[i].getPrecio();
        }
        valor = Math.round(valor/cantidadDatos);
        return valor;
    }
    public void analisis(){
        JOptionPane.showMessageDialog(null, "El producto de menor precio es: " +"\n"
                + productos[posicionMenor()].toString());
        JOptionPane.showMessageDialog(null, "El producto de mayor precio es: " +"\n"
                + productos[posicionMayor()].toString());
        JOptionPane.showMessageDialog(null, "El promedio de los precios es: " + prom());
              
    }
    public void mostrarIds(){
        for(int i =0; i<cantidadDatos;i++){
            System.out.println("NOMBRE: "+ productos[i].getNombre()+ " ID: "+ productos[i].getId());
        }
    }

    public void eliminar(String id) {
        int pos = findIndex(id);
        productos[pos] = null; //Como no existe referencia al objeto que estaba guardado aquí
        //será eliminado de memoria por el garbage collector

        //Es necesario desplazar todos los elementos siguientes a la posicion eliminada para
        //no dejar una posicion intermedia con valor null
        int i = pos;
        int contador = 0;
        while (productos[i + 1] != null) {
            productos[i] = productos[i + 1];
            
            i++;
            contador++;
        }
        cantidadDatos--;

    }

}
