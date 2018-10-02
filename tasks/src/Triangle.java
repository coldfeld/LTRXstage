public class Triangle {
    TPoint[] vertexes;

    public Triangle(TPoint[] _vertex) {
        if (_vertex.length == 3) this.vertexes = (TPoint[]) _vertex.clone();
        else throw new IllegalArgumentException("Triangle should have 3 vertexes points.");
    }

    public Triangle(TPoint a, TPoint b, TPoint c) {
        TPoint[] vertexes = new TPoint[]{a, b, c};
        this.vertexes = vertexes;
    }

    static double dist(TPoint a, TPoint b) {
        return Math.sqrt(Math.pow((a.X - b.X), 2) + Math.pow((a.Y - b.Y), 2));
    }

    static double p(TPoint a, TPoint b, TPoint c) {
        return dist(a, b) + dist(b, c) + dist(c, a);
    }

    static double s(TPoint a, TPoint b, TPoint c) {
        double p = p(a, b, c) / 2d;
        return Math.sqrt(p * (p - dist(a, b)) * (p - dist(a, c)) * (p - dist(b, c)));
    }

    boolean isBelong(TPoint t) {
        double d = 0.0000000001;// возьмем за погрешность двоичных вычислений при
                                // сравнении площадей образованных проверяемой точкой треугольников
        if (this.vertexes != null) {
            double t1 = s(this.vertexes[0], this.vertexes[1], t);
            double t2 = s(this.vertexes[0], this.vertexes[2], t);
            double t3 = s(this.vertexes[1], this.vertexes[2], t);
            double t0 = s(this.vertexes[0], this.vertexes[1], this.vertexes[2]);
            if (Math.abs(t1 + t2 + t3 - t0) < d) return true; else return false;
        } else throw new IllegalArgumentException();
    }
}
