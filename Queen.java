package Submit;

class Qun {
   
   
 public static void SolveQueen(int[][] d) {
    int count = 0;
    int ix = 0, iy = 0;
    PointStack st = new PointStack(d.length);
    Point O = new Point(0,0);
    d[ix][iy]=1;count++;st.push(O);
    int cx = ix;int cy = iy;
    while(count<8) { 
    	cx++;cy=0;
    	while(cx<8) { 
    		cy = NextMove(d, cx, cy);
              while(cy<8) {
                  d[cx][cy]=1;
                  count++;
                  Point px = new Point(cx, cy);
                  st.push(px);
                  break;
              	}
                 if (cy != d.length) {
                	 break;
                 }
                 else if (cy == d.length) {
                    O = st.pop();count--;cx=O.getX();cy=O.getY();d[cx][cy]=0;cy++;
                 }
              }
          }
    }

 public static boolean checkRow(int[][] d, int crow) {
    for (int i = 0; i < d[0].length; i++)
       if (d[crow][i] == 1)
          return false;
    return true;

 }

 public static boolean checkCol(int[][] d, int ccol) {
    for (int i = 0; i < d.length; i++)
       if(d[i][ccol] == 1)
          return false;
    return true;
 }

 public static boolean checkDiagSW(int[][] d, int cx, int cy) { // x++,
    for (int i = cx, j = cy; 0 <= i && i < 8 && 0 <= j && j <= 7; i++, j--)
       if (d[i][j] == 1)
          return false;
    for (int i = cx, j = cy; 0 <= i && i < 8 && 0 <= j && j <= 7; i--, j++)
       if (d[i][j] == 1)
          return false;
    return true;
 }

 public static boolean checkDiagSE(int[][] d, int cx, int cy) {// x++,
    // y++
    // or
    // x--,
    // y--

    for (int i = cx, j = cy; 0 <= i && i < 8 && 0 <= j && j <= 7; i++, j++)
       if (d[i][j] == 1)
          return false;
    for (int i = cx, j = cy; 0 <= i && i < 8 && 0 <= j && j <= 7; i--, j--)
       if (d[i][j] == 1)
          return false;

    return true;
 }

 public static boolean CheckMove(int[][] d, int x, int y) {// (x,y)로 이동
    // 가능한지를
    // check
    if (checkRow(d, x) && checkCol(d, y) && checkDiagSE(d,x, y)
          && checkDiagSW(d, x, y))
       return true;
    return false;

 }

 public static int NextMove(int[][] d, int row, int col) {
    // 특정 row에 대하여 col을 이동하여 이동할 체크하고 위치 col을 리턴한다
    while (col < d.length) {
       if (CheckMove(d, row, col))
        return col;
          col++;
    }
    return d.length;// 
 }

}

public class Queen{
 public static void main(String[] args) {
    int row = 8, col = 8;
    int[][] data = new int[row][col];

    for (int i = 0; i < data.length; i++)
       for (int j = 0; j < data[0].length; j++)
          data[i][j] = 0;

    Qun.SolveQueen(data);

    for (int i = 0; i < data.length; i++) {
       for (int j = 0; j < data[0].length; j++) {
          System.out.print(" " + data[i][j]);
       }
       System.out.println();
    }
 }

}



