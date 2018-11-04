public class Circle extends Shape
{
    private double radius;//半径
    public Circle(double r)
    {
        this.radius = r;
    }

    public double getArea()
    {
        return this.radius*this.radius*Math.PI;
    }
}
