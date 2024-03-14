package Java.lebin.Training.InterviewCases.characterString;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
在英语中，我们有一个叫做 词根(root) 的概念，可以词根后面添加其他一些词组成另一个较长的单词——我们称这个词为 继承词(successor)。
例如，词根an，跟随着单词 other(其他)，可以形成新的单词 another(另一个)。
现在，给定一个由许多词根组成的词典 dictionary 和一个用空格分隔单词形成的句子 sentence。
你需要将句子中的所有继承词用词根替换掉。如果继承词有许多可以形成它的词根，则用最短的词根替换它。
你需要输出替换之后的句子。
示例 1：
输入：dictionary = ["cat","bat","rat"], sentence = "the cattle was rattled by the battery"
输出："the cat was rat by the bat"
示例 2：
输入：dictionary = ["a","b","c"], sentence = "aadsfasf absbs bbab cadsfafs"
输出："a a b c"
 */
/*
时间复杂度：O(d+∑wi^2). 其中 d 是 dictionary 的字符数，构建哈希集合消耗 O(d) 时间。wi 是 sentence 分割后第 i 个单词的字符数，
判断单词的前缀子字符串是否位于哈希集合中消耗 O(w_i^2)时间。
空间复杂度：O(d+s)，其中 s 是 sentence 的字符数。
构建哈希集合消耗 O(d) 空间，分割 sentence 消耗 O(s) 空间。
 */
public class _648_单词替换 {
    public String replaceWords(List<String> dictionary, String sentence) {
        Set<String> dictionarySet = new HashSet<String>();
        for (String root : dictionary) {
            dictionarySet.add(root);
        }

        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (int j = 0; j < word.length(); j++) {
                if (dictionarySet.contains(word.substring(0, 1 + j))) {
                    words[i] = word.substring(0, 1 + j);//包含在内就替换
                    break;
                }
            }
        }
        return String.join(" ", words);
    }
}
