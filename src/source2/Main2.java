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
        double dblInput;
        String s0 = "Salir (0)";
        String s1 = "Bienvenido, señecciona una acción";
        String s2 = "Agregar producto (1)"; 
        String s3 = "Eliminar producto (2)";
        String s4 = "Modificar producto (3)";
        String s5 = "Elija la posicion del producto a modificar";
        String s6 = "Modificar nombre(1)";
        String s7 = "Buscar un producto(4)";
        String s8 = "Modificar proveedor(2)";
        String s9 = "Modificar unidad(3)";
        String s10 = "Modificar cantidad(4)";
        String s11 = "Modificar precio(5)";
        
    
        
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
            numInput = menu.mostrarOpciones(s1, s2, s3, s4,s7,s0);
            switch(numInput){
                case 0:
                    estado = false;
                    break;
                case 1:
                    String nombre = JOptionPane.showInputDialog("Escriba el nombre del producto");
                    String proveedor = JOptionPane.showInputDialog("Escriba el proveedor del producto");
                    String unidad = JOptionPane.showInputDialog("Escriba la unidad de cantidad del producto");
                    double cantidad = Double.parseDouble(JOptionPane.showInputDialog("Escriba la cantidad de producto"));
                    double precio = Double.parseDouble(JOptionPane.showInputDialog("Escriba el precio del producto"));
                    Producto p = new Producto(nombre, proveedor,unidad,cantidad,precio);
                    a.insertar(p);
                    System.out.println(a.productos[2].getNombre());
                    break;
                case 2:
                    int pos =  Integer.parseInt(JOptionPane.showInputDialog("Ingrese la posicion del produto a eliminar"));
                    a.eliminar(pos);
                    System.out.println(a.productos[1].getNombre());
                    break;
                case 3:
                    int posicion = menu.mostrarOpciones(s5);
                    numInput = menu.mostrarOpciones(s6,s8,s9,s10,s11);
                    switch(numInput){
                        case 1:
                            strInput = JOptionPane.showInputDialog("Escriba el nuevo nombre");
                            a.productos[posicion].setNombre(strInput);
                            break;
                        case 2:
                            strInput = JOptionPane.showInputDialog("Escriba el nuevo proveedor");
                            a.productos[posicion].setProveedor(strInput);
                            break;
                        case 3:
                            strInput = JOptionPane.showInputDialog("Escriba la nuevo unidad");
                            a.productos[posicion].setUnidad(strInput);
                            break;
                        case 4:
                            dblInput = Double.parseDouble(JOptionPane.showInputDialog("Escriba el nuevo cantidad"));
                            a.productos[posicion].setCantidad(dblInput);
                            break;
                        case 5:
                            dblInput = Double.parseDouble(JOptionPane.showInputDialog("Escriba el nuevo precio"));
                            a.productos[posicion].setPrecio(dblInput);
                            break;
                            
                
                        
                    }
                case 4:
                    //Buscar un producto
                    break;
            }
        }
        System.out.println(a.productos[0].getNombre());
        System.out.println(a.productos[2].getNombre());
        
        
        
        
    }
          
    
}
