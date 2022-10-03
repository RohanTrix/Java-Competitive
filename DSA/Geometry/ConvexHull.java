package DSA.Geometry;
import java.util.*;
// REFER : Coding Minutes for logic
public class ConvexHull {
     
    // We are considering collinear points as well in this
    public List<Point> convexHull(Point points[])
    {
        int n = points.length;
        Arrays.sort(points);
        List<Point> up = new ArrayList<>(), down = new ArrayList<>();
        
        Point first = points[0], last = points[n-1];
        up.add(first); down.add(first);
        
        for(int i = 1; i<n; i++)
        {
            if(i == n-1 || !anticlockwise(first, points[i], last)) // Means clockwise and collinear considered
            {
                //down set
                while(up.size()>=2 && anticlockwise(up.get(up.size() - 2), up.get(up.size() - 1), points[i]))
                    up.remove(up.size() - 1);
                up.add(points[i]);
            }
            if(i == n-1 || !clockwise(first, points[i], last))
            {
                // up set
                while(down.size()>=2 && clockwise(down.get(down.size() - 2), down.get(down.size() - 1), points[i]))
                    down.remove(down.size() - 1);
                down.add(points[i]);
            }
        }
        Set<Point> set = new HashSet<>();
        for(Point p : up)
            set.add(p);
        for(Point p : down)
            set.add(p);
        
        return new ArrayList<>(set);
    }
    public boolean clockwise(Point a, Point b, Point c)
    {
        return a.x * (c.y - b.y) + b.x * (a.y - c.y) + c.x * (b.y - a.y) > 0;
    }
    public boolean anticlockwise(Point a, Point b, Point c)
    {
        return a.x * (c.y - b.y) + b.x * (a.y - c.y) + c.x * (b.y - a.y) < 0;
    }
    public boolean colinear(Point a, Point b, Point c)
    {
        return a.x * (c.y - b.y) + b.x * (a.y - c.y) + c.x * (b.y - a.y)  == 0;
    }

    
    private class Point implements Comparable<Point>
    {
        int x, y;
        public Point(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
        public int compareTo(Point that)
        {
            if(this.x == that.x)
                return this.y - that.y;
            return this.x - that.x;
        }
        @Override
        public boolean equals(Object o)
        {
            Point that = (Point) o;
            return this.x == that.x && this.y == that.y;
        } 
        public int hashCode()
        {
            return Objects.hash(x,y);
        }
    }
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Point points[] = new Point[n];
        for(int i = 0; i<n; i++)
        {
            points[i] = new Point(sc.nextInt(), sc.nextInt());
        }
        ConvexHull ob = new ConvexHull();
        System.out.println(ob.convexHull(points)); 
    }
}
