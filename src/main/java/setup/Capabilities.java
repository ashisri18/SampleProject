package setup;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileReader;
import java.util.HashMap;

public class Capabilities {

    private static JSONArray parseJSON(String jsonFilePath) throws Exception {
        FileReader reader = new FileReader(jsonFilePath);
        JSONParser jsonParser = new JSONParser();
        return (JSONArray) jsonParser.parse(reader);
    }

    private static JSONObject getCapability(String deviceType, String jsonFlePath) throws Exception {
        JSONArray capabilitiesArray = parseJSON(jsonFlePath);
        for (Object jsonObj : capabilitiesArray) {
            JSONObject capability = (JSONObject) jsonObj;
            if (capability.get("deviceType").toString().equalsIgnoreCase(deviceType)) {
                return (JSONObject) capability.get("caps");
            }
        }
        return null;
    }

    private static HashMap<String, Object> convertCapsToHashMap(String deviceType, String jsonFlePath) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(getCapability(deviceType, jsonFlePath).toString(), HashMap.class);
    }

    public static DesiredCapabilities getDesiredCapabilities(String deviceType, String jsonFlePath){
        try {
            HashMap<String, Object>  caps = convertCapsToHashMap(deviceType, jsonFlePath);
            return new DesiredCapabilities(caps);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}