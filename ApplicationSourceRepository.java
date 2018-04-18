package applications;

public final class ApplicationSourceRepository {
  
    private ApplicationSourceRepository() {
    }

    public static IApplicationSource defaultParameters() {
        return EpizyChrome();
    }

    public static IApplicationSource EpizyChrome() {
        return new ApplicationSource("webdriver.chrome.driver",
		"C:/Program Files (x86)/Google/Chrome/Application/chromedriver.exe",
                10, 
                "http://atqc-shop.epizy.com"
                );
    }
    
}
