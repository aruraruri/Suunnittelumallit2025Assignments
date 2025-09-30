package Facade;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiAccessObj {

    public static String getJsonFromApi(String apiUrl) throws Exception {
        URL url = new URL(apiUrl);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            return content.toString();
        } finally {
            con.disconnect();
        }
    };

    public static String extractAttributeFromJson(String json, String jsonKey) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse(json);

        if (!jsonKey.contains(".")) {
            return (String) jsonObject.get(jsonKey);
        }

        String[] keys = jsonKey.split("\\.");
        Object current = jsonObject;

        for (int i = 0; i < keys.length; i++) {
            if (current instanceof JSONObject) {
                current = ((JSONObject) current).get(keys[i]);
            } else {
                throw new ParseException(ParseException.ERROR_UNEXPECTED_TOKEN, "Expected JSONObject at key '" + keys[i] + "'");
            }

            if (current == null && i < keys.length - 1) {
                    throw new ParseException(ParseException.ERROR_UNEXPECTED_TOKEN, "Key '" + keys[i] + "' not found in JSON");
            }
        }

        return current != null ? current.toString() : null;
    }
}
