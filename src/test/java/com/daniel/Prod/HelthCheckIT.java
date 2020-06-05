package com.daniel.Prod;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import static org.junit.Assert.*;

public class HelthCheckIT {

	@Test
	public void helthCheck () {
		
		DesiredCapabilities cap =  DesiredCapabilities.chrome();
		WebDriver driver = null;
		try {
			driver = new RemoteWebDriver(new URL("http://192.168.1.77:4444/wd/hub"), cap);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		driver.get("http://192.168.1.77:8001/tasks/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String version = driver.findElement(By.id("version")).getText();
		assertTrue(version.startsWith("Build"));
		
		driver.quit();
	}
}
