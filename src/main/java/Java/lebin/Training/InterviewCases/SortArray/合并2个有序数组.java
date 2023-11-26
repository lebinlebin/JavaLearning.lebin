package Java.lebin.Training.InterviewCases.SortArray;

import Java.lebin.Training.InterviewCases.LinkedList.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**

 */
public class 合并2个有序数组 {
    //和归并排序的思想差不多，归并排序也用到了合并有序数组
    public static int[] merge(int[] arr1, int[] arr2){
        int length1 = arr1.length;
        int length2 = arr2.length;

        int[] arr = new int[length1 + length2];
        int j = 0;
        int k = 0;
        int i = 0;
        while (j < length1 && k < length2){
            if (arr1[j] <= arr2[k]){
                arr[i] = arr1[j];
                i++;
                j++;
            }else {
                arr[i] = arr2[k];
                i++;
                k++;
            }
        }
        //把还没有进行合并的元素直接添加到新数组的后面
        while (j < length1){
            arr[i] = arr1[j];
            i++;
            j++;
        }
        while (k < length2){
            arr[i] = arr2[k];
            i++;
            k++;
        }

        return arr;
    }

    public static  int[] mergekSortedArrays(int[][] arrays) {
        int[] ans = new int[] {};
        for (int i = 0; i < arrays.length; ++i) {
            ans = merge(ans, arrays[i]);
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] arr1 = {1,3,5,6};
        int[] arr2 = {1,2,5,7};
        int[] arr3 = {3,6,9,11};
        int[] arr4 = {5,7,13,17};
        int[][] arrays = {arr1,arr2,arr3,arr4};
        int[] merge = mergekSortedArrays(arrays);
        System.out.println(Arrays.toString(merge));
    }
}
