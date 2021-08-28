package com.leetcode.algorithm.No773;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

import static java.util.Comparator.*;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/6/26 18:10
 */
public class Solution {
	public int slidingPuzzle(int[][] board) {
		// helper ÊÇ board µÄtwin
		int[][] helper = new int[2][3];

		// copy board
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 3; j++) {
				helper[i][j] = board[i][j];
			}
		}

		// make it is the TWIN
		for (int j = 0; j < 3; j++) {
			if (helper[0][j] != 0 && helper[1][j] != 0) {
				int tmp = helper[0][j];
				helper[0][j] = helper[1][j];
				helper[1][j] = tmp;
				break;
			}
		}

		PriorityQueue<int[][]> queue = new PriorityQueue<>(comparingInt(this::cost));
		PriorityQueue<int[][]> helpQueue = new PriorityQueue<>(comparingInt(this::cost));
		queue.offer(board);
		helpQueue.offer(helper);
		int step = 0;
		while (true) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				int[][] tmp = queue.poll();
				int[][] helpTmp = helpQueue.poll();

				if (isResult(tmp)) return step;
				if (isResult(helpTmp)) return -1;

				int[][] cur;
				if ((cur = moveLeft(tmp)) != null) queue.offer(cur);
				if ((cur = moveRight(tmp)) != null) queue.offer(cur);
				if ((cur = moveDown(tmp)) != null) queue.offer(cur);
				if ((cur = moveUp(tmp)) != null) queue.offer(cur);

				if ((cur = moveLeft(helpTmp)) != null) helpQueue.offer(cur);
				if ((cur = moveRight(helpTmp)) != null) helpQueue.offer(cur);
				if ((cur = moveDown(helpTmp)) != null) helpQueue.offer(cur);
				if ((cur = moveUp(helpTmp)) != null) helpQueue.offer(cur);

			}
			step++;
		}
	}

	private int cost(int[][] arr) {
		int cost = 0;
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 3; j++) {
				int goal = arr[i][j];
				if (goal != 0) {
					int finalI = (goal - 1) / 3;
					int finalJ = (goal - 1) % 3;
					cost += Math.abs(finalI - i) + Math.abs(finalJ - j);
				}
			}
		}
		return cost;
	}

	// is it the answer?
	private boolean isResult(int[][] arr) {
		int num = 1;
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 3; j++) {
				if (i == 1 && j == 2)
					continue;
				if (arr[i][j] != num++)
					return false;
			}
		}
		return true;
	}

	private int[][] moveLeft(int[][] arr) {
		int x = 0, y = 0;

		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 3; j++) {
				if (arr[i][j] == 0) {
					x = i;
					y = j;
					break;
				}
			}
		}
		if (y == 0) return null;
		int[][] res = new int[2][3];
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 3; j++) {
				res[i][j] = arr[i][j];
			}
		}
		res[x][y] = arr[x][y - 1];
		res[x][y - 1] = arr[x][y];

		return res;
	}

	private int[][] moveRight(int[][] arr) {
		int x = 0, y = 0;

		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 3; j++) {
				if (arr[i][j] == 0) {
					x = i;
					y = j;
					break;
				}
			}
		}
		if (y == 2) return null;
		int[][] res = new int[2][3];
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 3; j++) {
				res[i][j] = arr[i][j];
			}
		}
		res[x][y] = arr[x][y + 1];
		res[x][y + 1] = arr[x][y];
		return res;
	}

	private int[][] moveUp(int[][] arr) {
		int x = 0, y = 0;

		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 3; j++) {
				if (arr[i][j] == 0) {
					x = i;
					y = j;
					break;
				}
			}
		}
		if (x == 0) return null;
		int[][] res = new int[2][3];
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 3; j++) {
				res[i][j] = arr[i][j];
			}
		}
		res[x][y] = arr[x - 1][y];
		res[x - 1][y] = arr[x][y];
		return res;
	}

	private int[][] moveDown(int[][] arr) {
		int x = 0, y = 0;

		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 3; j++) {
				if (arr[i][j] == 0) {
					x = i;
					y = j;
					break;
				}
			}
		}
		if (x == 1) return null;
		int[][] res = new int[2][3];
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 3; j++) {
				res[i][j] = arr[i][j];
			}
		}
		res[x][y] = arr[x + 1][y];
		res[x + 1][y] = arr[x][y];
		return res;
	}
}