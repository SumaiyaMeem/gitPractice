package DB;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DbTest2 {
	Object o[][];

@DataProvider(name = "logIn")
	public Object[][] getData() {
		try {
			FileInputStream fi = new FileInputStream(
					new File("/Users/mdalam/eclipse-workspace/TestNgFramework/exell.xlsx"));
			XSSFWorkbook book = new XSSFWorkbook(fi);
			XSSFSheet sheet = book.getSheetAt(0);
			// to get 1 value by index number
			sheet.getRow(1).getCell(1).getStringCellValue();
			// to get entire data from excel sheet
			int rn = sheet.getLastRowNum();
			int cn = sheet.getRow(1).getLastCellNum();
			 o = new Object[rn][cn];
			for (int i = 1; i <= rn; i++) {
				for (int j = 0; j <= cn; j++) {
					XSSFCell cell = sheet.getRow(i).getCell(j);
					switch (cell.getCellType()) {
					case XSSFCell.CELL_TYPE_NUMERIC:

						o[i - 1][j] = cell.getNumericCellValue();
						break;

					case XSSFCell.CELL_TYPE_STRING:

						o[i - 1][j] = cell.getStringCellValue();
						break;

					default:
						break;
					}
				}

			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return o;

	}

//is there any way you could get out of the system whenever use try catch block?
//yes system.exit();

}
