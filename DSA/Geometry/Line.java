package DSA.Geometry;

class Line {
    double a, b, c;
    final double EPS = 1e-9;

    public Line(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Line(Point p1, Point p2) {
        if (Math.abs(p1.x - p2.x) < EPS) {
            a = 1.0;
            b = 0.0;
            c = -p1.x;
        } else {
            a = -1.0 * (p1.y - p2.y) / (p1.x - p2.x);
            b = 1.0;
            c = -1.0 * (a * p1.x) - p1.y;
        }
    }

    // Parallel Lines check
    public boolean isParallel(Line l) {
        return Math.abs(a - l.a) < EPS && Math.abs(b - l.b) < EPS;
    }

    // Same Lines check
    public boolean isSame(Line l) {
        return isParallel(l) && Math.abs(c - l.c) < EPS;
    }

    // Intersection Point
    public double[] intersectionPoint(Line l)
    {
        //  Solve system of two linear algebraic equations with two unknowns: a1x + b1y + c1 = 0 and a2x + b2y + c2 = 0.
        if(isSame(l) || isParallel(l)) return new int[]{};
        double point[] = {0.0,0.0};
        point[0] =  (l.b * c - b * l.c) / (l.a * b - a * l.b);

        // special case: test for vertical line to avoid division by zero
        if(Math.abs(b) > EPS) point[1] = -(a * point[0] + c);
        else                  point[1] = -(l.a * point[0] + l.c);

        return point;

    }

}
