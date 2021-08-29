import org.junit.Test;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/11 16:11
 */
public class SubStringTest {
	@Test
	public void test1() {
		String s = "  hello world";

		int left = 2, right = 7;
		String str_left = s.substring(0, left);
		String str_reserve = s.substring(left, right);
		String str_right = s.substring(right);

		System.out.println(str_left);
		System.out.println(str_reserve);
		System.out.println(str_right);
	}

	@Test
	public void test2() {
		String s = "  hello world";

		System.out.println(reserve(s));
	}

	public String reserve(String s) {
		if (s.equals("")) return "";

		char ch = s.charAt(0);
		String substring = s.substring(1);

		return reserve(substring) + ch;
	}
}
