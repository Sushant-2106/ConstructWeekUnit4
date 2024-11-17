package runner;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import Browser.all_browsers;
import Modules.BestSellers;
import Modules.FeaturedAuthor;
import Modules.NewArrivals;
import Modules.RequestBook;
import Modules.search;

public class TestRunner {
	
	private WebDriver driver;
    private NewArrivals newArrivalsPage;
    private BestSellers bestSellersPage;
    private FeaturedAuthor featuredAuthorPage;
    private RequestBook requestBookPage;

    @BeforeTest
    public void setup() {
        // Initialize the WebDriver using the All_browser class
        driver = all_browsers.getDriver("CHROME");

        // Launch the application
        driver.get("https://www.bookswagon.com/");

        // Initialize Page Object Model (POM) classes
        newArrivalsPage = new NewArrivals();
        newArrivalsPage.LoginPOM(driver);

        bestSellersPage = new BestSellers();
        bestSellersPage.LoginPOM(driver);

        featuredAuthorPage = new FeaturedAuthor();
        featuredAuthorPage.LoginPOM(driver);

        requestBookPage = new RequestBook();
        requestBookPage.LoginPOM(driver);
    }
    
    
    @Test
    public void Automation_Tests() {
    	
    	requestBookPage.RequestBooks();
    	requestBookPage.ISBN("152969695X");
    	requestBookPage.BookTitle("Early Years Foundation Stage");
    	requestBookPage.AuthorName("Sage Publications");
    	requestBookPage.MailId("sushantmishra2110@gmail.com");
    	requestBookPage.MobileNumber("8240196250");
    	requestBookPage.clicking_on_logo();
    	
    	newArrivalsPage.ClickNewArrivals();
        newArrivalsPage.ClickBookName();
        newArrivalsPage.ClickAddToCart();
        newArrivalsPage.Go_cart();
        
        bestSellersPage.ClickBestSellers();
        bestSellersPage.ClickBookName();
        bestSellersPage.ClickAddToCart();
        bestSellersPage.Go_cart();
        
        featuredAuthorPage.FeaturedBooks();
        featuredAuthorPage.ClickAuthorImage();
        featuredAuthorPage.clickBookName();
        featuredAuthorPage.Adding_in_cart();
        featuredAuthorPage.Go_cart();
        featuredAuthorPage.click_On_buy();
        
        
    	
    }
}
    
    
    
