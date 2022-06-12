package server;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**     
*  
* @author 龙翔宇  
* @date 2022年6月12日  新建  
*/
public class Server implements Runnable{
	private ServerSocket serverSocket;
	
	public Server() {
		try {
			serverSocket = new ServerSocket(8088);
		
			
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void start() {

	}
	public static void main(String[] args) {
		new Server().start();
	}

	@Override
	public void run() {
//		监听客户端
		try {
			
			int port = serverSocket.getLocalPort();
			String hostName = InetAddress.getLocalHost().getHostAddress();
			System.out.println("服务器启动,等待客户端连接"+ hostName + ",监听端口" + port);
			
//			如果有客户端连接,会返回一个socket实例
			Socket clientSocket= serverSocket.accept();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
