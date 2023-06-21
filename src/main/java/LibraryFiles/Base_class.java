package LibraryFiles;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base_class
{
	 public WebDriver driver = null;
	
	public void intializeBrowser() throws IOException 
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(Utility_Class.getDataFromPropertiesFile("URL"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}	
}
