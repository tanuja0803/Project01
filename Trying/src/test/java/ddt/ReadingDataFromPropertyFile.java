package ddt;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.testng.annotations.Test;

public class ReadingDataFromPropertyFile {
	@Test
	public void readData() throws Exception {
		FileInputStream fis=new FileInputStream("./src/test/resources/common_Data.PropertyFileData.properties");
		Properties prop=new Properties();
		prop.load(fis);
		System.out.println("Name:"+prop.getProperty("Name")+" "+"Age:"+prop.getProperty("Age"));
	}
}
