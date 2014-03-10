package foo.one.openbrowser;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LevelLocate {
	private static WebDriver ffwb = null;
	private static String projectpath = System.getProperty("user.dir");
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ffwb = new FirefoxDriver();
		ffwb.manage().window().maximize();
		ffwb.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		File file = new File("page/level_locate.html");
        String filePath = "file:///" + file.getAbsolutePath();
        System.out.printf("now accesss %s \n", filePath);
        ffwb.get(filePath);
        ffwb.findElement(By.linkText("Link1")).click();
        
        (new WebDriverWait(ffwb, 10)).until(new ExpectedCondition<Boolean>(){
            public Boolean apply(WebDriver d){
                return d.findElement(By.id("dropdown1")).isDisplayed();
            }
        } );

        WebElement menu = ffwb.findElement(By.id("dropdown1")).findElement(By.linkText("Another action"));
        (new Actions(ffwb)).moveToElement(menu).perform();
        ffwb.quit();
	}

}
