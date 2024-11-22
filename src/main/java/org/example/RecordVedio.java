package org.example;

import com.microsoft.playwright.*;

import java.awt.*;
import java.nio.file.Paths;

public class RecordVedio {
    public static void main(String[] args) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int)screenSize.getWidth();
        int height = (int)screenSize.getHeight();
        Playwright playwright = Playwright.create();
        Browser browser= playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext context = browser.newContext(new Browser.NewContextOptions().setViewportSize(width,height).setRecordVideoDir(Paths.get("videos/")));
        Page page = context.newPage();
        page.navigate("https://www.saucedemo.com/v1/");
        page.locator("#user-name").fill("standard_user");
        page.locator("#password").fill("secret_sauce");
        page.locator("#login-button").click();
        page.close();
    }
}