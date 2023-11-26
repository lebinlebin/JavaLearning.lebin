package Java.lebin.Training.TEST;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

class arrayDouble
{
	public static void main(String[] args) 
	{
//		Double[] PriceWeightRange;
//
//		float[] resultProbDefault = new float[30];
//		/**
//		 * 不需要循环
//		 * 直接打印数组信息
//		 */
////		System.out.println(Arrays.toString(resultProbDefault));
//		for(int i=0;i<1000;i++){
//			System.out.println("ctr--->  "+randomRanker(0.001));
//		}

		String abc = "11";//,22,33,44,55
		String[] ABC = abc.split(",");
		System.out.println(ABC[0]);
		String[]  advaluearr = "12,14".split(",");
		String[] virtualCategoryProfileList = "5,4,13,14,0".split(",");
		double virtualCategoryMatchScore = 0.0;

		/**
		 * 虚拟类目加权
		 */
		if (null != virtualCategoryProfileList) {
			double virtualCategoryPWeight = 2.0;
				for (String virtualCategory : virtualCategoryProfileList) {
					if (null != virtualCategory  && match(advaluearr,virtualCategory)) {
						virtualCategoryMatchScore += virtualCategoryPWeight * 2;
					}
					virtualCategoryPWeight = virtualCategoryPWeight - 0.2;
				}

		}



		System.out.println(virtualCategoryMatchScore);

		int[][] matrx = new int[3][3];

		//初始化
		for(int i = 0;i<3;i++){
			for(int j = 0;j<3;j++){
				matrx[i][j]= i*(matrx[i].length)+j+1;
			}
		}


		//遍历输出
		for(int i = 0;i<3;i++){
			for(int j = 0;j<3;j++){
				System.out.print(matrx[i][j]+"\t");
			}
			System.out.print("\n");
		}
		int[][] abv = transpose(matrx);
		//遍历输出
		System.out.println("==========================");
		for(int i = 0;i<3;i++){
			for(int j = 0;j<3;j++){
				System.out.print(abv[i][j]+"\t");
			}
			System.out.print("\n");
		}




	}
	private static double  randomRanker(double low) {
			String bid = "1.0";
			double R = Math.random()*low;
			double ctr = R;
			return ctr;
			//为保证预估值的6位有效数字*1000
//			double ctr = MathUtils.sigmoidFunction(1000 * R / Double.parseDouble(bid), 0.5);   //二手车 实验  对比纯按ctr排序实验，去掉bid因素。 后期切为ecpm排序记得改回来。
//			//double ctr = R;
//			featureContext.getPredictResult().setCtr(ctr);
//			featureContext.getPredictResult().setQvalue(ctr);
		}


	public static int[][] transpose(int[][] matrix) {
		int col = matrix[0].length;
		int row = matrix.length;

		int[][] transposeM = new int[row][col];
		for(int i = 0;i<row;i++){
			for(int j = 0;j<col;j++){
				transposeM[j][i]=matrix[i][j];
			}
		}
		return transposeM;
	}

	/*
	输入：[1,2,5,9,5,9,5,5,5] => 1，2，5，5，5，5，5，9，9
	输出：5
	你有办法在时间复杂度为 O(N)，空间复杂度为 O(1) 内完成吗？
	 */
	public int majorityElement(int[] nums) {
		int half = nums.length/2;
		Arrays.sort(nums);
		int majorityElement = nums[half];
		int number = 0;
		for (int num : nums) {
			if (num == majorityElement){
				number++;
			}
		}
		if (number>nums.length/2){
			return majorityElement;
		}
		return -1;
	}

	public static boolean match(String[] arr, String targetValue) {
		return Arrays.asList(arr).contains(targetValue);
	}


}
