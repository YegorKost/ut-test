package com.yegor;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by YegorKost on 16.05.2017.
 */
public class RequestParameters {
    private Map<String, String> parameters = new HashMap<>();
    private String url;

    public void setAmount(int amount) {
        this.parameters.put("amount", String.valueOf(amount));
    }

    public void setZipCode(String zipCode) {
        this.parameters.put("zipCode", zipCode);
    }

    public void setCsc(String csc) {
        this.parameters.put("csc", csc);
    }

    public Map<String, String> getParameters() {
        return parameters;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void init() {}

}
