package com.pomselenium.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.pomselenium.pages.IngresarCuentaPages;
import com.pomselenium.pages.PaginaPrincipalPages;



import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class IngresarCuentaTest {
	private String rutaDriver = "src/test/java/drivers/";
	private String rutaUrl = "http://automationpractice.com/index.php";
	WebDriver driver;
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", rutaDriver+"chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
	}
	
	@Test
	public void account() throws InterruptedException {
		driver.get(rutaUrl);
		PaginaPrincipalPages principal = new PaginaPrincipalPages(driver);
		IngresarCuentaPages cuenta = new IngresarCuentaPages(driver);
		principal.clickEnRegistrarse();
		Thread.sleep(3000);
		cuenta.ingresarCredencialesYValidarMensaje();
		Thread.sleep(3000);
		cuenta.validarUsuario();
	
		
	}
	
	@After
	public void cerrarSesionYNavegador() {
		IngresarCuentaPages desconectar = new IngresarCuentaPages(driver);
		desconectar.clickEnDesconectar();
		driver.close();
		
	}
	

}
