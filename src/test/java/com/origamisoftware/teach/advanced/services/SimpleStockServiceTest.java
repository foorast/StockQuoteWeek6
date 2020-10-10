package com.origamisoftware.teach.advanced.services;

import com.origamisoftware.teach.advanced.model.StockQuote;
import org.junit.Test;

import static junit.framework.Assert.assertNotNull;

public class SimpleStockServiceTest {

    /**
     * Test the SimpleStockService getQuote(symbol) method
     */
    @Test
    public void getQuoteTest (){
        SimpleStockService stockService = new SimpleStockService();
        String symbol = "APPL";
        StockQuote stockQuote = stockService.getQuote(symbol);
        assertNotNull("Can we get a Quote.",  stockQuote);
    }
}
