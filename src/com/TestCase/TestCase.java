package com.TestCase;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;


public class TestCase {
    //HashMap<Long, ArrayList<TestCase>> testCaseHashMap = new HashMap<Long, ArrayList<TestCase>>();


    private Integer TC_ID;
    private String TC_NM;
    private String TC_STATUS;
    private String TC_STTIMESTAMP;
    private String TC_ENDTIMESTAMP;
    private String TC_DETAILFILENM;

    public TestCase(Integer TCID) {
        this.TC_ID = TCID;
    }

    public TestCase() {

    }

    public Integer getTC_ID() {
        return TC_ID;
    }

    public void setTC_ID(Integer TC_ID) {
        this.TC_ID = TC_ID;
    }

    public String getTC_NM() {
        return TC_NM;
    }

    public void setTC_NM(String TC_NM) {
        this.TC_NM = TC_NM;
    }

    public String getTC_STATUS() {
        return TC_STATUS;
    }

    public void setTC_STATUS(String TC_STATUS) {
        this.TC_STATUS = TC_STATUS;
    }

    public String getTC_STTIMESTAMP() {
        return TC_STTIMESTAMP;
    }

    public void setTC_STTIMESTAMP(String TC_STTIMESTAMP) {
        this.TC_STTIMESTAMP = TC_STTIMESTAMP;
    }

    public String getTC_ENDTIMESTAMP() {
        return TC_ENDTIMESTAMP;
    }

    public void setTC_ENDTIMESTAMP(String TC_ENDTIMESTAMP) {
        this.TC_ENDTIMESTAMP = TC_ENDTIMESTAMP;
    }

    public String getTC_DETAILFILENM() {
        return TC_DETAILFILENM;
    }

    public void setTC_DETAILFILENM(String TC_DETAILFILENM) {
        this.TC_DETAILFILENM = TC_DETAILFILENM;
    }


    public void showTestcase() {
        try {
            JSONParser parser = new JSONParser();
            Object object = parser.parse(new FileReader("src\\json-file\\TestCase.json"));
            JSONObject jsonObject = (JSONObject) object;
            System.out.println("Testcases \n");
            JSONArray jsonArray = (JSONArray) jsonObject.get("Testcases");

            TestCase tcobj = null;
            for (Object o : jsonArray) {
                JSONObject obj = (JSONObject) o;
                tcobj = new TestCase();
                tcobj.setTC_ID(Integer.parseInt((String) obj.get("TC_ID")));
                //System.out.println("TC_ID: " + obj.get("TC_ID"));
                tcobj.setTC_NM((String) obj.get("TC_NAME"));
                // System.out.println("TC_NAME: " + obj.get("TC_NAME"));
                tcobj.setTC_STATUS((String) obj.get("TC_STATUS"));
                // System.out.println("TC_STATUS: " + obj.get("TC_STATUS"));
                tcobj.setTC_STTIMESTAMP((String) obj.get("TC_STTIMESTAMP"));
                // System.out.println("TC_STTIMESTAMP: " + obj.get("TC_STTIMESTAMP"));
                tcobj.setTC_ENDTIMESTAMP((String) obj.get("TC_ENDTIMESTAMP"));
                // System.out.println("ENDTIMESTAMP: " + obj.get("TC_ENDTIMESTAMP"));
                tcobj.setTC_DETAILFILENM((String) obj.get("TC_DETAILFILENM"));
                // System.out.println("DETAILFILENM: " + obj.get("TC_DETAILFILENM"));
                //TestCase tcobject=new TestCase();
                //this.testCases.add(tcobj);

                System.out.println("\n");
            }
        } catch (Exception exp) {

        }
        //System.out.println("arraylist size is: "+testCases.size());
        // for(TestCase TCID:testCases) {
        //testCaseHashMap.put(tcobj.getTC_ID(),testCases);

        //   }

    }
}






