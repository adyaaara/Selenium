package testScripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigateToGoogle {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		//WebDriver driver = new EdgeDriver();
		//WebDriver driver = new FirefoxDriver();
		driver.get("https://www.google.com");
		
		driver.manage().window().maximize();
		
		System.out.println("Browser has been opened with Google");
		
		driver.close();	}

}
