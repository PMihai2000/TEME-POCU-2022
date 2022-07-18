package Generics.Example1.Media;

import java.util.List;

public class Newspaper extends Media{
    private List<String> articles;
    private String publication;

    public Newspaper(String title, List<String> articles, String publication) {
        super(title);
        this.articles = articles;
        this.publication = publication;
    }

    public List<String> getArticles() {
        return articles;
    }

    public void setArticles(List<String> articles) {
        this.articles = articles;
    }

    public String getPublication() {
        return publication;
    }

    public void setPublication(String publication) {
        this.publication = publication;
    }

    @Override
    public String toString() {
        return "Newspaper{" +
                "title='" + title + '\'' +
                ", articles=" + articles + '\'' +
                ", publication='" + publication +
                '}';
    }
}
