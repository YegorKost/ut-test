package com.yegor;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by YegorKost on 12.05.2017.
 */
public class SaleResponseTrackDataTest {
    private RequestParameters requestParametersTrackData = new RequestParametersTrackData();
    private SaleResponse saleResponse = new SaleResponse();

    @Before
    public void setUpProperties() {
        requestParametersTrackData.init();
        requestParametersTrackData.setUrl("https://sandbox-secure.unitedthinkers.com/gates/xurl?");
    }

    @Test
    public void getSaleResponseTrackDataTest1() throws Exception {
        requestParametersTrackData.setAmount(7000);
        assertTrue(saleResponse
                .getSaleResponse(requestParametersTrackData)
                .get("responseCode")
                .equals("D05"));

    }

    @Test
    public void getSaleResponseTrackDataTest2() throws Exception {
        requestParametersTrackData.setAmount(7999);
        assertTrue(saleResponse
                .getSaleResponse(requestParametersTrackData)
                .get("responseCode")
                .equals("D05"));
    }

    @Test
    public void getSaleResponseTrackDataTest3() throws Exception {
        requestParametersTrackData.setAmount(13000);
        assertTrue(saleResponse
                .getSaleResponse(requestParametersTrackData)
                .get("responseCode")
                .equals("E02"));
    }

    @Test
    public void getSaleResponseTrackDataTest4() throws Exception {
        requestParametersTrackData.setAmount(13999);
        assertTrue(saleResponse
                .getSaleResponse(requestParametersTrackData)
                .get("responseCode")
                .equals("E02"));
    }

    @Test
    public void getSaleResponseTrackDataTest5() throws Exception {
        requestParametersTrackData.setZipCode("33333");
        assertTrue(saleResponse
                .getSaleResponse(requestParametersTrackData)
                .get("avsResponseCode")
                .equals("43"));
    }

    @Test
    public void getSaleResponseTrackDataTest6() throws Exception {
        requestParametersTrackData.setZipCode("44444");
        assertTrue(saleResponse
                .getSaleResponse(requestParametersTrackData)
                .get("avsResponseCode")
                .equals("40"));
    }

    @Test
    public void getSaleResponseTrackDataTest7() throws Exception {
        requestParametersTrackData.setCsc("333");
        assertTrue(saleResponse
                .getSaleResponse(requestParametersTrackData)
                .get("cscResponseCode")
                .equals("P"));
    }

    @Test
    public void getSaleResponseTrackDataTest8() throws Exception {
        requestParametersTrackData.setCsc("444");
        assertTrue(saleResponse
                .getSaleResponse(requestParametersTrackData)
                .get("cscResponseCode")
                .equals("S"));
    }
}