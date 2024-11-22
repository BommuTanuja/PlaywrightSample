package org.example;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.SelectOption;

import java.awt.*;

public class LearnDropdown {
    public static void main(String[] args) {
        Dimension screemSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int)screemSize.getWidth();
        int height = (int)screemSize.getHeight();
        Playwright playwright = Playwright.create();
        Browser browser= playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext context = browser.newContext(new Browser.NewContextOptions().setViewportSize(width,height));
        Page page = context.newPage();
        page.navigate("https://the-internet.herokuapp.com/");
        page.locator("//a[@href='/dropdown']").click();
        //page.selectOption("//select[@id='dropdown']","2");
       Locator dropDown =page.locator("//select[@id='dropdown']");
//        dropDown.selectOption("1");
       // dropDown.selectOption(new SelectOption().setLabel("Option 1"));         // set label
        dropDown.selectOption(new SelectOption().setIndex(1));              //set index




        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        playwright.close();

    }
}
