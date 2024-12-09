package com.rtj.mctrackerrebuild;
import static org.junit.Assert.*;
import org.junit.Test;

public class ValidatePhoneTest {
    private final PhoneValidator phoneValidator = new PhoneValidator();
    @Test
    public void testValidPhone(){
        assertTrue(phoneValidator.isValidPhone("123-456-7890"));
        assertTrue(phoneValidator.isValidPhone("1234567890"));
    }
    @Test
    public void testInvalidPhone(){
        assertFalse(phoneValidator.isValidPhone("phone123456"));
        assertFalse(phoneValidator.isValidPhone(""));
        assertFalse(phoneValidator.isValidPhone(null));
    }


    class PhoneValidator {
        public boolean isValidPhone(String phone) {
            String phonePattern = "\\d{3}-?\\d{3}-?\\d{4}";
            return phone != null && phone.matches(phonePattern);
        }
    }
}
