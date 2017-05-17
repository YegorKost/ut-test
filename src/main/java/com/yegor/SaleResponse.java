package com.yegor;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.MalformedInputException;
import java.util.*;

/**
 * Created by YegorKost on 12.05.2017.
 */
public class SaleResponse {

    public Map<String, String> getSaleResponse(RequestParameters requestParameters) {
        Map<String, String> result = null;
        try {
            URL url = new URL(requestParameters.getUrl());
            HttpsURLConnection httpsCon = (HttpsURLConnection) url.openConnection();
            httpsCon.setDoInput(true);
            httpsCon.setDoOutput(true);
            httpsCon.setConnectTimeout(5 * 1000);
            httpsCon.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            httpsCon.setRequestMethod("GET");
            Map<String, String> parameters = requestParameters.getParameters();
            if (parameters.containsKey("accountNumber")) {
                sendDataWithAccountNumber(requestParameters, httpsCon);
            } else if (parameters.containsKey("accountData")){
                sendDataWithTrackData(requestParameters, httpsCon);
            }
            String response = getResponse(httpsCon);
            result = getResponseParameters(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    private void sendDataWithTrackData(RequestParameters parameters, HttpsURLConnection httpsCon) {
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(httpsCon.getOutputStream()))){
            String value = parameters.getParameters().get("accountData");
            value = URLEncoder.encode(value, "utf-8");
            parameters.getParameters().put("accountData", value);
            writer.write(getStringParameters(parameters.getParameters()));
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendDataWithAccountNumber(RequestParameters parameters, HttpsURLConnection httpsCon) {
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(httpsCon.getOutputStream()))){
            writer.write(getStringParameters(parameters.getParameters()));
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getResponse(HttpsURLConnection httpCon) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(httpCon.getInputStream()))){
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
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

    private String getStringParameters(Map<String, String> parameters) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry: parameters.entrySet()) {
            sb.append("&");
            sb.append(entry.getKey());
            sb.append("=");
            sb.append(entry.getValue());
        }
        return sb.toString();
    }
}
