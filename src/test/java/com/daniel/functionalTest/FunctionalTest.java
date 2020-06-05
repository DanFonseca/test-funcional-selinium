package com.daniel.functionalTest;



import java.beans.DesignMode;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import static org.junit.Assert.*;
public class FunctionalTest {
	
	
	public WebDriver acessarAplicacao()  {
			DesiredCapabilities cap =  DesiredCapabilities.chrome();
			WebDriver driver = null;
			try {
				driver = new RemoteWebDriver(new URL("http://192.168.1.77:4444/wd/hub"), cap);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
			driver.get("http://192.168.1.77:8001/tasks/");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			
			return driver;
	}

	
	@Test
	public void deveCadastrarTask()  {
		WebDriver driver = acessarAplicacao();
		try {
		//clicar no botado de adicionar
		driver.findElement(By.id("addTodo")).click();
		//inputar os dados de texto
		driver.findElement(By.id("task")).sendKeys("Teste Funcional Texto");
		//inputar os dados de texto
		driver.findElement(By.id("dueDate")).sendKeys("10/10/2030");
		//apertar no botao enviar
		driver.findElement(By.id("saveButton")).click();
		
		//pegar a mensagem de retorno
		String message = driver.findElement(By.id("message")).getText();
		assertEquals("Success!", message);
		
		}finally {
			driver.quit();
		}
	}
	
	@Test
	public void naoDeveSalvarTarefaSemDescricao()  {
		WebDriver driver = acessarAplicacao();
		try {
		//clicar no botado de adicionar
		driver.findElement(By.id("addTodo")).click();
		//inputar os dados de texto
		//driver.findElement(By.id("task")).sendKeys("Teste Funcional Texto");
		//inputar os dados de texto
		driver.findElement(By.id("dueDate")).sendKeys("10/10/2030");
		//apertar no botao enviar
		driver.findElement(By.id("saveButton")).click();
		
		//pegar a mensagem de retorno
		String message = driver.findElement(By.id("message")).getText();
		assertEquals("Fill the task description", message);
		
		}finally {
			driver.quit();
		}
	}

	
	@Test
	public void naoDeveSalvarTarefaSemData()  {
		WebDriver driver = acessarAplicacao();
		try {
		//clicar no botado de adicionar
		driver.findElement(By.id("addTodo")).click();
		//inputar os dados de texto
		driver.findElement(By.id("task")).sendKeys("Teste Funcional Texto");
		//inputar os dados de texto
		//driver.findElement(By.id("dueDate")).sendKeys("10/10/2030");
		//apertar no botao enviar
		driver.findElement(By.id("saveButton")).click();
		
		//pegar a mensagem de retorno
		String message = driver.findElement(By.id("message")).getText();
		assertEquals("Fill the due date", message);
		
		}finally {
			driver.quit();
		}
	}
	
	@Test
	public void deveDeletar () {
		WebDriver driver = acessarAplicacao();
		try {
		//clicar no botado de adicionar
		driver.findElement(By.id("addTodo")).click();
		//inputar os dados de texto
		driver.findElement(By.id("task")).sendKeys("Teste Funcional Texto");
		//inputar os dados de texto
		driver.findElement(By.id("dueDate")).sendKeys("10/10/2030");
		//apertar no botao enviar
		driver.findElement(By.id("saveButton")).click();

		driver.findElement(By.xpath("//a[@class=\"btn btn-outline-danger btn-sm\"]")).click();
		String message = driver.findElement(By.id("message")).getText();
	
		assertEquals("Success!", message);
		
		}finally {
			driver.quit();
		}
		
	}

}
