package com.dice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DiceJobSearch {

	public static void main(String[] args) {
	 WebDriverManager.chromedriver().setup();
 WebDriver driver =new ChromeDriver();
 
 String url ="http://dice.com";
 driver.get(url);
 
 String actualTitle =driver.getTitle();
 String expectedTitle = "Job Search for Technology Professionals | Dice.com";
 if(actualTitle.equals(expectedTitle)) {
	 System.out.println("dice sucsesfully loaded");
 }else {
	 System.out.println("dice NOT sucsesfully loaded");
	 throw new RuntimeException("Step Fail");
 }
 //fullscreen
 driver.manage().window().maximize();
 //set universal
 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 
 String keyword="Selenium";
 driver.findElement(By.id("search-field-keyword")).clear();
 driver.findElement(By.id("search-field-keyword")).sendKeys(keyword);
 
 String location="20175";
 driver.findElement(By.id("search-field-location")).clear();
 driver.findElement(By.id("search-field-location")).sendKeys(location);

 driver.findElement(By.id("findTechJobs")).click();
  String count  = driver.findElement(By.id("posiCountId")).getText();
  System.out.println(count);
  int countResult = Integer.parseInt(count.replace(",", " "));
  
  if(countResult > 0) {
	  	System.out.println( "Step PASS: Keyword : " + keyword +" search returned " +
	  	countResult +" results in " + location);
	  	}else {
	  		System.out.println( "Step FAIL: Keyword : " + keyword +" search returned " +
	  				countResult +" results in " + location);
	  	}
	   		
	  	
	  	driver.close();
	 				

	}


}
