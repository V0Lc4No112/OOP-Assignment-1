public class Rectangle {

    private double width;
    private double height;
    private final int id = idGen++;
    private static int idGen = 1;

    public Rectangle() {
        this.width = 1.0;
        this.height = 1.0;
    }

    public Rectangle(double width, double height) {
        this();
        setWidth(width);
        setHeight(height);
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public int getId() {
        return id;
    }

    public void setWidth(double width) {
        if (width <= 0) {
            throw new IllegalArgumentException("Width must be greater than 0");
        }
        this.width = width;
    }

    public void setHeight(double height) {
        if (height <= 0) {
            throw new IllegalArgumentException("Height must be greater than 0");
        }
        this.height = height;
    }

    public double area() {
        return width * height;
    }

    public double perimeter() {
        return 2 * (width + height);
    }

    @Override
    public String toString() {
        return String.format("Rectangle[id=%d, width=%.2f, height=%.2f]",
                id, width, height);
    }
}