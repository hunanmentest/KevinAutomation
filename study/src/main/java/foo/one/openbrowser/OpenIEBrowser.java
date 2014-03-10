package foo.one.openbrowser;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class OpenIEBrowser {
	private static WebDriver ie = null;
	private static String projectpath = System.getProperty("user.dir");
	
    public static void main(String[] args){
    	System.setProperty("webdriver.ie.driver", projectpath+"/libs/IEDriverServer64.exe"); 
    	ie = new InternetExplorerDriver();
    	ie.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    	ie.manage().window().maximize();
    	ie.get("http://www.baidu.com");
    	WebElement e = ie.findElement(By.id(""));
    	e.click();
    	String title = ie.getTitle();
    	String currenturl = ie.getCurrentUrl();
    	System.out.println("当前url是：" + currenturl + "\n" + "当前网路窗口是： " + title);
    }
}
