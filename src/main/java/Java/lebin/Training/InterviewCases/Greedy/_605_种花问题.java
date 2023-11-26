package Java.lebin.Training.InterviewCases.Greedy;

import java.util.Arrays;

/**
 * 605. 种花问题
 * 假设有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
 * 给你一个整数数组  flowerbed 表示花坛，由若干 0 和 1 组成，其中 0 表示没种植花，1 表示种植了花。
 * 另有一个数 n ，能否在不打破种植规则的情况下种入 n 朵花？
 * 能则返回 true ，不能则返回 false。
 */
public class _605_种花问题 {
	public boolean canPlaceFlowers(int[] flowerbed, int n) {
		for(int i = 0; i < flowerbed.length; i++) {
			if(n <= 0) {        // 如果已经种够花了，可以提前返回true
				return true;
			}
			if(flowerbed[i] == 1) {     // 如果已经种过花了，则不能再种了
				continue;
			}
			if(i > 0 && flowerbed[i - 1] == 1) {        // 如果上一个格子已经种过花了，则当前这格不能种花
				continue;
			}
			if(i < flowerbed.length - 1 && flowerbed[i + 1] == 1) {   // 如果下一个格子已经种过花了，则当前这格不能种花
				continue;
			}
			// 可以种花了，并且记录次数
			flowerbed[i] = 1;
			n--;
		}
		return n <= 0;
	}
}
