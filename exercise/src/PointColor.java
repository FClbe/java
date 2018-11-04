

public class PointColor extends Point
{

    private int ared;
    private int ablue;
    private int ayellow;
    private int greyscale;
    public PointColor(int px, int py, int Ared, int Ablue, int Ayellow)
    {
        super(px, py);
        this.ared = Ared;
        this.ablue = Ablue;
        this.ayellow = Ayellow;
        this.greyscale = (Ared + Ablue + Ayellow)/3;
    }

    @Override
    public int getGreyscale()
    {
        return greyscale;
    }

    public double getDistance(Point p) {
        return Math.sqrt(Math.pow((this.px - p.px), 2) + Math.pow((this.py - p.py), 2));
    }

    public int greyscaleDiff(Point p)
    {
        return this.greyscale - p.getGreyscale();
    }
}
