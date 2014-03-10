package foo.one.openbrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class OpenChromBrowser {
	private static WebDriver chromewb = null;
	private static DesiredCapabilities caps = null;
	private static String projectpath = System.getProperty("user.dir");
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", projectpath+"/libs/chromedriver.exe");
		chromewb = new ChromeDriver();
		chromewb.get("http://www.baidu.com");
		chromewb.quit();
	}

}
