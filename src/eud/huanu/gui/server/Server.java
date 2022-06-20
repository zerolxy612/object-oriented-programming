package eud.huanu.gui.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Vector;

import javax.swing.JOptionPane;

import edu.hunau.gui.ServerFrame;
import edu.hunau.gui.utils.ChatRoomProtocol;
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
		try {
			Socket clientSocket =  serverSocket.accept();
			System.out.println("服务端:获得客户端的连接");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
			
			// TODO 持续地对客户端的连接进行监听
			while(true) {
//				如果有客户端连接,会返回一个socket实例
				Socket clientSocket= serverSocket.accept();
				// 将获得的socket实例由线程进行处理
				String clientIp = clientSocket.getLocalAddress().getHostAddress();
				System.out.println("服务端:获得客户端连接");
				serverFrame.getMessageArea().append(ChatRoomUtils.showMessage("获得客户端连接,ip地址为: "+clientIp));
				
				// TODO: 读取客户端的数据
				InputStream is = clientSocket.getInputStream();
				InputStreamReader isr = new InputStreamReader(is,Charset.forName("utf-8"));
				BufferedReader br = new BufferedReader(isr);
//				String data = br.readLine();
//				// TODO 需要进行修改
//				serverFrame.getMessageArea().append(ChatRoomUtils.showMessage(data+"登录上线!"));
				//TODO: 持续读取客户端信息
				while(true) {
					String info = br.readLine();
					
					if (Objects.nonNull(info) && !info.equals("") ) {
						String messageType =  ChatRoomProtocol.checkMessageType(info);
						// 标识为登录消息
						if("login".equals(messageType)) {
							
							//用户上线
							//提取用户信息
							String username = ChatRoomProtocol.originMessage(info,ChatRoomProtocol.CLIENT_LOGIN);
							serverFrame.getMessageArea().append(ChatRoomUtils.showMessage(username+"登录上线!"));
							// 将用户的信息存储到集合中
							//获得输出流
							OutputStream os = clientSocket.getOutputStream();
							PrintWriter out = new PrintWriter(os,true,Charset.forName("utf-8"));
							clientMap.put(username, out);
							System.out.println(clientMap.keySet());
							
							updateClientList(username);
							//将登录消息广播到所有在线客户端中
							
							
						} else if ("sendAll".equals(messageType)){
							String message1 = ChatRoomProtocol.originMessage(info,ChatRoomProtocol.SEND_ALL_MESSAGE);
							serverFrame.getMessageArea().append(ChatRoomUtils.showMessage(message1));
							
							//message发到所有客户端
							if(clientMap.size()>0) {
								Collection<PrintWriter> outs = clientMap.values();
								for(PrintWriter out : outs) {
									out.println(message);
								}
							}
						}
	
						
						serverFrame.getMessageArea().selectAll();
					}
			}

		
				}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 更新在线用户列表
	 * @param username
	 */
	private void updateClientList(String username) {
		Vector<String> row = new Vector<String>();
		row.add(username);
		serverFrame.getClientInfoTableModel().addRow(row);
		
	}

	/**
	 * 在服务器中通过Map集合,维护客户端信息
	 */
	private Map<String,PrintWriter> clientMap = Collections.synchronizedMap(new HashMap<>());
	
	/**
	 * 定义一个服务维护socket的线程
	 */
	private class ServerHandler extends Thread{
		private Socket socket;
		
		public ServerHandler (Socket socket) {
			this.socket = socket;
		}
		
		@Override
		public void run() {
			try {
				
			} catch(Exception e){
				
			}
		}
		
		
	}
}
