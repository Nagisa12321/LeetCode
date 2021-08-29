import org.junit.Test;

import java.util.TreeSet;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/26 9:13
 */
public class TreeSetTest {
    @Test
    public void test1() {
        TreeSet<Integer> set = new TreeSet<>();

        set.add(-1);
        set.add(3);
        set.add(1);

        System.out.println(set.toString());
        System.out.println(set.pollFirst());
        System.out.println(set);
        System.out.println(set.pollLast());
        System.out.println(set);

        // set.remove()

    }
}
