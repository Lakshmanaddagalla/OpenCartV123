package utilities;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelUtility {
	
	 public static FileInputStream fi;
	    public static FileOutputStream fo;
	    public static XSSFWorkbook workbook;
	    public static XSSFSheet sheet;
	    public static XSSFRow row;
	    public static XSSFCell cell;
	    public static CellStyle style;
	    String path;

	    //Excel file----->workBook---------->sheet------>row

	    public ExcelUtility(String path) {
	        this.path = path;
	    }


	    public int getRowCount(String sheetName) throws IOException {

	        fi = new FileInputStream(path);
	        workbook = new XSSFWorkbook(fi);
	        sheet = workbook.getSheet(sheetName);
	        int rowCount = sheet.getLastRowNum();

	        workbook.close();
	        fi.close();

	        return rowCount;


	    }

	    //Excel file----->workBook---------->sheet------>row------>cell
	    public int cellCount(String sheetName, int rowNum) throws IOException {

	        fi = new FileInputStream(path);
	        workbook = new XSSFWorkbook(fi);
	        sheet = workbook.getSheet(sheetName);
	        row = sheet.getRow(rowNum);
	        int cellCount = row.getLastCellNum();
	        workbook.close();
	        fi.close();
	        return cellCount;


	    }

	    public String getCellData(String sheetName, int rowNum, int colNum) throws IOException {
	        fi = new FileInputStream(path);
	        workbook = new XSSFWorkbook(fi);
	        sheet = workbook.getSheet(sheetName);
	        row = sheet.getRow(rowNum);
	        cell = row.getCell(colNum);

	        String data;
	        try {
	            //data=cell.toString();
	            DataFormatter dataFormatter = new DataFormatter();
	            data = dataFormatter.formatCellValue(cell);
	        } catch (Exception e) {
	            data = "";
	        }
	        workbook.close();
	        fi.close();
	        return data;

	    }

	    public void setCellData(String sheetName, int rowNum, int colNum, String data) throws IOException {
	        File xlfile = new File(path);
	        if (!xlfile.exists())

	        {
	            workbook = new XSSFWorkbook();
	            fo = new FileOutputStream(path);
	            workbook.write(fo);
	        }
	        fi = new FileInputStream(path);
	        workbook = new XSSFWorkbook(fi);

	        if (workbook.getSheetIndex(sheetName) == -1)
	            workbook.createSheet(sheetName);
	        sheet = workbook.getSheet(sheetName);

	        if (sheet.getRow(rowNum) == null)
	            sheet.createRow(rowNum);
	        row = sheet.getRow(rowNum);

	        cell = row.createCell(colNum);
	        cell.setCellValue(data);
	        fo=new FileOutputStream(path);


	        workbook.write(fo);
	        workbook.close();
	        fi.close();
	        fo.close();

	    }
}
