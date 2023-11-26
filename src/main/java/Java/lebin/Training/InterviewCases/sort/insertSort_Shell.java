package Java.lebin.Training.InterviewCases.sort;

import java.util.Arrays;
/*
直接插入排序本身还不够高效，插入排序每次只能将数据移动一位。当有大量数据需要排序时，会需要大量的移位操作。
但是插入排序在对几乎已经排好序的数据操作时，效率很高，几乎可以达到线性排序的效率。所以，如果能对数据进行初步排列达到基本排序，
然后再用插入排序就会大大提高排序效率。希尔排序正是基于此思路而形成的。
(1). 把元素按步长gap分组，gap的数值其实就是分组的个数。gap的起始值为数列长度的一半，每循环一轮gap减为原来的一半。
(2). 对每组元素采用直接插入排序算法进行排序。
(3). 随着步长逐渐减小，组就越少，组中包含的元素就越多。
(4). 当步长值减小到1时，整个数据合成一组，最后再对这一组数列用直接插入排序进行最后的调整，最终完成排序。
 */
public class insertSort_Shell {
    //希尔排序：
    //时间复杂度：O(n^1.3)
    //空间复杂度：O(1)
    //希尔排序是一种特殊的插入排序，通过缩小步长来完成排序过程，使得序列在初始阶段有序，之后进行的插入排序就会更快。
    // 希尔排序的时间复杂度约为O(n^1.3)，空间复杂度与插入排序一样为O(1)。
    public static void shellSort(int[] arr){
        int temp=0;
//        int count=0;
        //步长
        for (int gap= arr.length/2;gap>=1;gap=gap/2){
//            count++;
            for (int i=gap; i< arr.length; i++){
                //分组
                for (int j = i-gap; j>=0; j = j-gap){
                    if (arr[j] > arr[j + gap]){//左边大于右边，需要交换
                        temp = arr[j];
                        arr[j] = arr[j+gap];
                        arr[j+gap] = temp;
                    }
                }
            }
//            System.out.println("第"+count+"轮排序后的数据：");
//            System.out.println(Arrays.toString(arr));
        }

    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 1, 5, 3};
        shellSort(arr);
        System.out.println(Arrays.toString(arr)); // 输出 [1, 2, 3, 4, 5]
    }
}
