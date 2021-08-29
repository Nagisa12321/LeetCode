package com.leetcode.week.No236.bishi;

import java.io.*;
import java.util.*;

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
public class Solution4 {
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
			model0.models.add(model1);

			if (head == null) head = model0;
		}

		if (head == null) {
			// �ļ���û����, Ҳ�Ͳ�����ѭ������
			System.out.println("is round? false");
		} else {
			// ��HashSet��¼�ظ�, ����һ��dfs
			HashSet<String> names = new HashSet<>();
			System.out.println("is round? " + isRound(head, names));
		}
	}

	private static boolean isRound(Model model, Set<String> names) {
		if (names.contains(model.modelName)) return true;
		names.add(model.modelName);

		boolean result = false;
		for (Model curModel : model.models) {
			result = result || isRound(curModel, names);
		}

		return result;
	}

	// ����ģ������ݽṹ
	public static class Model {
		private final String modelName; // ģ����
		private final List<Model> models; // ����

		public Model(String modelName) {
			this.modelName = modelName;
			models = new ArrayList<>();
		}

		@Override
		public String toString() {
			return modelName;
		}
	}
}
