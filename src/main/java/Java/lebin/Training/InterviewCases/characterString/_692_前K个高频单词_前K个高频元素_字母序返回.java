package Java.lebin.Training.InterviewCases.characterString;

import java.util.*;

/*
692. 前K个高频单词
给一非空的单词列表，返回前 k 个出现次数最多的单词。
返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。

示例 1：

输入: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
输出: ["i", "love"]
解析: "i" 和 "love" 为出现次数最多的两个单词，均为2次。
    注意，按字母顺序 "i" 在 "love" 之前。

示例 2：

输入: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
输出: ["the", "is", "sunny", "day"]
解析: "the", "is", "sunny" 和 "day" 是出现次数最多的四个单词，
    出现次数依次为 4, 3, 2 和 1 次。
     */
public class _692_前K个高频单词_前K个高频元素_字母序返回 {
    //统计频率的时间复杂度为N,小根堆循环的复杂度也为N，入队的时间复杂度为logK,所以最终的时间复杂度为NlogK
    public List<String> topKFrequent(String[] words, int k) {
        //top k算法
        //1.先统计频率
        //2.topK算法
        Map<String,Integer> map = new HashMap<>();
        List<String> ans = new ArrayList<>();
        for(String word:words){
            map.put(word,map.getOrDefault(word,0)+1);
        }

        PriorityQueue<String> queue = new PriorityQueue<>((s1,s2)->{
            if (map.get(s1).equals(map.get(s2))) {
                return s2.compareTo(s1);
            } else {
                return map.get(s1) - map.get(s2);
            }
        });

        for(String str:map.keySet()){
            queue.offer(str);
            if(queue.size()>k){
                queue.poll();
            }
        }
        //循环出队
        while(!queue.isEmpty()){
            ans.add(queue.poll());
        }
        //需要反转队列，符合题目要求
        Collections.reverse(ans);
        return ans;
    }

    //------------------------------------------------------------------------

    //内部类
    static class MyComparator implements Comparator<String>{
        private Map<String,Integer> map;

        public MyComparator(Map<String, Integer> map) {
            this.map = map;
        }

        @Override
        public int compare(String o1, String o2) {
            int count1 = map.get(o1);
            int count2 = map.get(o2);
            if (count1 == count2){
                return o1.compareTo(o2);
            }
            return count2-count1;//降序排列
        }
    }




    public static List<String> topKFrequent2(String[] words, int k) {
        //1.先统计每个单词出现的个数
        Map<String,Integer> map = new HashMap<>();
        for (String s : words){
            Integer count = map.getOrDefault(s,0);
            map.put(s,count+1);
        }
        //2.需要把刚才的内容放到ArrayList中
        //keySet相当于得到了一个Set，Set中存放的就是所有的key
        ArrayList<String> arrayList = new ArrayList<>(map.keySet());
        //3.按照刚才的字符串出现次数，进行排序
        //sort 默认按照升序排列
        //此处需要按照字符串出现次数降序排列，也就是通过比较器来自定制比较规则
        Collections.sort(arrayList,new MyComparator(map));
        return arrayList.subList(0,k);//获取到前k个元素
    }




    public static void main(String[] args) {
//        int[] nums = new int[]{-1,-2,2,-2,2,-2,3,3,-3};
//        System.out.println(topKFrequent2(nums,2));
        String[] words = new String[]{"a","a","a","a","c","c","c","b","b","b","d","d","d"};
        System.out.println(topKFrequent2(words,3));
//        System.out.println('a'>'b');
    }
}