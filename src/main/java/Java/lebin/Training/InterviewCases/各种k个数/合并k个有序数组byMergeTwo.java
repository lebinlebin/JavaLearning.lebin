package Java.lebin.Training.InterviewCases.各种k个数;

import java.util.Arrays;

public class 合并k个有序数组byMergeTwo {
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
    //最大长度 k x n
/*
时间复杂度：
假设每个数组的最长长度是 n。
在第一次合并，两个n长度的数组合并，ans 的长度为 2n；
第二次合并，ans 的长度为 2×n，和长度维n的数组合并。
第 i 次合并，ans 的长度为 i×n 和长度维n的数组合并。
第 i 次合并的时间代价是 O(i×n)，那么总的时间代价为 2n + 3n + ... + in
一共合并k-1次   --> O(∑i=1,k (i×n))=O( ((1+k)⋅k)×n/2)=O(k^2*n)，
故渐进时间复杂度为O(k^2*n)。
空间复杂度：没有用到与 k 和 n 规模相关的辅助空间，空间复杂度为 O(1)。
 */
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
