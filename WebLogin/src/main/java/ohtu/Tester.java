package ohtu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tester {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("http://localhost:4567");

        sleep(1);

        WebElement element = driver.findElement(By.linkText("login"));
        element.click();

        sleep(1);

        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("login"));

        sleep(1);
        element.submit();

        sleep(2);
        
        element = driver.findElement(By.name("username"));
        element.sendKeys("appep");
        element = driver.findElement(By.name("password"));
        element.sendKeys("akkep");
        element = driver.findElement(By.name("login"));

        sleep(1);
        element.submit();

        sleep(2);
        
        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("akkep");
        element = driver.findElement(By.name("login"));

        sleep(1);
        element.submit();

        sleep(2);
        
        element = driver.findElement(By.linkText("logout"));
        element.click();
        
        sleep(1);
        
        element = driver.findElement(By.linkText("register new user"));
        element.click();
        
        sleep(1);
        element = driver.findElement(By.name("username"));
        element.sendKeys("pena");
        element = driver.findElement(By.name("password"));
        element.sendKeys("anep");
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("anep");
        element = driver.findElement(By.name("signup"));
        
        sleep(1);
        element.submit();
        
        sleep(1);

        element = driver.findElement(By.linkText("continue to application webpage"));
        sleep(2);
        
        element = driver.findElement(By.linkText("logout"));
        element.click();
        
        sleep(2);
        
        driver.quit();
    }

    private static void sleep(int n) {
        try {
            Thread.sleep(n * 1000);
        } catch (Exception e) {
        }
    }
}
