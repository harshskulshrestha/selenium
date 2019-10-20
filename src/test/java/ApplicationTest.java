import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.core.Is.is;

public class ApplicationTest {
    @Test
    public void testIfWebsiteIsDeployed() throws Exception {
        System.setProperty("webdriver.chrome.driver", "src/chromedriver");
        String ip = System.getenv("TEST_SERVER_IP");
        ChromeDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("http://"+ ip + ":1052/index.php");
        chromeDriver.manage().window().maximize();
        chromeDriver.findElement(By.id("About Us")).click();
        String aboutUsText = chromeDriver.findElement(By.id("PID-ab2-pg")).getText();
        String expectedAboutUsText = "This is about page. Lorem Ipsum Dipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.";
        Assert.assertThat(aboutUsText, is(expectedAboutUsText));
        chromeDriver.close();
    }
}
