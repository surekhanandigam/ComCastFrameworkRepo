package com.comcast.crm.generic.fileutility;

import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonUtility {
   public String getDataFromJsonFile(String Key) throws Throwable
   {
	   FileReader fileR=new FileReader("./configAppData/appCommonData.json");
	   JSONParser parser=new JSONParser();
	   Object obj=parser.parse(fileR);
	   JSONObject map=(JSONObject)obj;//downcasting
	   String data=(String)map.get(Key);
	   return data;
   }
}
