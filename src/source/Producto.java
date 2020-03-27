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
public class Producto {
    
    public String nombre;
    public String descripcion;
    public String proveedor;
    public String unidad;
    public double precio;
    public int id;
    public double cantidad;

    public Producto(String nombre, String descripcion, String proveedor, String unidad, double cantidad, double precio) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.proveedor = proveedor;
        this.cantidad = cantidad;
        this.unidad = unidad;
        this.precio = precio;
        
    }

    @Override
    public String toString() {
        return "Producto{" + "nombre=" + nombre + ", descripcion=" + descripcion + ", proveedor=" + proveedor + ", unidad=" + unidad + ", precio=" + precio + ", id=" + id + ", cantidad=" + cantidad + '}';
    }
    
}
