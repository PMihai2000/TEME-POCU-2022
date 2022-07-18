package Generics.Example1.Media;

public abstract class Media {
    protected String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Media{" +
                "title='" + title + '\'' +
                '}';
    }

    public Media(String title) {
        this.title = title;
    }
}
