/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package source2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.Scanner;
import javax.swing.JOptionPane;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import source.Producto;

/**
 *
 * @author f_fig
 */
public class Main2 {

    public static void leerExcel(Almacen2 a) throws IOException {

    }

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
        String s14 = "Buscar la cantidad de productos de mayor precio que otro producto(7)";
        String s15 = "Buscar la cantidad de productos de menor precio que otro producto(8)";
        String s16 = "Imprimir un analisis de los datos(9)";
        String s17 = "Consultar ID's(10)";
        String s6 = "Elija la posicion del producto a modificar";
        String s7 = "Modificar nombre(1)";
        String s8 = "Modificar proveedor(2)";
        String s9 = "Modificar unidad(3)";
        String s10 = "Modificar cantidad(4)";
        String s11 = "Modificar precio(5)";

        Scanner input = new Scanner(new File("src\\source2\\datos.txt"));
        input.useDelimiter("\\/");
        Almacen2 a = new Almacen2();
        Menu menu = new Menu();
        Imprimir impr = new Imprimir();

//        impr.leerExcel(a);
//        for (int i = 0; i < a.cantidadDatos; i++) {
//            impr.agregarDato(a.productos[i]);
//        }

        while (input.hasNext()) {

            String d1 = input.next();
            String d2 = input.next();
            String d3 = input.next();
            double d4 = Double.parseDouble(input.next());
            double d5 = Double.parseDouble(input.next());
            String d6 = input.next();

            Producto c = new Producto(d1, d2, d3, d4, d5,d6);

            a.insertar(c);

        }
        System.out.println("lacantidad de datos es  " + a.cantidadDatos);

        boolean estado = true;
        while (estado) {
            numInput = menu.mostrarOpciones(s1, s2, s3, s4, s5, s12, s13, s14, s15,s16,s17,s0);
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
                    impr.agregarDato(p);
                    System.out.println(a.productos[2].getNombre());
                    break;
                case 2:
                    //File fl = new File("C:\\Users\\f_fig\\Documents\\NetBeansProjects\\trabajo1\\src\\main\\java\\source2\\basededatos.txt");
                    //FileWriter fw = new FileWriter(fl);
                    //BufferedWriter bw = new BufferedWriter(fw);

                    String elim = JOptionPane.showInputDialog("Ingrese el id del produto a eliminar");
                    a.eliminar(elim);
                    impr.eliminarDato(a.productos, a.cantidadDatos);

                    // for (int i = 0; i < a.cantidadDatos; i++) {
                    //   bw.write(a.productos[i].getNombre() + "," + a.productos[i].getProveedor() + "," + a.productos[i].getUnidad() + "," + a.productos[i].getCantidad() + "," + a.productos[i].getPrecio() + ",");
                    //}
                    //bw.flush();
                    //bw.close();
                    //fw.close();
                    break;
                case 3:
                    
                    boolean z = true;
                    while (z == true) {
                        
                        String key = JOptionPane.showInputDialog(null, "Ingrese el id del producto a modificar");
                        int posicion = a.findIndex(key);
                        numInput = menu.mostrarOpciones(s7, s8, s9, s10, s11, s0);
                        switch (numInput) {
                            case 0:
                                z= false;
                                break;
                                
                            case 1:
                                strInput = JOptionPane.showInputDialog("Escriba el nuevo nombre");
                                a.productos[posicion].setNombre(strInput);
                                impr.modificacion(a);
                                z= false;
                                break;
                            case 2:
                                strInput = JOptionPane.showInputDialog("Escriba el nuevo proveedor");
                                a.productos[posicion].setProveedor(strInput);
                                impr.modificacion(a);
                                z= false;
                                break;
                            case 3:
                                strInput = JOptionPane.showInputDialog("Escriba la nuevo unidad");
                                a.productos[posicion].setUnidad(strInput);
                                impr.modificacion(a);
                                z= false;
                                break;
                            case 4:
                                dblInput = Double.parseDouble(JOptionPane.showInputDialog("Escriba el nuevo cantidad"));
                                a.productos[posicion].setCantidad(dblInput);
                                impr.modificacion(a);
                                z= false;
                                break;
                            case 5:
                                dblInput = Double.parseDouble(JOptionPane.showInputDialog("Escriba el nuevo precio"));
                                a.productos[posicion].setPrecio(dblInput);
                                impr.modificacion(a);
                                z= false;
                                break;

                        }
                    }
                    break;
                case 4:
                    strInput = JOptionPane.showInputDialog("Ingrese el id del objeto a buscar");
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
                        JOptionPane.showMessageDialog(null, "El producto de menor valor es:" + "\n" + a.productos[numInput].toString() + "\n" + "Se encuentra en la posicion " + numInput);
                    }
                    break;
                case 6:
                    numInput = a.posicionMayor();
                    if (numInput == -2) {
                        JOptionPane.showMessageDialog(null, "El almacen está vacío");
                    } else {
                        JOptionPane.showMessageDialog(null, "El producto de mayor valor es:" + "\n" + a.productos[numInput].toString() + "\n" + "Se encuentra en la posicion " + numInput);
                    }
                    break;
                case 7:
                    numInput = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la posicion del valor a comparar"));
                    int mayores = a.contarMayores(numInput);
                    JOptionPane.showMessageDialog(null, "Existen " + mayores + " productos de mayor precio que el seleccionado");
                    break;
                case 8:
                    numInput = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la posicion del valor a comparar"));
                    int menores = a.contarMenores(numInput);
                    JOptionPane.showMessageDialog(null, "Existen " + menores + " productos de menor precio que el seleccionado");
                    break;
                case 9:
                    a.analisis();
                    break;
                case 10:
                    a.mostrarIds();
                    break;
            }
        }
        

    }

}
