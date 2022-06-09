package edu.hunau.gui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**     
*  
* @author 龙翔宇  
* @date 2022年6月9日  新建  
*/
public class HelloFrame {
	public static void main(String[] args) {
		
		JFrame jFrame = new JFrame();
		
//		属于一个容器组件
		JPanel jPanel = new JPanel();
//		定义组件
		JButton addBtn = new JButton("按钮");
		
		new JTextField();
		jPanel.add(addBtn);
		jFrame.add(jPanel);
		jFrame.setTitle("Hello");
		jFrame.setSize(200,300);
		center(jFrame);
//		默认为隐藏状态
		jFrame.setVisible(true);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void center(Window win) {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screen = toolkit.getScreenSize();
		int w = win.getWidth();
		int h = win.getHeight();
		int x = (screen.width - w) / 2;
		int y = (screen.height - h) / 2;
		win.setLocation(x,y);
	}
}
