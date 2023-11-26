package Java.lebin.Training.jsonConvert;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class JsonTest {

	public static void main(String[] args) {
		//----------------JsonObject创建的方法-----------------------------------------------------------
		//创建JsonObject第一种方法
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("UserName", "kobi");
		jsonObject.put("age", "34");
		jsonObject.put("workIn", "ALI");//此处的"ALI"也可以替换为一个json{"sex":"男","station":"徐州","hoobey":"coding"}
		// System.out.println("jsonObject1：" + jsonObject);//jsonObject1：{"UserName":"kobi","workIn":"ALI","age":"34"}
		Iterator iterator = jsonObject.keys();//用Iterator迭代器遍历取值，建议用反射机制解析到封装好的对象中
		while (iterator.hasNext()) {
			String key = (String) iterator.next();
			String value = jsonObject.getString(key);
			System.out.println(value);//输出值   kobi ALI 34
		}
		//创建JsonObject第二种方法
		HashMap<String, String> hashMap = new HashMap<String, String>();
		hashMap.put("UserName", "ZHULI");
		hashMap.put("age", "30");
		hashMap.put("workIn", "ALI");
		// System.out.println("jsonObject2：" + JSONObject.fromObject(hashMap));//jsonObject2：{"UserName":"ZHULI","workIn":"ALI","age":"30"}


		//----------------JSONArray创建的方法-----------------------------------------------------------
		//一：遍历JsonArray
		String str = "[{\"I\":1208,\"V\":\"0\"},{\"I\":12523,\"V\":\"3453\"},{\"I\":12524,\"V\":\"忻州\"},{\"I\":12525,\"V\":\"忻州\"},{\"I\":12526,\"V\":\"112.74062416023847\"},{\"I\":12527,\"V\":\"38.42238338517772\"},{\"I\":12528,\"V\":\"忻州忻州忻州\"},{\"I\":1209,\"V\":\"忻州\"},{\"I\":12529,\"V\":\"3453\"},{\"I\":12530,\"V\":\"忻州\"},{\"I\":12531,\"V\":\"岢岚\"},{\"I\":12532,\"V\":\"111.57947778177136\"},{\"I\":12533,\"V\":\"38.710151038936225\"},{\"I\":12534,\"V\":\"忻州岢岚岢岚\"},{\"I\":1210,\"V\":\"岢岚\"},{\"I\":12584,\"V\":\"112.74062416023847|111.57947778177136\"},{\"I\":12585,\"V\":\"38.42238338517772|38.710151038936225\"},{\"I\":1211,\"V\":\"2019-10-1823:59:59\"},{\"I\":2692,\"V\":\"1\"},{\"I\":2694,\"V\":\"1\"},{\"I\":2695,\"V\":\"18\"},{\"I\":2696,\"V\":\"6\"},{\"I\":5142,\"V\":\"0\"},{\"I\":9273,\"V\":\"4\"},{\"I\":12522,\"V\":\"20191018235959\"},{\"I\":12562,\"V\":\"779395\"},{\"I\":12713,\"V\":\"每天\"},{\"I\":5333,\"V\":\"1383507****\"},{\"I\":6691,\"V\":\"38.710151038936225\"},{\"I\":6692,\"V\":\"111.57947778177136\"},{\"I\":5461,\"V\":\"type=%E6%89%BE%E8%BD%A6%E4%B8%BB&ObjectType=%E4%B8%8A%E4%B8%8B%E7%8F%AD%E6%8B%BC%E8%BD%A6\"},{\"I\":9184,\"V\":\"2019-11-1700:39:17\"},{\"I\":11151,\"V\":\"1\"},{\"I\":12554,\"V\":\"轿车,忻州,忻州,岢岚,岢岚\"},{\"I\":11174,\"V\":\"0\"},{\"I\":10589,\"V\":\"00000000\"},{\"I\":10922,\"V\":\"null\"},{\"I\":8992,\"V\":\"00000000\"}]";  // 一个未转化的字符串
		String strDL = "[{\"D\":3453,\"L\":3453}]";  // 一个未转化的字符串

		JSONArray json = JSONArray.fromObject(strDL); // 首先把字符串转成 JSONArray  对象
		if (json.size() > 0) {
			for (int i = 0; i < json.size(); i++) {
				JSONObject job = json.getJSONObject(i);  // 遍历 jsonarray 数组，把每一个对象转成 json 对象
				 System.out.println(job);//{"name":"a","value":"aa"}  {"name":"b","value":"bb"} {"name":"c","value":"cc"}.....
				  System.out.println(job.get("D").toString());  // a b c d

			}
		}

		//创建JsonArray方法2
		ArrayList<String> arrayList = new ArrayList<String>();
		arrayList.add("kobi");
		arrayList.add("34");
		arrayList.add("ALI");
		//System.out.println("jsonArray2：" + JSONArray.fromObject(arrayList));//jsonArray2：["kobi","34","ALI"]


	}

	@Test
	public void test0105() {
        /*
取出name4值过程步骤:  1.将以上字符串转成JSONArray对象  2.取出对象的第一项,JSONObject 3.取出name1的值JSONObject
                      4.然后取出name2的值JSONObject对象  5.取出name4的值value2
* */
		/*  记住":"前是键,符号后是值  大括号成对找  一层层拨开就清楚了*/
		String str = "[{name1:{name2:{name3:'value1',name4:'value2'}}},{}]";

		JSONArray jsonArray = JSONArray.fromObject(str);//  将结果转成JSONArray对象的形式

		JSONObject getJsonObj = jsonArray.getJSONObject(0);//获取json数组中的第一项

		JSONObject json = getJsonObj.getJSONObject("name1").getJSONObject("name2");//{"name4":"value2","name3":"value1"}
		Object value = json.get("name4");
//		System.out.println(value);//value2
	}

	@Test
	public void test01051() {
		JSONObject json = new JSONObject();
		JSONArray jsonArray = new JSONArray();

		json.put("key", "value");//JSONObject对象中添加键值对
		jsonArray.add(json);//将JSONObject对象添加到Json数组中
//		System.out.println(json);
//		System.out.println(jsonArray);
	}

}