package com.TestCase;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;


//import static jdk.nashorn.internal.objects.NativeSymbol.iterator;


public class TestCaseDetails {

    private int STEPNO;
    String filename="src\\json-file\\TestCaseDetail.json";
    private HashMap<Integer, TestCaseStep> tcd=new HashMap<>();



    private Long TC_ID;
    private String TC_STATUS;
    private String SITIMESTAMP;
    private String ENDTIMESTAMP;
    private String DETAILFILENM;

    public Long getTC_ID() {
        return TC_ID;
    }

    public void setTC_ID(Long TC_ID) {
        this.TC_ID = TC_ID;
    }
    public String getDETAILFILENM() {
        return DETAILFILENM;
    }

    public void setDETAILFILENM(String DETAILFILENM) {
        this.DETAILFILENM = DETAILFILENM;
    }

    public String getTC_STATUS() {
        return TC_STATUS;
    }

    public void setTC_STATUS(String TC_STATUS) {
        this.TC_STATUS = TC_STATUS;
    }

    public String getSITIMESTAMP() {
        return SITIMESTAMP;
    }

    public void setSITIMESTAMP(String SITIMESTAMP) {
        this.SITIMESTAMP = SITIMESTAMP;
    }

    public String getENDTIMESTAMP() {
        return ENDTIMESTAMP;
    }

    public void setENDTIMESTAMP(String ENDTIMESTAMP) {
        this.ENDTIMESTAMP = ENDTIMESTAMP;
    }

    public TestCaseDetails(String filename) throws IOException, ParseException {

     //filename="src\\json-file\\TestCaseDetail.json";
     getDetails(filename);
    // getDetails();
    }


    public void getDetails(String filename) throws IOException, ParseException {
        JSONParser parser = new JSONParser();


        Object object = parser.parse(new FileReader(filename));
        JSONObject jsonObject = (JSONObject) object;
        JSONObject details = (JSONObject) jsonObject.get("TestCaseDetails");
        //System.out.println("TestCaseDetails");
        //System.out.println("---------------");

            TestCase tc = new TestCase();

            tc.setTC_ID(Integer.parseInt((String)details.get("TCID")));
            tc.setTC_NM((String) details.get("TCNM"));
            //System.out.println("TCID:" + details.get("TCID"));
            //System.out.println("TCNAME:" + details.get("TCNM"));

            JSONArray array = (JSONArray) details.get("STEPS");
            System.out.println("\n");
            //System.out.println("testcase steps");
            //System.out.println("-------------");

            int STEPNO = 1;
            for (Object o : array)
            {

                JSONObject object1 = (JSONObject) o;
                TestCaseStep tcs = new TestCaseStep();

                tcs.setStep_no( (Long)object1.get("STEPNO"));
              //  System.out.println("STEPNO:" + object1.get("STEPNO"));
                tcs.setStep_Title((String) object1.get("STEPTITLE"));
                //System.out.println("STEPTITLE:" + object1.get("STEPTITLE"));
                tcs.setTimer_Flg((String) object1.get("TIMER_FLG"));
                //System.out.println("TIMER_FLAG:" + object1.get("TIMER_FLAG"));
                tcs.setTimer_Duration((String) object1.get("TIMERDURATION"));
                //System.out.println("TIMEDURATION:" + object1.get("TIMEDURATION"));
                tcs.setStep_Status((String) object1.get("STEP_STATUS"));
                //System.out.println("STEP_STATUS:" + object1.get("STEP_STATUS"));
                System.out.println("\n");

                this.tcd.put((int) STEPNO, tcs);
                STEPNO++;

            }
        tc.setTC_STATUS((String) details.get("TC_STATUS"));
            //System.out.println("TCSTATUS:" + details.get("TC_STATUS"));
        tc.setTC_STTIMESTAMP((String) details.get("TC_STTIMESTAMP"));
            //System.out.println("TCSTTIMESTAMP:" + details.get("TC_STTIMESTAMP"));
        tc.setTC_ENDTIMESTAMP((String) details.get("TC_ENDTIMESTAMP"));
            //System.out.println("TCENDTIMESTAMP:" + details.get("TC_ENDTIMESTAMP"));
        tc.setTC_DETAILFILENM((String) details.get("TC_DETAILFILENM"));
            //System.out.println("TCDETAILFILENM:" + details.get("TC_DETAILFILENM"));


    }

    public HashMap<Integer, TestCaseStep> showTestCaseDetails(){

        //Print all attributes including HashMap containing steps.
        System.out.println("");
        return tcd;

    }
}
