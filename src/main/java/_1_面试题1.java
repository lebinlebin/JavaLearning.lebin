import java.util.ArrayList;
import java.util.HashMap;

/*
Given 一个二维数组
[ 1 11 15 21
  31 65 78 4
  97 11 18 63
]
将其展开成
[1 11 31 97 65 15 21 78 11 18 4 63]
 */
/*
解题思路:
* 0.默认情况是从左往右走，包括上坡（列加行减），反向则是从右往左走，包括下坡（行加列减）
 * 1.从起点开始往右走，走完后的坐标还在第一行，但列没在最后一列时，进行反向，下坡走
 * 2.当坐标点在第一列，但没在最后一行，往下走，然后再反向，上坡
 * 3.当坐标在最后一行，并反向，列加一
 * 4.当坐标在最后一列，并反向，行加一
 */

public class _1_面试题1 {
    public static ArrayList<Integer> print(int[][] nums){
        int r = 0;
        int endrow = nums.length;
        int c = 0;
        int endcol = nums[0].length;
        ArrayList<Integer> result = new ArrayList<Integer>();
        boolean l2r = true;//从左到右
        while(r<endrow && c < endcol){
            //左下到右上对角
            if(l2r){
                System.out.println(nums[r][c]);
                result.add(nums[r][c]);
                //第一行，向右走
                if(r==0 && c<endcol-1){
                    c++;
                    l2r = !l2r;//记录取反
                    continue;
                }else if(r>0 && c==endcol-1){
                    //最后一列，向下走
                    l2r = !l2r;//记录取反
                    r++;
                    continue;
                }else{
                    //上破走
                    r--;
                    c++;
                }
            }else{
                //反方向
                System.out.println(nums[r][c]);
                result.add(nums[r][c]);
                if(c == 0 && r < endrow-1){//第一列
                    r++;
                    l2r = !l2r;//记录取反
                    continue;
                }else if(r==endrow-1){
                    //最后一行，向右
                    l2r = !l2r;//记录取反
                    c++;
                    continue;
                }else{
                    r++;
                    c--;
                }
            }

        }
        return result;
    }

    public static void main(String[] args) {
        /*
Given 一个二维数组
[ 1 11 15 21
  31 65 78 4
  97 11 18 63
]
将其展开成
[1 11 31 97 65 15 21 78 11 18 4 63]
         */
        int[][] nums = new int[][]{{1,11,15,21},{31,65,78,4},{97,11,18,63}};
        ArrayList<Integer> list = print(nums);
        System.out.println(list);
    }
}
/*

 */
