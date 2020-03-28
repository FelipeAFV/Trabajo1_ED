/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package source2;

import java.lang.reflect.Array;
import javax.swing.JOptionPane;
import source.Producto;


/**
 *
 * @author f_fig
 */
public class Main2 {
    
  
    
    
    public static void main(String[] args) {
        String strInput;
        int numInput;
        String s0 = "Salir (0)";
        String s1 = "Bienvenido, señecciona una acción";
        String s2 = "Agregar producto (1)"; 
        String s3 = "Eliminar producto (2)";
        String s4 = "Modificar producto (3)";
        String s5 = "Elija la posicion del producto a modificar";
        String s6 = "Modificar nombre(1)";
    
        
        Almacen2 a = new Almacen2();
        Menu menu = new Menu();
        Producto p1 = new Producto("Producto1");
        Producto p2 = new Producto("Producto2");
       
        a.insertar(p1);
        System.out.println(a.productos[0].getNombre());
        a.insertar(p2);
        System.out.println(a.productos[1].getNombre());
        
        
        
        boolean estado = true;
        while(estado){
            numInput = menu.mostrarOpciones(s1, s2, s3, s0,s4);
            switch(numInput){
                case 0:
                    estado = false;
                    break;
                case 1:
                
                case 3:
                    int posicion = menu.mostrarOpciones(s5);
                    numInput = menu.mostrarOpciones(s6);
                    switch(numInput){
                        case 1:
                            strInput = JOptionPane.showInputDialog("Escriba el nuevo nombre");
                            a.productos[posicion].setNombre(strInput);
                            break;
                    }
            }
        }
        System.out.println(a.productos[0].getNombre());
        
        
        
        
    }
          
    
}
