package Java.lebin.Training.InterviewCases.binarySearch;

public class _153_寻找旋转排序数组中的最小值 {
    public static int minArray(int[] array) {
        int left = 0;
        int right = array.length-1;
        //		左闭右开
        while (left < right){//终止条件  left == right
            int mid = left +((right-left)>>1);
            //判定是属于前边部分还是后边部分，不管是和right比还是和left比都是要判定属于哪一部分
            if(array[mid] > array[right]){//前边部分，大的部分
                left = mid+1;//left 是可以取到的所以需要+1
            }else if(array[mid] < array[right]){//后边部分
                right = mid;//右边是取不到的所以不需要+1
            }else if(array[mid] == array[right]){//存在两个连续值相等的情况，直接让右侧向左移动即可
                right--;
            }
        }
        return array[left];//为什么返回的是 left？？？？？
    }




    public static int minArray2(int[] array) {
        int left = 0;
        int right = array.length-1;
        while (left <= right){//终止条件  left == right +1
            int mid = left +((right-left)>>1);
            //判定是属于前边部分还是后边部分，不管是和right比还是和left比都是要判定属于哪一部分
            if(array[mid] > array[right]){//前边部分，大的部分
                left = mid+1;//left 是可以取到的所以需要+1
            }else if(array[mid] < array[right]){//后边部分，这里mid不确定是不是最小值，所以mid还要保留，
                right = mid;//这里mid不确定是不是最小值，所以mid还要保留，right = mid而不是right = mid-1
            }else if(array[mid] == array[right]){//存在两个连续值相等的情况，直接让右侧向左移动即可
                right--;//第一个比比最小值大的数，应该return right+1的位置，而终止条件正好是left == right +1 ，所以retur  narray[left]
            }
        }
        return array[left];//为什么返回的是 left？？？？？
    }
}
