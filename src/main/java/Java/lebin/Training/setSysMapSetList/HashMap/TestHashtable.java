package Java.lebin.Training.setSysMapSetList.HashMap;

import java.util.Hashtable;

public class TestHashtable {

	/**
	 * hashTable不允许null值
	 * @param args
	 */
	public static void main(String[] args) {
		
		Hashtable table = new Hashtable();
		
		table.put("john", 1);
		table.put("jac", null);
		table.put(null, 2);
		table.put("john", 1);
		
		
		System.out.println(table);
		
	}
}
