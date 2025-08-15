package tests;

import base.BaseTest;
import org.testng.annotations.Test;

public class SampleTest extends BaseTest {

    @Test
    public void openGoogle() {
        page.navigate("https://www.google.com");
        System.out.println("Title: " + page.title());
    }
}
