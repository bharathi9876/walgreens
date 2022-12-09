/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test.com;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author giril
 */
public class FileUtil {

    public static List<ProductVO> loadData() throws Exception {
        FileInputStream inputStream = new FileInputStream(new File("C:\\data\\walgreens.xlsx"));
        Workbook workbook = new XSSFWorkbook(inputStream);
         Sheet firstSheet = workbook.getSheetAt(0);  
         List<ProductVO> productList = new ArrayList<>();
         String productname=null;
         ProductVO walgreens = null;
         for(int i=1;i<firstSheet.getPhysicalNumberOfRows();i++){
            Row r = firstSheet.getRow(i);
            Cell c = r.getCell(0); 
            productname = c.getStringCellValue();
    //         for (var i = 0; i < 10; i++) {
    //   //every three
    //}
            //c = r.getCell(1); //where value
            //String where = c.getStringCellValue();       
            walgreens = new ProductVO(productname);
            productList.add(walgreens);
            System.out.println(walgreens);
         }
        inputStream.close();
        return productList;
    }
}
