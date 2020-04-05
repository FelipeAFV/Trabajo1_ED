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
    public String[] numeros = {"1","2","3","4","5","6","7","8","9","0"};
    public String[] letras = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","ñ","o","p","q","r","s","t","u","v","w","x","y","z"};
    public int[] ids = new int[1000];
    
    
    private String nombre;
    private String descripcion;
    private String proveedor;
    private String unidad;
    private double precio;
    private String id;
    private double cantidad;
    private String rubro;
    
    public Producto(String nombre){
        this.nombre =  nombre;
    }
    public Producto(String nombre,String proveedor, String unidad, double cantidad, double precio) {
        this.nombre = nombre;
        this.rubro = rubro;
        this.proveedor = proveedor;
        this.cantidad = cantidad;
        this.unidad = unidad;
        this.precio = precio;
        this.id = idCheck();
        
        
    }
    public Producto(String nombre,String proveedor, String unidad, double cantidad, double precio, String id) {
        this.nombre = nombre;
        this.proveedor = proveedor;
        this.cantidad = cantidad;
        this.unidad = unidad;
        this.precio = precio;
        this.id = id;
        
        
    }
    
    private  String idCreate(){
        String c1 = numeros[(int) (Math.random() * numeros.length)];
        String c2 = numeros[(int) (Math.random() * numeros.length)];
        String c3 = letras[(int) (Math.random() * letras.length)];
        String c4 = letras[(int) (Math.random() * letras.length)];
        String c5 = c3.toUpperCase();
        String c6 = c4.toUpperCase();
        String key = c1+c2+c5+c6;
        return key;
    }
    public String idCheck(){
        boolean estado = true;
        
        String key2 = "";
        while(estado){
            key2 = idCreate();
            estado = compareTo(key2, ids);
        }
        
        return key2;
    }
    private boolean compareTo(String valor, int[] a){
        boolean estado = false;
        for(int i = 0; i<a.length; i++){
            if(valor.equals(a[i])){
                estado = true;
                break;
                
            }
        }
        return estado;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }
    
    
    
    
    
}
