package com.cg.uservalidation;
import org.junit.Assert;
import org.junit.Test;
 class TestException {
    UserValidation userValidation= new UserValidation();
    @Test
    public void givenFirstName_whenEntered_shouldReturnValidation(){
        Assert.assertFalse(userValidation.isValidName("abhinav"));
    }
    @Test
    public void givenLastName_whenEntered_shouldReturnValidation(){
        Assert.assertFalse(userValidation.isValidName("thakur"));
    }
    @Test
    public void givenMobile_whenEntered_shouldReturnValidation(){
        Assert.assertTrue(userValidation.isValidPHno("91 9013341138"));
    }
    @Test
    public void givenEmail_whenEntered_shouldReturnValidation(){
        Assert.assertTrue(userValidation.isValidEmail("thakurabhinav56@gmail.com"));
    }
    @Test
    public void givenPassword_whenEntered_shouldReturnValidation(){
        Assert.assertFalse(userValidation.isValidPass("Abhinav@@901"));
    }
    @Test
    public void givenString_whenEntered_shouldReturnSad(){
        Assert.assertEquals("sad",userValidation.happyOrSad("sad"));
    }
}

