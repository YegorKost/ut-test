package com.yegor;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by YegorKost on 12.05.2017.
 */
public class RequestParameters {

    private Map<String, String> parameters = new HashMap<>();

    public RequestParameters() {
        parameters.put("requestType", "sale");
        parameters.put("userName", "test_api_user");
        parameters.put("password", "C8v20gAdHjig3LMRWGhm5PK1G00v08V1");
        parameters.put("merchantAccountCode", "2001");
        parameters.put("amount", "5000");
        parameters.put("accountType", "R");
        parameters.put("transactionIndustryType", "RE");
        parameters.put("holderType", "P");
        parameters.put("holderName", "John Smith");
        parameters.put("accountNumber", "4111111111111111");
        parameters.put("accountAccessory", "0422");
        parameters.put("street", "12 Main St");
        parameters.put("city", "Denver");
        parameters.put("state", "CO");
        parameters.put("zipCode", "30301");
        parameters.put("customerAccountCode", "0000000001");
        parameters.put("transactionCode", "0000000001");
    }

    public RequestParameters setAmount(int amount) {
        this.parameters.put("amount", String.valueOf(amount));
        return this;
    }

    public RequestParameters setAccountNumber(String accountNumber) {
        this.parameters.put("accountNumber", accountNumber);
        return this;
    }

    public RequestParameters setAccountData (String accountData ) {
        this.parameters.put("accountData ", accountData);
        return this;
    }

    public RequestParameters setZipCode(String zipCode) {
        this.parameters.put("zipCode", zipCode);
        return this;
    }

    public RequestParameters setCsc(String csc) {
        this.parameters.put("csc", csc);
        return this;
    }

    public String getParameters() {
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
