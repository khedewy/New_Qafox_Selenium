package registerDataSuite;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class EmptyTelephoneData {
    public String firstName, lastName,email,telephone,password;

    public void registerData() throws IOException, java.text.ParseException, org.json.simple.parser.ParseException {
        String srcFile = System.getProperty("user.dir")+"/src/test/java/registerDataSuite/emptyTelephoneData.json";
        File file = new File(srcFile);

        JSONParser parser = new JSONParser();
        JSONArray jsonArray = (JSONArray)  parser.parse(new FileReader(file));

        for (Object object : jsonArray){
            JSONObject person = (JSONObject) object;

            firstName = (String) person.get("firstName");
            lastName = (String) person.get("lastName");
            email = (String) person.get("email");
            telephone = (String) person.get("telephone");
            password = (String) person.get("password");
        }
    }
}
