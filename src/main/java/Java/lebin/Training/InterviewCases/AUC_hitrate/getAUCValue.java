package Java.lebin.Training.InterviewCases.AUC_hitrate;

import java.util.*;
import java.util.stream.Collectors;

public class getAUCValue {
    public static double getAUCValue(List<Integer> labels, List<Double> predictions) throws Exception {
        if (labels.size() != predictions.size()) {
            throw new Exception("labels和predictions长度必须一致");
        }
        Map<Double, List<Integer>> map = new HashMap<>();
        int totalPositiveNum = 0;
        int totalNegativeNum = 0;
        for (int i = 0; i < labels.size(); i++) {
            int oneLabel = labels.get(i);
            double onePred = predictions.get(i);
            if (oneLabel == 1) {
                totalPositiveNum += 1;
            } else {
                totalNegativeNum += 1;
            }
            map.putIfAbsent(onePred, new ArrayList<>());
            map.get(onePred).add(oneLabel);
        }
        List<Double> sortPred = map.keySet().stream().sorted().collect(Collectors.toList());
        int startRank = 1;
        double pairAll = 0.0;
        for (double pred : sortPred) {
            List<Integer> list = map.get(pred);
            int positiveNum = list.stream().mapToInt(Integer::intValue).sum();
            int endRank = startRank + list.size() - 1;
            double avgRank = 1.0 * (startRank + endRank) / 2;
            startRank = endRank + 1;
            // 分子左边
            pairAll += positiveNum * avgRank;
        }
        double pairPositive = 1.0 * totalPositiveNum * (totalPositiveNum + 1) / 2;
        return (pairAll - pairPositive) / (totalPositiveNum * totalNegativeNum);
    }

    public static void main(String[] args) throws Exception {
        List<Integer> label = Arrays.asList(1, 1, 0, 0, 0, 1, 0, 1, 1, 1, 0, 0, 1, 1, 0, 1);
        List<Double> probs = Arrays.asList(0.4, 0.8, 0.2, 0.4, 0.5, 0.7, 0.9, 0.6, 0.3, 0.2, 0.1, 0.1, 0.2, 0.3, 0.5, 0.8);
        double res = getAUCValue(label, probs);
        System.out.println(res);
    }
}
