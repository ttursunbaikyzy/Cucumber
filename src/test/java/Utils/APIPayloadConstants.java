package Utils;

import org.json.JSONObject;

public class APIPayloadConstants {
    // we will pass the body in multiple formats, for this we have created this class
    public static String createEmployeePayload(){
        String createEmployeePayload = "{\n" +
                "    \"emp_firstname\": \"nickou\",\n" +
                "    \"emp_lastname\": \"boujevic\",\n" +
                "    \"emp_middle_name\": \"f\",\n" +
                "    \"emp_gender\": \"M\",\n" +
                "    \"emp_birthday\": \"2017-05-20\",\n" +
                "    \"emp_status\": \"Confirmed\",\n" +
                "    \"emp_job_title\": \"Napper\"\n" +
                "}";

        return createEmployeePayload;
    }

    public static String createEmployeePayLoadJson(){
        JSONObject obj = new JSONObject();
        obj.put("emp_firstname","nickou");
        obj.put("emp_lastname","boujevic");
        obj.put("emp_middle_name","f");
        obj.put("emp_gender","M");
        obj.put("emp_birthday","2017-05-20");
        obj.put("emp_status","Confirmed");
        obj.put("emp_job_title","Napper");
        return obj.toString();
    }

}
