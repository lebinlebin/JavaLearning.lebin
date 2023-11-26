package Java.lebin.Training.Array;

import java.util.*;
import java.util.regex.Pattern;

class arrayDouble {
	public static void main(String[] args) 
	{
//		Double[] PriceWeightRange;
//		Random r = new Random(1);
//
//		float[] resultProbDefault = new float[10];
//		for (int i = 0;i<resultProbDefault.length;i++){
//			resultProbDefault[i] = i+10;
//		}
//		/**
//		 * 不需要循环
//		 * 直接打印数组信息
//		 */
//		for(int i = 0; i<resultProbDefault.length;i=i+2){
//			System.out.println(resultProbDefault[i]);
//
//		}
//
//		System.out.println("----------------------------------");
//		List<String> a = new ArrayList<String>();
//		a.add("aaaa");
//		a.add("bbbb");
//		a.add("cccc");
//		System.out.println(Arrays.toString(a.toArray()));
//		//System.out.println(Arrays.toString(resultProbDefault));
//		System.out.println(reverseInteger(123));
//
//
		String welcare = "1|2|4";
		HashMap<String, String> resultMap = new HashMap<>();
		parseWelcare(welcare,resultMap);

	}
	public static int reverseInteger(int number) {
		// write your code here
		System.out.println("-----------------------------------");
		System.out.println(number);

		int a = number/100;//1
		System.out.println("a --->"+a);
		System.out.println("----->"+number/10%10);
		int b = number/10%10;//2
		System.out.println(b);

		int c = number%10;//3
		System.out.println(c);

		return c * 100 + b * 10 + a;

	}

	private static HashMap<String, String> parseWelcare(String welcare, HashMap<String, String> resultMap) {
		Integer[] welcareArr = new Integer[10];
		for(int i=0; i < welcareArr.length; i++) {
			welcareArr[i] = 0;
		}
		if(null != welcare && welcare.length() >= 1){
			String[]  welcareSplit =  welcare.split("\\|");
			for(String e: welcareSplit){
//				System.out.println(e);
				if(isInteger(e) && Integer.parseInt(e) <= 10 && Integer.parseInt(e) > 0){
					welcareArr[Integer.parseInt(e)-1] = 1;
				}
			}
		}




		resultMap.put("wxyjr", welcareArr[0].toString());
		resultMap.put("fanbr", welcareArr[1].toString());
		resultMap.put("huabr", welcareArr[2].toString());
		resultMap.put("fangbr", welcareArr[3].toString());
		resultMap.put("jtbr", welcareArr[4].toString());
		resultMap.put("sxiur", welcareArr[5].toString());
		resultMap.put("jbanbr", welcareArr[6].toString());
		resultMap.put("bzhur", welcareArr[7].toString());
		resultMap.put("shxinr", welcareArr[8].toString());
		resultMap.put("bchir", welcareArr[9].toString());

		Integer SUM = 0;
		for(int i=0; i < welcareArr.length; i++)
		{
			SUM += welcareArr[i];
		}
		resultMap.put("welnumr", SUM.toString());
		return resultMap;
	}

	public static boolean isInteger(String str) {
		Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
		return pattern.matcher(str).matches();
	}


}
