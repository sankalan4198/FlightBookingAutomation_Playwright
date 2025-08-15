package base;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.*;
import org.junit.jupiter.api.BeforeAll;
import org.testng.annotations.*;

public class BaseTest {

    //NOTE: Here we declare the variables protected because it provides encapsulation, they are accessible in the same package and subclasses
    //and cannot be accessible by any random classes which increases the risk of unintended modification
    protected Playwright playwright;
    protected Browser browser;
    protected BrowserContext context;
    protected Page page;

    @BeforeClass
    public void setUp(){
        playwright=Playwright.create();
        browser= playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        context=browser.newContext();
        page=context.newPage();
    }

    @AfterClass
    public void tearDown(){
        context.close();
        browser.close();
        playwright.close();
    }

}
