package Recursion.WhiteBoard.Week5;

import java.util.*;

class TopoVertex {
    char value;
    List<TopoVertex> neighbour = new ArrayList<>();

    public TopoVertex(char data) {
        this.value = data;
    }
}

public class TopologicalSort {
    public static void main(String args[]) {
        TopoVertex vertex1 = new TopoVertex('a');
        TopoVertex vertex2 = new TopoVertex('b');
        TopoVertex vertex3 = new TopoVertex('c');
        TopoVertex vertex4 = new TopoVertex('d');
        TopoVertex vertex5 = new TopoVertex('e');
        TopoVertex vertex6 = new TopoVertex('f');
        TopoVertex vertex7 = new TopoVertex('g');
        List<TopoVertex> list = new ArrayList<>();
        list.add(vertex1);
        list.add(vertex2);
        list.add(vertex3);
        list.add(vertex4);
        list.add(vertex5);
        list.add(vertex6);
        list.add(vertex7);

        vertex1.neighbour.add(vertex4);
        vertex1.neighbour.add(vertex3);
        vertex1.neighbour.add(vertex2);
        vertex4.neighbour.add(vertex6);
        vertex3.neighbour.add(vertex5);
        vertex7.neighbour.add(vertex6);
        vertex5.neighbour.add(vertex2);
        vertex6.neighbour.add(vertex3);

        inDegree(list);
        int[][] data = new int[][]{{25, 14, 1},
                                   {25, 4, 1},
                                   {25, 2, 1},
                                    {378,10,1},
                {478,18,1},
                {13,1,1},
                {11,7,1},
                {11,7,1}};

        int[][] data1 = new int[][]{{25, 21, 1},
                {25, 4, 0},
                {18, 7, 0}};
//        System.out.print(Arrays.toString(findDiagonalOrder(arr)));
//        System.out.print(spiralOrder(arr));
//            System.out.print(generate(5));
//        System.out.print(addBinary("11", "1"));
     //   System.out.println(findBusiestPeriod1(data));
//        System.out.println(findBusiestPeriod1(data1));
//        System.out.println(numOfPathsToDest(4));
    }



    static int numOfPathsToDest(int n) {
        return numOfPathToDestHelper(n,0,0,new int[n][n]);
    }

    static int numOfPathToDestHelper(int n , int i, int j,int[][] memo){
        // base case : i = 0 & j = 0
        if(i >= n || j >= n){
            return 0;
        }else if(i == n-1 && j == n-1){
            return 1;
        }else if(i == n && j == n){
            return 1;
        }else if(j > i){
            memo[i][j] = 0;
        }

       memo[i][j] = numOfPathToDestHelper(n , i , j+1, memo )+ numOfPathToDestHelper(n, i+1 , j,memo );


        return memo[i][j];
    }


    static int findBusiestPeriod1(int[][] data) {

        int count  = 0;
        int maxCount = 0;
        int maxPeriodTime = 0;

        for(int i = 0 ; i < data.length ; i++){
            if(data[i][2] == 1){
                count+=data[i][1];
            }else if(data[i][2] == 0){
                count -=data[i][1];
            }

            if(i < data.length-1 && data[i][0] == data[i+1][0]){
                continue;
            }

            if(count > maxCount){
                maxCount = count;
                maxPeriodTime = data[i][0];
            }
        }
        return maxPeriodTime;
    }


    static int findBusiestPeriod(int[][] data) {

        // step 1
        // max value variable, keep timestamp
        int maxValue = 0;
        int maxtimeStamp = 0;

        int curtimeStamp = 0;
        int curValue = 0;

        // step 2 : loop through 2d array
        for(int i = 0; i < data.length ; ++i){

            int time = data[i][0];
            int ppl = data[i][1];
            int entry = data[i][2];

            if(curtimeStamp == time){
                if(entry == 1){
                    curValue += ppl;
                }else{
                    curValue -=ppl;
                }
            }else{
                if(maxValue < curValue){
                    maxValue = curValue;
                    maxtimeStamp = curtimeStamp;
                }
                if(entry == 0) {
                    curtimeStamp = time;
                    curValue = 0;
                    curValue -= ppl;
                }else{
                    curtimeStamp = time;   //25
                    curValue = ppl;
                }
            }
        }
        if(maxValue < curValue){
            maxtimeStamp = curtimeStamp;
        }
        return maxtimeStamp;
    }


    static String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1, carry = 0;
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (j >= 0) {
                sum += b.charAt(j--) - '0';
            }
            if (i >= 0) {
                sum += a.charAt(i--) - '0';
            }
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if (carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }

    static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> allrows = new ArrayList<List<Integer>>();
        ArrayList<Integer> row = new ArrayList<Integer>();
        for (int i = 0; i < numRows; i++) {
            row.add(0, 1);
            for (int j = 1; j < row.size() - 1; j++)
                row.set(j, row.get(j) + row.get(j + 1));
            allrows.add(new ArrayList<Integer>(row));
        }
        return allrows;

    }

    static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        if (matrix.length == 0 || matrix[0].length == 0) return res;

        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while (true) {
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }
            top++;
            if (left > right || top > bottom) break;

            for (int i = top; i <= bottom; i++) {
                res.add(matrix[i][right]);
            }
            right--;
            if (left > right || top > bottom) break;

            for (int i = right; i >= left; i--) {
                res.add(matrix[bottom][i]);
            }
            bottom--;
            if (left > right || top > bottom) break;

            for (int i = bottom; i >= top; i--) {
                res.add(matrix[i][left]);
            }
            left++;
            if (left > right || top > bottom) break;
        }

        return res;
    }


    static int[] findDiagonalOrder(int[][] matrix) {
        if (matrix.length == 0)
            return new int[0];

        int result[] = new int[matrix.length * matrix[0].length];
        int curRow = 0;
        int curCol = 0;
        int index = 0;
        boolean isUp = true;
        for (int i = 0; i < matrix.length + matrix[0].length; i++) {
            if (isUp) {
                while (curRow >= 0 && curCol < matrix[0].length) {
                    result[index] = matrix[curRow][curCol];
                    index++;
                    curCol++;
                    curRow--;
                }
                if (curCol == matrix[0].length)
                    curCol = matrix[0].length - 1;
                curRow = i + 1 - curCol;
                isUp = !isUp;
            } else {
                while (curRow < matrix.length && curCol >= 0) {
                    result[index++] = matrix[curRow++][curCol--];
                }
                if (curRow == matrix.length)
                    curRow = matrix.length - 1;
                curCol = i + 1 - curRow;
                isUp = !isUp;
            }
        }
        return result;
    }

    static int[] plusOne(int[] digits) {

        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }

            digits[i] = 0;
        }

        int[] newNumber = new int[n + 1];
        newNumber[0] = 1;

        return newNumber;
    }


    /*find all indegree of vertex*/
    static void inDegree(List<TopoVertex> list) {
        HashMap<TopoVertex, Integer> hashMap = new HashMap<>();
        for (TopoVertex ver : list) {
            hashMap.put(ver, 0);
            for (TopoVertex n : ver.neighbour) {
                if (!hashMap.containsKey(n)) {
                    hashMap.put(n, 1);
                } else {
                    hashMap.put(n, hashMap.get(n) + 1);
                }
            }
        }
        printAllElementesInHashMap(hashMap);
    }


    static void printAllElementesInHashMap(HashMap<TopoVertex, Integer> map) {
        for (Map.Entry entry : map.entrySet()) {
            System.out.println("Key:" + entry.getKey() + "Value" + entry.getValue().toString());
        }

    }
}
