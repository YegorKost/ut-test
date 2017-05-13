package com.yegor;

import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by YegorKost on 12.05.2017.
 */
public class SaleResponseTest {
    private RequestParameters requestParameters;
    private SaleResponse saleResponse = new SaleResponse();

    @Before
    public void setUpProperties() {
      requestParameters = new RequestParameters();
    }

    @Test
    public void getSaleResponseTest1() throws Exception {
        Map<String, String> keys_values = saleResponse.getSaleResponse(requestParameters.getParameters(), "https://sandbox-secure.unitedthinkers.com/gates/xurl?");
        assertTrue(keys_values.get("responseCode").equals("A01"));
    }

    @Test
    public void getSaleResponseTest2() throws Exception {
        requestParameters.setAmount(500);
        Map<String, String> keys_values = saleResponse.getSaleResponse(requestParameters.getParameters(), "https://sandbox-secure.unitedthinkers.com/gates/xurl?");
        assertTrue(keys_values.get("responseCode").equals("A01"));
    }

    @Test
    public void getSaleResponseTest3() throws Exception {
        requestParameters.setAmount(6999);
        Map<String, String> keys_values = saleResponse.getSaleResponse(requestParameters.getParameters(), "https://sandbox-secure.unitedthinkers.com/gates/xurl?");
        assertTrue(keys_values.get("responseCode").equals("A01"));
    }

    @Test
    public void getSaleResponseTest4() throws Exception {
        requestParameters.setAmount(12000);
        Map<String, String> keys_values = saleResponse.getSaleResponse(requestParameters.getParameters(), "https://sandbox-secure.unitedthinkers.com/gates/xurl?");
        assertTrue(keys_values.get("responseCode").equals("D03"));
    }

    @Test
    public void getSaleResponseTest5() throws Exception {
        requestParameters.setAmount(12999);
        Map<String, String> keys_values = saleResponse.getSaleResponse(requestParameters.getParameters(), "https://sandbox-secure.unitedthinkers.com/gates/xurl?");
        assertTrue(keys_values.get("responseCode").equals("D03"));
    }

    @Test
    public void getSaleResponseTest6() throws Exception {
        requestParameters.setZipCode("11111");
        Map<String, String> keys_values = saleResponse.getSaleResponse(requestParameters.getParameters(), "https://sandbox-secure.unitedthinkers.com/gates/xurl?");
        assertTrue(keys_values.get("avsResponseCode").equals("00"));
    }

    @Test
    public void getSaleResponseTest7() throws Exception {
        requestParameters.setZipCode("22222");
        Map<String, String> keys_values = saleResponse.getSaleResponse(requestParameters.getParameters(), "https://sandbox-secure.unitedthinkers.com/gates/xurl?");
        assertTrue(keys_values.get("avsResponseCode").equals("46"));
    }

    @Test
    public void getSaleResponseTest8() throws Exception {
        requestParameters.setCsc("111");
        Map<String, String> keys_values = saleResponse.getSaleResponse(requestParameters.getParameters(), "https://sandbox-secure.unitedthinkers.com/gates/xurl?");
        assertTrue(keys_values.get("cscResponseCode").equals("M"));
    }

    @Test
    public void getSaleResponseTest9() throws Exception {
        requestParameters.setCsc("222");
        Map<String, String> keys_values = saleResponse.getSaleResponse(requestParameters.getParameters(), "https://sandbox-secure.unitedthinkers.com/gates/xurl?");
        assertTrue(keys_values.get("cscResponseCode").equals("N"));
    }

}