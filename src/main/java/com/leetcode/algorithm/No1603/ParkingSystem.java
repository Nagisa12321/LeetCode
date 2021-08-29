package com.leetcode.algorithm.No1603;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/19 16:40
 */
public class ParkingSystem {

	private int big;
	private int medium;
	private int small;
	private final int big_max;
	private final int medium_max;
	private final int small_max;

	public ParkingSystem(int big, int medium, int small) {
		this.big = 0;
		this.medium = 0;
		this.small = 0;
		this.big_max = big;
		this.medium_max = medium;
		this.small_max = small;
	}

	public boolean addCar(int carType) {
		if (carType == 1) {
			if (big == big_max) return false;
			else {
				big++;
				return true;
			}
		} else if (carType == 2) {
			if (medium == medium_max) return false;
			else {
				medium++;
				return true;
			}
		} else {
			if (small == small_max) return false;
			else {
				small++;
				return true;
			}
		}
	}
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */