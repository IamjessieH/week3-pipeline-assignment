# Code Review: BSN Validator

## Reviewed Files
BsnValidator.java BsnValidatorTest.java

The BSNValidator class is easy to understand
You have good test coverage (letters, special chars, valid/invalid numbers)
The eleven test looks correct for BSN

## Issues Found

### Method naming inconsistency
`ShouldRejectInvalidBsn()` has incorrect capitalization - should be `shouldRejectInvalidBsn()`