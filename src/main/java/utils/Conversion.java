package utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * leetcode≤‚ ‘”√¿˝◊™ªØ
 * @author jtchen
 * @version 1.0
 * @date 2021/2/27 11:02
 */
public class Conversion {
	public static void main(String[] args) throws Exception {
		FileInputStream fis = new FileInputStream("src/main/resources/conversion.txt");
		FileOutputStream fos = new FileOutputStream("src/main/resources/out.txt");

		int data;
		while ((data = fis.read()) != -1) {
			if (data == '[') fos.write('{');
			else if (data == ']') {
				fos.write('}');
			}
			else fos.write(data);
		}
		fos.flush();
		fis.close();
		fos.close();

	}
}
