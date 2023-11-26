package Java.lebin.Training.InterviewCases.概率题;
import java.util.HashMap;
import java.util.Map;


/*
谷歌面试题：在半径为1的圆中随机选取一点
扫码查看
方法1.
在x轴[-1, 1]，y轴[-1, 1]的正方形内随机选取一点。然后判断此点是否在圆内（通过计算此点到圆心的距离）。如果在圆内，则此点即为所求；如果不在，则重新选取直到找到为止。
正方形的面积为4，圆的面积为pi，所以正方形内的随机点在圆内的概率是 pi / 4。

方法2.
从[0, 2*pi)中随机选一个角度，对应于圆中的一条半径，然后在此半径上选一个点。但半径上的点不能均匀选取，选取的概率应该和距圆心的长度成正比，这样才能保证随机点在圆内是均匀分布的。
 */
    public class _2_概率题_FindPointInCircle {
        //    方法1.
//            在x轴[-1, 1]，y轴[-1, 1]的正方形内随机选取一点。然后判断此点是否在圆内（通过计算此点到圆心的距离）。
//    如果在圆内，则此点即为所求；如果不在，则重新选取直到找到为止。
        private Map<Character,Double> solution(){
            Map<Character,Double> resMap = new HashMap<>();
            double x = Math.random()*2 - 1;
            double y = Math.random()*2 - 1;
            while(true){
                if(Math.pow(x,2)+Math.pow(y,2) <=1){
                    resMap.put('x',x);
                    resMap.put('y',y);
                    return resMap;
                }

            }
        }

    public static void main(String args[]){
        _2_概率题_FindPointInCircle findPointInCircle = new _2_概率题_FindPointInCircle();
        System.out.println(findPointInCircle.solution());
    }
    }

