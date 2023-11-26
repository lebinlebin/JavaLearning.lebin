package Java.lebin.Training.jsonparse;

import java.util.HashMap;
import java.util.Map;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;

public class HashMapNullValueTest {
//	int disableDecimalFeature = JSON.DEFAULT_PARSER_FEATURE & ~Feature.UseBigDecimal.getMask();
//	int disableDecimalFeature = JSON.DEFAULT_PARSER_FEATURE &= ~Feature.UseBigDecimal.getMask();


	public static void main(String[] args) {
		HashMap<String, Double> resultMap = new HashMap<>();
		int disableDecimalFeature = JSON.DEFAULT_PARSER_FEATURE & ~Feature.UseBigDecimal.getMask();

//		String aaa = "{\"1\":1.0}";
////		JSONObject  jsonObject = JSONObject.parseObject(aaa);
////		Map<String,Object> map = (Map<String,Object>)jsonObject;//    //json对象转Map
////		resultMap = JSONObject.parseObject(jsonObject.toString(), HashMap.class);
//
//		resultMap = (HashMap<String, Double>)JSONObject.parse(aaa);
//
////		System.out.println(">>>>>>>>>>>> "+resultMap);
//
//		for (String key : resultMap.keySet()) {
//		 System.out.println(key +":"+resultMap.get(key));
//
//	     System.out.println((Double)resultMap.get(key));
//		}

		Map<String, String> oldRedisUserMap = new HashMap<>();
		JSONObject jsonObject = new JSONObject();
//            jsonObject.put(imcV, String.valueOf(((double)Math.round(redisValuerCnt * 10) / 10)));
//            System.out.println("=====>lebinbin:  "+String.valueOf(redisValuerCnt));
		//oldRedisUserMap:   {workyearr4w=1.2, workyearr={"1":"1.0"}, workyearr4=13, workyearr3=11, workyearr2=14, workyearr1=12, workyearr1w=8.0, workyearr3w=2.0, workyearr2w=3.5}
		Double num = 2.0;
		String str = "imcV";
		jsonObject.put(str, num);
//            System.out.println("=====>jsonObject.toString():  "+jsonObject.toString());
		oldRedisUserMap.put("121221",jsonObject.toJSONString());// 四舍五入保留一位小数
		System.out.println(oldRedisUserMap);
		String aaa = oldRedisUserMap.get("121221");
		resultMap = JSONObject.parseObject(aaa, HashMap.class,disableDecimalFeature);
		System.out.println(resultMap);
		Double num2 = resultMap.get("imcV");
//		System.out.println(Double.parseDouble(resultMap.get("imcV").toString()));
//		Double num_double=Double.parseDouble(num2);
		Double a = num2+0.34;
		System.out.println(a);


	}

	public static String getType(Object test) {
		return test.getClass().getName().toString();
	}
	private double calcWeight(long diffDay) {
		return 0.1 + 1 / (Math.exp(diffDay/1.5 - 1) + 1);
	}
}
