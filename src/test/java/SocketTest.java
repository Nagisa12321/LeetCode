import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/7/3 11:38
 */
public class SocketTest {

	static class Client {
		public static void main(String[] args) throws IOException {
			Socket s = new Socket("192.168.1.111", 9999);

			s.getOutputStream().write('1');

			s.close();
		}
	}

	static class Server {
		public static void main(String[] args) throws IOException {
			ServerSocket ss = new ServerSocket(9999);
			Socket socket = ss.accept();


			char i = (char) socket.getInputStream().read();
			System.out.println(i);

			socket.close();
			ss.close();
		}
	}
}
