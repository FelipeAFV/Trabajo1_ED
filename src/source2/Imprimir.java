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
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import source.Producto;

/**
 *
 * @author f_fig
 */
public class Imprimir {

    public void leerExcel(Almacen2 a) throws IOException {
        try {
            FileInputStream f = new FileInputStream("C:\\Users\\f_fig\\Desktop\\basededatostrabajo1.xlsx");

            XSSFWorkbook libro = new XSSFWorkbook(f);//Se crea el objeto que contiene el libro excel

            XSSFSheet hoja = libro.getSheetAt(0);//Seleccionamos la primera hoja

            Iterator<Row> filas = hoja.iterator();//Iteradores usados para recorrer una coleccion
            Iterator<Cell> celdas;                //en este caso la coleccion está compuesta por las
            //filas y celdas de la hoja de excel
            Row fila;
            Cell celda;

            while (filas.hasNext()) {

                fila = filas.next();
                celdas = fila.cellIterator();

                int posicion = 0;
                String d1 = celdas.next().getStringCellValue();
                String d2 = celdas.next().getStringCellValue();

                String d3 = celdas.next().getStringCellValue();
                double d4 = celdas.next().getNumericCellValue();
                double d5 = celdas.next().getNumericCellValue();

                Producto c = new Producto(d1, d2, d3, d4, d5);

                a.insertar(c);

            }
            libro.close();

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }

    public void eliminarDato(Producto[] p, int tamaño) throws IOException {
        File fl = new File("src\\source2\\datos.txt");
        FileWriter fw = new FileWriter(fl);
        BufferedWriter bw = new BufferedWriter(fw);
        for (int i = 0; i < tamaño; i++) {
            bw.write(p[i].getNombre() + "/" + p[i].getProveedor() + "/" + p[i].getUnidad() + "/" + p[i].getCantidad() + "/" + p[i].getPrecio() + "/"+ p[i].getId()+ "/" );
        }
        bw.flush();
        bw.close();
        fw.close();

    }

    public void agregarDato(Producto p) throws IOException {
        File fl = new File("src\\source2\\datos.txt");
        FileWriter fw = new FileWriter(fl, true);
        BufferedWriter bw = new BufferedWriter(fw);

        bw.write("\n" + p.getNombre() + "/" + p.getProveedor() + "/" + p.getUnidad() + "/" + p.getCantidad() + "/" + p.getPrecio() + "/" +p.getId()+ "/" );

        bw.flush();
        bw.close();
        fw.close();
    }

    public void modificacion(Almacen2 a) throws IOException {
        File fl = new File("src\\source2\\datos.txt");
        FileWriter fw = new FileWriter(fl);
        BufferedWriter bw = new BufferedWriter(fw);
        
        for (int i = 0; i < a.cantidadDatos; i++) {

            bw.write(a.productos[i].getNombre() + "/" + a.productos[i].getProveedor() + "/" + a.productos[i].getUnidad() + "/" + a.productos[i].getCantidad() + "/" + a.productos[i].getPrecio() + "/" +a.productos[i].getId()+"/");
        }
        bw.flush();
        bw.close();
        fw.close();

    }

}
