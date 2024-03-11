package Java.lebin.Training.InterviewCases.SortArray;

import java.util.*;

public class 合并两个List中并去掉重复的元素 {
    public static void main(String[] args) {
        // 这里要记得new一个ArrayList
        List<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(4, 5, 6));

        Set<Integer> set = new HashSet<>();
        for(Integer element: list1){
            set.add(element);
        }

        for(Integer element: list2){
            set.add(element);
        }

        List<Integer> result = new ArrayList<>(new HashSet<>(set));
        System.out.println("去重后的List：" + result);
    }
}
