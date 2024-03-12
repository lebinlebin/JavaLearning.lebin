package Java.lebin.Training.InterviewCases.AUC_hitrate;

import java.util.*;

public class RecommendationMetrics {

    // 假设 userRatings 是一个映射，其中键是用户ID，值是该用户喜欢的项目ID列表
    private Map<Integer, Set<Integer>> userRatings;

    // 假设 recommendedItems 是一个映射，其中键是用户ID，值是该用户被推荐的项目ID列表
    private Map<Integer, Set<Integer>> recommendedItems;

    public RecommendationMetrics(Map<Integer, Set<Integer>> userRatings, Map<Integer, Set<Integer>> recommendedItems) {
        this.userRatings = userRatings;
        this.recommendedItems = recommendedItems;
    }

    public double calculatePrecision() {
        double precision = 0.0;
        int totalTP = 0;
        int totalFP = 0;

        for (Map.Entry<Integer, Set<Integer>> entry : userRatings.entrySet()) {
            int userId = entry.getKey();
            Set<Integer> userRatedItems = entry.getValue();
            Set<Integer> recommendedForUser = recommendedItems.getOrDefault(userId, new HashSet<>());

            for (Integer itemId : recommendedForUser) {
                if (userRatedItems.contains(itemId)) {
                    totalTP++; // 真正例
                } else {
                    totalFP++; // 假正例
                }
            }
        }

        if (totalTP + totalFP > 0) {
            precision = totalTP / (double) (totalTP + totalFP);
        }

        return precision;
    }

    public double calculateRecall() {
        double recall = 0.0;
        int totalTP = 0;
        int totalFN = 0;

        for (Map.Entry<Integer, Set<Integer>> entry : userRatings.entrySet()) {
            int userId = entry.getKey();
            Set<Integer> userRatedItems = entry.getValue();
            Set<Integer> recommendedForUser = recommendedItems.getOrDefault(userId, new HashSet<>());

            for (Integer itemId : userRatedItems) {
                if (recommendedForUser.contains(itemId)) {
                    totalTP++; // 真正例
                } else {
                    totalFN++; // 假负例
                }
            }
        }

        if (totalTP + totalFN > 0) {
            recall = totalTP / (double) (totalTP + totalFN);
        }

        return recall;
    }

    public static void main(String[] args) {
        //假设 userRatings 是一个映射，其中键是用户ID，值是该用户喜欢的项目ID列表
        Map<Integer, Set<Integer>> userRatings = new HashMap<>();
        userRatings.put(1, new HashSet<>(Arrays.asList(1, 2, 3)));
        userRatings.put(2, new HashSet<>(Arrays.asList(3, 4, 5)));
        // 假设 recommendedItems 是一个映射，其中键是用户ID，值是该用户被推荐的项目ID列表
        Map<Integer, Set<Integer>> recommendedItems = new HashMap<>();
        recommendedItems.put(1, new HashSet<>(Arrays.asList(1, 2, 4)));
        recommendedItems.put(2, new HashSet<>(Arrays.asList(3, 4, 5, 6)));

        // 计算准确率和召回率
        RecommendationMetrics metrics = new RecommendationMetrics(userRatings, recommendedItems);
        double precision = metrics.calculatePrecision();
        double recall = metrics.calculateRecall();

        // 输出结果
        System.out.println("Precision: " + precision);
        System.out.println("Recall: " + recall);
    }
}
