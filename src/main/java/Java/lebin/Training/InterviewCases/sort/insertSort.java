package Java.lebin.Training.InterviewCases.sort;

import java.util.Arrays;

public class insertSort {
    //从小到大排序
    //空间复杂度 O(1)
    // 时间复杂度：O(n^2)
    //最好情况时间复杂度：当待排序序列已经有序时，插入排序的时间复杂度为 O(n)，即最优情况下的时间复杂度。
    //最坏情况时间复杂度：当待排序序列是逆序的时，插入排序的时间复杂度为 O(n^2)，即最坏情况下的时间复杂度。
    // 平均情况时间复杂度：插入排序的平均情况时间复杂度为 O(n^2)。
    // 适用性：插入排序适用于小规模的数据排序，对于大规模数据排序效率较低。在实际应用中，插入排序通常用作其他排序算法的辅助排序算法，例如快速排序的子过程。
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;//key插入到前边
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 1, 5, 3};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr)); // 输出 [1, 2, 3, 4, 5]
    }
}
