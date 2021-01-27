package Geometry;
public class Geometry
{
    public static void main(String args[])
    {

    }
}
class Point implements Comparable<Point>
{
    final double INF = 1e9;
    final double EPS = 1e-9; // Epsilon to take care of the small error in floating numbers
    double x,y; 
    Point(double _x, double _y)
    {
        this.x = _x; this.y = _y;
    }
    public int compareTo(Point other)
    {
        if(Math.abs(this.x - other.x) > EPS)
            return (int)Math.ceil(this.x - other.x);   // first: Sorting by x-coordinate
        else if (Math.abs(y - other.y) > EPS)
            return (int)Math.ceil(y - other.y);        // second: Sorting by y-coordinate
        else
            return 0;
    }
    double dist(Point p1, Point p2) // Euclidean distance 
    { return Math.hypot(p1.x - p2.x, p1.y - p2.y); } // Math.hypot(dx, dy) returns sqrt(dx * dx + dy * dy)

}