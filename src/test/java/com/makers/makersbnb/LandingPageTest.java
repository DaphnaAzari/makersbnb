package com.makers.makersbnb;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

class LandingPageTest {
    static Playwright playwright;
    static Browser browser;
    BrowserContext context;
    Page page;

    @BeforeAll
    static void launchBrowser() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch();
    }

    @AfterAll
    static void closeBrowser() {
        playwright.close();
    }

    @BeforeEach
    void createContextAndPage() {
        context = browser.newContext();
        page = context.newPage();
    }

    @AfterEach
    void closeContext() {
        context.close();
    }

    @Test
    public void usersAreWelcomedToTheApp() {
        //we first navigate to http://localhost:8080 which generates a GET "/":
        page.navigate("http://localhost:8080");
        //we use page.locator to grab the entire HTML body:
        Locator pageBody = page.locator("body");
        //we assert that the body should contain "Welcome to MakersBnB!":
        assertThat(pageBody).containsText("Welcome to MakersBnB");
    }

    @Test
    public void usersSeeEmailAddressWhenOnContactUs() {
        //we first navigate to http://localhost:8080 which generates a GET "/":
        page.navigate("http://localhost:8080/contactus");
        //we use page.locator to grab the entire HTML body:
        Locator pageBody = page.locator("body");
        //we assert that the body should contain "Welcome to MakersBnB!":
        assertThat(pageBody).containsText("makersbnb@gmail.com");
    }
    @Test
    public void usersSeeListOfStaffWhenOnTeamPage(){
        page.navigate("http://localhost:8080/team");
        Locator pageBody =page.locator("body");
        assertThat(pageBody).containsText("Toby, Katerina, Sandy");
    }
}

