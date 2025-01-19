import org.pages.ArticlePage;
import org.pages.MainPage;
import org.testng.annotations.Test;

import java.io.IOException;

public class SampleTest extends BaseTest{

    @Test
    public void sampleTest(){
        new MainPage(driver).verifyLanguage("ESPAÑA");
    }

    @Test
    public void scrapeArticle()  {
        new MainPage(driver).navigateOption("Opinión").getArticleContent(5);
    }

    @Test
    public void translateArticle() throws InterruptedException, IOException {
        new MainPage(driver).navigateOption("Opinión").translateArticleTitle(5);
    }

    @Test
    public void getWordCount() throws InterruptedException, IOException {
        new MainPage(driver).navigateOption("Opinión").getRepeatedWords(5);
    }
}
