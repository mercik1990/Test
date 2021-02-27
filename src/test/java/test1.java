import org.junit.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class test1 {

    @Test
    public void test2() throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();


        driver.get("http://ec2-54-208-152-154.compute-1.amazonaws.com/");


        WebElement left_box0 = driver.findElement(By.id("left_0"));
        WebElement left_box1 = driver.findElement(By.id("left_1"));
        WebElement left_box2 = driver.findElement(By.id("left_2"));
        WebElement left_box3 = driver.findElement(By.id("left_3"));

        WebElement[] left = new WebElement[]{left_box0, left_box1, left_box2, left_box3};


        WebElement right_box0 = driver.findElement(By.id("right_0"));
        WebElement right_box1 = driver.findElement(By.id("right_1"));
        WebElement right_box2 = driver.findElement(By.id("right_2"));
        WebElement right_box3 = driver.findElement(By.id("right_3"));

        WebElement[] right = new WebElement[]{right_box0, right_box1, right_box2, right_box3};

        WebElement weigh = driver.findElement(By.id("weigh"));

        int i = 0;
        while (i < 4) {

            left[i].sendKeys(i + "");
            Thread.sleep(2000);
            right[i].sendKeys((i + 4) + "");
            Thread.sleep(2000);

            weigh.click();
            Thread.sleep(2000);

            WebElement big = driver.findElement(By.xpath("//ol/li"));


            i++;

        }


        List<WebElement> list = driver.findElements(By.xpath("//ol/li"));

        for (WebElement each : list) {
            if (each.getText().contains(">") || each.getText().contains("<")) {
                System.out.println("Yay! You find it!");
                System.out.println(each.getText());
                return;
            }
        }


        System.out.println("Yay! You find it! It is 8");


    }
}