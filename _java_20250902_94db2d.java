package com.project.demo;

import com.project.utils.DataValidationUtility;

/**
 * Demonstration program showing the functionality of DataValidationUtility class
 * This program showcases various validation and formatting methods that can be
 * used in group projects for data processing and input validation.
 * 
 * @author Student Developer
 */
public class ValidationDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Data Validation Utility Demo ===\n");
        
        // Email validation examples
        System.out.println("Email Validation:");
        testEmailValidation("john.doe@example.com");
        testEmailValidation("invalid-email");
        testEmailValidation("user@domain");
        testEmailValidation("");
        
        System.out.println("\nPhone Number Validation:");
        testPhoneValidation("+573001234567");
        testPhoneValidation("3001234567");
        testPhoneValidation("abc123");
        testPhoneValidation("123-456-7890");
        
        System.out.println("\nData Formatting:");
        testFormatting("john SMITH");
        testFormatting("123-abc-456");
        testFormatting("HELLO world");
        
        System.out.println("\nLength Validation:");
        testLengthValidation("short", 3, 10);
        testLengthValidation("this is too long", 3, 10);
        testLengthValidation("ok", 3, 10);
    }
    
    private static void testEmailValidation(String email) {
        boolean isValid = DataValidationUtility.isValidEmail(email);
        System.out.printf("Email '%s': %s%n", email, isValid ? "VALID" : "INVALID");
    }
    
    private static void testPhoneValidation(String phone) {
        boolean isValid = DataValidationUtility.isValidPhoneNumber(phone);
        System.out.printf("Phone '%s': %s%n", phone, isValid ? "VALID" : "INVALID");
    }
    
    private static void testFormatting(String input) {
        String titleCase = DataValidationUtility.toTitleCase(input);
        String digitsOnly = DataValidationUtility.extractDigits(input);
        System.out.printf("Input: '%s' -> Title Case: '%s', Digits: '%s'%n", 
                         input, titleCase, digitsOnly);
    }
    
    private static void testLengthValidation(String input, int min, int max) {
        boolean isValid = DataValidationUtility.isLengthValid(input, min, max);
        System.out.printf("Length '%s' (%d-%d): %s%n", 
                         input, min, max, isValid ? "VALID" : "INVALID");
    }
}