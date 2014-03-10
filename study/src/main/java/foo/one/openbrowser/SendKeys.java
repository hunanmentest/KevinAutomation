package foo.one.openbrowser;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.Keys;

public class SendKeys {
	private static WebDriver dr = null;
	private static String projectpath = System.getProperty("user.dir");
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		dr = new FirefoxDriver();
		dr.manage().window().maximize();
		dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		File file = new File("page/send_keys.html");
        String filePath = "file:///" + file.getAbsolutePath();
        System.out.printf("now accesss %s \n", filePath);
        dr.get(filePath);
        Thread.sleep(2000);
          
//      copy content of A
        dr.findElement(By.id("A")).sendKeys(Keys.chord(Keys.CONTROL + "a"));
        Thread.sleep(1000);
        dr.findElement(By.id("A")).sendKeys(Keys.chord(Keys.CONTROL + "x"));

//      paste to B
        dr.findElement(By.id("B")).sendKeys(Keys.chord(Keys.CONTROL + "v"));

//      SendKeys to A
        dr.findElement(By.id("A")).sendKeys(Keys.chord("watir webdriver is better than selenium webdriver"));

         System.out.println("browser will be close");
         dr.quit();  
	}
}
