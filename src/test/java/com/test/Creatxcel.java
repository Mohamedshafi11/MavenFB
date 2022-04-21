package com.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Creatxcel {
	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://demo.automationtesting.in/Register.html");
		WebElement Skilldrop = driver.findElement(By.id("Skills"));
		Select se = new Select (Skilldrop);
		List<WebElement> options = se.getOptions();

		File file = new File ("C:\\Users\\ELCOT\\eclipse-workspace\\Fb\\Exel sheets\\hello.xlsx");
		Workbook wrkbook = new XSSFWorkbook();
		Sheet createSheet = wrkbook.createSheet("Datas");
		
		
		
		for (int i = 0; i < options.size(); i++) {
			WebElement webElement = options.get(i);
			Row row = createSheet.createRow(i);
			Cell creCell = row.createCell(0);
			String text = webElement.getText();
			System.out.println(text);
			creCell.setCellValue(text);
		}
		
		FileOutputStream stream = new FileOutputStream(file);
		wrkbook.write(stream);

	}

}


