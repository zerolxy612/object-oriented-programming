package edu.hunau.gui.client;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**     
*  
* @author 龙翔宇  
* @date 2022年6月13日  新建  
*/
public class Client {
	
	public static void main(String[] args) {
		try {
			Socket socket = new Socket("localhost",8088);
			System.out.println(socket);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
