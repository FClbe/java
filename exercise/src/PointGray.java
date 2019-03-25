package abstractClasses;

public class PointGrey extends abstractClasses.Point
{
    private int greyscale;//0-255
    public PointGrey (int Apx, int Apy, int Agreyscale)
    {
        this.px = Apx;
        this.py = Apy;
        greyscale = Agreyscale;
    }
    public double getDistance(PointGrey p)
    {
        return (int)Math.sqrt((this.px - p.px)^2 + (this.py - p.py)^2);
    }
    public int greyscaleDiff(PointGrey p)
    {
        return this.greyscale - p.greyscale;
    }
}