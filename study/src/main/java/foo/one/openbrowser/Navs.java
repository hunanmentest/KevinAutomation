package foo.one.openbrowser;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Navs {

	private static WebDriver ie = null;
	private static String projectpath = System.getProperty("user.dir");
	
    public static void main(String[] args) throws InterruptedException{
    	System.setProperty("webdriver.ie.driver", projectpath+"/libs/IEDriverServer64.exe"); 
    	ie = new InternetExplorerDriver();
    	ie.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    	ie.manage().window().maximize();
		File file = new File("page/level_locate.html");
        String filePath = "file:///" + file.getAbsolutePath();
        System.out.printf("now accesss %s \n", filePath);
        ie.get(filePath);
        //      方法1：层级定位，先定位ul再定位li
        ie.findElement(By.className("nav")).findElement(By.linkText("About")).click();
        Thread.sleep(1000);

//      方法2: 直接定位link
        ie.findElement(By.linkText("Home")).click();
        
        ie.quit();
	}

}
