package Java.lebin.Training.InterviewCases.sort;

import Java.lebin.Training.DSA._14_Sort.sort.Sort;

import java.util.Arrays;

//时间复杂度：O(nlogn)
//空间复杂度：O(n)
//归并排序的时间复杂度为O(nlogn)，空间复杂度为O(n)，因为需要额外使用一个与原序列同样大小的辅助数组。
public class MergeSort {

	/**
	 * 对 [begin, end) 范围的数据进行归并排序
	 */
	private static void sort(int begin, int end, int[] array) {
		System.out.println("begin:"+begin + "   end:"+end);
		if (end - begin < 2) return;//终止条件
		int mid = (begin + end) >> 1;
		System.out.println("mid: "+mid);
		sort(begin, mid, array);
		sort(mid, end, array);
		merge(begin, mid, end, array);//一开始只有两个数进行merge
	}
	/**
	 * 将 [begin, mid) 和 [mid, end) 范围的序列合并成一个有序序列
	 */
	private static void merge(int begin, int mid, int end, int[] array) {
		int li = 0;//左边起始位置
		int le = mid - begin;//左边截止位置

		int ri = mid;//右边开始位置
		int re = end;//右边截止位置
		//mid放在右边；左闭右开

		int ai = begin;
		int[] leftArray = new int[array.length>>1];//左边部分

		// 备份左边数组
		for (int i = li; i < le; i++) {
			leftArray[i] = array[begin + i];
		}

		// 如果左边还没有结束
		while (li < le) {
			if (ri < re && (array[ri] < leftArray[li])) {
				array[ai++] = array[ri++];
			} else {
				array[ai++] = leftArray[li++];
			}
		}

	}


	public static void main(String[] args) {
		int[] array = new int[]{1, 3, 2, 4, 6, 11, 23, 42, 22, 31};
		sort(0, array.length, array);
		System.out.println(Arrays.toString(array));
	}
}
