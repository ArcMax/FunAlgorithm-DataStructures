package Recursion.WhiteBoard.Week4.HomeWork;

public class MedianOfTwoSortedArray {
    public static void main(String[] args) {
        int[] a = {-5, 3, 6, 12, 15};
        int[] b = {-12, -10, -6, -3, 4, 10};
        System.out.print(findMedian(a, b));
    }

    /*Time Complexity is O(n+m) How can you do better*/
    static int findMedian(int[] a, int[] b) {
        int asize = a.length;
        int bsize = b.length;
        int csize = asize + bsize;

        int median;
        if (csize % 2 == 0) {
            median = (csize / 2) - 1;

        } else {
            median = csize / 2;
        }
        int[] c = new int[median + 1];
        int i = 0, j = 0, k = 0;
        while (k < c.length) {
            if (a[i] < b[j]) {
                c[k] = a[i];
                i++;
            } else {
                c[k] = b[j];
                j++;
            }
            k++;
        }
        return c[c.length - 1];
    }

    
}
