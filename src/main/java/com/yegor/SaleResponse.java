package com.yegor;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.URL;
import java.util.*;

/**
 * Created by YegorKost on 12.05.2017.
 */
public class SaleResponse {

    public Map<String, String> getSaleResponse(String requestParameters, String urlAddress) {
        Map<String, String> result = null;
        try {
            URL url = new URL(urlAddress);
            HttpsURLConnection httpsCon = (HttpsURLConnection) url.openConnection();
            httpsCon.setDoInput(true);
            httpsCon.setDoOutput(true);
            httpsCon.setConnectTimeout(5 * 1000);
            httpsCon.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            httpsCon.setRequestMethod("GET");

            try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(httpsCon.getOutputStream()))){
                writer.write(requestParameters);
                writer.flush();
               }

            String response = getResponse(httpsCon);
            result = getResponseParameters(response);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    private String getResponse(HttpsURLConnection httpCon) throws IOException {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(httpCon.getInputStream()))){
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        }
        return sb.toString();
    }

    private Map<String, String> getResponseParameters(String response) {
        Map<String, String> result = new HashMap<>();
        List<String> keys_values = new ArrayList<>();
        Collections.addAll(keys_values, response.split("&"));
        for (String key_value: keys_values) {
            String[] couple = key_value.split("=");
            if(couple.length == 2) {
                result.put(couple[0], couple[1]);
            } else {
                result.put(couple[0], null);
            }
        }
        return result;
    }
}
