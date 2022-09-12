package DSA.Geometry;
import java.util.*;
// REFER OneNote for explanations
class Point implements Comparable<Point>{
    int x, y;
    public Point(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    // COMPARATOR
    public int compareTo(Point p)
    {
        if(this.x == p.x)
            return Integer.compare(this.y, p.y);
        return Integer.compare(this.x, p.x);
    }
    // EQUALS CHECK
    @Override
    public boolean equals(Object o)
    {
        Point p = (Point) o;
        return x == p.x && y == p.y;
    } 
    public int hashCode()
    {
        return Objects.hash(x,y);
    }
    // DISTANCE FROM ANOTHER POINT
    public double dist(Point p)
    {
        return Math.hypot(x - p.x, y - p.y);
    }
    // Rotate Point theta degrees about origin
    // public Point rotate(double theta)
    // {
    //     double rad = Math.toRadians(theta);
    //     double sin = Math.sin(rad), cos = Math.cos(rad);
    //     return new Point(x*cos - y*sin, x*sin + y*cos);
    // }
}
