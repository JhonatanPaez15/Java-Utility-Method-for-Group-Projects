package com.project.utils;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * DataValidationUtility - A utility class for common data validation and formatting operations
 * that can be used across multiple projects for input validation and data processing.
 * 
 * @author Student Developer
 * @version 1.0
 */
public class DataValidationUtility {
    
    // Regular expression patterns for validation
    private static final Pattern EMAIL_PATTERN = 
        Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
    private static final Pattern PHONE_PATTERN = 
        Pattern.compile("^\\+?[0-9]{7,15}$");
    private static final Pattern DATE_PATTERN = 
        Pattern.compile("^\\d{4}-\\d{2}-\\d{2}$");
    
    /**
     * Validates if a string represents a valid email address
     * 
     * @param email The email string to validate
     * @return true if the email is valid, false otherwise
     */
    public static boolean isValidEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            return false;
        }
        return EMAIL_PATTERN.matcher(email.trim()).matches();
    }
    
    /**
     * Validates if a string represents a valid phone number
     * 
     * @param phone The phone number string to validate
     * @return true if the phone number is valid, false otherwise
     */
    public static boolean isValidPhoneNumber(String phone) {
        if (phone == null || phone.trim().isEmpty()) {
            return false;
        }
        // Remove any non-digit characters except leading plus sign
        String cleanedPhone = phone.replaceAll("[^0-9+]", "");
        return PHONE_PATTERN.matcher(cleanedPhone).matches();
    }
    
    /**
     * Validates if a string represents a valid date in YYYY-MM-DD format
     * 
     * @param date The date string to validate
     * @return true if the date format is valid, false otherwise
     */
    public static boolean isValidDateFormat(String date) {
        if (date == null || date.trim().isEmpty()) {
            return false;
        }
        return DATE_PATTERN.matcher(date.trim()).matches();
    }
    
    /**
     * Extracts numeric digits from a string, useful for cleaning input data
     * 
     * @param input The input string containing mixed characters
     * @return A string containing only numeric digits
     */
    public static String extractDigits(String input) {
        if (input == null) {
            return "";
        }
        return input.replaceAll("[^0-9]", "");
    }
    
    /**
     * Formats a string to title case (first letter of each word capitalized)
     * 
     * @param input The input string to format
     * @return The formatted string in title case
     */
    public static String toTitleCase(String input) {
        if (input == null || input.trim().isEmpty()) {
            return input;
        }
        
        String[] words = input.trim().split("\\s+");
        StringBuilder result = new StringBuilder();
        
        for (String word : words) {
            if (!word.isEmpty()) {
                result.append(Character.toUpperCase(word.charAt(0)))
                      .append(word.substring(1).toLowerCase())
                      .append(" ");
            }
        }
        
        return result.toString().trim();
    }
    
    /**
     * Validates if a string length is within specified bounds
     * 
     * @param input The input string to validate
     * @param minLength Minimum allowed length (inclusive)
     * @param maxLength Maximum allowed length (inclusive)
     * @return true if length is within bounds, false otherwise
     */
    public static boolean isLengthValid(String input, int minLength, int maxLength) {
        if (input == null) {
            return minLength == 0;
        }
        int length = input.length();
        return length >= minLength && length <= maxLength;
    }
}