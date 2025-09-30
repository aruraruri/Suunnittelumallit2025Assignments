package Facade;

import java.io.IOException;

// the facade
public class ApiReader {
    public static String getAttributeValueFromJson(String urlString, String attributeName) throws Exception {
        String json = ApiAccessObj.getJsonFromApi(urlString);
        return ApiAccessObj.extractAttributeFromJson(json, attributeName);
    }
}
