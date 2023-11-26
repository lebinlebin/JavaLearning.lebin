package Java.lebin.Training.setSysMapSetList.HashMap;

import java.util.*;
public class HashMapSort {

	public static void main(String[] args) {
		Map phone = new HashMap();

		System.out.println(">>>>>>>>>>>>>>>>>>>:::::   "+phone.size());
		phone.put("Apple", 7299);
		phone.put("SAMSUNG", 6000);
		phone.put("Meizu", 2698);
		phone.put("Xiaomi", 2400);


		//key-sort
		Set set = phone.keySet();
		Object[] arr = set.toArray();

		Arrays.sort(arr);
		for (Object key : arr) {
			System.out.println(key + ": " + phone.get(key));
		}
		System.out.println("----------------------------------");


		/**
		 * 要比较vlue要先将map转化为list，然后利用list的sort方法
		 */
		//value-sort
		List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(phone.entrySet());


		//list.sort()
		list.sort(new Comparator<Map.Entry<String, Integer>>() {
			@Override
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				return o2.getValue().compareTo(o1.getValue());
			}
		});


		//collections.sort()
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
			@Override
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				return o2.getValue().compareTo(o1.getValue());
			}
		});


		//for
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getKey() + ": " + list.get(i).getValue());
		}
		System.out.println();
		//for-each
		for (Map.Entry<String, Integer> mapping : list) {
			System.out.println(mapping.getKey() + ": " + mapping.getValue());
		}
	}
}