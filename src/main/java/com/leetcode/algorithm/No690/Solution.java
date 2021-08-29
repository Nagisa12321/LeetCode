package com.leetcode.algorithm.No690;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/5/1 11:24
 */
// Definition for Employee.
class Employee {
	public int id;
	public int importance;
	public List<Integer> subordinates;
};

public class Solution {
	public int getImportance(List<Employee> employees, int id) {
		HashMap<Integer, Employee> map = new HashMap<>();

		for (Employee employee : employees) {
			map.put(employee.id, employee);
		}

		return getImportance(map, id);
	}

	public int getImportance(Map<Integer, Employee> map, int id) {
		Employee nowEmployee = map.get(id);
		int importance = nowEmployee.importance;

		for (int employeeId : nowEmployee.subordinates) {
			importance += getImportance(map, employeeId);
		}

		return importance;
	}
}