package Collections.Objects;

import java.util.Objects;

public class Rectangle {
    private Point origin;
    private float height;
    private float width;

    public Rectangle(Point origin, float height, float width) {
        this.origin = origin;
        this.height = height;
        this.width = width;
    }

    public Point getOrigin() {
        return origin;
    }

    public void setOrigin(Point origin) {
        this.origin = origin;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "origin=" + origin +
                ", height=" + height +
                ", width=" + width +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return Float.compare(rectangle.height, height) == 0 && Float.compare(rectangle.width, width) == 0 && Objects.equals(origin, rectangle.origin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(origin, height, width);
    }
}
