package Java.lebin.Training.StringMathArraySystemBigDecimal;

import java.util.Stack;

/**
 * 此类用于演示StringBuffer类和String类之间的转换
 * @author liulebin
 *
 */
public class TestStringReplace {
	
	public static void main(String[] args) {
		
	String AA = "2539:1|2|6|7|11,112831:3";
		String BB = AA.replaceAll("2539:1\\|2\\|6\\|7\\|11","").replaceAll("112831:\\d{1}","");
		System.out.println(BB);
	}

	public int[] dailyTemperatures(int[] T) {
		// int n = T.size();
		int n = T.length;
		int[] res = new int[n];
		Stack<Integer> s = new Stack<>();

		for (int i=n-1;i>=0;i--){
			while(!s.isEmpty() && T[s.peek()] <= T[i]){
				s.pop();
			}
			res[i] = s.isEmpty() ? 0 : (s.peek()-i);
			s.push(i);
		}
		return res;
	}


	public int[] nextGreaterElements(int[] nums) {
		int n = nums.length;
		int[] res = new int[n];
		Stack<Integer> s = new Stack<>();
		for(int i=2*n-1;i>=0;i--){
			while(!s.isEmpty() && s.peek()<=nums[i % n]){
				s.pop();
			}
			res[i % n] = s.isEmpty()? 0:(s.peek());
			s.push(nums[i % n]);
		}
		return res;
	}


}
