package com.origamisoftware.teach.advanced.util;

import com.origamisoftware.teach.advanced.services.StockServiceException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class DatabaseInitializationExceptionTest {
    /**
     * Initialize expected exception thrown
     */
    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    /**
     *
     * @throws DatabaseInitializationException
     * Sets the expected exception to DatabaseInitializationException
     * Sets the expected Message to "Testing Message"
     * Creates an instance of the exception being thrown and verifies it
     */
    @Test
    public void DatabaseInitializationExceptionTest() throws DatabaseInitializationException{
        exceptionRule.expect(DatabaseInitializationException.class);
        exceptionRule.expectMessage("Testing Message");

        boolean not = false;
        if(not = true){
            throw new DatabaseInitializationException("Testing Message", null);
        }
    }
}
