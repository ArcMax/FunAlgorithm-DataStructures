package Recursion;

public class NumberOfIsland {

    static int getNumberOfIslands(int[][] binaryMatrix) {
        int m = binaryMatrix.length;
        int n = binaryMatrix[0].length;
        int[][] visited = new int[m][n];
        int count = 0;
        for(int row = 0 ; row < binaryMatrix.length ; row++){
            for(int col = 0 ; col <binaryMatrix[0].length ; col++){

                if(binaryMatrix[row][col] == 1){
                    if(visited[row][col] != binaryMatrix[row][col]){
                        dfs(binaryMatrix, row,col, visited);
                        count++;
                    }
                }
            }
        }

        return count;
    }

    static void dfs(int[][] binaryMatrix , int row, int col, int[][] visited ){

        if( row >= binaryMatrix.length  || col >= binaryMatrix[0].length){
            return;
        }else {
            if (visited[row][col] != binaryMatrix[row][col]) {
                visited[row][col] = binaryMatrix[row][col];
            }

            dfs(binaryMatrix, row, col + 1, visited);
            dfs(binaryMatrix, row, col - 1, visited);
            dfs(binaryMatrix, row - 1, col, visited);
            dfs(binaryMatrix, row + 1, col, visited);
        }

    }

    public static void main(String[] args){
        int[][] binaryMatrix = new int[][] {{0,    1,    0,    1,    0},
                {0,    0,    1,    1,    1},
                {1,    0,    0,    1,    0},
                {0,    1,    1,    0,    0},
                {1,    0,    1,    0,    1} };

        System.out.println(getNumberOfIslands(binaryMatrix));
    }
}
