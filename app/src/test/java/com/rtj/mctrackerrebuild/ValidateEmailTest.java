package com.rtj.mctrackerrebuild;
import static org.junit.Assert.*;
import org.junit.Test;

public class ValidateEmailTest {
    private final EmailValidator emailValidator = new EmailValidator();
    @Test
    public void testValidEmail(){
        assertTrue(emailValidator.isValidEmail("jane@email.com"));
        assertTrue(emailValidator.isValidEmail("john.smith@smith.co"));
        assertTrue(emailValidator.isValidEmail("jae_jae123@domain.org"));
    }
    @Test
    public void testInvalidEmail(){
        assertFalse(emailValidator.isValidEmail("jim.com"));
        assertFalse(emailValidator.isValidEmail("example@com"));
        assertFalse(emailValidator.isValidEmail("example@domain."));
        assertFalse(emailValidator.isValidEmail(""));
        assertFalse(emailValidator.isValidEmail(null));
    }


    class EmailValidator {
        public boolean isValidEmail(String email){
            String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
            return email != null && email.matches(emailPattern);
        }
    }
}
