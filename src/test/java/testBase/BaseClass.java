package testBase;


import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;


import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


public class BaseClass {
	public static WebDriver driver;
	public Logger logger;
	public Properties p;
	
	@BeforeClass(groups= {"Sanity","Master","DataDriver"})
	@Parameters({"os","browser"})
	public void setup(String os, String br) throws IOException
	{
		//Loading config.properties file
		FileReader file=new FileReader("./src//test//resources//config.properties");
		p=new Properties();
		p.load(file);
		
		logger=LogManager.getLogger(this.getClass());
		
		if(p.getProperty("execution_env").equalsIgnoreCase("remote")) {
			DesiredCapabilities cap=new DesiredCapabilities();
			
			if(os.equalsIgnoreCase("windows")) {
				cap.setPlatform(Platform.WIN11);
			}
			if(os.equalsIgnoreCase("linux")) {
				cap.setPlatform(Platform.LINUX);
			}
			switch(br.toLowerCase()) {
			case "chrome":cap.setBrowserName("chrome"); break;
			case "edge":cap.setBrowserName("edge"); break;
			case "firefox":cap.setBrowserName("firefox"); break;
			default: System.out.println("Invalid browser name"); return;
			}
			driver=new RemoteWebDriver(new URL("http://192.168.1.3:4444/wd/hub"),cap);
		}
		if(p.getProperty("execution_env").equalsIgnoreCase("local")) {
			switch(br.toLowerCase()) {
			case "chrome" : driver=new ChromeDriver();
			break;
			case "edge" :driver=new EdgeDriver();
			break;
			case "firefox" :driver=new FirefoxDriver();
			break;
			default : System.out.println("Invalid browser name...");
			return;
		}
		
		
	}
		
		
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		driver.get(p.getProperty("AppUrl2"));  //reading url from properties file
		driver.manage().window().maximize();
		
	} 
	@AfterClass(groups= {"Sanity","Master","DataDriven"})
	public void tearDown() {
		 if (driver != null)
		 {
		
		driver.quit();
		 }
	}
	public String randomeString() {
		String generatedString=RandomStringUtils.randomAlphabetic(8);
		return generatedString;
	}
	public String randomeAlphaNumeric() {
		String str=RandomStringUtils.randomAlphanumeric(10);
		return str;
	}
	public String randomAlphanumeric() {
		String str=RandomStringUtils.randomAlphabetic(5);
		String num=RandomStringUtils.randomNumeric(2);
		return (str+"@"+num);
	}
	public String randomEmail() {
		String str=RandomStringUtils.randomAlphabetic(5);
		String num=RandomStringUtils.randomNumeric(2);
		return (str+num+"@gmail.com");
	}
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		return destination;

	}

}

