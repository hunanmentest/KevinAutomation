package foo.one.openbrowser;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.JavascriptExecutor;

public class SimpleLocate {

	private static WebDriver dr = null;
	private static String projectpath = System.getProperty("user.dir");
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		dr = new FirefoxDriver();
		dr.manage().window().maximize();
		dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		File file = new File("page/form.html");
        String filePath = "file:///" + file.getAbsolutePath();
        System.out.printf("now accesss %s \n", filePath);
         dr.get(filePath);
         Thread.sleep(2000);

 //      by id
         dr.findElement(By.id("inputEmail")).click();
         Thread.sleep(1000);

 //      by name
         dr.findElement(By.name("password"));
         Thread.sleep(1000);

 //      by tagname
         String classOfForm = dr.findElement(By.tagName("form")).getAttribute("class");
         System.out.printf("%s\n", classOfForm);
         Thread.sleep(1000);

 //      by link text
         WebElement link = dr.findElement(By.linkText("register"));
         ((JavascriptExecutor)dr).executeScript("$(arguments[0]).fadeOut().fadeIn()", link);
         Thread.sleep(1000);

 //      by partial link test
         WebElement sameLink = dr.findElement(By.partialLinkText("reg"));
         ((JavascriptExecutor)dr).executeScript("$(arguments[0]).fadeOut().fadeIn()", sameLink);
         Thread.sleep(1000);

 //      by css selector
         WebElement div = dr.findElement(By.cssSelector(".controls"));
         ((JavascriptExecutor)dr).executeScript("$(arguments[0]).fadeOut().fadeIn()", div);
         Thread.sleep(1000);

 //      by xpath
         dr.findElement(By.xpath("/html/body/form/div[3]/div/label/input")).click();
         Thread.sleep(1000);

         System.out.println("browser will be close");
         dr.quit();  
	}
}
