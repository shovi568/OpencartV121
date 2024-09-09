package TestBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class BaseClass {
	

	public static WebDriver driver;
	public Logger logger;
	public Properties p;

	@BeforeClass(groups= {"Master"})
	@Parameters({"browser" })
	public void setup(String br) throws IOException {

		// Loading config.propertis file
		
		FileReader file = new FileReader("./src//test//resources//config.properties");
		 p = new Properties();
		 p.load(file);

		 logger = LogManager.getLogger(this.getClass());

		// driver = new ChromeDriver();

		switch (br) {
		case "chrome":driver = new ChromeDriver();break;
		case "edge":driver = new EdgeDriver(); break;
		default:System.out.println("invalid browser name...");return;
		}

		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("url"));
		driver.manage().window().maximize();

	}

	@AfterClass(groups= {"Master"})
	
	public void teardown() {
	
		driver.quit();

	} 

	public String randomeString() {
		String generatingstring = RandomStringUtils.randomAlphabetic(5);
		return generatingstring;
	}

	public String randomno() {
		String generano = RandomStringUtils.randomNumeric(10);
		return generano;
	}

	public String randomaphanum() {
		String generatingstring = RandomStringUtils.randomAlphabetic(5);
		String generano = RandomStringUtils.randomNumeric(10);
		return (generatingstring + "@" + generano);

	}

	public String captureScreen(String tname) throws IOException {
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		TakesScreenshot takesScreenShot=(TakesScreenshot) driver;
		File sourceFile= takesScreenShot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname +"_"+timeStamp +".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
	
		
		return targetFilePath;
	} 

	
}
