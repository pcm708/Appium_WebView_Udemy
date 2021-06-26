package mdFactory;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class MobileWebdriverFactory {
	
	static DesiredCapabilities cap;
	
	static {
		cap = new DesiredCapabilities();
	}
	
	public static AndroidDriver<AndroidElement> connectWithAppiumServer(DesiredCapabilities cap) throws MalformedURLException {
		return new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"), cap);
	}
	
	public static AndroidDriver<AndroidElement> getMobileDriver(String udid,String eName) throws MalformedURLException {
		System.out.println("Info:: Trying to launch driver session");
		cap.setCapability("avd",eName);
		cap.setCapability("avdLaunchTimeout", 18000);
		
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Any Device");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		cap.setCapability(MobileCapabilityType.UDID, udid);
		cap.setCapability(MobileCapabilityType.BROWSER_NAME,"chrome");
		return connectWithAppiumServer(cap);
	}
}
