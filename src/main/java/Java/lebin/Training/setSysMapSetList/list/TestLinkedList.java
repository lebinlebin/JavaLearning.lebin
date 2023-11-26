package Java.lebin.Training.setSysMapSetList.list;

import java.util.LinkedList;

public class TestLinkedList {
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		
		LinkedList list  = new LinkedList();
		
		for(int i=1;i<=10;i++){
			list.add("john"+i);
		
		}
		
		for(int i=11;i<=20;i++){
			list.add("john"+i);
		
		}
	}
}
