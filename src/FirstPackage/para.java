package FirstPackage;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;



public class para
{
	static FirefoxDriver driver;
	public static void main(String[] args) throws Exception
	{
		System.setProperty("webdriver.gecko.driver","E:\\Jayesh\\MyProject\\bin\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://www.bluelineticket.com/login");
		File src = new File("E:\\Jayesh\\test.xlsx");
		FileInputStream fls = new FileInputStream(src);
		XSSFWorkbook wb1 = new XSSFWorkbook(fls);
		XSSFSheet sheet1 = wb1.getSheetAt(0);
		String para[] = new String[10];
		int noOfrows = sheet1.getLastRowNum();
		int noOfColumns = sheet1.getRow(0).getLastCellNum();
		System.out.println(noOfrows);
		System.out.println(noOfColumns);
		FileOutputStream fout = new FileOutputStream(src);
		
			
		for (int row = 1; row < noOfrows+1; row++)
		{		

			for (int col = 0; col < noOfColumns; col++)
			{				
				para[col] = sheet1.getRow(row).getCell(col).getStringCellValue();				
			}
														
			driver.findElement(By.xpath(".//*[@id='email']")).sendKeys(para[0]);
			Thread.sleep(3000);
			driver.findElement(By.xpath(".//*[@id='password']")).sendKeys(para[1]);
			Thread.sleep(3000);
			driver.findElement(By.xpath(".//*[@id='update_details']")).click();
			Thread.sleep(5000);
			
			
			//if(driver.findElement(By.xpath(".//*[@id='main-navigation']/div/div[1]/ul/li/a/i")).isDisplayed())
			if(driver.findElements( By.xpath(".//*[@id='main-navigation']/div/div[1]/ul/li/a/i")).size() != 0)
			{
				System.out.println("login successful" + "\t" + "with" + "\t" + "emai id:" + para[0] + "\t" +"password:" + para[1]);
				sheet1.getRow(row).createCell(noOfColumns).setCellValue("pass");
			
				driver.findElement(By.xpath(".//*[@id='main-navigation']/div/div[1]/ul/li/a/i")).click();
				
				driver.findElement(By.xpath(".//*[@id='main-navigation']/div/div[1]/ul/li/div/ul/li[2]/a")).click();
				Thread.sleep(5000);
			}
			else
			{
				System.out.println("login failed" + "\t" + "with" + "\t" + "emai id:" + para[0] + "\t" +"password:" + para[1]);
				sheet1.getRow(row).createCell(noOfColumns).setCellValue("fail");
				driver.navigate().refresh();
				Thread.sleep(3000);
			}
			
		}
		driver.quit();
		wb1.write(fout);
		wb1.close();
		


	}

}
