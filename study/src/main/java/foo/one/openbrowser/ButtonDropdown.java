package foo.one.openbrowser;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class ButtonDropdown {
	private static WebDriver dr = null;
	private static String projectpath = System.getProperty("user.dir");
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		dr = new FirefoxDriver();
		dr.manage().window().maximize();
		dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		File file = new File("page/button_dropdown.html");
        String filePath = "file:///" + file.getAbsolutePath();
        System.out.printf("now accesss %s \n", filePath);
        dr.get(filePath);
        
        //      定位text是watir-webdriver的下拉菜单
        //      首先显示下拉菜单
        dr.findElement(By.linkText("Info")).click();
        (new WebDriverWait(dr, 10)).until(new ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver d){
                        return d.findElement(By.className("dropdown-menu")).isDisplayed();
                    }
                });

        //      通过ul再层级定位
        dr.findElement(By.className("dropdown-menu")).findElement(By.linkText("watir-webdriver")).click();
        Thread.sleep(1000);
        System.out.println("browser will be close");
        dr.quit();
	}
}
