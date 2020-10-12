package com.cg.uservalidation;
import org.junit.Assert;
import org.junit.Test;
import com.cg.uservalidation.UserValidation;
 class TestException {
    UserValidation user= new UserValidation();
    @Test
    public void givenFirstName_whenEntered_shouldReturnValidation(){
        Assert.assertTrue(user.valOp("Abhinav",user.isValidName));
    }
    @Test
    public void givenLastName_whenEntered_shouldReturnValidation(){
        Assert.assertFalse(user.valOp("thakur",user.isValidName));
    }
    @Test
    public void givenMobile_whenEntered_shouldReturnValidation(){
        Assert.assertTrue(user.valOp("91 9013341138", user.isValidPHno));
    }
    @Test
    public void givenEmail_whenEntered_shouldReturnValidation(){
        Assert.assertTrue(user.valOp("thakurabhinav56@gmail.com",user.isValidEmail));
    }
    @Test
    public void givenPassword_whenEntered_shouldReturnValidation(){
        Assert.assertFalse(user.valOp("Abhinav@@901",user.isValidPass));
    }
}

