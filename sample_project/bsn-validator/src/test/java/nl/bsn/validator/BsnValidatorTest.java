package nl.bsn.validator;

import org.junit.Test;
import static org.junit.Assert.*;


public class BsnValidatorTest {
    
    @Test
    public void shouldAcceptValidBsn() {
        BsnValidator validator = new BsnValidator();
        assertTrue("123456782 should be valid", validator.isValid("123456782"));
    }
  
    @Test
    public void ShouldRejectInvalidBsn() {
        BsnValidator validator = new BsnValidator();
        assertFalse("123456789 should be invalid", validator.isValid("123456789"));
    }

    @Test
    public void shouldRejectBsnWithWrongLength() {
        BsnValidator validator = new BsnValidator();
        assertFalse("12345678 should be invalid (too short)", validator.isValid("12345678"));
        assertFalse("1234567890 should be invalid (too long)", validator.isValid("1234567890"));
    }

        @Test
    public void shouldRejectBsnWithLetters() {
        BsnValidator validator = new BsnValidator();
        assertFalse("12345678a should be invalid", validator.isValid("12345678a"));
        assertFalse("A12345678 should be invalid", validator.isValid("A12345678"));
    }

    @Test
    public void shouldRejectNullBsn() {
        BsnValidator validator = new BsnValidator();
        assertFalse("null should be invalid", validator.isValid(null));
    }
    
    @Test
    public void shouldRejectEmptyBsn() {
        BsnValidator validator = new BsnValidator();
        assertFalse("empty string should be invalid", validator.isValid(""));
    }
    
    @Test
    public void shouldRejectBsnWithSpecialCharacters() {
        BsnValidator validator = new BsnValidator();
        assertFalse("12345678! should be invalid", validator.isValid("12345678!"));
        assertFalse("12345678@ should be invalid", validator.isValid("12345678@"));
        assertFalse("12345678# should be invalid", validator.isValid("12345678#"));
        assertFalse("12345678$ should be invalid", validator.isValid("12345678$"));
    }

    @Test
    public void shouldRejectBsnWithSpaces() {
        BsnValidator validator = new BsnValidator();
        String[] invalidBsns = { "123 456 78", " 12345678", "12345678 " };
        
        for (String bsn : invalidBsns) {
            assertFalse(bsn + " should be invalid", validator.isValid(bsn));
        }
    }
}