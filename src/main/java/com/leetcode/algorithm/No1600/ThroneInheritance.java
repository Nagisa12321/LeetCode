package com.leetcode.algorithm.No1600;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/6/20 16:29
 */
public class ThroneInheritance {

	private ThroneNode root;
	private HashMap<String, ThroneNode> map;

	public ThroneInheritance(String kingName) {
		this.root = new ThroneNode(kingName);
		this.map = new HashMap<>();
		map.put(kingName, root);
	}

	public void birth(String parentName, String childName) {
		ThroneNode child = map.get(parentName).createChild(childName);
		map.put(childName, child);
	}

	public void death(String name) {
		map.get(name).dead = true;
	}

	public List<String> getInheritanceOrder() {
		List<String> list = new ArrayList<>();
		dfs(list, root);
		return list;
	}

	private void dfs(List<String> list, ThroneNode node) {
		if (node == null) return;
		else if (!node.dead) {
			list.add(node.name);
		}
		for (int i = 0; i < node.idx; i++) {
			dfs(list, node.children[i]);
		}
	}

	private static class ThroneNode {
		private final String name;
		private ThroneNode[] children;
		private int idx;
		private boolean dead;

		public ThroneNode(String name) {
			this.name = name;
			this.children = new ThroneNode[10000];
			this.idx = 0;
			this.dead = false;
		}

		public ThroneNode createChild(String name) {
			raise();
			ThroneNode child = new ThroneNode(name);
			children[idx++] = child;
			return child;
		}

		private void raise() {
			if (children.length == idx) {
				ThroneNode[] tmp = new ThroneNode[idx * 2];
				System.arraycopy(children, 0, tmp, 0, idx);
				children = tmp;
			}
		}
	}
}

/**
 * Your ThroneInheritance object will be instantiated and called as such:
 * ThroneInheritance obj = new ThroneInheritance(kingName);
 * obj.birth(parentName,childName);
 * obj.death(name);
 * List<String> param_3 = obj.getInheritanceOrder();
 */