package Java.lebin.Training.setSysMapSetList.HashMap;

import java.util.*;

public class HashMapNullValueTest {

	public static void main(String[] args) {


		Map userDataMap = new HashMap<String, String>();

		Map userDataMap1 = new HashMap<String, String>();
		Map userDataMap2 = new HashMap<String, String>();;

		userDataMap1.get("Apple");
		userDataMap1.put("Apple", "7299");

		userDataMap.putAll(userDataMap2);
		Map<String, String> userOfflineDataMap = new HashMap();

		/**
		 * 这样声明map下边调用put一定会报空指针
		 */
		Map<String, Map<String, String>> usermap = null;
		try{
			usermap.put("lebin",userDataMap1);
		}catch (Exception e){
			System.out.println("map异常：  "+e);
		}

		Map<String, Map<String, String>> usermap2 = new HashMap<>();
		usermap2.put("lebin",userDataMap1);






		/**
		 * 遍历map采用entry类型，代表了map中k-v pair
		 * map中的每一个元素都是entry类型。
		 */
		if(null != usermap2){
			for (Map.Entry<String, Map<String, String>> entry : usermap2.entrySet()) {
				System.out.println("---->  "+entry.getValue());
				//这里的entry.getValue()是一个Map<String, String>类型
				userOfflineDataMap.putAll(entry.getValue());
			}
		}
		/**
		 * HashMap允许key和vlue同时为null
		 */
		userDataMap.putAll(userOfflineDataMap);
		userDataMap1.put("bpple", "7299");
		userDataMap1.put(null, "7299");
		userDataMap1.put(null, null);
		userDataMap1.put("bpple", null);

		userDataMap.putAll(userDataMap1);


		System.out.println(">>>>>>>>>>>> "+userDataMap.toString());
	}
}