package com.leetcode.week.No236.bishi;

import org.testng.TestNGAntTask;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/4/30 11:07
 */
/*
4. 某项目X的代码引用了若干个外部模块,每个模块以一个唯一的字符串作为标识,外部的模块也会相互引用,
经过一个工具的扫描,生成了所有的模块和它们之间的引用关系,用文本文件modules.txt表示,示例:
honnef,renameio
zap,honnef
tcaplus,zap
X,tcaplus
..., ...
即每行两个模块名,以逗号分隔,表示前面的模块引用了后面的模块,其中名为X的模块代表本项目.
请编写代码,通过这个文本文件(modules.txt)分析这些模块是否出现了循环引用,编程语言不限.
 */
public class Solution5 {
	public static void main(String[] args) throws IOException {
		// 读取文件
		InputStream fis = new FileInputStream("src/main/resources/input.data");
		BufferedReader reader = new BufferedReader(new InputStreamReader(fis));

		// 保存第一个节点
		Model head = null;
		// 一行一行的读, 建立引用关系
		Map<String, Model> modelMap = new HashMap<>();
		String line;

		while ((line = reader.readLine()) != null) {
			String[] strs = line.split(",");
			String model0Name = strs[0];
			String model1Name = strs[1];

			Model model0;
			Model model1;

			if (modelMap.containsKey(model0Name)) model0 = modelMap.get(model0Name);
			else {
				model0 = new Model(model0Name);
				modelMap.put(model0Name, model0);
			}
			if (modelMap.containsKey(model1Name)) model1 = modelMap.get(model1Name);
			else {
				model1 = new Model(model1Name);
				modelMap.put(model1Name, model1);
			}
			model0.linkModel = model1;

			if (head == null) head = model0;
		}

		System.out.println("is round? " + isRound(head));
	}

	// 相当于判断有没有环形链表
	private static boolean isRound(Model model) {
		// 快慢指针
		Model fast = model;
		Model slow = model;

		// fast没走到终点, slow也肯定没有
		while (fast != null && fast.linkModel != null) {
			fast = fast.linkModel.linkModel;
			slow = slow.linkModel;

			if (fast == slow) return true;
		}

		return false;
	}

	// 代表模块的数据结构
	public static class Model {
		private final String modelName; // 模块名
		private Model linkModel; // 引用

		public Model(String modelName) {
			this.modelName = modelName;
		}

		@Override
		public String toString() {
			return modelName;
		}
	}
}
