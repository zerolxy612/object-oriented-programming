package eud.huanu.gui.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.Objects;

import javax.swing.JOptionPane;

import edu.hunau.gui.ServerFrame;
import edu.hunau.gui.utils.ChatRoomUtils;

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
	
	// 关闭服务器
	public void close() {
		if (Objects.nonNull(serverSocket)) {
			try {
				serverSocket.close();
				JOptionPane.showMessageDialog(serverFrame, "服务器已经关闭");
				serverFrame.getMessageArea().append(ChatRoomUtils.showMessage("服务器关闭!"));
			} catch (IOException e) {
				JOptionPane.showMessageDialog(serverFrame, "服务器繁忙!");
			}
		}
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
			JOptionPane.showMessageDialog(serverFrame, message);
			
			serverFrame.getMessageArea().append(ChatRoomUtils.showMessage(message));
//			如果有客户端连接,会返回一个socket实例
			Socket clientSocket= serverSocket.accept();
			System.out.println("服务端:获得客户端连接");
			
			// TODO: 读取客户端的数据
			InputStream is = clientSocket.getInputStream();
			InputStreamReader isr = new InputStreamReader(is,Charset.forName("utf-8"));
			BufferedReader br = new BufferedReader(isr);
			String data = br.readLine();
			System.out.println("服务端:"+data);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
