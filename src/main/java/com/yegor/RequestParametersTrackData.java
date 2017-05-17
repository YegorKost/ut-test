package com.yegor;

import java.util.Map;

/**
 * Created by YegorKost on 12.05.2017.
 */
public class RequestParametersTrackData extends RequestParameters {

    @Override
    public void init() {
        Map<String, String> parameters = getParameters();
        parameters.put("requestType", "sale");
        parameters.put("userName", "test_api_user");
        parameters.put("password", "C8v20gAdHjig3LMRWGhm5PK1G00v08V1");
        parameters.put("terminalId", "001");
        parameters.put("accountId", "2001");
        parameters.put("transactionIndustryType", "RE");
        parameters.put("amount", "5000");
        parameters.put("accountType", "R");
        parameters.put("accountData", "%B4111111111111111^SMITH/JOHN^22041011000 1111A123456789012?");
        parameters.put("customerAccountCode", "0000000001");
        parameters.put("transactionCode", "0000000001");
    }

}
