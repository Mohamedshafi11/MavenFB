package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FaceBk {

	public static void main(String[] args) {
WebDriverManager.chromedriver().setup();
WebDriver driver = new ChromeDriver();
driver.get("https://en-gb.facebook.com/");
driver.manage().window().maximize();
WebElement emailTxt = driver.findElement(By.id("email"));
emailTxt.sendKeys("9876543210");
WebElement passTxt = driver.findElement(By.id("pass"));
passTxt.sendKeys("1234567@ss");
WebElement loginBtn = driver.findElement(By.name("login"));
loginBtn.click();

	}

}
