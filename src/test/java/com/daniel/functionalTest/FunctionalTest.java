package com.daniel.functionalTest;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.*;
public class FunctionalTest {
	
	
	public WebDriver acessarAplicacao() {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://localhost:8001/tasks/");
		
		return driver;
	}
	
	@Test
	public void deveCadastrarTask() {
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
			driver.close();
		}
	}
	
	@Test
	public void naoDeveSalvarTarefaSemDescricao() {
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
			driver.close();
		}
	}
	
	@Test
	public void naoDeveSalvarTarefaSemData() {
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
			driver.close();
		}
	}
}
