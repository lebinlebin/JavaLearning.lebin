package Java.lebin.Training.InterviewCases.sort;

import Java.lebin.Training.DSA._14_Sort.sort.Sort;

import java.util.Arrays;
//时间复杂度：O(nlogn)
//空间复杂度：O(logn)
//快速排序的时间复杂度为O(nlogn)，空间复杂度为O(logn)。快速排序的效率高于归并排序，但在最坏情况下的时间复杂度为O(n^2)。
public class QuickSort {
	/**
	 * 对 [begin, end) 范围的元素进行快速排序
	 */
	private static void sort(int begin, int end, int[] array) {
		if (end - begin < 2) return;
		//前序遍历逻辑
		// 确定轴点位置 O(n)
		int mid = pivotIndex(begin, end, array);
		// 对子序列进行快速排序
		sort(begin, mid, array);
		sort(mid + 1, end, array);
	} 
	
	/**
	 * 构造出 [begin, end) 范围的轴点元素
	 * @return 轴点元素的最终位置
	 */
	private static int pivotIndex(int begin, int end, int[] array) {
		// 备份begin位置的元素
		// 也可以随机选择一个元素跟begin位置进行交换
		int pivot = array[begin];
		// end指向最后一个元素。我们的元素都是左闭右开的。所以先把end--,才能进行接下来的工作
		end--;

		while (begin < end) {
			// 从右向左
			while (begin < end) {
				if (pivot < array[end]) { // 右边元素 > 轴点元素
					end--;
				} else { // 右边元素 <= 轴点元素 交换并且begin++
					array[begin] = array[end];
					begin++;
					break;
				}
			}
			 // 从左向右
			while (begin < end) {
				if (pivot > array[begin]) { // 左边元素 < 轴点元素
					begin++;
				} else { // 左边元素 >= 轴点元素
					array[end] = array[begin];
					end--;
					break;
				}
			}
		}
		//返回轴点元素的位置index
		// 将轴点元素放入最终的位置
		array[begin] = pivot;//放到begin和end都可以
		// 返回轴点元素的位置
		return begin;//begin和end是重合的
	}

	public static void main(String[] args) {
		int[] array  = new int[]{1,3,2,4,56,65,43,23,1,2};
		//左闭右开
		sort(0, array.length,array);
		System.out.println(Arrays.toString(array));
	}
}
