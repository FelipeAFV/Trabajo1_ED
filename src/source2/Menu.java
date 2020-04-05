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

    public int mostrarOpciones(String a) {
        opcion = JOptionPane.showInputDialog(a + "\n");
        num = Integer.parseInt(opcion);
        return num;
    }

    public int mostrarOpciones(String a, String b, String c, String d) {
        opcion = JOptionPane.showInputDialog(a + "\n" + b + "\n" + c + "\n" + d + "\n");
        num = Integer.parseInt(opcion);
        return num;
    }

    public int mostrarOpciones(String a, String b, String c, String d, String e) {
        opcion = JOptionPane.showInputDialog(a + "\n" + b + "\n" + c + "\n" + d + "\n" + e + "\n");
        num = Integer.parseInt(opcion);
        return num;
    }

    public int mostrarOpciones(String a, String b, String c, String d, String e, String f) {
        opcion = JOptionPane.showInputDialog(a + "\n" + b + "\n" + c + "\n" + d + "\n" + e + "\n" + f + "\n");
        num = Integer.parseInt(opcion);
        return num;
    }

    public int mostrarOpciones(String a, String b, String c, String d, String e, String f, String g) {
        opcion = JOptionPane.showInputDialog(a + "\n" + b + "\n" + c + "\n" + d + "\n" + e + "\n" + f + "\n" + g + "\n");
        num = Integer.parseInt(opcion);
        return num;
    }

    public int mostrarOpciones(String a, String b, String c, String d, String e, String f, String g, String h) {
        opcion = JOptionPane.showInputDialog(a + "\n" + b + "\n" + c + "\n" + d + "\n" + e + "\n" + f + "\n" + g + "\n" + h + "\n");
        num = Integer.parseInt(opcion);
        return num;
    }

    public int mostrarOpciones(String a, String b, String c, String d, String e, String f, String g, String h, String i, String j) {
        opcion = JOptionPane.showInputDialog(a + "\n" + b + "\n" + c + "\n" + d + "\n" + e + "\n" + f + "\n" + g + "\n" + h + "\n" + i + "\n" + j + "\n");
        num = Integer.parseInt(opcion);
        return num;
    }

    public int mostrarOpciones(String a, String b, String c, String d, String e, String f, String g, String h, String i, String j, String k) {
        opcion = JOptionPane.showInputDialog(a + "\n" + b + "\n" + c + "\n" + d + "\n" + e + "\n" + f + "\n" + g + "\n" + h + "\n" + i + "\n" + j + "\n" + k + "\n");
        num = Integer.parseInt(opcion);
        return num;
    }

    public int mostrarOpciones(String a, String b, String c, String d, String e, String f, String g, String h, String i, String j, String k,String l) {
        opcion = JOptionPane.showInputDialog(a + "\n" + b + "\n" + c + "\n" + d + "\n" + e + "\n" + f + "\n" + g + "\n" + h + "\n" + i + "\n" + j + "\n" + k + "\n"+ l + "\n");
        num = Integer.parseInt(opcion);
        return num;
    }

}
