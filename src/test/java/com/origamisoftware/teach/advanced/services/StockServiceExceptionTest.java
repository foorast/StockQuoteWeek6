package com.origamisoftware.teach.advanced.services;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class StockServiceExceptionTest {

    /**
     * Initialize expected exception thrown
     */
    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    /**
     *
     * @throws StockServiceException
     * Sets the expected exception to StockService Exception
     * Sets the expected Message to "Testing Message"
     * Creates an instance of the exception being thrown and verifies it
     */
    @Test
    public void StockServiceExceptionTest() throws StockServiceException{
        exceptionRule.expect(StockServiceException.class);
        exceptionRule.expectMessage("Testing Message");

        boolean not = false;
        if(not = true){
            throw new StockServiceException("Testing Message");
        }
    }
}
