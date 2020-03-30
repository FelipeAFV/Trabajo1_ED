/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data_base;

/*import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
*/

/**
 *
 * @author ITs Ok To Be Sad
 */
public class Data_base {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     ///   escrituraExcel();
        
    }
    
    /*public static void escrituraExcel() {
        String archiveName = "Materiales.xlsx";
        
        String paper = "Materiales de construcción";
        
        XSSFWorkbook book = new XSSFWorkbook();
        XSSFSheet paper1 = book.createSheet(paper);
        
        String[] header = new String[] {"Nombre", "ID", "Características", 
            "Proveedor", "Rubro", "Precio", "Stock"};
        String[][] content = new String[][] {
            {"Madera", "A", "A", "A", "A", "A", "A"}, 
            {"Madera2", "B", "B", "B", "B", "B", "B"},
            {"Madera3", "B", "B", "B", "B", "B", "B"},
            {"Madera4", "B", "B", "B", "B", "B", "B"}
            
                
        };
        
        for (int i=0; i<=content.length; i++) {
            XSSFRow row = paper1.createRow(i);
            for(int z = 0; z<header.length; z++) {
                if(i==0) {
                    XSSFCell cell = row.createCell(z);
                    cell.setCellValue(header[z]);
                } else {
                    XSSFCell cell = row.createCell(z);
                    cell.setCellValue(content[i-1][z]);
                }
            }
        }
        
        try (OutputStream fileOut = new FileOutputStream(archiveName)) {
            System.out.println("Se ha creado excel");
            book.write(fileOut);
            
        } catch(IOException ex) {
            ex.printStackTrace();
        }
        
        
   }*/
    
}
