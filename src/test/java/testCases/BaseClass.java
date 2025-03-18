package testCases;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import net.bytebuddy.utility.RandomString;

import java.text.SimpleDateFormat;

public class BaseClass {
	public static WebDriver driver;
	public Logger logger;
	protected Actions action;
	public Properties p;
	public WebDriverWait wait;
	public static String randomString;
	
	//Base class
	@BeforeClass
	@Parameters({"os","browser"})
	public void setup(String os,String br) throws IOException 
	{
		//Load properties file 
				FileReader file =new FileReader("C:\\Workspaces\\30-10-2024 On words\\Parabank_V1.2\\src\\test\\resources\\config.properties");
				p=new Properties();
				p.load(file);
		
			//for remote	
			if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
			{
				DesiredCapabilities capabilities=new DesiredCapabilities();
				
				//os
				if(os.equalsIgnoreCase("windows"))
				{
					capabilities.setPlatform(Platform.WIN10);
				}
				else if(os.equalsIgnoreCase("mac"))
				{
					capabilities.setPlatform(Platform.WIN10);
				}
				else {
					System.out.println("no matching OS");
					return;
				}
				
				//browser
				
				switch(br.toLowerCase())
				{
					case "chrome": capabilities.setBrowserName("chrome"); break;
					case "firefox": capabilities.setBrowserName("firefox"); break;
					case "edge": capabilities.setBrowserName("Microsoftedge"); break;
					default: System.out.println("browser is not matching: "+ br);return;
					
				}
				
				driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
				
			}
				
				
		//for local		
			if(p.getProperty("execution_env").equalsIgnoreCase("local"))
			{	
					switch(br.toLowerCase())
					{
						case "chrome": driver=new ChromeDriver(); break;
						case "firefox": driver=new FirefoxDriver(); break;
						case "edge": driver=new EdgeDriver(); break;
						default: System.out.println("browser is not matching: "+ br);
						
					}
			}
			
			
		
		// Initialize the Actions object
        action = new Actions(driver); // Initialize action with driver
        
		
        wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		
		logger=LogManager.getLogger(this.getClass()); //log4j2
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get(p.getProperty("AppURL"));
		
		
		
	}
	
	public String captureScreen(String tname) 
	{
		String timeStamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		
		TakesScreenshot takesScreenshot= (TakesScreenshot)driver;
		File SourceFile=takesScreenshot.getScreenshotAs(OutputType.FILE);
		String path="C:\\Workspaces\\30-10-2024 On words\\Parabank_V1.2\\screenshots\\"+tname+" "+timeStamp+".png";
		File targetfile=new File(path);
		
		SourceFile.renameTo(targetfile);
		return path;
		
		
		
	}
	
	
	
	static 
	{
        // Generate the random string once when the class is loaded
        randomString = RandomString.make(3); // Generates a 10-character random string
    }
	public static String getRandomString() 
	{
		
		return randomString;
	}
	
	
	
	
	@AfterClass
	public void tearDown() 
	{
		driver.quit();
	}

}
