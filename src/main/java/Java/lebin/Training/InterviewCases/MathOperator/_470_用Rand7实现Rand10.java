package Java.lebin.Training.InterviewCases.MathOperator;

import java.util.Random;

public class _470_用Rand7实现Rand10 {

    //rand7() 实现 rand10()
    public int rand10() {
        // ①已知 rand7()可以等概率生成1~7；
        // ②那么rand7()-1可以等概率生成0~6；
        // ③那么（rand7()-1）* 7 可以等概率生成{0, 7, 14, 21, 28, 35, 42};
        // ④那么（rand7()-1）* 7 + rand7()可以等概率生成1~49。

        // 现在我们实现了等概率生成1~49的功能，我们规定如果生成的数大于40，
        // 我们就重新生成，即只要生成在1~40之间的数，这样我们就可以生成1~40的等概率分布。

        // 再接着，我们用（1~40）%10，就可以得到0~9
        // 最后，（1~40）%10 + 1 ，就可以得到1~10了。

        int ans = 41;
        while(ans>40){
            ans = ((rand7() - 1) * 7 + rand7());
        }
        return 1 + ans % 10;
    }

    //=====================================================================
    //用rand5生成rand7
    //rand5()  1-5
    // rand5()-1  0-4
    //5 * (rand5() - 1)   0 5 10 15 20
    //5 * (rand5() - 1) + rand5()  1-25
    //对于 >20的进行重新生成。 1-20
    //1-20 %7的花  0-6   再+1 就是rand7
    public int rand7() {
        int ans = 21;
        while(ans>20){
            ans = 5 * (rand5() - 1) + rand5();
        }
        return 1 + ans % 7;
    }


    public int rand5() {
        Random rand =new Random();
        int result = rand.nextInt(5)+1;//0~4 +1  = 1~5
        return result;
    }


    //rand3()实现rand7()
    public int rand3_To_rand7() {
        while (true) {
            int srand = (rand3() - 1) * 3;//0， 1， 2随机取；  *3 ==> 0 3 6
            int sum = srand + rand3() - 1;//随机加上0 1 2，就会使得出现res: 0 1 2 3 4 5 6 7 8的概率相等
            if (sum >= 7) { //保证每个7都出现相同的概率，即8,9的存在會使得1,2概率上升。
                continue;
            } else {
                return sum + 1; //1 2 3 4 5 6 7
            }
        }
    }

    public int rand3() {
        Random rand =new Random();
        int result = rand.nextInt(3)+1;//0~2 +1  = 1~3
        return result;
    }


    //rand5生成rand3
    int Rand3(){
        int ret;
        while(true){
            ret = (rand5()-1)*5 + rand5();//0-4 * 5 ==> 0  5  10 15 20   +rand5()==> 0 1 2 3 4 5 6 ----25
            if(ret>=25)//只保留 0--24
                continue;
            else
                return ret % 3 + 1;//生成 random3
        }
    }
}
