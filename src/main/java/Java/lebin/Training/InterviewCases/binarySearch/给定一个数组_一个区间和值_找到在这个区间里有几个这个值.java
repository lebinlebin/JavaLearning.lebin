package Java.lebin.Training.InterviewCases.binarySearch;
/*
2.给定一个非常长的数组，再给你一个区间及值，找到在这个区间里有几个这个值。

数组：[12,13,10,9,8,12,18,16,12,19]。区间及值：(0,5)，12。输出为2。区间及值：(0,8)，12。输出为3。
 */
public class 给定一个数组_一个区间和值_找到在这个区间里有几个这个值 {
    public static void main(String[] args) {
        int[] array = {12, 13, 10, 9, 8, 12, 18, 16, 12, 19};

        // 测试区间(0,5)，值12，预期输出2
        int count1 = countValueInRange(array, 0, 5, 12);
        System.out.println("Count in range (0,5) for value 12: " + count1);

        // 测试区间(0,8)，值12，预期输出3
        int count2 = countValueInRange(array, 0, 8, 12);
        System.out.println("Count in range (0,8) for value 12: " + count2);
    }

    public static int countValueInRange(int[] array, int start, int end, int value) {
        int count = 0;
        // 确保start和end是有效的索引，并且start不大于end
        if (start < 0 || end >= array.length || start > end) {
            throw new IllegalArgumentException("Invalid range");
        }
        // 遍历区间内的元素并计数
        for (int i = start; i <= end; i++) {
            if (array[i] == value) {
                count++;
            }
        }
        return count;
    }
}