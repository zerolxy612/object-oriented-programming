package edu.hunau.gui.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import edu.hunau.gui.ChatAllFrame;
import edu.hunau.gui.utils.ChatRoomProtocol;
import edu.hunau.gui.utils.ChatRoomUtils;

/**     
*  
* @author 龙翔宇  
* @date 2022年6月13日  新建  
*/
public class Client {
	private Socket socket;
	private String username;
	private ChatAllFrame chatAllFrame;
	
	/**
	 *  客户端发送消息的消息队列
	 *  messageQueue必须是线程安全的集合对象
	 */
	private List<String> messageQueue = Collections.synchronizedList(new LinkedList<String>()) ;
	
	public void addMessage(String message) {
		messageQueue.add(message);
		System.out.println("client-addMessage==>"+ messageQueue);
	}
	
	public void setChatAllFrame(ChatAllFrame chatAllFrame) {
		this.chatAllFrame = chatAllFrame;
	}

	public Client() {
		try {
			socket = new Socket("localhost",8088);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public Client(String username,String hostName, int port) {
		try {
			this.username = username;
			socket = new Socket(hostName,port);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public void start() {
		// 启动发送线程的任务
		new Thread(new SendMessageHandler()).start();
		//启动接收消息的线程
		new ReceiveMessageHandler().start();
	}
	/**
	 * 接收消息的线程
	 */
	private class ReceiveMessageHandler extends Thread{
		@Override
		public void run() {
			try {
				InputStream is = socket.getInputStream();
				InputStreamReader isr =  new InputStreamReader(is,Charset.forName("utf-8"));
				BufferedReader br = new BufferedReader(isr);
				while(true) {
					String message = br.readLine();
					if(Objects.nonNull(message)&& !message.equals("")) {
						chatAllFrame.getMessageShowArea().append(ChatRoomUtils.chatMessage(message));
						chatAllFrame.getMessageShowArea().selectAll();;
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 客户端 发送消息的线程
	 * @author LXY
	 *
	 */
	private class SendMessageHandler implements Runnable{

		@Override
		public void run() {
			try {
				OutputStream os = socket.getOutputStream();
				PrintWriter out = new PrintWriter(os,true,Charset.forName("utf-8"));
				out.println(ChatRoomProtocol.sendLoginMessage(username));
				while(true) {
					// 从消息框中获得用户输入的信息
					if(!messageQueue.isEmpty() && messageQueue.size()>0) {
						System.out.println("client-addMessage==>"+messageQueue);
						// 从index位置移除数据,并将数据返回
						String message = messageQueue.remove(0);
					    out.println(ChatRoomProtocol.SEND_ALL_MESSAGE + message);
					}
				    
				}
			}catch(Exception e){
				throw new RuntimeException(e);
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		try {
			Socket socket = new Socket("localhost",8088);
			System.out.println(socket);
			OutputStream os = socket.getOutputStream();
			// TRUE 自动刷新
			PrintWriter out = new PrintWriter(os,true,Charset.forName("utf-8"));
			out.println("我来了!");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}
