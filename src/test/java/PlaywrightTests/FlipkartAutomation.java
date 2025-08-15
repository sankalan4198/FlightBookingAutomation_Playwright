package PlaywrightTests;

import com.microsoft.playwright.*;

public class FlipkartAutomation {

    public static void main(String[] args) {
       Playwright playwright = Playwright.create();
       Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
       //Maximize the browser window
       BrowserContext context=browser.newContext(new Browser.NewContextOptions().setViewportSize(1920,1080));
       Page page=context.newPage();
       page.navigate("https://www.flipkart.com/");
       String title=page.title();
       System.out.println("Page title is: " + title);
       page.locator("//a[@aria-label='Mobiles & Tablets']").click();
       page.waitForTimeout(3000);
       page.selectOption("(//select[@class='Gn+jFg'])[last()]","₹10000");
       page.waitForTimeout(8000);
       page.locator("//div[contains(text(),'Samsung')]//ancestor::a").click();
       //browser.close();
       //playwright.close();
    }


}
