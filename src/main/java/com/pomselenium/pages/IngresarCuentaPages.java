package com.pomselenium.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IngresarCuentaPages {
	
	private WebDriver driver;
	
	//Localizadores
	@FindBy(xpath = "//*[@id=\"email\"]")
	WebElement usuario;
	@FindBy(xpath = "//*[@id=\"passwd\"]")
	WebElement contrasena;
	@FindBy(css = "#SubmitLogin > span")
	WebElement btnRegistrarse;
	@FindBy(xpath = "//*[@id=\"login_form\"]/h3")
	WebElement mensajeRegistrarse;
	@FindBy(css = "header#header > div:nth-of-type(2) > div > div > nav > div > a > span")
	WebElement UsuarioCuenta;
	@FindBy(xpath = "//*[@id=\"header\"]/div[2]/div[1]/div[1]/nav[1]/div[2]/a[1]")
	WebElement desconectarse;
	
	public IngresarCuentaPages(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickSobreElemento(WebElement elementoClick) {
		elementoClick.click();
	}
	
	public void enviarTexto(WebElement elementoEscribir,String texto) {
		elementoEscribir.sendKeys(texto);
	}
	
	public void ingresarCredencialesYValidarMensaje() {
		clickSobreElemento(mensajeRegistrarse); System.out.println("ELEMENTO SELECCIONADO");
		String mensajeIniciarSesion = mensajeRegistrarse.getText();
		System.out.println("EL MENSAJE ES: "+mensajeIniciarSesion);
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		enviarTexto(usuario, "camilolearn@gmail.com");
		enviarTexto(contrasena, "123456789");
		clickSobreElemento(btnRegistrarse);
	}
	
	public void validarUsuario() {
		clickSobreElemento(UsuarioCuenta);
		String mensajeCuentaIngresada = UsuarioCuenta.getText();
		System.out.println("EL USUARIO ES: "+mensajeCuentaIngresada);
		
	}
	
	public void clickEnDesconectar () {
		clickSobreElemento(desconectarse);
	}
	
	
	
	
	
	

}
