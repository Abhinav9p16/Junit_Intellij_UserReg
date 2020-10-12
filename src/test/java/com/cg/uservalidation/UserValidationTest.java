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
    private static String str;
    private static boolean expected;
    UserValidation user= new UserValidation();
    public UserValidationTest(String str, boolean expected) {
        this.str = str;
        this.expected = expected;
    }
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
    public void givenPassword_whenEntered_shouldReturnValidation(){
        Assert.assertFalse(user.valOp("Abhinav@@901",user.isValidPass));
    }
    @Parameterized.Parameters
    public static Collection validEmail(){
        return Arrays.asList(new Object[][] { {"abc@gmail.com",true},{"abc-100@gmail.com",true},{"abc.100@gmail.com",true},
                {"abc111@abc.com",true},{"abc-100@abc.net",true},{"abc.100@gmail.com.au",true},{"abc@1.com",true},
                {"abc@gmail.com.com",true},{"abc",false}, {"abc@.com.my",false},{"abc123@gmail.a",false},{"abc123@.com",false},{"abc123@.com.com",false},
                {".abc@abc.com",false},{"abc()*@abc.com",false},{".abc@!#$.com",false},{"abc..2002@abc.com",false},
                {"abc.@abc.com",false},{"abc@abc@abc.com",false},{".abc@abc.com",false},{"abc@abc.com.1a",false},
                {"abc@abc.com.aa.au",false}});
    }

    @Test
    public void givenEmail_whenEntered_shouldReturnValidation() {
        System.out.println("Parameterized email : "+str);
        Assert.assertEquals(expected,user.valOp(str,user.isValidEmail));
    }
}
