package headerPageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Search {
    @FindBy(css = "#main-container > div > section.col-one > article:nth-child(1) > div > ul > li:nth-child(1) > a > div.quicklinks_list__detail > span")
    WebElement start;

    public void sart(){
        start.click();
    }
}
