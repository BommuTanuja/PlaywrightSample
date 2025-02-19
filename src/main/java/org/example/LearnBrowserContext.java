package org.example;

import com.microsoft.playwright.*;

import java.awt.*;

public class LearnBrowserContext {
    public static void main(String[] args) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int)screenSize.getWidth();
        int height = (int)screenSize.getHeight();
        Playwright playwright = Playwright.create();
        Browser browser= playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext context = browser.newContext(new Browser.NewContextOptions().setViewportSize(width,height));
        Page page = context.newPage();
        page.navigate("https://www.saucedemo.com/v1/");
    }
}
