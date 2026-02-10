package geometry;

class SquareCheckSimple {

    static int distSq(int x1, int y1, int x2, int y2) {
        return (x1 - x2)*(x1 - x2) + (y1 - y2)*(y1 - y2);
    }

    public static void main(String[] args) {

        int[][] p = {{20,10},{10,20},{20,20},{10,10}};

        int d1 = distSq(p[0][0], p[0][1], p[1][0], p[1][1]);
        int d2 = distSq(p[0][0], p[0][1], p[2][0], p[2][1]);
        int d3 = distSq(p[0][0], p[0][1], p[3][0], p[3][1]);
        int d4 = distSq(p[1][0], p[1][1], p[2][0], p[2][1]);
        int d5 = distSq(p[1][0], p[1][1], p[3][0], p[3][1]);
        int d6 = distSq(p[2][0], p[2][1], p[3][0], p[3][1]);

        int[] d = {d1,d2,d3,d4,d5,d6};
        java.util.Arrays.sort(d);

        if (d[0] > 0 && d[0]==d[1] && d[1]==d[2] && d[2]==d[3] && d[4]==d[5])
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}
