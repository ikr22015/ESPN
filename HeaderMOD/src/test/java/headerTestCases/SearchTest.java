package headerTestCases;

import base.CommonAPI;
import headerPageObject.Search;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class SearchTest extends CommonAPI{
    @Test
    public void testStart(){
        Search search = PageFactory.initElements(driver, Search.class);
        search.sart();
    }
}
