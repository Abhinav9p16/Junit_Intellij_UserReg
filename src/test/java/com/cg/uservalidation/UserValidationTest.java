package com.cg.uservalidation;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.lang.reflect.ParameterizedType;
import java.util.Arrays;
import java.util.Collection;
@RunWith(Parameterized.class)
public class UserValidationTest {

    private final String email;
    private boolean expected_result;

    UserValidation userValidation= new UserValidation();
    public UserValidationTest(String email, boolean expected_result) {
        this.email=email;
        this.expected_result=expected_result;
    }
    @Test
    public void givenFirstName_whenEntered_shouldReturnValidation(){
        Assert.assertTrue(userValidation.isValidName("Abhinav"));
    }
    @Test
    public void givenLastName_whenEntered_shouldReturnValidation(){
        Assert.assertTrue(userValidation.isValidName("Thakur"));
    }
    @Test
    public void givenMobile_whenEntered_shouldReturnValidation(){
        Assert.assertTrue(userValidation.isValidPHno("91 9013341138"));
    }

    @Test
    public void givenPassword_whenEntered_shouldReturnValidation(){
        Assert.assertTrue(userValidation.isValidPass("Abhinav@901"));
    }
    @Test
    public void givenString_whenEntered_shouldReturnSad(){
        Assert.assertEquals("sad",userValidation.happyOrSad("sad"));
    }
    @Parameterized.Parameters
    public static Collection validEmail(){
        return Arrays.asList(new Object[][] { {"abc@gmail.com",true},{"abc-100@gmail.com",true},{"abc.100@gmail.com",true},
                {"abc111@abc.com",true},{"abc-100@abc.net",true},{"abc.100@gmail.com.au",true},{"abc@1.com",true},
                {"abc@gmail.com.com",true},{"abc+100@gmail.com",false},{"abc+100@gmail.com",false},{"abc",false},
                {"abc@.com.my",false},{"abc123@gmail.a",false},{"abc123@.com",false},{"abc123@.com.com",false},
                {".abc@abc.com",false},{"abc()*@abc.com",false},{".abc@!#$.com",false},{"abc..2002@abc.com",false},
                {"abc.@abc.com",false},{"abc@abc@abc.com",false},{".abc@abc.com",false},{"abc@abc.com.1a",false},
                {"abc@abc.com.aa.au",false}});
    }

    @Test
    public void givenEmail_whenEntered_shouldReturnValidation() {
        System.out.println("Parameterized email : "+email);
        Assert.assertEquals(expected_result,userValidation.isValidEmail(email));
    }
}
