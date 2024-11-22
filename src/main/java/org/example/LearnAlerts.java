package org.example;

import com.microsoft.playwright.*;

import java.awt.*;

public class LearnAlerts {
    public static void main(String[] args){
        Dimension screemSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int)screemSize.getWidth();
        int height = (int)screemSize.getHeight();
        Playwright playwright= Playwright.create();
        Browser browser =playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext context = browser.newContext(new Browser.NewContextOptions().setViewportSize(width,height));
        Page page = context.newPage();
        page.navigate("https://the-internet.herokuapp.com/");
        page.locator("//a[@href='/javascript_alerts']").click();

        page.onDialog(dialog -> {
            System.out.println(dialog.message());
            dialog.accept("tanuja");
        });
       // page.locator("//button[contains(text(),'JS Alert')]").click();
        page.locator("//button[contains(text(),'JS Prompt')]").click();
        System.out.println(page.locator("#result").textContent());

    }
}
