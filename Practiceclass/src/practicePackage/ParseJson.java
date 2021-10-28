package practicePackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ParseJson {

	public static void main(String[] args) throws Exception,JSONException {
		String filename = "C:\\Users\\abhinav.abhay\\Downloads\\jsonjar\\jsonfile.txt";
		
		JSONObject obj = new JSONObject();
		obj =parseJSONFILE(filename);
		String pageName = obj.getJSONObject("pageInfo").getString("pageName");
		JSONArray arr = obj.getJSONArray("posts");
		for (int i = 0; i < arr.length(); i++)
		{
		    //String post_id = arr.getJSONObject(i).getString("post_id");
		    //System.out.println(post_id);
			System.out.println(arr.getJSONObject(i));
			 System.out.println(arr.getString (i)+" = "+obj.getString (arr.getString (i)));
		}

	}

	private static JSONObject parseJSONFILE(String filename) throws JSONException,IOException {
		String content = new String(Files.readAllBytes(Paths.get(filename)));
        return new JSONObject(content);
	}

}
