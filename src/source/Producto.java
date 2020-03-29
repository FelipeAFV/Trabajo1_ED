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
    
    public int[] ids = new int[1000];
    private String nombre;
    private String descripcion;
    private String proveedor;
    private String unidad;
    private double precio;
    private int id;
    private double cantidad;
    
    public Producto(String nombre){
        this.nombre =  nombre;
    }
    public Producto(String nombre,String proveedor, String unidad, double cantidad, double precio) {
        this.nombre = nombre;
       
        this.proveedor = proveedor;
        this.cantidad = cantidad;
        this.unidad = unidad;
        this.precio = precio;
        this.id = idGen();
        
        
    }
    private boolean compareTo(int valor, int[] a){
        boolean estado = false;
        for(int i = 0; i<a.length; i++){
            if(valor == a[i]){
                estado = true;
                break;
                
            }
        }
        return false;
    }
    private int idGen(){
        boolean estado = true;
        
        int key = 0;
        while(estado){
            key = (int) (Math.random() * 1000);
            estado = compareTo(key, ids);
        }
        
        return key;
    }
            
    

    @Override
    public String toString() {
        return "Producto{" + "nombre=" + nombre + ", descripcion=" + descripcion + ", proveedor=" + proveedor + ", unidad=" + unidad + ", precio=" + precio + ", id=" + id + ", cantidad=" + cantidad + '}';
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }
    
    
    
    
    
}
