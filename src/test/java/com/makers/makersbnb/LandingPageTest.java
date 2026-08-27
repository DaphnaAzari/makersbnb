package com.makers.makersbnb;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

class LandingPageTest {
    static Playwright playwright;
    static Browser browser;
    BrowserContext context;
    Page page;
//Methods with a @BeforeAll annotation are run once, at the
// start of the test run. In this case,
// we're instantiating Playwright and
// launching a Chromium browser (of chome broser).
    @BeforeAll
    static void launchBrowser() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch();
    }

    @AfterAll
    static void closeBrowser() {
        playwright.close();
    }
//before each is used when we want the test to do the same set of things before
    //each of the tests so that we do not have to repeat the steps top the starting
   //point. @BeforeEach or @AfterEach are run before/after every individual test.
    // In this case, we're creating a new browser context for each test, and then creating a
    //new page (tab) which we can reference within the tests.

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
        assertThat(pageBody).containsText("spaces are waiting to be discovered");
        assertThat(pageBody).containsText("bookings were made last week");

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

