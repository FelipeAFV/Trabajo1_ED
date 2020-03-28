
package teeest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;


public class Teeest {

    public static void read(String nombre, int longitud){
        try{
            
        File fl = new File(nombre + ".xlsx");
        FileInputStream fis = new FileInputStream(fl);
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheetAt(0);
        for (int i = 0; i <= longitud; i++){
            for (int a = 0; a <= 3; a++){
                CellType tipo = sheet.getRow(i).getCell(a).getCellType();
                String valor = tipo.toString();
                if (valor == "NUMERIC"){
                    String output = "" + sheet.getRow(i).getCell(a).getNumericCellValue();
                    System.out.print(String.format("%-20.20s", output) + "|");
                }else if (valor != "NUMERIC"){
                    String el = sheet.getRow(i).getCell(a).getStringCellValue();
                    System.out.print(String.format("%-20.20s", el) + "|");
                }
                    
                        
            }
            System.out.print("\n");
        }
        
         FileOutputStream fout = new FileOutputStream(fl);
         wb.write(fout);
         wb.close(); 
        }catch (Exception e){
            e.printStackTrace();
        }
        
    }
    
    public static int buscador(String Id, int longitud){
        try{
            File fl = new File("testeo" + ".xlsx");
            FileInputStream fis = new FileInputStream(fl);
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sheet = wb.getSheetAt(0);
            for (int i = 1; i <= longitud; i++){
                String actual = sheet.getRow(i).getCell(0).getStringCellValue();
                actual = actual.toLowerCase();
                boolean vv = actual.equalsIgnoreCase(Id);
                if (vv){
                    return i;
                }
            }
            return 000; 
        }catch(Exception e){
            e.printStackTrace();
        }
        return 1;
    }
    
    public static void searcher(String Id, int longitud){
        try{
            File fl = new File("testeo" + ".xlsx");
            FileInputStream fis = new FileInputStream(fl);
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sheet = wb.getSheetAt(0);
            
            for (int i = 1; i <= longitud; i++ ){
                String actual = sheet.getRow(i).getCell(0).getStringCellValue();
                actual = actual.toLowerCase();
                boolean vv = actual.equalsIgnoreCase(Id);
                if (vv){
                    System.out.println("elemento encontrado!");
                    String dato1 = sheet.getRow(0).getCell(0).getStringCellValue();
                    String dato2 = sheet.getRow(0).getCell(1).getStringCellValue();
                    String dato3 = sheet.getRow(0).getCell(2).getStringCellValue();
                    String dato4 = sheet.getRow(0).getCell(3).getStringCellValue();
                    System.out.print(String.format("%-20.20s", dato1) + "|");
                    System.out.print(String.format("%-20.20s", dato2) + "|");
                    System.out.print(String.format("%-20.20s", dato3) + "|");
                    System.out.print(String.format("%-20.20s", dato4) + "|");
                    System.out.print("\n");
                  
                    for(int a = 0; a <= 3; a++){
                       CellType tipo = sheet.getRow(i).getCell(a).getCellType();
                       String valor = tipo.toString();
                       if (valor == "NUMERIC"){
                    String output = "" + sheet.getRow(i).getCell(a).getNumericCellValue();
                    System.out.print(String.format("%-20.20s", output) + "|");
                }else if (valor != "NUMERIC"){
                    String el = sheet.getRow(i).getCell(a).getStringCellValue();
                    System.out.print(String.format("%-20.20s", el) + "|");
                }
                    }
                    System.out.print("\n");
                    return;
                }
                
            }
            System.out.println("elemento no encontrado");
            
        }catch (Exception e){
            e.printStackTrace();
        }
        
    }
    
    public static int deleter(int posicion, int longitud){
        try{
            
            String[] ids = new String[longitud+1];
            String[] nombre = new String[longitud+1];
            String[] tipo = new String[longitud+1];
            String[] cantidades = new String[longitud+1];
            File fl = new File("testeo" + ".xlsx");
            FileInputStream fis = new FileInputStream(fl);
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sheet = wb.getSheetAt(0);
            for(int i = 0 ; i<= longitud; i++){
                for (int a = 0; a <= 3; a++){
                    switch (a){
                      
                        case 0:
                            ids[i] = sheet.getRow(i).getCell(a).getStringCellValue();
                            break;
                           
                        case 1:
                            nombre[i] = sheet.getRow(i).getCell(a).getStringCellValue();
                            break;
                        case 2:
                            CellType tipoo = sheet.getRow(i).getCell(a).getCellType();
                            String valor = tipoo.toString();
                            if (valor == "NUMERIC"){
                                String output = "" + sheet.getRow(i).getCell(a).getNumericCellValue();
                                cantidades[i] = output;
                                break;
                            }else if (valor != "NUMERIC"){
                                String el = sheet.getRow(i).getCell(a).getStringCellValue();
                                cantidades[i] = el;
                                break;
                            }
                                
                            break;
                        case 3:
                            tipo[i] = sheet.getRow(i).getCell(a).getStringCellValue();
                    }
                    
                    
                }
            }

            if(posicion == longitud){
                sheet.getRow(longitud).createCell(0).setCellValue("");
                sheet.getRow(longitud).createCell(1).setCellValue("");
                sheet.getRow(longitud).createCell(2).setCellValue("");
                sheet.getRow(longitud).createCell(3).setCellValue("");
                return (longitud - 1);
            }
            for (int o = 0; o<= longitud; o++){
                if(o == posicion){
                    sheet.getRow(o).createCell(0).setCellValue(ids[o+1]);
                    sheet.getRow(o).createCell(1).setCellValue(nombre[o+1]);
                    sheet.getRow(o).createCell(2).setCellValue(cantidades[o+1]);
                    sheet.getRow(o).createCell(3).setCellValue(tipo[o+1]);
                    int p = o+1;
                    if (p == longitud){
                    sheet.getRow(p).createCell(0).setCellValue("");
                    sheet.getRow(p).createCell(1).setCellValue("");
                    sheet.getRow(p).createCell(2).setCellValue("");
                    sheet.getRow(p).createCell(3).setCellValue("");
                    break;
                    }
                }else if (o > posicion){
               
                    int p = o+1;
                    if (p == longitud){
                    sheet.getRow(o).createCell(0).setCellValue(ids[o+1]);
                    sheet.getRow(o).createCell(1).setCellValue(nombre[o+1]);
                    sheet.getRow(o).createCell(2).setCellValue(cantidades[o+1]);
                    sheet.getRow(o).createCell(3).setCellValue(tipo[o+1]);
                    sheet.getRow(p).createCell(0).setCellValue("");
                    sheet.getRow(p).createCell(1).setCellValue("");
                    sheet.getRow(p).createCell(2).setCellValue("");
                    sheet.getRow(p).createCell(3).setCellValue("");
                    break;
                    }else if(p > longitud){
                        
                    }else
                    for(int f = 0; f<= 3; f++){
                    switch (f){
                    case 0:
                        sheet.getRow(o).createCell(f).setCellValue(ids[o+1]);
                        break;
                    case 1:
                        sheet.getRow(o).createCell(f).setCellValue(nombre[o+1]);
                        break;
                    case 2:
                        sheet.getRow(o).createCell(f).setCellValue(cantidades[o+1]);
                        break;
                    case 3:
                        sheet.getRow(o).createCell(f).setCellValue(tipo[o+1]);
                        break;
                }
                    
                }
                }else if (o < posicion){
               
                    int p = o+1;
                    if (p == longitud){
                    sheet.getRow(p).createCell(0).setCellValue("");
                    sheet.getRow(p).createCell(1).setCellValue("");
                    sheet.getRow(p).createCell(2).setCellValue("");
                    sheet.getRow(p).createCell(3).setCellValue("");
                    sheet.getRow(o).createCell(0).setCellValue(ids[o+1]);
                    sheet.getRow(o).createCell(1).setCellValue(nombre[o+1]);
                    sheet.getRow(o).createCell(2).setCellValue(cantidades[o+1]);
                    sheet.getRow(o).createCell(3).setCellValue(tipo[o+1]);
                    break;
                    }else
                    for(int f = 0; f<= 3; f++){
                    switch (f){
                    case 0:
                        sheet.getRow(o).createCell(f).setCellValue(ids[o]);
                        break;
                    case 1:
                        sheet.getRow(o).createCell(f).setCellValue(nombre[o]);
                        break;
                    case 2:
                        sheet.getRow(o).createCell(f).setCellValue(cantidades[o]);
                        break;
                    case 3:
                        sheet.getRow(o).createCell(f).setCellValue(tipo[o]);
                        break;
                }
                    
                }
                }
            }
            
            FileOutputStream fout = new FileOutputStream(fl);
            wb.write(fout);
            wb.close();
            longitud = (longitud - 1);
            return longitud;
        }catch (Exception e){
            e.printStackTrace();
        }
        return longitud;
    }
    
    public static int getmax(int longitud){
        try{
        int max = 0;    
        File fl = new File("testeo.xlsx");
        FileInputStream fis = new FileInputStream(fl);
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheetAt(0);
        int[] valores = new int[longitud];
        for (int i = 1;i <= longitud; i++ ){
            CellType tipo = sheet.getRow(i).getCell(2).getCellType();
            String valor = tipo.toString();
            if (valor == "NUMERIC"){
                int output =  (int)sheet.getRow(i).getCell(2).getNumericCellValue();
                valores[i-1] = output;
            }else if (valor != "NUMERIC"){
                String el = sheet.getRow(i).getCell(2).getStringCellValue();
                double output = Double.parseDouble(el);
                int aux = (int)output;
                valores[i-1] = aux;
            }
        }
        for(int a = 0;a < longitud; a++ ){
            if (max > valores[a]){
                max = max;
            }else
                max = valores[a];
        }
        return max;
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        return 1;
    }
    
    public static int adder(int longitud){
        try{
        File fl = new File("testeo.xlsx");
        FileInputStream fis = new FileInputStream(fl);
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheetAt(0); 
        
        sheet.createRow( longitud + 1).createCell(0).setCellValue("fri1");
        sheet.getRow( longitud + 1).createCell(1).setCellValue("friz");
        sheet.getRow( longitud + 1).createCell(2).setCellValue("56");
        sheet.getRow( longitud + 1).createCell(3).setCellValue("fri");
        FileOutputStream fout = new FileOutputStream(fl);
        wb.write(fout);
        wb.close();
        return (longitud + 1);
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return 1;
    }

    public static void main(String[] args) throws Exception {
        
        int rows = 3;
        read("testeo",rows);
        rows = adder(rows);
        read("testeo",rows);
        rows = deleter(2,rows);
        read("testeo",rows);

        
    
    }
    
}
