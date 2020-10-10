package com.origamisoftware.teach.advanced.util;

import com.origamisoftware.teach.advanced.services.StockServiceException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class DatabaseConnectionExceptionTest {

    /**
     * Initialize expected exception thrown
     */
    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    /**
     *
     * @throws DatabaseConnectionException
     * Sets the expected exception to DatabaseConnectionException
     * Sets the expected Message to "Testing Message"
     * Creates an instance of the exception being thrown and verifies it
     */
    @Test
    public void DatabaseConnectionExceptionTest() throws DatabaseConnectionException{
        exceptionRule.expect(DatabaseConnectionException.class);
        exceptionRule.expectMessage("Testing Message");

        boolean not = false;
        if(not = true){
            throw new DatabaseConnectionException("Testing Message", null);
        }
    }
}
