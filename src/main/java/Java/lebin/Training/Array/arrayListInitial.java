package Java.lebin.Training.Array;
import java.util.ArrayList;
import java.util.List;

public class arrayListInitial {

    public static void main(String[] args) {
        final List<Integer> integers = new ArrayList<Integer>(20);
        for(int i = 0; i < 100;i++){
            integers.add(i);
        }


        for(Integer i: integers){
            System.out.println("i:"+i);
        }
    }



}
