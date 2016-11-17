package Matrix;
//matrix multiplication in multithreading
public class MainMatrix {
    private int[][] arrC;

    MainMatrix(int n, int m){
        this.arrC = new int[n][m];
    }

    public int getIndex(int n, int m){
        return arrC[n][m];
    }

    public void setIndex(int n, int m, int res){
        arrC[n][m] = res;
    }

}
