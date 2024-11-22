package org.example;

import com.microsoft.playwright.*;

import java.nio.file.Paths;

public class BasicTest {

    public static void main( String[] args )
    {

         Playwright playwright = Playwright.create() ;
         Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
         Page page = browser.newPage();
         page.navigate("https://www.google.com");
        BrowserContext context=browser.newContext(new Browser.NewContextOptions().setViewportSize(780,500));
        String title =page.title();
        System.out.println(title);
        page.type("//input[name='q']","Playwright Automation");
        page.click("//input[@name='btnk']");
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("example.png")));
        browser.close();
        playwright.close();

    }
}
