package com.leetcode.algorithm.No773;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/6/26 19:23
 */
public class Solution2 {
	public int slidingPuzzle(int[][] board) {
		Board root = new Board(board, 0, null);
		Board helper = root.twin();

		PriorityQueue<Board> queue = new PriorityQueue<>(Comparator.comparingInt(Board::cost));
		PriorityQueue<Board> helpQ = new PriorityQueue<>(Comparator.comparingInt(Board::cost));
		queue.offer(root);
		helpQ.offer(helper);

		while (true) {
			Board tmp = queue.poll();
			Board helperTmp = helpQ.poll();

			if (tmp.isResult()) return tmp.step;
			if (helperTmp.isResult()) return -1;
			Board cur;
			cur = tmp.left();
			if (cur != null && !cur.equals(tmp.parent)) {
				queue.offer(cur);
			}
			cur = tmp.right();
			if (cur != null && !cur.equals(tmp.parent)) {
				queue.offer(cur);
			}
			cur = tmp.up();
			if (cur != null && !cur.equals(tmp.parent)) {
				queue.offer(cur);
			}
			cur = tmp.down();
			if (cur != null && !cur.equals(tmp.parent)) {
				queue.offer(cur);
			}

			cur = helperTmp.left();
			if (cur != null && !cur.equals(helperTmp.parent)) {
				helpQ.offer(cur);
			}
			cur = helperTmp.right();
			if (cur != null && !cur.equals(helperTmp.parent)) {
				helpQ.offer(cur);
			}
			cur = helperTmp.up();
			if (cur != null && !cur.equals(helperTmp.parent)) {
				helpQ.offer(cur);
			}
			cur = helperTmp.down();
			if (cur != null && !cur.equals(helperTmp.parent)) {
				helpQ.offer(cur);
			}
		}
	}

	private static class Board {
		private final int[][] board;
		private int x;
		private int y;
		private int step;
		private Board parent;

		public Board(int[][] arr, int step, Board parent) {
			this.step = step;
			this.board = arr;
			this.parent = parent;
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < 3; j++) {
					if (board[i][j] == 0) {
						x = i;
						y = j;
					}
				}
			}
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (!(o instanceof Board)) return false;
			Board board1 = (Board) o;
			return Arrays.deepEquals(board, board1.board);
		}

		@Override
		public int hashCode() {
			return Arrays.deepHashCode(board);
		}

		public Board left() {
			if (y == 0) return null;
			int[][] res = new int[2][3];
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < 3; j++) {
					res[i][j] = board[i][j];
				}
			}
			res[x][y] = board[x][y - 1];
			res[x][y - 1] = board[x][y];

			return new Board(res, step + 1, this);
		}

		public Board right() {
			if (y == 2) return null;
			int[][] res = new int[2][3];
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < 3; j++) {
					res[i][j] = board[i][j];
				}
			}
			res[x][y] = board[x][y + 1];
			res[x][y + 1] = board[x][y];
			return new Board(res, step + 1, this);
		}

		public Board up() {
			if (x == 0) return null;
			int[][] res = new int[2][3];
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < 3; j++) {
					res[i][j] = board[i][j];
				}
			}
			res[x][y] = board[x - 1][y];
			res[x - 1][y] = board[x][y];
			return new Board(res, step + 1, this);
		}

		public Board down() {
			if (x == 1) return null;
			int[][] res = new int[2][3];
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < 3; j++) {
					res[i][j] = board[i][j];
				}
			}
			res[x][y] = board[x + 1][y];
			res[x + 1][y] = board[x][y];
			return new Board(res, step + 1, this);
		}

		public Board twin() {
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
			return new Board(helper, step, parent);
		}

		public int cost() {
			int cost = 0;
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < 3; j++) {
					int goal = board[i][j];
					if (goal != 0) {
						int finalI = (goal - 1) / 3;
						int finalJ = (goal - 1) % 3;
						cost += Math.abs(finalI - i) + Math.abs(finalJ - j);
					}
				}
			}
			return cost + step;
		}

		public boolean isResult() {
			int num = 1;
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < 3; j++) {
					if (i == 1 && j == 2)
						continue;
					if (board[i][j] != num++)
						return false;
				}
			}
			return true;
		}

		public String toString() {
			return Arrays.deepToString(board);
		}
	}

	public static void main(String[] args) {
		int[][] arr1 = {{3, 5, 4}, {0, 2, 1}};

		Board board = new Board(arr1, 0, null);
		System.out.println(board.cost());
	}
}
