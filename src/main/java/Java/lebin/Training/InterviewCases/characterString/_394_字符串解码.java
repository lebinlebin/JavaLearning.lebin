package Java.lebin.Training.InterviewCases.characterString;

import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/*
给定一个经过编码的字符串，返回它解码后的字符串。
编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
示例 1：
输入：s = "3[a]2[bc]"
输出："aaabcbc"
示例 2：
输入：s = "3[a2[c]]"
输出："accaccacc"
示例 3：
输入：s = "2[abc]3[cd]ef"
输出："abcabccdcdcdef"
 */
//数字存放在数字栈，字符串存放在字符串栈，遇到右括号时候弹出一个数字栈，字母栈弹到左括号为止。就是逆波兰式那种题。
//时间复杂度：记解码后得出的字符串长度为 S，除了遍历一次原字符串 s，我们还需要将解码后的字符串中的每个字符都入栈，并最终拼接进答案中，故渐进时间复杂度为 O(S+∣s∣)，即 O(S)。
//空间复杂度：记解码后得出的字符串长度为 S，这里用栈维护 TOKEN，栈的总大小最终与 S 相同，故渐进空间复杂度为 O(S)。
public class _394_字符串解码 {
    //数字存放在数字栈，字母存放在字母栈，遇到右括号时候弹出一个数字栈，字母栈弹到左括号为止。
    public String decodeString(String s) {
        StringBuilder strBuilder = new StringBuilder();
        //字母栈
        Stack<Character> words = new Stack<>();
        //数量栈
        Stack<Integer> nums = new Stack<>();
        //字符串长度
        int length = s.length();
        //数字求和变量
        int sum = 0;
        //遍历数组
        for(int i=0;i<length;i++){
            char a = s.charAt(i);
            //若是数字，则存入求和变量（将分散的数字解析为数量）。
            if((a-'0')<10&&(a-'0')>=0){
                sum = sum*10+(a-'0');
            }else{
                words.add(a);
            }
            //遇‘[’，则将数量存入数量栈。
            if(a=='['){
                nums.add(sum);
                sum=0;
            }
            //遇‘]’，则根据数量栈顶的数，重复展开字母栈中‘[’之前的所有字符。
            if(a==']'){
                char word = words.pop();
                int  num = nums.pop();
                Deque<Character> QueChar = new LinkedList<>();
                while(word!='['){
                    word = words.pop();
                    if(word!='['){
                        QueChar.addFirst(word);
                    }
                }
                int size = QueChar.size();
                for(int index=0;index<num;index++){
                    for(int j = 0;j<size;j++){
                        char x =  QueChar.poll();
                        words.add(x);
                        QueChar.addLast(x);
                    }
                }
            }
        }
        //全部出栈
        while(!words.isEmpty()){
            strBuilder.append(words.pop());
        }
        //反转字符串
        return strBuilder.reverse().toString();
    }
}
