package loginData;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LoginValidData {
    public String email,password;

    public void loginData() throws IOException, java.text.ParseException, org.json.simple.parser.ParseException {
        String srcFile = System.getProperty("user.dir")+"/src/test/java/loginData/loginValidData.json";
        File file = new File(srcFile);

        JSONParser parser = new JSONParser();
        JSONArray jsonArray = (JSONArray)  parser.parse(new FileReader(file));

        for (Object object : jsonArray){
            JSONObject person = (JSONObject) object;


            email = (String) person.get("email");
            password = (String) person.get("password");
        }
    }
}
