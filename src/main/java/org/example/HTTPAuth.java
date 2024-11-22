package org.example;

import com.microsoft.playwright.*;

import java.awt.*;

public class HTTPAuth {
    public  static void main(String[] args) {
        Dimension screemSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int)screemSize.getWidth();
        int height = (int)screemSize.getHeight();
        Playwright playwright= Playwright.create();
        Browser browser =playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext context = browser.newContext(new Browser.NewContextOptions().setHttpCredentials("admin","admin").setViewportSize(width,height));
        Page page = context.newPage();
        page.navigate("https://the-internet.herokuapp.com/basic_auth");
        String text =page.locator("h3").textContent();
        System.out.println(text);
        //page.close();
        Page Newpage = context.newPage();
        Newpage.navigate("https://www.saucedemo.com/v1/index.html");
//        page.close();
//        browser.close();
//        playwright.close();

    }
}
