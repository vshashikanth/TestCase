package com.TestCase;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class TestCaseMain {
    private static Long TCID;
    private HashMap<Integer, TestCase> testCaseHashMap;
    private TestCaseDetails tcDetails ;

    public TestCaseMain() {

        testCaseHashMap = new HashMap<Integer, TestCase>();
        try{

            tcDetails = new TestCaseDetails("src\\json-file\\TestCaseDetail.json");
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println("Exception Occured");
        }

    }

    public void buildTestCaseMap(String testCaseDataFilePath){

        //This is where we read JSON Data file and build a HashMap containing TestCase Objects
        try {
            JSONParser parser = new JSONParser();

            Object object = parser.parse(new FileReader(testCaseDataFilePath));
            JSONObject jsonObject = (JSONObject) object;
            //System.out.println("Testcases \n");
            JSONArray jsonArray = (JSONArray) jsonObject.get("Testcases");

            TestCase tcobj = null;
            for (Object obj : jsonArray) {
                JSONObject jsonObj = (JSONObject) obj;
                tcobj = new TestCase();
                tcobj.setTC_ID(Integer.parseInt((String) jsonObj.get("TC_ID")));
                // System.out.println("TC_ID: " + obj.get("TC_ID"));
                tcobj.setTC_NM((String) jsonObj.get("TC_NAME"));
                //System.out.println("TC_NAME: " + obj.get("TC_NAME"));
                tcobj.setTC_STATUS((String) jsonObj.get("TC_STATUS"));
                //System.out.println("TC_STATUS: " + obj.get("TC_STATUS"));
                tcobj.setTC_STTIMESTAMP((String) jsonObj.get("TC_STTIMESTAMP"));
                //System.out.println("TC_STTIMESTAMP: " + obj.get("TC_STTIMESTAMP"));
                tcobj.setTC_ENDTIMESTAMP((String) jsonObj.get("TC_ENDTIMESTAMP"));
                //System.out.println("ENDTIMESTAMP: " + obj.get("TC_ENDTIMESTAMP"));
                tcobj.setTC_DETAILFILENM((String) jsonObj.get("TC_DETAILFILENM"));
                //System.out.println("DETAILFILENM: " + obj.get("TC_DETAILFILENM"));

                testCaseHashMap.put(Integer.parseInt((String)jsonObj.get("TC_ID")),tcobj);


                System.out.println("\n");
            }
        }catch(Exception e){ e.printStackTrace();
            System.out.println("Exception occured.");
        }
        //System.out.println("hashmap size is: "+testCaseHashMap.size());
        }

    public void showTestCases(){

        //Purpose of this method is to print all Test Cases in testCaseHashMap
        //System.out.println(testCaseHashMap.keySet());
        for(Object objname:testCaseHashMap.keySet()) {
            //System.out.println(objname);
            //System.out.println(testCaseHashMap.get(objname));
            TestCase tc=testCaseHashMap.get(objname);
            System.out.println("TC_ID: "+tc.getTC_ID());
            System.out.println("TC_NAME:"+tc.getTC_NM());
            System.out.println("TC_STATUS"+tc.getTC_STATUS());
            System.out.println("TC_STTIMESTAMP"+tc.getTC_STTIMESTAMP());
            System.out.println("TC_ENDTIMESTAMP"+tc.getTC_ENDTIMESTAMP());
            System.out.println("TC_DETAILFILENM"+tc.getTC_DETAILFILENM());
            System.out.println("\n\n");

        }

    }

    public void showTestCase(Integer tcid){
        // Access specific test case from filled HashMap and call showTestCase method of that Object

        TestCase testCase = testCaseHashMap.get(tcid);
        //testCase.showTestcase();
        System.out.println("TC_ID: "+testCase.getTC_ID());
        System.out.println("TC_NAME: "+testCase.getTC_NM());
        System.out.println("TC_STATUS: "+testCase.getTC_STATUS());
        System.out.println("TC_STTIMESTAMP: "+testCase.getTC_STTIMESTAMP());
        System.out.println("TC_ENDTIMESTAMP: "+testCase.getTC_ENDTIMESTAMP());
    }

    public void showTestCaseDetails(){
        // Access specific test case from filled HashMap and call showTestCase method of that Object

        HashMap<Integer,TestCaseStep> stepsMap=tcDetails.showTestCaseDetails();

        for(Object objname:testCaseHashMap.keySet()) {
            //System.out.println(objname);
            //System.out.println(testCaseHashMap.get(objname));
            TestCase tc = testCaseHashMap.get(objname);
            System.out.println("TC_ID: "+tc.getTC_ID());
            System.out.println("TC_NAME: "+tc.getTC_NM());
            System.out.println("\n TestCaseSteps: ");
            for(Object obj:stepsMap.keySet()) {
                TestCaseStep tcs=stepsMap.get(obj);

                System.out.println("STEP_NO: "+tcs.getStep_no());
                System.out.println("STEP_TITLE: "+tcs.getStep_Title());
                System.out.println("TIMER_FLG: "+tcs.getTimer_Flg());
                System.out.println("TIMER_DURATION: "+tcs.getTimer_Duration());
                System.out.println("STEP_STATUS: "+tcs.getStep_Status());

                System.out.println("\n");
            }
            System.out.println("end of TestCaseSteps: ");
            System.out.println("TC_STATUS: "+tc.getTC_STATUS());
            System.out.println("TC_STTIMESTAMP: "+tc.getTC_STTIMESTAMP());
            System.out.println("TC_ENDTIMESTAMP: "+tc.getTC_ENDTIMESTAMP());
            System.out.println("TC_DETAILFILENM: "+tc.getTC_DETAILFILENM());
            System.out.println("\n ------------------");
        }
        //System.out.println(stepsMap.size());

    }

    public static void main(String[] args) throws IOException, ParseException {
        TestCaseMain testCaseMain = new TestCaseMain();

        testCaseMain.buildTestCaseMap("src\\json-file\\testCase.json");
        //testCaseMain.showTestCases();
        System.out.println("After showTestcases() and output of method showTestCaseDetails() ");
        //testCaseMain.showTestCaseDetails();
        testCaseMain.showTestCase(2);


    }

}






