package Java.lebin.Training.InterviewCases.MathOperator;

/**
 剑指 Offer 20. 表示数值的字符串

 首先定义了四个flag，对应四种字符
 是否有数字：hasNum
 是否有e：hasE
 是否有正负符号：hasSign
 是否有点：hasDot
 其余还定义了字符串长度n以及字符串索引index
 先处理一下开头的空格，index相应的后移
 然后进入循环，遍历字符串
 如果当前字符c是数字：将hasNum置为true，index往后移动一直到非数字或遍历到末尾位置；如果已遍历到末尾(index == n)，结束循环
 如果当前字符c是'e'或'E'：如果e已经出现或者当前e之前没有出现过数字，返回fasle；否则令hasE = true，并且将其他3个flag全部置为false，因为要开始遍历e后面的新数字了
 如果当前字符c是+或-：如果已经出现过+或-或者已经出现过数字或者已经出现过'.'，返回flase；否则令hasSign = true
 如果当前字符c是'.'：如果已经出现过'.'或者已经出现过'e'或'E'，返回false；否则令hasDot = true
 如果当前字符c是' '：结束循环，因为可能是末尾的空格了，但也有可能是字符串中间的空格，在循环外继续处理
 如果当前字符c是除了上面5种情况以外的其他字符，直接返回false
 处理空格，index相应的后移
 如果当前索引index与字符串长度相等，说明遍历到了末尾，但是还要满足hasNum为true才可以最终返回true，因为如果字符串里全是符号没有数字的话是不行的，而且e后面没有数字也是不行的，但是没有符号是可以的，所以4个flag里只要判断一下hasNum就行；所以最后返回的是hasNum && index == n
 如果字符串中间有空格，按以上思路是无法遍历到末尾的，index不会与n相等，返回的就是false
 */
public class 剑指Offer20_表示数值的字符串 {
    /*
    复杂度分析
    时间复杂度：O(n)
    空间复杂度：O(1)
     */
    public boolean isNumber(String s) {
        int n = s.length();
        int index = 0;
        boolean hasNum = false, hasE = false;
        boolean hasSign = false, hasDot = false;
        while(index < n && s.charAt(index) == ' ')
            index++;
        while(index < n){
            while(index < n && s.charAt(index) >= '0' && s.charAt(index) <= '9'){
                index++;
                hasNum = true;
            }
            if(index == n){
                break;
            }
            char c = s.charAt(index);
            if(c == 'e' || c == 'E'){
                if(hasE || !hasNum){
                    return false;
                }
                hasE = true;
                hasNum = false; hasSign = false; hasDot = false;
            }else if(c == '+' || c == '-'){
                if(hasSign || hasNum || hasDot){
                    return false;
                }
                hasSign = true;
            }else if(c == '.'){
                if(hasDot || hasE){
                    return false;
                }
                hasDot = true;
            }else if(c == ' '){
                break;
            }else{
                return false;
            }
            index++;
        }
        while(index < n && s.charAt(index) == ' ')
            index++;
        return hasNum && index == n;
    }

}
