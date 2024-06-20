package pe.bazan.luis.uni.s11;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Tower {
	private Stack<Integer> stack = new Stack();
	private TowerRole towerRole;
	private final int length;

	public Tower(int length, TowerRole towerRole) {
		this.length = length;
		this.towerRole = towerRole;
	}

	public Tower(int length, TowerRole towerRole, boolean fill) {
		this.length = length;
		this.towerRole = towerRole;

		for (int i = 0; i < this.length; i++) {
			stack.push(this.length - i);
		}
	}

	public void push(int value) {
		stack.push(value);
	}

	public int pop() {
		return stack.pop();
	}

	public int getHeadValue() {
		Integer value = stack.pop();
		stack.push(value);

		return value;
	}

	public TowerRole getTowerRole() {
		return towerRole;
	}

	public int getLength() {
		return length;
	}

	public boolean is(TowerRole towerRole) {
		return this.towerRole.equals(towerRole);
	}

	public String[] print() {
		List<String> rows = new ArrayList<>();

		for (int i = 0; i < this.length - stack.size(); i++) {
			rows.add(StringUtils.center("|", this.length * 2 + 1));
		}

		for (Integer i : stack.toArray(Integer[]::new)) {
			rows.add(0, StringUtils.center("* ".repeat(i).trim(), this.length * 2 + 1));
		}

		return rows.toArray(String[]::new);
	}

	class StringUtils {

		public static String center(String s, int size) {
			return center(s, size, ' ');
		}

		public static String center(String s, int size, char pad) {
			if (s == null || size <= s.length())
				return s;

			StringBuilder sb = new StringBuilder(size);
			for (int i = 0; i < (size - s.length()) / 2; i++) {
				sb.append(pad);
			}
			sb.append(s);
			while (sb.length() < size) {
				sb.append(pad);
			}
			return sb.toString();
		}
	}
}
