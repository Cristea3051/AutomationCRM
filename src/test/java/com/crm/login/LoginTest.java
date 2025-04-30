package com.crm.login;

import com.crm.utils.BasePage;
import org.testng.annotations.Test;

import static com.diogonunes.jcolor.Ansi.colorize;

@Test
public class LoginTest extends BasePage {

    public void testLogin() {
        System.out.println(colorize("LoginPage"));
    }
}
