package genericUtilities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadingDataFromJsonFile {
	public String readDataFromJsonFile(String key) throws Exception, IOException, ParseException {
		JSONParser jp=new JSONParser();
		Object obj=jp.parse(new FileReader("./testData/LaunchingData.json"));
		JSONObject jobj=(JSONObject)obj;
		
		return (String)jobj.get(key);
	}
}
