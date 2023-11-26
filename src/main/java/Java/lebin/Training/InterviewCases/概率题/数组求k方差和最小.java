package Java.lebin.Training.InterviewCases.概率题;
/**
 * 给你一个数组，求一个k值，使得前k个数的方差 + 后面n-k个数的方差最小 。
 */
public class 数组求k方差和最小 {
    int minVar(float[] a, int n) {
        float[] left = new float[n];
        float[] right = new float[n];
        float leftsum = 0;
        float rightsum = 0;
        float leftSquareSum = 0;
        float rightSquareSum = 0;
        int len = a.length;
        for (int i = 0; i < len; i++) {
            leftsum += a[i];
            leftSquareSum += a[i] * a[i];
            left[i] = leftSquareSum / (i + 1) - (leftsum / (i + 1)) * (leftsum / (i + 1));
        }

        for (int i = n - 1; i >= 0; i--) {
            rightsum += a[i];
            rightSquareSum += a[i] * a[i];
            right[i] = rightSquareSum / (n - i) - (rightsum / (n - i)) * (rightsum / (n - i));
        }
        //错位相加
        for (int i = 0; i < len - 1; i++) {
            left[i] += right[i + 1];
        }

        float minvar = left[0];
        int pos = 0;
        for (int i = 0; i < left.length; i++) {
            if (minvar > left[i]) {
                minvar = left[i];
                pos = i;
            }
        }
        System.out.println("minVar:" + pos + 1);
        return pos + 1;
    }

    public static void main(String[] args) {
            float[] a = new float[]{1,2,3,4,5,11,12,13,14,15};

    }
}
