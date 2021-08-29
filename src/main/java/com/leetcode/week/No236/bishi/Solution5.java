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
4. ĳ��ĿX�Ĵ������������ɸ��ⲿģ��,ÿ��ģ����һ��Ψһ���ַ�����Ϊ��ʶ,�ⲿ��ģ��Ҳ���໥����,
����һ�����ߵ�ɨ��,���������е�ģ�������֮������ù�ϵ,���ı��ļ�modules.txt��ʾ,ʾ��:
honnef,renameio
zap,honnef
tcaplus,zap
X,tcaplus
..., ...
��ÿ������ģ����,�Զ��ŷָ�,��ʾǰ���ģ�������˺����ģ��,������ΪX��ģ�������Ŀ.
���д����,ͨ������ı��ļ�(modules.txt)������Щģ���Ƿ������ѭ������,������Բ���.
 */
public class Solution5 {
	public static void main(String[] args) throws IOException {
		// ��ȡ�ļ�
		InputStream fis = new FileInputStream("src/main/resources/input.data");
		BufferedReader reader = new BufferedReader(new InputStreamReader(fis));

		// �����һ���ڵ�
		Model head = null;
		// һ��һ�еĶ�, �������ù�ϵ
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

	// �൱���ж���û�л�������
	private static boolean isRound(Model model) {
		// ����ָ��
		Model fast = model;
		Model slow = model;

		// fastû�ߵ��յ�, slowҲ�϶�û��
		while (fast != null && fast.linkModel != null) {
			fast = fast.linkModel.linkModel;
			slow = slow.linkModel;

			if (fast == slow) return true;
		}

		return false;
	}

	// ����ģ������ݽṹ
	public static class Model {
		private final String modelName; // ģ����
		private Model linkModel; // ����

		public Model(String modelName) {
			this.modelName = modelName;
		}

		@Override
		public String toString() {
			return modelName;
		}
	}
}
