package se.lexicon.simon.JPAworkshop.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppUserTest {

    // Arrange
    AppUser theObject = null;
    int id = 10;
    String firstName = "Simon";
    String lastName = "Elbrink";
    String email = "simon@gmail.com";

    @BeforeEach
    void setUp() {
        theObject = new AppUser(id,firstName,lastName,email);

    }
    @Test
    void testSuccessfullyCreated(){

        assertEquals(theObject.getAppUserId(), 10);
        assertEquals(theObject.getFirstName(), "Simon");
        assertEquals(theObject.getLastName(), "Elbrink");
        assertEquals(theObject.getEmail(), "simon@gmail.com");

    }

    @Test
    void testEquals() {
        AppUser isEqual = new AppUser(id,firstName,lastName,email);

        assertTrue(theObject.equals(isEqual));

    }

    @Test
    void testHashCode() {
        AppUser isEqual = new AppUser(id,firstName,lastName,email);

        assertEquals(theObject.hashCode(), isEqual.hashCode());

    }

    @Test
    void testToString() {

        String toString = theObject.toString();

        assertTrue(toString.contains("10"));
        assertTrue(toString.contains("Simon"));
        assertTrue(toString.contains("Elbrink"));
        assertTrue(toString.contains("simon@gmail.com"));


    }
}