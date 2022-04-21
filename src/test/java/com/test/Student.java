package com.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Student {

	public static void main(String[] args) throws IOException {
File file = new File("C:\\Users\\ELCOT\\eclipse-workspace\\Fb\\Exel sheets\\info.xlsx");
FileInputStream stream = new FileInputStream(file);
Workbook workbk = new XSSFWorkbook(stream);
Sheet sheet = workbk.getSheet("Info");
//int Count = sheet.getPhysicalNumberOfRows();
//System.out.println(Count);
for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
	Row row = sheet.getRow(i);
	for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
		Cell cl = row.getCell(j);
		//System.out.println(cell);
		CellType cltype = cl.getCellType();
		switch (cltype) {
	//	case STRING:
		//	String s1 = cl.getStringCellValue();
		//	System.out.println(s1);
		case STRING:
			String stringCellValue = cl.getStringCellValue();
 System.out.println(stringCellValue);
	break;

		case NUMERIC:
			if (DateUtil.isCellDateFormatted(cl)) {
				Date dt = cl.getDateCellValue();
				SimpleDateFormat formt = new SimpleDateFormat ("dd-MM-yy");
				String format = formt.format(dt);
				System.out.println(format);
			} else {
				double d = cl.getNumericCellValue();
				BigDecimal b = BigDecimal.valueOf(d);
				String numb = b.toString();
				System.out.println(numb);

			}
			
			break;

		default:
			break;
		}
	}
}
	}

}
