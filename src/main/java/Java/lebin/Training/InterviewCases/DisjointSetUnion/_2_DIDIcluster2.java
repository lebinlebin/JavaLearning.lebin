//package Java.lebin.Training.InterviewCases.DisjointSetUnion;
//
//import Java.lebin.Training.DSA._10_HashMap.map.HashMap;
//
//import java.util.*;
//
///**
// * 滴滴二面代码题：
// *       输入：[1, 5, 7, 3, 9, 8, 10]
// *             [(1, 3), (5, 7), (7, 1), (9, 8)]
// *             -- 表示1和3有关，5和7有关，7和1有关，9和8有关。
// *       输出：[(1, 3, 7, 5), (8, 9), (10)]
// *
// * 思路:
// *  [(1, 3), (5, 7), (7, 1), (9, 8)]
// *   先把这个玩意合并了
// *   [(1,3,5,7), (9, 8)]
// *   Map(1->1,3->1,5->1,7->1,9->2,8->2)
// *   遍历     [1, 5, 7, 3, 9, 8, 10]
// *   Getindex  1 1  1 1  2 2  -1
// *
// */
//public class _2_DIDIcluster2 {
//    /** 滴滴二面代码题：
//     *       输入：[1, 5, 7, 3, 9, 8, 10]
//     * [(1, 3), (5, 7), (7, 1), (9, 8)]
//     * --表示1和3有关，5和7有关，7和1有关，9和8有关。
//     *       输出：[(1, 3, 7, 5), (8, 9), (10)]*/
//
//
//const int N = 1e5;
//    int p[N];
//
//    int find(int x)
//    {
//        if (p[x] != x) p[x] = find(p[x]);
//        return p[x];
//    }
//
//    void to_union(int i,int j)
//    {
//        p[find(i)] = find(j);
//    }
//
//    int main()
//    {
//        vector<int> myvec = {1,5,7,3,9,8,10};
//        unordered_set<int> hs;
//
//
//        for (int i = 0;i< myvec.size();i++)
//        {
//            hs.emplace(myvec[i]);
//        }
//        sort(myvec.begin(), myvec.end());
//
//        for (int i = 0;i<=myvec[myvec.size()-1];i++)
//        {
//            p[i] = i;
//        }
//
//        vector<vector<int>> in2 = { {1,3},{5,7},{7,1},{9,8} };
//        for (int i = 0;i<in2.size();i++)
//        {
//            to_union(in2[i][0], in2[i][1]);
//        }
//        int size = 0;
//        vector<int> leader;
//        for (int i = 0;i<=myvec[myvec.size()-1];i++)
//        {
//            if (hs.find(i) != hs.end() && p[i] == i)
//            {
//                leader.push_back(i);
//            }
//        }
//        vector<vector<int>> out;
//        vector<int> mid;
//        for (int k = 0; k < leader.size(); k++)
//        {
//            for (int i = 0; i <= myvec[myvec.size() - 1]; i++)
//            {
//                if (hs.find(i) != hs.end() && p[i] == leader[k])
//                {
//                    mid.push_back(i);
//                    cout << i << ' ';
//                }
//            }
//            out.emplace_back(mid);
//            mid.clear();
//            cout << endl;
//        }
//        //cout << p[5] << endl;
//        return 0;
//    }
//
//}
//
//
//
///*
//
//
//        int size = 0;
//
//
//
//
//
//        vector<vector<int>> out;
//        vector<int> mid;
//        for (int k = 0; k < leader.size(); k++)
//        {
//        for (int i = 0; i <= myvec[myvec.size() - 1]; i++)
//        {
//        if (hs.find(i) != hs.end() && p[i] == leader[k])
//        {
//        mid.push_back(i);
//        cout << i << ' ';
//        }
//        }
//        out.emplace_back(mid);
//        mid.clear();
//        cout << endl;
//        }
//        //cout << p[5] << endl;
//        return 0;
//        }
// */