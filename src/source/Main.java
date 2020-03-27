/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package source;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author f_fig
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Almacen a1 = new Almacen(1);
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
                String d4 = celdas.next().getStringCellValue();
                double d5 = celdas.next().getNumericCellValue();
                double d6 = celdas.next().getNumericCellValue();

                Producto c = new Producto(d1, d2, d3, d4, d5, d6);

                a1.insertarMedio(c,(int) a1.productos.length/2);
                continue;

//                while (celdas.hasNext()) {
//
//                    celda = celdas.next();
                /////                            System.out.println(celda.getNumericCellValue());
                //                           break;
//
                //                      case STRING:
                //                        System.out.println(celda.getStringCellValue());
                //                      break;
                //            }
                
                
            }
            libro.close();

        }

    
    catch (FileNotFoundException e

    
        ) {
            System.out.println(e.getMessage());
    }
    for (Producto c : a1.productos

    
        ) {
            System.out.println(c.toString());
    }
    }}

