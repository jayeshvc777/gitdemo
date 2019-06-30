package FirstPackage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class browsercalling 
{

	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "E:\\Jayesh\\MyProject\\bin\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com");
		
		//driver.manage().window().maximize();
		WebElement search = driver.findElementByXPath(".//*[@id='container']/div/header/div[1]/div[2]/div/div/div[2]/form/div/div[1]/div/input");
		search.sendKeys("pc games");
		Thread.sleep(3000);
		WebElement button = driver.findElementByXPath(".//*[@id='container']/div/header/div[1]/div[2]/div/div/div[2]/form/div/div[2]/button");
		button.click();
		Thread.sleep(10000);
		
		for (int i=2;i<=5;i++)
		{
			WebElement pagination = driver.findElementByXPath(".//*[@id='container']/div/div[2]/div[2]/div/div[2]/div/div[3]/div[2]/ul/li["+i+"]/a");
			pagination.click();
			Thread.sleep(10000);
		}
		WebElement game = driver.findElementByXPath(".//*[@id='container']/div/div[2]/div[2]/div/div[2]/div/div[3]/div[1]/div[1]/div[2]/div/a[2]");
		game.click();
		
		
	}
}
//.//*[@id='container']/div/header/div[1]/div[2]/div/div/div[2]/form/div/div[1]/div/input
//.//*[@id='container']/div/header/div[1]/div[2]/div/div/div[2]/form/div/div[2]/button
//.//*[@id='container']/div/div[2]/div[2]/div/div[2]/div/div[3]/div[2]/ul/li[1]/a
//.//*[@id='container']/div/div[2]/div[2]/div/div[2]/div/div[3]/div[1]/div[1]/div[2]/div/a[2]
//.//*[@id='container']/div/div[2]/div/div/div[1]/div/div[1]/div/div/div[2]/ul/li[1]/button