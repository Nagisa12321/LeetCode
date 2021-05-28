import org.junit.Test;

import java.util.Arrays;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/5/25 10:54
 */
public class SplitTest {
	@Test
	public void test1() {
		String s = "1+2-34*67/22";
		String[] strs = s.split("[+\\-*/]");

		System.out.println(Arrays.toString(strs));
	}
}
