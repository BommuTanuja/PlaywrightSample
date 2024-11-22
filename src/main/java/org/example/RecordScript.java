package org.example;

import com.microsoft.playwright.*;

public class RecordScript {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false));
            BrowserContext context = browser.newContext();
            Page page = context.newPage();
            page.navigate("https://www.saucedemo.com/v1/index.html");
            page.locator("[data-test=\"username\"]").click();
            page.locator("[data-test=\"username\"]").fill("standard_user");
            page.locator("[data-test=\"username\"]").press("Tab");
            page.locator("[data-test=\"password\"]").fill("secret_sauce");
            page.locator("[data-test=\"password\"]").press("Enter");
        }
    }
}
