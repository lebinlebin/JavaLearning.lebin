package Java.lebin.Training.InterviewCases.sort;

import java.util.Arrays;
//主要思想是在第n轮中选择第n小（或大）的数据元素，并存放在其相应的位置。
//时间复杂度：O(n^2)
//空间复杂度：O(1)
public class SelectionSort {
    //每次选择最小的元素放到前边
    public static void selectionSort(int[] arr){
        //需要遍历获得最小值的次数
        if (arr.length <= 1) return;

        for (int i = 0; i < arr.length-1; i++){
            int temp = 0;
            int index = i;     //选择当前值为最小值索引
            for (int j = i + 1; j < arr.length; j++){
                if (arr[index] > arr[j]){
                    index = j;  //修改最小值索引，扫描一遍找到最小的索引
                }
            }
            //把最小的数与当前数进行交换
            temp = arr[index];
            arr[index] = arr[i];
            arr[i] = temp;
        }

    }





    public static void main(String[] args){
        int[] arr={4,3,6,5,7,8,2,10,2,9};
        selectionSort(arr);
        for (int num:arr){
            System.out.print(num+" ");
        }
    }
}
