package genericUtilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadingDataFromExcelFile {
	public Workbook wb;
	Sheet sh;
	
	public String readingDataFromExcelFile(String sheetName,int row,int cell) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./src/test/resources/TestData.xlsx");
		wb=WorkbookFactory.create(fis);
		sh=wb.getSheet(sheetName);
		return sh.getRow(row).getCell(cell).toString();
	}
	
	public int getTotalNumberOfRows() {
		return sh.getPhysicalNumberOfRows();
	}
	
	public int getTotalNumberOfColumns() {
		return sh.getRow(1).getPhysicalNumberOfCells();
	}
	
	
}
