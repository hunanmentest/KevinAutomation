package foo.one.openbrowser;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ButtonGroup {
	private static WebDriver dr = null;
	private static String projectpath = System.getProperty("user.dir");
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		dr = new FirefoxDriver();
		dr.manage().window().maximize();
		dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		File file = new File("page/button_group.html");
        String filePath = "file:///" + file.getAbsolutePath();
        System.out.printf("now accesss %s \n", filePath);
        dr.get(filePath);
         Thread.sleep(1000);

 //      定位text是second的按钮
         List<WebElement> btns = dr.findElement(By.className("btn-group")).findElements(By.className("btn"));

         for(WebElement btn : btns){
             if(btn.getText().equals("second")){
                 btn.click();
                 break;
             }
         }

         Thread.sleep(1000);
         System.out.println("browser will be close");
         dr.quit();  
     }

}
