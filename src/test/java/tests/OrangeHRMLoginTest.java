package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.OrangeHRMLoginPage;

public class OrangeHRMLoginTest extends BaseTest {

    @Test(dataProvider = "Credentials")
    public void verifyLoginCredentials(String scenario,String username,String password) {
        OrangeHRMLoginPage lp = new OrangeHRMLoginPage(getDriver());

        if (scenario.equals("bothvalid")) {
            lp.doValidLogin(username, password);
        } else {
            lp.doInvalidLogin(username, password);
        }

        if (scenario.equals("userblank")) {
            lp.verifyLoginErrMsg( "Username cannot be empty");
        }
        else if (scenario.equals("passwordblank")) {
            lp.verifyLoginErrMsg("Password cannot be empty");
        }
        else if (scenario.equals("wronguser")) {
            lp.verifyLoginErrMsg("Invalid credentials");
        }
        else if (scenario.equals("wrongpassword")) {
            lp.verifyLoginErrMsg("Invalid credentials");
        }

    }

    @DataProvider(name = "Credentials")
    public Object[][] GetData(){

        return new Object[][] {
                {"bothvalid","Admin","admin123"},
                {"userblank","","admin123"},
                {"passwordblank","Admin",""},
                {"wronguser","Admina","admin123"},
                {"wrongpassword","Admin","admin"}

        };

    }
}
