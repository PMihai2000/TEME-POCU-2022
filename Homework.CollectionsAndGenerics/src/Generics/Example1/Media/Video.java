package Generics.Example1.Media;

public class Video extends Media{
    private float duration;
    private String description;
    private String videoURL;

    public Video(String title, float duration, String description, String videoURL) {
        super(title);
        this.duration = duration;
        this.description = description;
        this.videoURL = videoURL;
    }

    public float getDuration() {
        return duration;
    }

    public void setDuration(float duration) {
        this.duration = duration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVideoURL() {
        return videoURL;
    }

    public void setVideoURL(String videoURL) {
        this.videoURL = videoURL;
    }

    @Override
    public String toString() {
        return "Video{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", videoURL='" + videoURL + '\'' +
                ", duration=" + duration +
                '}';
    }
}
