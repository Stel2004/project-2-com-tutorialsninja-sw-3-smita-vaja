package homepage;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class TopMenuTest extends Utility {

    String baseUrl =  "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }

    public void selectMenu(String menu){
        mouseHoverToElement(By.xpath("//a[normalize-space()='"+ menu +"']"));
        clickOnElement(By.xpath("//a[normalize-space()='Show All"+ menu +"']"));
        String actualText = driver.getTitle();
        String expectedText = menu;
        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully(){
        selectMenu("Desktops");
    }
    @Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully(){
        selectMenu("Laptops & Notebooks");
    }

    @Test
    public void verifyUserShouldNavigateToComponentsPageSuccessfully(){
        selectMenu("Components");
    }

    @After
    public void tearDown() {
        closeBrowser();
    }

}