package com.TestCase;

import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;

public class TestCaseStep {

    long Step_no;
    String Step_Title;
    String Timer_Flg;
    String Timer_Duration;
    String Step_Status;

    public TestCaseStep(){


    }




    public long getStep_no() {
        return Step_no;
    }

    public void setStep_no(Long step_no) {
        Step_no = step_no;
    }

    public String getStep_Title() {
        return Step_Title;
    }

    public void setStep_Title(String step_Title) {
        Step_Title = step_Title;
    }

    public String getTimer_Flg() {
        return Timer_Flg;
    }

    public void setTimer_Flg(String timer_Flg) {
        Timer_Flg = timer_Flg;
    }

    public String getTimer_Duration() {
        return Timer_Duration;
    }

    public void setTimer_Duration(String timer_Duration) {
        Timer_Duration = timer_Duration;
    }

    public String getStep_Status() {
        return Step_Status;
    }

    public void setStep_Status(String step_Status) {
        Step_Status = step_Status;
    }


}
