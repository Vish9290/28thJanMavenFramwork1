package LibraryFiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility_Class 
{
	//@Author name: Vishal
	//This method is use to get the test data from excel
	//This method accepts two parameters 1: rowIndex, 2: colIndex
	public static String getTestData(int rowIndex, int ColIndex) throws EncryptedDocumentException, IOException
	{
		FileInputStream fi = new FileInputStream("C:\\Users\\Vishal\\eclipse-workspace\\28thJanmavenFramework1\\Testdata\\Excel1.xlsx");
		Sheet sh = WorkbookFactory.create(fi).getSheet("Sheet1");
		
		String value = sh.getRow(rowIndex).getCell(ColIndex).getStringCellValue();
		return value;
	}
	
	
	public static void CaptureSS(WebDriver driver, int TCid) throws InterruptedException, IOException
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\Vishal\\eclipse-workspace\\28thJanmavenFramework1\\Screenshots\\FailedTC"+TCid+".jpg");
		
		FileHandler.copy(src, dest);
			
	}
	
	
	public static String getDataFromPropertiesFile(String Key) throws IOException
	{
		FileInputStream file = new FileInputStream("C:\\Users\\Vishal\\eclipse-workspace\\28thJanmavenFramework1\\GetTestData.properties");
		Properties prop = new Properties();
		prop.load(file);
		String value = prop.getProperty(Key);
		return value;
	}
		


}
