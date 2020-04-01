/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package source2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import source.Producto;

/**
 *
 * @author f_fig
 */
public class Imprimir {

    public void eliminarDato(Producto[] p, String nom, int tamaño) throws IOException {
        File fl = new File("C:\\Users\\f_fig\\Documents\\NetBeansProjects\\trabajo1\\src\\main\\java\\source2\\basededatos.txt");
        FileWriter fw = new FileWriter(fl);
        BufferedWriter bw = new BufferedWriter(fw);
        for(int i = 0; i < tamaño; i++){
            bw.write(p[i].getNombre() + "," + p[i].getProveedor() + "," + p[i].getUnidad() + "," + p[i].getCantidad() + "," + p[i].getPrecio() + ",");
        }
        bw.flush();
        bw.close();
        fw.close();

    }

}
