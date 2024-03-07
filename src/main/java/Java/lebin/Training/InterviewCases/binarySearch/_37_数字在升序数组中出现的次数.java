package Java.lebin.Training.InterviewCases.binarySearch;

/**
 统计一个数字在升序数组中出现的次数。
 示例1
 输入：
 [1,2,3,3,3,3,4,5],3
 返回值：
 4
 解题思路
 正常的思路就是二分查找了，我们用递归的方法实现了查找k第一次出现的下标，用循环的方法实现了查找k最后一次出现的下标。
 除此之外，还有另一种奇妙的思路，因为data中都是整数，所以我们不用搜索k的两个位置，
 而是直接搜索k-0.5和k+0.5这两个数应该插入的位置，然后相减即可。
 */
//时间复杂度:O(logn)
//空间复杂度: O(1)
public class _37_数字在升序数组中出现的次数 {
	public int GetNumberOfK(int [] array , int k) {
		return biSearch(array, k+0.5) - biSearch(array, k-0.5);
	}
	public int biSearch(int [] array, double k){
		int start  = 0, end = array.length - 1;
		while(start <= end){
			int mid = start + (end - start)/2;
			if(array[mid] > k){
				end = mid - 1;
			}else{
				start = mid + 1;
			}
		}
		return start;
	}
}


