/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package source2;

import javax.swing.JOptionPane;

/**
 *
 * @author f_fig
 */
public class Menu {
    
    public String opcion;
    public int num;
    
    public int mostrarOpciones(String a){
        opcion = JOptionPane.showInputDialog(a+"\n");
        num = Integer.parseInt(opcion);
        return num;
    }
    
    public int mostrarOpciones(String a, String b, String c, String d){
        opcion = JOptionPane.showInputDialog(a+"\n"+b+"\n"+c+"\n"+d+"\n");
        num = Integer.parseInt(opcion);
        return num;
    }
    public int mostrarOpciones(String a, String b, String c, String d, String e){
        opcion = JOptionPane.showInputDialog(a+"\n"+b+"\n"+c+"\n"+d+"\n"+e+"\n");
        num = Integer.parseInt(opcion);
        return num;
    }
    public int mostrarOpciones(String a, String b, String c, String d, String e, String f, String g,String h){
        opcion = JOptionPane.showInputDialog(a+"\n"+b+"\n"+c+"\n"+d+"\n"+e+"\n"+f+"\n"+g+"\n"+h+"\n");
        num = Integer.parseInt(opcion);
        return num;
    }
    
    
    
}
