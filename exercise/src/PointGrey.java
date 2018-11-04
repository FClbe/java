
public class PointGrey extends Point
{
    private int greyscale;//0-255

    public PointGrey(int px, int py, int greyscale)
    {
        super(px ,py);

        this.greyscale = greyscale;
    }

    public int getGreyscale()
    {
        return greyscale;
    }

    public double getDistance(Point p) {
        return (int) Math.sqrt(Math.pow((this.px - p.px), 2) + Math.pow((this.py - p.py), 2));
    }

    public int greyscaleDiff(Point p) {
        return this.greyscale - p.getGreyscale();
    }
}