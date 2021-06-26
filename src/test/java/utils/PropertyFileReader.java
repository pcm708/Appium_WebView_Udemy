package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileReader {
	static Properties prop= null;
	static FileInputStream fs= null;
	
	static {
		prop= new Properties();
		try {
			fs = new FileInputStream(System.getProperty("user.dir")+"/config.properties");
			prop.load(fs);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String getProperty(String key) {
		return prop.getProperty(key).toString().trim();
	}
}
