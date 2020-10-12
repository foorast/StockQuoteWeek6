package com.origamisoftware.teach.advanced.model;

import org.junit.Test;

import java.sql.Timestamp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Unit test for PersonHobby class
 */
public class PersonQuoteTest {

    /**
     * Testing helper method for generating PersonQuote test data
     *
     * @return a PersonQuote object that uses Person and StockQuote
     * return from their respective create method.
     */
    public static PersonQuote createPersonQuote() {
        Person person = PersonTest.createPerson();
        StockQuote quote = StockQuoteTest.createQuote();
        return new PersonQuote(person, quote);
    }

    @Test
    public void testPersonHobbiesGetterAndSetters() {
        StockQuote stockQuote = StockQuoteTest.createQuote();
        Person person = PersonTest.createPerson();
        PersonQuote personQuote = new PersonQuote();
        int id = 10;
        personQuote.setId(id);
        personQuote.setPerson(person);
        personQuote.setStockQuote(stockQuote);
        assertEquals("person matches", person, personQuote.getPerson());
        assertEquals("stock quote matches", stockQuote, personQuote.getStockQuote());
        assertEquals("id matches", id, personQuote.getId());
    }

    @Test
    public void testEqualsNegativeDifferentPerson() {
        PersonQuote personQuote = createPersonQuote();
        personQuote.setId(10);
        StockQuote stockQuote = StockQuoteTest.createQuote();
        Person person = new Person();
        Timestamp birthDate = new Timestamp(PersonTest.birthDayCalendar.getTimeInMillis() + 10000);
        person.setBirthDate(birthDate);
        person.setFirstName(PersonTest.firstName);
        person.setLastName(PersonTest.lastName);
        PersonQuote personQuote2 = new PersonQuote(person, stockQuote);
        assertFalse("Different person", personQuote.equals(personQuote2));
    }

    @Test
    public void testEquals() {
        PersonQuote personQuote = createPersonQuote();
        assertTrue("Same objects are equal", personQuote.equals(createPersonQuote()));
    }

    @Test
    public void testToString() {
        PersonQuote personQuote = createPersonQuote();
        assertTrue("toString has lastName", personQuote.toString().contains(PersonTest.lastName));
        assertTrue("toString has person", personQuote.toString().contains(PersonTest.firstName));
        assertTrue("toString has quote date", personQuote.toString().contains(StockQuoteTest.createQuote().getDate().toString()));
        assertTrue("toString has quote symbol", personQuote.toString().contains(StockQuoteTest.createQuote().getSymbol()));
        assertTrue("toString has quote price", personQuote.toString().contains(Integer.toString(StockQuoteTest.createQuote().getPrice().intValue())));
    }

}
