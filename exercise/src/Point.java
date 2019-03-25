

public abstract class Point
{
    protected int px;
    protected int py;

    public Point(int px, int py) {
        this.px = px;
        this.py = py;
    }

    public abstract double getDistance(Point p);
    public abstract int greyscaleDiff(Point p);
    public abstract int getGreyscale();
}

