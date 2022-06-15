package edu.hunau.gui.client;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.Charset;

/**     
*  
* @author 龙翔宇  
* @date 2022年6月13日  新建  
*/
public class Client {
	private Socket socket;
	private String username;
	
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
		try {
			OutputStream os = socket.getOutputStream();
			PrintWriter out = new PrintWriter(os,true,Charset.forName("utf-8"));
			out.println(username);
		}catch(Exception e){
			throw new RuntimeException(e);
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

	public void addMessage(String message) {
		// TODO Auto-generated method stub
		
	}
}
