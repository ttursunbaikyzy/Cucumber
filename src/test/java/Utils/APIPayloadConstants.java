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

    public static String createEmployeePayLoadDynamic(String emp_firstname, String emp_lastname, String emp_middle_name, String emp_gender, String emp_birthday, String emp_status, String emp_job_title){
        JSONObject obj = new JSONObject();
        obj.put("emp_firstname",emp_firstname);
        obj.put("emp_lastname",emp_lastname);
        obj.put("emp_middle_name",emp_middle_name);
        obj.put("emp_gender",emp_gender);
        obj.put("emp_birthday",emp_birthday);
        obj.put("emp_status",emp_status);
        obj.put("emp_job_title",emp_job_title);
        return obj.toString();
    }

    public static String updateEmployeePayLoadJson(){
        JSONObject obj = new JSONObject();
        obj.put("employee_id","57568A");
        obj.put("emp_firstname","Lily");
        obj.put("emp_lastname","Pretty");
        obj.put("emp_middle_name","N");
        obj.put("emp_gender","F");
        obj.put("emp_birthday","2015-01-20");
        obj.put("emp_status","non employed");
        obj.put("emp_job_title","CEO");
        return obj.toString();
    }


}
