package finalmyyatra.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;


public class ReadExcelFile {
	public static File file;
	public static FileInputStream fis;
	@DataProvider(name="test")
	public String[][] readExcelFile(Method m) throws EncryptedDocumentException, IOException {
		String excelname=m.getName();
		file=new File(System.getProperty("user.dir")+"\\src\\test\\resources\\testdata1.xlsx");
		fis=new FileInputStream(file);
		Workbook wb =WorkbookFactory.create(fis);
		Sheet sheetname =wb.getSheet(excelname);
		int totalrow = sheetname.getLastRowNum();
		System.out.println("total Row : "+totalrow);
		Log.info("total Row : "+totalrow);
		Row row= sheetname.getRow(0);
		int totalcoln = row.getLastCellNum();
		System.out.println("total Row : "+totalcoln);
		Log.info("total colum : "+totalcoln);
		DataFormatter formatter =new DataFormatter();
		
		String testdata[][]=new String[totalrow][totalcoln];
		for (int i=1;i<=totalrow;i++) {
			for (int j=0;j<totalcoln;j++) {
				testdata[i-1][j]=formatter.formatCellValue(sheetname.getRow(i).getCell(j));
			}
		}
		System.out.println("excel data :"+testdata);
		Log.info("excel data :"+testdata);
		return testdata;
	}
	
}
