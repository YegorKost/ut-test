package com.yegor;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by YegorKost on 12.05.2017.
 */
public class SaleResponseAccountNumberTest {
    private RequestParameters requestParametersAccountNumber = new RequestParametersAccountNumber();
    private SaleResponse saleResponse = new SaleResponse();

    @Before
    public void setUpProperties() {
        requestParametersAccountNumber.init();
        requestParametersAccountNumber.setUrl("https://sandbox-secure.unitedthinkers.com/gates/xurl?");
    }

    @Test
    public void getSaleResponseAccountNumberTest1() throws Exception {
        assertTrue(saleResponse
                .getSaleResponse(requestParametersAccountNumber)
                .get("responseCode")
                .equals("A01"));
    }

    @Test
    public void getSaleResponseAccountNumberTest2() throws Exception {
        requestParametersAccountNumber.setAmount(500);
        assertTrue(saleResponse
                .getSaleResponse(requestParametersAccountNumber)
                .get("responseCode")
                .equals("A01"));
    }

    @Test
    public void getSaleResponseAccountNumberTest3() throws Exception {
        requestParametersAccountNumber.setAmount(6999);
        assertTrue(saleResponse
                .getSaleResponse(requestParametersAccountNumber)
                .get("responseCode")
                .equals("A01"));
    }

    @Test
    public void getSaleResponseAccountNumberTest4() throws Exception {
        requestParametersAccountNumber.setAmount(12000);
        assertTrue(saleResponse
                .getSaleResponse(requestParametersAccountNumber)
                .get("responseCode")
                .equals("D03"));
    }

    @Test
    public void getSaleResponseAccountNumberTest5() throws Exception {
        requestParametersAccountNumber.setAmount(12999);
        assertTrue(saleResponse
                .getSaleResponse(requestParametersAccountNumber)
                .get("responseCode")
                .equals("D03"));
    }

    @Test
    public void getSaleResponseAccountNumberTest6() throws Exception {
        requestParametersAccountNumber.setZipCode("11111");
        assertTrue(saleResponse
                .getSaleResponse(requestParametersAccountNumber)
                .get("avsResponseCode")
                .equals("00"));
    }

    @Test
    public void getSaleResponseAccountNumberTest7() throws Exception {
        requestParametersAccountNumber.setZipCode("22222");
        assertTrue(saleResponse
                .getSaleResponse(requestParametersAccountNumber)
                .get("avsResponseCode")
                .equals("46"));
    }

    @Test
    public void getSaleResponseAccountNumberTest8() throws Exception {
        requestParametersAccountNumber.setCsc("111");
        assertTrue(saleResponse
                .getSaleResponse(requestParametersAccountNumber)
                .get("cscResponseCode")
                .equals("M"));
    }

    @Test
    public void getSaleResponseAccountNumberTest9() throws Exception {
        requestParametersAccountNumber.setCsc("222");
        assertTrue(saleResponse
                .getSaleResponse(requestParametersAccountNumber)
                .get("cscResponseCode")
                .equals("N"));
    }

}