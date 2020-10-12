package com.origamisoftware.teach.advanced.services;

import com.origamisoftware.teach.advanced.model.Person;
import com.origamisoftware.teach.advanced.model.PersonTest;
import com.origamisoftware.teach.advanced.model.StockQuote;
import com.origamisoftware.teach.advanced.util.DatabaseUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Unit tests for the DatabasePersonService
 */
public class DatabasePersonServiceTest {

    /**
     * Declare instance of PersonService
     * that can be used throughout this test class
     */
    private PersonService personService;

    /**
     * Initialize database through DatabaseUtils class and
     * initialize databaseStockService variable to a new instance of PersonService class
     *
     * @throws Exception
     */
    private void initDb() throws Exception {
        DatabaseUtils.initializeDatabase(DatabaseUtils.initializationFile);
    }

    /**
     * Initialize database through DatabaseUtils class and
     * initialize databaseStockService variable to a new instance of PersonService class
     *
     * @throws Exception
     */
    // do not assume db is correct
    @Before
    public void setUp() throws Exception {
        // we could also copy db state here for later restore before initializing
        initDb();
        personService = ServiceFactory.getPersonServiceInstance();
    }

    /**
     * clean up after ourselves. (this could also restore db from initial state)
     *
     * @throws Exception
     */
    @After
    public void tearDown() throws Exception {
        initDb();
    }

    /**
     * test that the personService instance is not null
     */
    @Test
    public void testGetInstance() {
        assertNotNull("Make sure personService is available", personService);
    }

    /**
     * Test that person objects can be retrieved from the database with the
     * getPerson method
     *
     * @throws PersonServiceException
     */
    @Test
    public void testGetPerson() throws PersonServiceException {
        List<Person> personList = personService.getPerson();
        assertFalse("Make sure we get some Person objects from service", personList.isEmpty());
    }

    /**
     * Test that a person objects can be added or updated
     *
     * @throws PersonServiceException
     */
    @Test
    public void testAddOrUpdatePerson() throws PersonServiceException {
        Person newPerson = PersonTest.createPerson();
        personService.addOrUpdatePerson(newPerson);
        List<Person> personList = personService.getPerson();
        boolean found = false;
        for (Person person : personList) {
            Timestamp returnedBirthDate = person.getBirthDate();
            Calendar returnCalendar = Calendar.getInstance();
            returnCalendar.setTimeInMillis(returnedBirthDate.getTime());
            if (returnCalendar.get(Calendar.MONTH) == PersonTest.birthDayCalendar.get(Calendar.MONTH)
                    &&
                    returnCalendar.get(Calendar.YEAR) == PersonTest.birthDayCalendar.get(Calendar.YEAR)
                    &&
                    returnCalendar.get(Calendar.DAY_OF_MONTH) == PersonTest.birthDayCalendar.get(Calendar.DAY_OF_MONTH)
                    &&
                    person.getLastName().equals(PersonTest.lastName)
                    &&
                    person.getFirstName().equals(PersonTest.firstName)) {
                found = true;
                break;
            }
        }
        assertTrue("Found the person we added", found);
    }

    /**
     * Test that quotes can be correctly returned for a given person
     * verifies addQuotesToPerson and getQuotes methods
     *
     * @throws PersonServiceException
     */
    @Test
    public void testGetQuotesByPerson() throws PersonServiceException {
        Person person = PersonTest.createPerson();
        List<StockQuote> quotes = personService.getQuotes(person);
        // make the person have all the quotes
        for (StockQuote quote : quotes) {
            personService.addQuoteToPerson(quote, person);
        }
        List<StockQuote> quoteList = personService.getQuotes(person);
        for (StockQuote quote : quotes) {
            boolean removed = quoteList.remove(quote);
            assertTrue("Verify that the quote was found on the list", removed);
        }
        // if  hobbyList is empty then we know the lists matched.
        assertTrue("Verify the list of returned quotes match what was expected ", quoteList.isEmpty());

    }
}
