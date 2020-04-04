
package pulidatrabajo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import javax.swing.JOptionPane;


public class Pulidatrabajo {
    public static void read(String nombre, int longitud){
        try{
            
        File fl = new File(nombre + ".xlsx");
        FileInputStream fis = new FileInputStream(fl);
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheetAt(0);
        File archivo = new File ("traspaso.txt");
        FileWriter fl2 = new FileWriter(archivo);
        BufferedWriter lector = new BufferedWriter(fl2);

        for (int i = 1; i <= longitud; i++){
            for (int a = 0; a <= 5; a++){
                CellType tipo = sheet.getRow(i).getCell(a).getCellType();
                String valor = tipo.toString();
                if (valor == "NUMERIC"){
                    String output = "" + sheet.getRow(i).getCell(a).getNumericCellValue();
                    lector.write(output);
                    if (i == longitud && a == 5){
                        continue;
                    }else
                    lector.newLine();
                }else if (valor != "NUMERIC"){
                    String el = sheet.getRow(i).getCell(a).getStringCellValue();
                    lector.write(el);
                    if (i == longitud && a == 5){
                        continue;
                    }else
                    lector.newLine();
                }
                    
                        
            }
            
        }
        
         FileOutputStream fout = new FileOutputStream(fl);
         wb.write(fout);
         wb.close(); 
         lector.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        
    }
    
    public static Contenedor[] setter(Contenedor[] datos){
        try{
            File archivo = new File ("traspaso.txt");
            FileReader fl2 = new FileReader(archivo);
            BufferedReader escritor = new BufferedReader(fl2);
            int numerolienas = 0;
            String line = escritor.readLine();
            while (line!=null) {
                for (int i = 0; i <= 5; i++){
                    datos[numerolienas].personal[i] = line;
                    line = escritor.readLine();
                }
                
                numerolienas = numerolienas + 1;
                
            }
           /* int ll = datos.length;
            
            for(int i = 0; i < ll;i++ ){
                for (int a = 0; a <= 5; a++){
                    System.out.println(datos[i].personal[a]); 
                }
                
            }*/
            escritor.close();
            return datos;
        }catch (Exception e){
            e.printStackTrace();
        }
        
        
        
        Contenedor[] nuevo = new Contenedor[5];
        return nuevo;
    }
    
    public static int longchecker(){
        try{
            File archivo = new File ("traspaso.txt");
            FileReader fl2 = new FileReader(archivo);
            BufferedReader escritor = new BufferedReader(fl2);
            int numerolienas = 0;
            String line = escritor.readLine();
            while (line!=null) {
                numerolienas = numerolienas + 1;
                line = escritor.readLine();
            }
            return numerolienas;
        }catch (Exception e){
            e.printStackTrace();
        }
        return 1;
    }
    
    public static void searcher(Contenedor[] datos, String id){
        
        int longitud = datos.length;
        for (int i = 0; i < longitud; i++){
            if (id.equals(datos[i].personal[0])){
                String a,b,c,d,w,e,f;
                a = datos[i].personal[0];
                b = datos[i].personal[1];
                c = datos[i].personal[2];
                d = datos[i].personal[3];
                e = datos[i].personal[4];
                f = datos[i].personal[5];
                JOptionPane.showMessageDialog(null, "id: " + a);
                JOptionPane.showMessageDialog(null, "nombre: " + b);
                JOptionPane.showMessageDialog(null, "marca: " + c);
                JOptionPane.showMessageDialog(null, "medida: " + d);
                JOptionPane.showMessageDialog(null, "cantidad: " + e);
                JOptionPane.showMessageDialog(null, "precio: " + f);
                return;
                /*System.out.print(String.format("%-20.20s", a) + "|");
                System.out.print(String.format("%-20.20s", b) + "|");
                System.out.print(String.format("%-20.20s", c) + "|");
                System.out.print(String.format("%-20.20s", d) + "|");
                System.out.print(String.format("%-20.20s", e) + "|");
                System.out.print(String.format("%-20.20s", f) + "|");
                System.out.println("\n");*/
            }
        }
        JOptionPane.showMessageDialog(null, "no se encontro el elemento");
        
    }
    
     public static Contenedor[] deleter(Contenedor[] datos,String id){
         
         int info, nueval;
         info = datos.length;
         nueval = info - 1;
         Contenedor[] aux = new Contenedor[nueval];
         for (int i = 0; i < nueval; i++){
             
             aux[i] = new Contenedor();
         }
         int control = 0;
         for (int i = 0; i < info; i++){
             if (id.equals(datos[i].personal[0])){

                 continue;
             }else
             if (control == nueval){
                 JOptionPane.showMessageDialog(null, "el elemento ya ha sido eliminado");
                 return datos;
             }else    
             for (int a = 0; a < 6; a++){
                 aux[control].personal[a] = datos[i].personal[a];
             }

             control = control +1;
         }
         datos = aux;
         refresher(datos);
         return datos;
     }
     
     public static void refresher(Contenedor[] datos){
         try{
             File archivo = new File ("traspaso.txt");
            FileWriter fl2 = new FileWriter(archivo);
            BufferedWriter lector = new BufferedWriter(fl2);
            int longitud = datos.length;
            int aux = longitud - 1;
            for(int i = 0; i < longitud; i++){
                
                for(int a = 0; a < 6; a++){
                    lector.write(datos[i].personal[a]);
                    if (i == aux && a == 5){
                        continue;
                    }
                    lector.newLine();
                }
                
                
            }
            lector.close();
         }catch (Exception e){
             e.printStackTrace();
         }
         
     }
     
     public static Contenedor[] adder(Contenedor[] datos){
         String id = JOptionPane.showInputDialog("entrega el id");
         String name = JOptionPane.showInputDialog("entrega el nombre");
         String marca = JOptionPane.showInputDialog("entrega la marca");
         String med = JOptionPane.showInputDialog("medicion");
         String cantidad = JOptionPane.showInputDialog("cantidad");
         String price = JOptionPane.showInputDialog("precio");
         int info, nueval;
         info = datos.length;
         nueval = info + 1;
         Contenedor[] aux = new Contenedor[nueval];
         for (int i = 0; i < nueval; i++){
             
             aux[i] = new Contenedor();
         }
         
         for (int i = 0; i < info; i++){
             for (int a = 0; a < 6; a++){
                 aux[i].personal[a] = datos[i].personal[a];
             }
         }
         aux[info].personal[0] = id;
         aux[info].personal[1] = marca;
         aux[info].personal[2] = name;
         aux[info].personal[3] = med;
         aux[info].personal[4] = cantidad;
         aux[info].personal[5] = price;
         datos = aux;
         refresher(datos);
         JOptionPane.showMessageDialog(null, "elemnto añadido!");
         return datos;
     }
     
     public static void edit(Contenedor[] datos){
         String l = JOptionPane.showInputDialog("id de elemnto a editar");
         for (int i = 0; i < datos.length; i++){
             if (l.equals(datos[i].personal[0])){
                 String newid = JOptionPane.showInputDialog("indica el nuevo id");
                 String newname = JOptionPane.showInputDialog("indica el nombre");
                 String newmarca = JOptionPane.showInputDialog("indica la marca");
                 String newmed = JOptionPane.showInputDialog("indica la medida");
                 String newcantidad = JOptionPane.showInputDialog("indica la cantidad");
                 String newprecio = JOptionPane.showInputDialog("indica el precio");
                 datos[i].personal[0] = newid;
                 datos[i].personal[1] = newname;
                 datos[i].personal[2] = newmarca;
                 datos[i].personal[3] = newmed;
                 datos[i].personal[4] = newcantidad;
                 datos[i].personal[5] = newprecio;
             
             }
             
         }
         JOptionPane.showMessageDialog(null, "no se encontro el elemento");
         refresher(datos);
         
     }
     
     public static void viewall(Contenedor[] datos){
         JOptionPane.showMessageDialog(null, "mira la consola!");
         for(int i = 0; i < datos.length; i++){
             for(int a = 0; a < 6; a++){
                 String c = datos[i].personal[a];
                 System.out.print(String.format("%-20.20s", c) + "|");
             }
             System.out.print("\n");
         }
     }

    public static void main(String[] args) {

        int lar = (longchecker() / 6);
        Contenedor[] caja = new Contenedor[(lar)];
        for (int i = 0; i < lar; i++){
            caja[i] = new Contenedor();
        }
        
        setter(caja);
        boolean decision = true;
        while(decision){
            JOptionPane.showMessageDialog(null, "1-consultar  2-añadir  "
                    + "3-eliminar" + "\n" + "4-editar  5-ver lista  6-salir");
            String l = JOptionPane.showInputDialog("que deseas hacer");
            int decision2 = Integer.parseInt(l);
            
            switch(decision2){
                case 1:
                    String id = JOptionPane.showInputDialog("dame el id");
                    searcher(caja, id);
                    break;
                case 2:
                    caja = adder(caja);
                    break;
                case 3:
                    String id2 = JOptionPane.showInputDialog("dame el id");
                    caja = deleter(caja, id2);
                    break;
                case 4:
                    edit(caja);
                    break;
                case 5:
                    viewall(caja);
                    break;
                case 6:
                    decision = false;
                    System.out.println("adios");
                    break;
                
                
            }
            
            
        }
        
      
    }
    
}
