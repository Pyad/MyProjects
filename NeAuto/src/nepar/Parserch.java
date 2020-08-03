package nepar;

public class Parserch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


package com.omnimobile.Testcases.sitecat;

 

import java.io.FileNotFoundException;

import java.io.FileReader;

import java.io.IOException;

import java.io.UnsupportedEncodingException;

import java.net.URLDecoder;		

import java.util.Date;

import java.util.HashMap;

import java.util.LinkedList;

import java.util.List;

import java.util.Map;

 

import org.json.JSONArray;

import org.json.JSONObject;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.json.Json;

import org.testng.Assert;

import org.testng.Reporter;

import org.testng.annotations.Test;

import org.testng.asserts.SoftAssert;

 

import com.fasterxml.jackson.core.JsonParseException;

import com.fasterxml.jackson.databind.JsonMappingException;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.google.gson.JsonArray;

import com.google.gson.JsonObject;

import com.google.gson.JsonParser;

import com.omnimobile.DataObjects.PropertyConfigs;

import com.omnimobile.PageObject.Alerts;

import com.omnimobile.PageObject.LoginAcceptAgreementPage;

import com.omnimobile.PageObject.Login.LoginPage;

import com.omnimobile.PageObject.Transfers.InternalTransfersHomePage;

import com.omnimobile.core.Base;

import com.omnimobile.core.annot.PageFactoryBy;

import com.omnimobile.interactions.ActionModule;

 

public class Parser extends Base{

 

                private static JSONObject parsedTags;

                private static FileReader jsonfile;

                private static FileReader chlsjfile;

                private static Object str,chlsjstr;

                private static JsonParser parser;

                private static List<String> tagContents;

                private static List<JSONObject> parsedTagContents;

                private static SoftAssert softAssert;

                private static JsonArray jsonArr;

                private static JsonArray expectedJsonArr;

                private static String jsonString,expectedJsonString;

                private Alerts alert;

                private LoginPage loginpage;

                private static String platform;

                private InternalTransfersHomePage homePage;

                ActionModule<WebDriver> actions;

                public PropertyConfigs config=new PropertyConfigs();

                public static ClassLoader classloader = new Base().getClass().getClassLoader();

                String jsonsiteSection = null ,jsonsubSiteSection=null,eventName = null;

 

 

                public Parser(ActionModule<WebDriver> actions) throws FileNotFoundException {

                               

                                this.actions=actions;

                                loginpage = new PageFactoryBy().initElements(config.platform, LoginPage.class);

                                alert = new Alerts();

                                softAssert = new SoftAssert();

                                parser = new JsonParser();

                                chlsjfile = new FileReader(HelloJourneyString.FILE_PATH);

                                chlsjstr = parser.parse(chlsjfile);

                                jsonString = chlsjstr.toString();

                                jsonArr = parser.parse(jsonString).getAsJsonArray();

                                tagContents = new LinkedList<String>();

                                parsedTagContents = new LinkedList<JSONObject>();

                                jsonfile = new FileReader(HelloJourneyString.EXPECTED_JSON_FILEPATH);           

                                str = parser.parse(jsonfile);

                                expectedJsonString =str.toString();

                                expectedJsonArr = parser.parse(expectedJsonString).getAsJsonArray();                  

 

                }

 

                public List<JSONObject> getTagContents() throws FileNotFoundException

                {

 

                if(chlsjstr==null) return null;

                for (int reqIndex = 0; reqIndex < jsonArr.size(); reqIndex++) {

                                if(jsonArr.get(reqIndex)!=null) {

                                                JsonObject jsonobject = jsonArr.get(reqIndex).getAsJsonObject();

                                                String hostName = jsonobject.toString();

                                                if (hostName.contains(HelloJourneyString.SITECAT_HOST)) {

                                                                JsonObject requestjson = jsonobject.getAsJsonObject(HelloJourneyString.REQUEST_KEY);

                                                                JsonObject innerJson = requestjson.getAsJsonObject(HelloJourneyString.BODY_KEY);

                                                                if(innerJson != null) {

                                                                                if (innerJson.get(HelloJourneyString.TAG_CONTENT) != null) {

                                                                                                //System.out.println("Image request " + reqIndex + innerJson.get(TAG_CONTENT) + "\n");

                                                                                                tagContents.add(innerJson.get(HelloJourneyString.TAG_CONTENT).toString());

                                                                                } else {

                                                                                                System.out.println(HelloJourneyString.NO_ENTRY);

                                                                                                }

                                                                                }

 

                                                                }

                                                }

                                }

 

                                try {

                                                for (String url : tagContents) {

                                                                parsedTags = parseTags(url);

                                                                parsedTagContents.add(parsedTags);

                                                }

                                } catch (UnsupportedEncodingException e) {

                                                e.printStackTrace();

                                }

 

                                return parsedTagContents;

                }

 

                public static JSONObject parseTags(String contents) throws UnsupportedEncodingException {

                                if (contents == null || contents.length()< 0) {

                                                return null;

                                }

                                String decodedText = URLDecoder.decode(contents, "UTF-8");

                                JSONObject pJson = new JSONObject();

                                JSONObject tJson = null;

                                JSONObject cJson = null;

                                JSONObject cdJson = null;

                                JSONObject aJson = null;

 

                                tJson = pJson;

                                for (String val : decodedText.split("&")) {

                                                //System.out.println(val);

                                                if (val.split("=").length > 1) {

                                                                tJson.append(val.split("=")[0], val.split("=")[1]);

                                                } else {

                                                                switch(val) {

                                                                case HelloJourneyString.C_TAG_START:

                                                                                cJson = new JSONObject();

                                                                                tJson = cJson;

                                                                                break;

                                                                case HelloJourneyString.CD_TAG_START:

                                                                                cdJson = new JSONObject();

                                                                                tJson = cdJson;

                                                                                break;

                                                                case HelloJourneyString.A_TAG_START:

                                                                                aJson = new JSONObject();

                                                                                tJson = aJson;

                                                                                break;

                                                                case HelloJourneyString.CD_TAG_END:

                                                                                cJson.append(HelloJourneyString.CD_TAG_START, cdJson);

                                                                                tJson = new JSONObject();

                                                                                break;

                                                                case HelloJourneyString.A_TAG_END:

                                                                                cJson.append(HelloJourneyString.A_TAG_START, aJson);

                                                                                tJson = new JSONObject();

                                                                                break;

                                                                case HelloJourneyString.C_TAG_END:

                                                                                pJson.append(HelloJourneyString.C_TAG_START, cJson);

                                                                                tJson = pJson;

                                                                                break;

                                                                }

                                                }

                                }

                                return pJson;

                }

               

                public Map<String, Object> assertValues(int index) throws JsonParseException, JsonMappingException, IOException {

                                Map<String,Object> jsonMap = null;

                                if(str==null) return null;

                                JsonObject jsonobject = expectedJsonArr.get(index).getAsJsonObject();

 

                                for (JSONObject jsonElement : parsedTagContents) {

 

                                                String pageName = jsonElement.getJSONArray(HelloJourneyString.PAGENAME).toString();

                                                eventName = jsonobject.getAsJsonObject(HelloJourneyString.TECHSPECVALUES).get(HelloJourneyString.EVENTNAME).toString();

                                                if(pageName.replaceAll(HelloJourneyString.LEFT_SQUARE_BRACKET, "").replaceAll(HelloJourneyString.RIGHT_SQUARE_BRACKET, "").equals(eventName))

                                                {

                                                                JSONArray cdArray = jsonElement.getJSONArray(HelloJourneyString.C_TAG_START).getJSONObject(0).getJSONArray(HelloJourneyString.CD_TAG_START);

                                                               

                                                                //jsonMap = new ObjectMapper().readValue(jsonElement.toString().replaceAll(HelloJourneyString.LEFT_SQUARE_BRACKET, "").replaceAll(HelloJourneyString.RIGHT_SQUARE_BRACKET, ""),HashMap.class);

                                                                System.out.println("Given Tag Content:"+new ObjectMapper().readValue(jsonElement.toString(),HashMap.class));

                                               

                                                                String tagSiteSection = cdArray.getJSONObject(0).getJSONArray(HelloJourneyString.SITESECTION).toString();

                                                                String tagSubSiteSection = cdArray.getJSONObject(0).getJSONArray(HelloJourneyString.SUBSITESECTION).toString();

                                                                String buildVersion = cdArray.getJSONObject(0).getJSONArray(HelloJourneyString.BUILDVERSION).toString();

                                                                String appType = cdArray.getJSONObject(0).getJSONArray(HelloJourneyString.APPTYPE).toString();

                                                                String visitorType = cdArray.getJSONObject(0).getJSONArray(HelloJourneyString.VISITOR_TYPE).toString();

                                                                String language = cdArray.getJSONObject(0).getJSONArray(HelloJourneyString.LANGUAGE_TXT).toString();

                                                                //Check Global variables),"Build version does not match");

                                                               

                                                                softAssert.assertTrue(buildVersion!=null,HelloJourneyString.BUILD_VERSION_ERROR_MSG);

                                                                softAssert.assertTrue(appType!=null,HelloJourneyString.APP_TYPE_ERROR_MSG);

                                                                softAssert.assertTrue(language!=null,HelloJourneyString.LANGUAGE_ERROR_MSG);

                                                                //Fetch sitesection value from json

                                                if(jsonobject.getAsJsonObject(HelloJourneyString.TECHSPECVALUES).get(HelloJourneyString.CD_TAG_START+HelloJourneyString.SITESECTION).toString()== null) return null;

                                                                jsonsiteSection = jsonobject.getAsJsonObject(HelloJourneyString.TECHSPECVALUES).get(HelloJourneyString.CD_TAG_START+HelloJourneyString.SITESECTION).toString();

                                                                //Fetch subSitesection value from json

                                                if(jsonobject.getAsJsonObject(HelloJourneyString.TECHSPECVALUES).get(HelloJourneyString.CD_TAG_START+HelloJourneyString.SUBSITESECTION).toString()== null) return null;

                                                                jsonsubSiteSection = jsonobject.getAsJsonObject(HelloJourneyString.TECHSPECVALUES).get(HelloJourneyString.CD_TAG_START+HelloJourneyString.SUBSITESECTION).toString();

                                                                String mid = jsonElement.get(HelloJourneyString.MID).toString().replaceAll(HelloJourneyString.REGEX, "").replaceAll(HelloJourneyString.LEFT_SQUARE_BRACKET, "").replaceAll(HelloJourneyString.RIGHT_SQUARE_BRACKET, "");

                                                               

                                                                if(mid!=null && !mid.matches(HelloJourneyString.NUMERIC_VALUES) || mid.length()!=38)

                                                                                softAssert.assertTrue(false, HelloJourneyString.MID_FORMAT_INCORRECT);

                                                                //TODO: Remove once AID issue is resolved

//		                                                            String aid = jsonElement.get(HelloJourneyString.AID).toString().replaceAll(HelloJourneyString.REGEX, "").replaceAll(HelloJourneyString.LEFT_SQUARE_BRACKET, "").replaceAll(HelloJourneyString.RIGHT_SQUARE_BRACKET, "");

//		                                                            if(aid!= null && !aid.matches(HelloJourneyString.ALPHA_NUMERIC_VALUES) || aid.length()!=33 || aid.charAt(16)!='-')

//		                                                                            softAssert.assertTrue(false, HelloJourneyString.AID_FORMAT_INCORRECT);

                                                                softAssert.assertEquals(tagSiteSection.replaceAll(HelloJourneyString.LEFT_SQUARE_BRACKET, "").replaceAll(HelloJourneyString.RIGHT_SQUARE_BRACKET, ""),jsonsiteSection,"sitesection is either null or it does not match with the expected value..");

                                                                softAssert.assertEquals(tagSubSiteSection.replaceAll(HelloJourneyString.LEFT_SQUARE_BRACKET, "").replaceAll(HelloJourneyString.RIGHT_SQUARE_BRACKET, ""),jsonsubSiteSection,"sitesection is either null or it does not match with the expected value..");                 

                                                                softAssert.assertAll();

 

                                                                if(jsonMap == null) jsonMap = new HashMap<String, Object>();

                                                               

                                                jsonMap.put(HelloJourneyString.TECHSPECVALUES,jsonobject.getAsJsonObject(HelloJourneyString.TECHSPECVALUES));

                                                                jsonMap.put(HelloJourneyString.EXPECTEDVALUES,

                                                                                                new HashMap<String, String>(){{

                                                                                                                put(HelloJourneyString.BUILDVERSION, buildVersion.replaceAll(HelloJourneyString.LEFT_SQUARE_BRACKET, "").replaceAll(HelloJourneyString.RIGHT_SQUARE_BRACKET, ""));

                                                                                                                put(HelloJourneyString.APPTYPE, appType.replaceAll(HelloJourneyString.LEFT_SQUARE_BRACKET, "").replaceAll(HelloJourneyString.RIGHT_SQUARE_BRACKET, ""));

                                                                                                                put(HelloJourneyString.VISITOR_TYPE, visitorType.replaceAll(HelloJourneyString.LEFT_SQUARE_BRACKET, "").replaceAll(HelloJourneyString.RIGHT_SQUARE_BRACKET, ""));

                                                                                                                put(HelloJourneyString.SITESECTION, tagSiteSection.replaceAll(HelloJourneyString.LEFT_SQUARE_BRACKET, "").replaceAll(HelloJourneyString.RIGHT_SQUARE_BRACKET, ""));

                                                                                                                put(HelloJourneyString.SUBSITESECTION, tagSubSiteSection.replaceAll(HelloJourneyString.LEFT_SQUARE_BRACKET, "").replaceAll(HelloJourneyString.RIGHT_SQUARE_BRACKET, ""));

                                                                                                                put(HelloJourneyString.LANGUAGE_TXT, language.replaceAll(HelloJourneyString.LEFT_SQUARE_BRACKET, "").replaceAll(HelloJourneyString.RIGHT_SQUARE_BRACKET, ""));

                                                                                                                put(HelloJourneyString.MID, mid);

                                                                                                                put(HelloJourneyString.PAGENAME, pageName.replaceAll(HelloJourneyString.LEFT_SQUARE_BRACKET, "").replaceAll(HelloJourneyString.RIGHT_SQUARE_BRACKET, ""));

                                                                                                }});

                                                                jsonMap.put(HelloJourneyString.COMPLETEREQ, jsonElement);

                                                                break;

                                                }

                                }

                                return jsonMap;

                }

 

                public boolean validateErrorMessage(int index) throws FileNotFoundException

                {

 

                                JsonObject jsonobject = expectedJsonArr.get(index).getAsJsonObject();

                                String errorMessage = null,jsonErrorMessage = null;

                                boolean flag = false;

 

                                for (JSONObject jsonElement : parsedTagContents) {

                                                String pageName = jsonElement.getJSONArray(HelloJourneyString.PAGENAME).toString();

                                                eventName = jsonobject.getAsJsonObject(HelloJourneyString.TECHSPECVALUES).get(HelloJourneyString.EVENTNAME).toString();

                                                if(pageName.replaceAll(HelloJourneyString.LEFT_SQUARE_BRACKET, "").replaceAll(HelloJourneyString.RIGHT_SQUARE_BRACKET, "").equals(eventName))

                                                {

                                                                JSONArray cdArray = jsonElement.getJSONArray(HelloJourneyString.C_TAG_START).getJSONObject(0).getJSONArray(HelloJourneyString.CD_TAG_START);               

                                                                //tag error message

                                                                errorMessage = cdArray.getJSONObject(0).getJSONArray(HelloJourneyString.ERRORMESSAGE).toString();             

                                                                //json error message

                                                                jsonErrorMessage = jsonobject.getAsJsonObject(HelloJourneyString.TECHSPECVALUES).get(HelloJourneyString.CD_TAG_START+HelloJourneyString.ERRORMESSAGE).toString();

                                                                System.out.println("Tag Error Message:"+errorMessage+"\t"+"Json Error Message:"+jsonErrorMessage);

                                                                softAssert.assertEquals(errorMessage.replaceAll(HelloJourneyString.LEFT_SQUARE_BRACKET, "").replaceAll(HelloJourneyString.RIGHT_SQUARE_BRACKET, ""), jsonErrorMessage,HelloJourneyString.ERROR_MSG_DOES_NOT_MATCH);

                                                                flag = true;

                                                                break;

                                                }                                             

                                }

                                return flag;         

                }

 

                public void handleAlert()

                {

                                System.out.println("Inside Alert handle method");

                                if(actions.isElementPresent(loginpage.showcase_skipbutton))

                                                actions.click(loginpage.showcase_skipbutton);

                                if(actions.isElementPresent(alert.Allow))

                                                actions.click(alert.Allow);            

                                if(actions.isElementPresent(alert.AlwaysAllow))

                                                actions.click(alert.AlwaysAllow);

                                if(actions.isElementPresent(alert.DontAllow))

                                                actions.click(alert.DontAllow);

                                if(actions.isElementPresent(alert.ContactOk))

                                                actions.click(alert.ContactOk);

                                if(actions.isElementPresent(alert.Cancel))

                                                actions.click(alert.Cancel);

                                if(actions.isElementPresent(alert.Ignore))

                                                actions.click(alert.Ignore);

                                if(actions.isElementPresent(alert.foreseeCloseX))

                                                actions.click(alert.foreseeCloseX);

                                if(actions.isElementPresent(alert.foreseeCloseX))

                                                actions.click(alert.foreseeCloseX);

                                if(actions.isElementPresent(alert.helpNoButton))

                                                actions.click(alert.helpNoButton);

                                System.out.println("********End of Alert Check********");

                                               

                }

 

                @Test(testName = "TC-01", description = "login remember me off", groups = HelloJourneyString.LOGIN)

                public void writeToExcel(HelloJourneySiteCatTest helloJourneySiteCatTest) throws JsonParseException, JsonMappingException, IOException

                {

                                System.out.println("Inside testLoginRememberMeOff");

                                Map<String, Object> assertValues = assertValues(0);

                                if(assertValues == null) Assert.assertTrue(false,HelloJourneyString.NO_CONTENT_FOUND);

                                helloJourneySiteCatTest.testresultdata.put("2",

                                                                new Object[] { 1d, "TestLoginRememberMeOff",

                                                                                                assertValues.get(HelloJourneyString.TECHSPECVALUES).toString(),

                                                                                                assertValues.get(HelloJourneyString.EXPECTEDVALUES).toString(),

                                                                                                assertValues.get(HelloJourneyString.COMPLETEREQ).toString(), "Pass", new Date(), "", "" });

                                //actions.getScreenshot("LoginRememberMeOff");

                                System.out.println("login remember me off section has been validated successfully..");

                                Reporter.log("login remember me off section has been validated successfully..");

		                }

		}

	}

}
