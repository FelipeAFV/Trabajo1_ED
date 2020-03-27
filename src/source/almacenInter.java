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
public interface almacenInter<T> {
    
   void insertarInicio(T t); 
   void insertarMedio(T t, int pos);
   void insertarFInal(T t);
   
   void eliminarInicio(T t);
   void eliminarMedio(T t, int pos);
   void eliminarFinal(T t);
   
   boolean estaVacio();
   
   T buscar(T t);
    
    
}
