package server;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

import edu.hunau.gui.ServerFrame;

/**     
*  
* @author 龙翔宇  
* @date 2022年6月12日  新建  
*/
public class Server implements Runnable{
	private ServerSocket serverSocket;
	
	private ServerFrame serverFrame;
//	this.serverFrame = serverFrame;
	
	public Server(ServerFrame serverFrame) {
		try {
			serverSocket = new ServerSocket(8088);
			this.serverFrame = serverFrame;
			
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
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
//		new Server().start();
	}

	@Override
	public void run() {
//		监听客户端
		try {
			
			int port = serverSocket.getLocalPort();
			String hostName = InetAddress.getLocalHost().getHostAddress();
			String message = "服务器启动成功,ip地址为"+ hostName + ",监听端口:" + port;
			System.out.println("服务器启动,等待客户端连接"+ hostName + ",监听端口" + port);
			// 弹出一个消息框
			JOptionPane.showMessageDialog(null, message);
			
			serverFrame.getMessageArea().append(message);
//			如果有客户端连接,会返回一个socket实例
			Socket clientSocket= serverSocket.accept();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
