package foo.one.openbrowser;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SimpleLocateCheckBox {

	private static WebDriver dr = null;
	private static String projectpath = System.getProperty("user.dir");
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		dr = new FirefoxDriver();
		dr.manage().window().maximize();
		dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		File file = new File("page/checkbox.html");
        String filePath = "file:///" + file.getAbsolutePath();
        System.out.printf("now accesss %s \n", filePath);
         dr.get(filePath);
         Thread.sleep(2000);
         /**
         // 选择所有的checkbox并全部勾上css,怎么判断是否被选中上
         List<WebElement> checkboxs = dr.findElements(By.cssSelector("input[type=checkbox]"));
         for(WebElement ch:checkboxs){
        	   ch.click();
         }
         dr.navigate().refresh();
         
         // 选择所有的checkbox并全部勾上xpath，,怎么判断是否被选中上
         List<WebElement> checkbox = dr.findElements(By.xpath("//div[@class='control-group']/div/input[@type='checkbox']"));
         for(WebElement ch:checkbox){
        	   ch.click();
         }
         //Assert.assertEquals(3, checkbox.size());
         //System.out.println(checkbox.size());
         dr.navigate().refresh();**/
         
         List<WebElement>  cb = dr.findElements(By.tagName("input"));
         for(WebElement c:cb){
        	 if(c.getAttribute("type").equals("checkbox"))
        		 c.click();
         }
         System.out.println(cb.size());
         dr.navigate().refresh();
         
         List<WebElement>  cs = dr.findElements(By.cssSelector("input[type='checkbox']"));
         cs.get(cs.size()-1).click();
         dr.navigate().refresh();
         System.out.printf("我要退出了，你知道的");
         dr.quit();
	}

}
