package nl.bsn.validator;

/**
 * Sources:
 * - https://nl.wikipedia.org/wiki/Burgerservicenummer
 * - https://testbestanden.nl/lijst_met_geldige_bsnnummers.php
 */
public class BsnValidator {

    private static final int BSN_LENGTH = 9;

    /**
     * 
     * Validates a Dutch Burger Service Number (BSN) using the 11-proef
     * 
     * this has the following validations
     * 1. Checks if the BSN is null or empty
     * 2. Validates that the BSN has exactly 9 characters
     * 3. Ensures the BSN contains only numeric digits
     * 4. Applies the 11-proef to verify the validation
     * 
     * @param bsn The BSN string to validate (must be 9 digits)
     * @return true if the BSN is valid according to the 11-proef, false otherwise
     */
    public boolean isValid(String bsn) {

        if (bsn == null || bsn.isEmpty()) {
            return false;
        }
        
        if (bsn.length() != BSN_LENGTH) {
            return false;
        }
        
        if (!bsn.matches("\\d+")) {
            return false;
        }
        
        int sum = 0;
        for (int i = 0; i < 8; i++) {
            int digit = Character.getNumericValue(bsn.charAt(i));
            int weight = 9 - i;
            sum += digit * weight;
        }
        
        int lastDigit = Character.getNumericValue(bsn.charAt(8));
        sum -= lastDigit;
        
        return sum % 11 == 0;
    }
}