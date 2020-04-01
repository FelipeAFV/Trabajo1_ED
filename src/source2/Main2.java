/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package source2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Scanner;
import javax.swing.JOptionPane;
import source.Producto;

/**
 *
 * @author f_fig
 */
public class Main2 {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        String strInput;
        int numInput;
        double dblInput;
        String s0 = "Salir (0)";
        String s1 = "Bienvenido, señecciona una acción";
        String s2 = "Agregar producto (1)";
        String s3 = "Eliminar producto (2)";
        String s4 = "Modificar producto (3)";
        String s5 = "Buscar un producto(4)";
        String s12 = "Buscar el producto de menor precio(5)";
        String s13 = "Buscar el producto de mayor precio(6)";
        String s6 = "Elija la posicion del producto a modificar";
        String s7 = "Modificar nombre(1)";
        String s8 = "Modificar proveedor(2)";
        String s9 = "Modificar unidad(3)";
        String s10 = "Modificar cantidad(4)";
        String s11 = "Modificar precio(5)";

        Scanner input = new Scanner(new File("C:\\Users\\f_fig\\Documents\\NetBeansProjects\\trabajo1\\src\\main\\java\\source2\\basededatos.txt"));
        input.useDelimiter("\\,");
        Almacen2 a = new Almacen2();
        Menu menu = new Menu();
        Imprimir impr = new Imprimir();

        while (input.hasNext()) {

            String d1 = input.next();
            System.out.println(d1);
            String d2 = input.next();
            System.out.println(d2);
            String d3 = input.next();
            System.out.println(d3);
            double d4 = Double.parseDouble(input.next());
            System.out.println(d4);
            double d5 = Double.parseDouble(input.next());
            System.out.println(d5);
            Producto c = new Producto(d1, d2, d3, d4, d5);

            a.insertar(c);

        }
        System.out.println("lacantidad de datos es  "+a.cantidadDatos);

        boolean estado = true;
        while (estado) {
            numInput = menu.mostrarOpciones(s1, s2, s3, s4, s5, s12, s13, s0);
            switch (numInput) {
                case 0:
                    estado = false;
                    break;
                case 1:
                    String nombre = JOptionPane.showInputDialog("Escriba el nombre del producto");
                    String proveedor = JOptionPane.showInputDialog("Escriba el proveedor del producto");
                    String unidad = JOptionPane.showInputDialog("Escriba la unidad de cantidad del producto");
                    double cantidad = Double.parseDouble(JOptionPane.showInputDialog("Escriba la cantidad de producto"));
                    double precio = Double.parseDouble(JOptionPane.showInputDialog("Escriba el precio del producto"));
                    Producto p = new Producto(nombre, proveedor, unidad, cantidad, precio);
                    a.insertar(p);
                    System.out.println(a.productos[2].getNombre());
                    break;
                case 2:
                    File fl = new File("C:\\Users\\f_fig\\Documents\\NetBeansProjects\\trabajo1\\src\\main\\java\\source2\\basededatos.txt");
                    FileWriter fw = new FileWriter(fl);
                    BufferedWriter bw = new BufferedWriter(fw);
                    
                    int pos = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la posicion del produto a eliminar"));
                    a.eliminar(pos);
                    
                    for (int i = 0; i < a.cantidadDatos; i++) {
                        bw.write(a.productos[i].getNombre() + "," + a.productos[i].getProveedor() + "," + a.productos[i].getUnidad() + "," + a.productos[i].getCantidad() + "," + a.productos[i].getPrecio() + ",");
                    }
                    bw.flush();
                    bw.close();
                    fw.close();
                   
                    break;
                case 3:
                    int posicion = menu.mostrarOpciones(s6);
                    numInput = menu.mostrarOpciones(s7, s8, s9, s10, s11);
                    switch (numInput) {
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
                    strInput = JOptionPane.showInputDialog("Ingrese el nombre del objeto a buscar");
                    Producto encontrado = a.busqueda(strInput);
                    if (encontrado == null) {
                        JOptionPane.showMessageDialog(null, "No existe el producto");
                    } else {
                        JOptionPane.showMessageDialog(null, "Producto encontrado:" + "\n" + encontrado.toString());
                    }

                    break;
                case 5:
                    numInput = a.posicionMenor();
                    if (numInput == -2) {
                        JOptionPane.showMessageDialog(null, "El almacen está vacío");
                    } else {
                        JOptionPane.showMessageDialog(null, "El producto de menor valor es" + "\n" + a.productos[numInput].toString());
                    }
            }
        }
        System.out.println(a.productos[0].getNombre());
        System.out.println(a.productos[2].getNombre());

    }

}
