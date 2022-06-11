package edu.hunau.gui;

import java.awt.Dimension;
import java.awt.Component;
import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import edu.hunau.gui.utils.BaseFrame;

/**     
*  
* @author 龙翔宇  
* @date 2022年6月11日  新建  
*/
public class ServerFrame extends BaseFrame{
	
	public void init() {
		this.setSize(500,450);
		
		this.add(topPanel(),BorderLayout.NORTH);
		this.add(middlePanel());
		this.add(bottomPanel(),BorderLayout.SOUTH);
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
//	底部的组件
	private JPanel bottomPanel() {
		JPanel jPanel =  new JPanel();
		return jPanel;
	}
	
	
//	中间的组件
	private Component middlePanel() {
		JPanel jPanel =  new JPanel();
		return jPanel;
	}

//	底部的组件
	private JPanel topPanel() {
		JPanel jPanel = new JPanel();
		
		JLabel jLabel = new JLabel("服务器端口");
		JTextField portField = new JTextField();
		portField.setPreferredSize(new Dimension(50,30));
		
//		设置内容在文本框居中
		portField.setHorizontalAlignment(JTextField.CENTER);
//		设置默认值
		portField.setText("8080");
		
//		设置按钮的图标
		JButton excuteBtn = new JButton(new ImageIcon("start.png"));
		
		jPanel.add(jLabel);
		jPanel.add(portField);
		jPanel.add(excuteBtn);
		
		return jPanel;
	}
	public static void main(String[] args) {
		new ServerFrame().init();
	}
}
