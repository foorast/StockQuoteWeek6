package com.origamisoftware.teach.advanced.util;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ProgramConfigurationTest {

    /**
     * Test the getApplicationProperties method in ProgramConfiguration
     * Should be null
     */
    @Test
    public void testProgramConfiguration(){
        assertNull("Should be Null", ProgramConfiguration.getApplicationProperties());
    }

}
