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
    
    
    public int posicionMayor(){
        int mayor = -2;
        if(productos[0]==null){
            return mayor;
            
        } else if (productos[1]==null){
            mayor = 0;
            return mayor;
        }
        for(int i = 0; i< productos.length; i++){
            if(productos[i]==null){
                
            } else if(productos[mayor].getPrecio() < productos[i].getPrecio()) {
                mayor = i;
            }
        }
        return mayor;
    }
    public int posicionMenor(){
        int menor = 0;
        
        for(int i = 0; i< productos.length; i++){
            if(productos[i]==null){
                
            } else if(productos[menor].getPrecio() > productos[i].getPrecio()) {
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

    public Producto busqueda(String nom) {
        
        
        for (int i = 0; i < cantidadDatos; i++) {
            if (nom.equals(productos[i].getNombre())) {
                return productos[i];
            } 
                
                
        }
        return null;
        
    }

    public void eliminar(int pos) {
        productos[pos] = null; //Como no existe referencia al objeto que estaba guardado aquí
        //será eliminado de memoria por el garbage collector

        //Es necesario desplazar todos los elementos siguientes a la posicion eliminada para
        //no dejar una posicion intermedia con valor null
        int i = pos;
        int contador = 0;
        while (productos[i + 1] != null) {
            productos[i] = productos[i + 1];
            System.out.println(productos[contador].getNombre()+"mensaje");
            i++;
            contador++;
        }
        cantidadDatos--;
        

    }

}
