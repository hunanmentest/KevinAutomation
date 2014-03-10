package foo.one.openbrowser;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class OpenFireFoxBrowser {
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
	    ffwb.quit();
	}

}
