package Java.lebin.Training.InterviewCases.binarySearch;
/*
1.在有序数组中，给定一个区间范围，找到这个区间范围内数的个数。
例子：数组[1,3,5,8,10,12]。区间[3,10]。输出为4。解法：二分查找，时间复杂度O(longN)。
 */
public class 有序数组中区间范围内数的个数 {
        // 辅助函数：找到目标值在有序数组中的左边界索引
        private static int findLeftBound(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            int result = -1; // 如果目标值不存在，则返回-1

            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] >= target) {
                    right = mid - 1;
                    result = mid; // 更新最近的满足条件的位置
                } else {
                    left = mid + 1;
                }
            }

            // 确保左边界索引是有效的，且指向的值确实在区间内
//            while (result != -1 && result < nums.length && nums[result] < target) {
//                result++;
//            }
            return result;
        }

        // 辅助函数：找到目标值在有序数组中的右边界索引
        private static int findRightBound(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            int result = -1; // 如果目标值不存在，则返回-1

            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] <= target) {
                    left = mid + 1;
                    result = mid; // 更新最近的满足条件的位置
                } else {
                    right = mid - 1;
                }
            }

            // 确保右边界索引是有效的，且指向的值确实在区间内
//            while (result != -1 && result >= 0 && nums[result] > target) {
//                result--;
//            }

            return result;
        }

        // 主函数：找到有序数组中给定区间范围内的数的个数
        public static int countRangeInSortedArray(int[] nums, int leftRange, int rightRange) {
            //寻找左边界和寻找有边界分开写的函数
//            int leftIdx = findLeftBound(nums, leftRange);
//            System.out.println("leftIdx: "+leftIdx);
//            int rightIdx = findRightBound(nums, rightRange);
//            System.out.println("rightIdx: "+rightIdx);
            //寻找左边界和寻找有边界合并到一起写的函数
            int leftIdx = binarySearch(nums, leftRange, true);
            int rightIdx = binarySearch(nums, rightRange, false) - 1;
            // 如果左边界或右边界没找到，或者左边界大于右边界，则区间内没有数
            if (leftIdx == -1 || rightIdx == -1 || leftIdx > rightIdx) {
                return 0;
            }

            // 计算区间内的数的个数（注意要加1，因为区间是闭区间）
            return rightIdx - leftIdx + 1;
        }


    public static int binarySearch(int[] nums, int target, boolean lower) {
        int left = 0, right = nums.length - 1, ans = nums.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target || (lower && nums[mid] >= target)) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

        public static void main(String[] args) {
            int[] nums = {1, 3, 5, 8, 10, 12};
            int leftRange = 2;
            int rightRange = 9;
            int count = countRangeInSortedArray(nums, leftRange, rightRange);
            System.out.println("Count in range [" + leftRange + ", " + rightRange + "]: " + count);
        }
    }