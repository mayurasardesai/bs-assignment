package org.pages;

import org.helper.HTTPClient;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class ArticlePage {
    public WebDriver driver;

    private HashMap<String, String> articleContent;
    private HashMap<String, Integer> wordCounter;

    private HTTPClient httpClient;

    @FindBy(tagName = "article")
    public List<WebElement> articles;

    @FindBy(xpath = "//article/header/h2")
    public List<WebElement> articleTitle;

    @FindBy(xpath = "//article/p")
    public List<WebElement> articleText;

    public ArticlePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void getArticle(){
        articleContent = new HashMap<>();
        for (WebElement article : articles) {
            System.out.println(article.getText());
        }
    }

    public ArticlePage translateArticleTitle(Integer articlesToPrint) throws IOException, InterruptedException {
        httpClient = new HTTPClient();
        articleContent = new HashMap<>();
        for (int i = 0; i <articlesToPrint; i++) {
            articleContent.put(articleTitle.get(i).getText(), articleText.get(i).getText());
            System.out.println("Title : " + httpClient.executeTranslate(articleTitle.get(i).getText()));
        }
        return this;
    }

    public ArticlePage getArticleContent(Integer articlesToPrint){
        articleContent = new HashMap<>();
        for (int i = 0; i <articlesToPrint; i++) {
            articleContent.put(articleTitle.get(i).getText(), articleText.get(i).getText());
            System.out.println("Title : " + articleTitle.get(i).getText());
            System.out.println("Content : " + articleText.get(i).getText());
        }
        return this;
    }

    public void getRepeatedWords(Integer articlesToPrint) throws IOException, InterruptedException {
        String[] words;
        String translatedArticleTitle;
        String combinedHeader = null;

        wordCounter = new HashMap<>();
        httpClient = new HTTPClient();
        for (int i = 0; i < articlesToPrint; i++) {
            translatedArticleTitle = httpClient.executeTranslate(articleTitle.get(i).getText());
            combinedHeader = combinedHeader + " " + translatedArticleTitle;
        }
        System.out.println(combinedHeader);
        words = combinedHeader.replaceAll("[^a-zA-Z0-9 ]", "").split(" ");
        for (String word : words) {
            if(wordCounter.containsKey(word.toLowerCase()))
                wordCounter.put(word.toLowerCase(), wordCounter.get(word.toLowerCase()) + 1);
            else wordCounter.put(word.toLowerCase(), 1);

        }
        for (String word : wordCounter.keySet())
        {
            if(wordCounter.get(word) > 1)
            System.out.println("Word: " + word + " Count:" + wordCounter.get(word));
        }
    }
}
