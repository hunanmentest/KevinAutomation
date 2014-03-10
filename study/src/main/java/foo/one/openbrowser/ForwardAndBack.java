package foo.one.openbrowser;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ForwardAndBack {

	private static WebDriver ffwb = null;
	private static String projectpath = System.getProperty("user.dir");
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ffwb = new FirefoxDriver();
		ffwb.manage().window().maximize();
		ffwb.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		ffwb.get("http://www.baidu.com");
		String title = ffwb.getTitle();
		String currenturl = ffwb.getCurrentUrl();
		System.out.println("当前的title是：" + title + "\n" + "当前的url是：" + currenturl);
		ffwb.get("www.xigua365.com");
		String title1 = ffwb.getTitle();
		String currenturl1 = ffwb.getCurrentUrl();
		System.out.println("当前的title是：" + title1 + "\n" + "当前的url是：" + currenturl1);
		ffwb.navigate().back();
		String title2 = ffwb.getTitle();
		String currenturl2 = ffwb.getCurrentUrl();
		System.out.println("当前的title是：" + title2 + "\n" + "当前的url是：" + currenturl2);
		
		ffwb.navigate().forward();
		String title3 = ffwb.getTitle();
		String currenturl3 = ffwb.getCurrentUrl();
		System.out.println("当前的title是：" + title3 + "\n" + "当前的url是：" + currenturl3);
		
		System.out.println("browser will be close");
	    ffwb.quit();
	}
}
