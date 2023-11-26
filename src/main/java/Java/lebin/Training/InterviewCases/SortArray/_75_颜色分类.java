package Java.lebin.Training.InterviewCases.SortArray;


/*
给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * 三指针
 * 指针1:放0的位置
 * 指针2:放2的位置
 * 指针3:扫描数据
 *
 * 遇到1：跳过，扫描指针++
 * 遇到0： 和放0指针交换值，然后放0的指针++、扫描指针++
 * 遇到2：和放2指针交换值，然后放2指针--，再次对扫描指针指向的位置的值进行判断
 *
 */
public class _75_颜色分类 {
	/*
	 * 时间复杂度O(n)
	 * 空间复杂度O(1)
	 * 三指针
	 * 一个指针l标志左侧放0的位置，一个r指针标记放2的位置
	 * 中间i扫描全数组，遇到0与l指针位置进行交换(i指针++)；遇到2与右边r指针位置进行交换{i指针不动，再进行};
	 */
    public void sortColors(int[] nums) {
    	int i = 0;
    	int l = 0;
    	int r = nums.length - 1;
    	while (i <= r) {
    		if (nums[i] == 0) {
    			swap(nums, i++, l++);
    		} else if (nums[i] == 1) {
    			i++;
    		} else {
    			swap(nums, i, r--);
    		}
    	}
    }
    
    private void swap(int[] nums, int i, int j) {
    	int tmp = nums[i];
    	nums[i] = nums[j];
    	nums[j] = tmp;
    }
}
