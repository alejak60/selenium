package com.pomselenium.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaginaPrincipalPages {

	private WebDriver driver;
	
	//Localizadores
	@FindBy(xpath= "//*[@id=\"header\"]/div[2]/div[1]/div[1]/nav[1]/div[1]/a[1]")
	WebElement registrarse;

	
	
	
	
	//contructor y metodos necesarios
	
	public PaginaPrincipalPages(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickEnRegistrarse() {
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		registrarse.click();
	}
	
	
	
	
}
