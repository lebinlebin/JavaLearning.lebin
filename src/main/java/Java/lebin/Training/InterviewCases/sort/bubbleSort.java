package Java.lebin.Training.InterviewCases.sort;

import java.util.Arrays;
//时间复杂度：O(n^2)
//空间复杂度：O(1)
//冒泡排序需要进行n-1趟冒泡，每一趟需要比较n-i次，最坏情况下需要交换n-1次，故时间复杂度为O(n^2)。冒泡排序的空间复杂度是O(1)，因为只需要使用一个临时变量即可。
public class bubbleSort {
    public static void bubbleSort(int[] arr){
        for(int end = arr.length-1; end > 0; end--){
            boolean changed = false;
            for(int start = 0; start < end; start++){
                if(arr[start] > arr[start+1]){//第一遍选出最大的，放到最后边，那么下一轮循环就是循环length-1轮
                    int t = arr[start+1];
                    arr[start+1] = arr[start];
                    arr[start]=t;
                    changed=true;
                }
            }
            //扫描一遍是有序的那么就return
            if(changed == false) return;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,3,2,4,5,6,8};
        System.out.println(Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
