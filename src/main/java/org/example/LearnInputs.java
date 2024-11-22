package org.example;


import com.microsoft.playwright.*;
import java.awt.*;

public class LearnInputs {
 public static void main(String[] args)  {
     Dimension screemSize = Toolkit.getDefaultToolkit().getScreenSize();
     int width = (int)screemSize.getWidth();
     int height = (int)screemSize.getHeight();
     Playwright playwright= Playwright.create();
     Browser browser =playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
     BrowserContext context = browser.newContext(new Browser.NewContextOptions().setViewportSize(width,height));
     Page page = context.newPage();
     page.navigate("https://www.saucedemo.com/v1/");
     page.locator("#user-name").type("standard_user");
     page.locator("//input[@name='password']").fill("secret_sauce");
     //page.locator(".btn_action").click();
     page.locator("id=login-button").click();
//     String value =page.locator("id=login-button").getAttribute("value");
//     System.out.println(value);


     //page.close();
     //browser.close();
    //playwright.close();


    }
}
