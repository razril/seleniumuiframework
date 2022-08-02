package tests;

import org.testng.annotations.Test;

public class userdir {

    @Test
    public void checkValue(){
       System.out.println(System.getProperty("user.dir"));
    }
}
