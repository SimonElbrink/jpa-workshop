package se.lexicon.simon.JPAworkshop.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppUserTest {

    // Arrange
    AppUser theObject = null;
    Integer id = 10;
    String firstName = "Simon";
    String lastName = "Elbrink";
    String email = "simon@gmail.com";

    @BeforeEach
    void setUp() {
        theObject = new AppUser(id,firstName,lastName,email);

    }
    @Test
    void testSuccessfullyCreated(){

        assertEquals(10, theObject.getAppUserId());
        assertEquals("Simon", theObject.getFirstName());
        assertEquals("Elbrink", theObject.getLastName());
        assertEquals("simon@gmail.com", theObject.getEmail());

    }

    @Test
    void testEquals() {
        AppUser isEqual = new AppUser(id,firstName,lastName,email);

        assertTrue(theObject.equals(isEqual));
    }

    @Test
    void testHashCode() {
        AppUser isEqual = new AppUser(id,firstName,lastName,email);

        assertEquals(isEqual.hashCode(), theObject.hashCode());
    }

    @Test
    void testToString() {
        String toString = theObject.toString();

        assertTrue(toString.contains(id.toString()));
        assertTrue(toString.contains((firstName)));
        assertTrue(toString.contains(lastName));
        assertTrue(toString.contains(email));


    }
}