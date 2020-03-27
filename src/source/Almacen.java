/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package source;

/**
 *
 * @author f_fig
 */
public class Almacen implements almacenInter<Producto> {

    Producto[] productos;
    Producto[] nuevosProductos;
    Producto[] mitad;
    Producto[] union;

    public Almacen(int tamaño) {
        productos = new Producto[tamaño];
    }

    @Override
    public boolean estaVacio() {
        return productos == null;
    }

    public void insertarInicio(Producto c) {
        int longitud = productos.length;
        if (estaVacio()) {
            productos[0] = c;
        } else {
            nuevosProductos = new Producto[longitud + 1];
            nuevosProductos[0] = c;
            for (int i = 1; i < longitud + 1; i++) {
                nuevosProductos[i] = productos[i - 1];
            }
            productos = nuevosProductos;
            nuevosProductos = null;
        }
    }
    

    public static void main(String[] args) {

    }

    @Override
    public void insertarMedio(Producto t, int pos) {
        if (productos.length <= pos) {
            System.out.println("Posición ingresada NO válida");

        } else if (estaVacio()) {
            productos[0] = t;
        } else {
            mitad = new Producto[pos + 1];

            union = new Producto[productos.length + 1];
            for (int i = 0; i < pos + 1; i++) {

                if (i == pos) {
                    mitad[i] = t;
                    break;
                } else {
                    mitad[i] = productos[i];
                }
            }
            for (int i = 0; i < union.length; i++) {

                if (i > pos) {
                    union[i] = productos[i - 1];
                } else {
                    union[i] = mitad[i];
                }

            }
            productos = union;

        }
    }

    @Override
    public void insertarFInal(Producto t) {
    }

    @Override
    public void eliminarInicio(Producto t) {
    }

    @Override
    public void eliminarMedio(Producto t, int pos) {
    }

    @Override
    public void eliminarFinal(Producto t) {
    }

    @Override
    public Producto buscar(Producto t) {
        return null;
        
    }

}
