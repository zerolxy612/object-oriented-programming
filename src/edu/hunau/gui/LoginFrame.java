package edu.hunau.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import edu.hunau.gui.utils.BaseFrame;

/**
 * 
 * @author 龙翔宇
 * @date 2022年6月10日 新建
 */
public class LoginFrame extends BaseFrame {
	public void init() {
		this.setTitle("登录");
		Box y_repeat = Box.createVerticalBox();
		
		y_repeat.add(Box.createVerticalStrut(5));
		
		JPanel titlePanel = new JPanel();
		JLabel titleLabel = new JLabel("登录服务器");
		titleLabel.setFont(new Font("黑体",Font.BOLD,30));
		titlePanel.add(titleLabel);
		y_repeat.add(titlePanel);
		y_repeat.add(Box.createVerticalStrut(5));
		
		
		JPanel userNamePanel = new JPanel();
		JLabel userNameLabel = new JLabel("用户名");
		JTextField userNameField = new JTextField(20);
		userNamePanel.add(userNameLabel);
		userNamePanel.add(userNameField);
		
		y_repeat.add(userNamePanel);
		y_repeat.add(Box.createVerticalStrut(15));
		
		JPanel hostPanel = new JPanel();
		JLabel hostLabel = new JLabel("主机名");
		JTextField hostField = new JTextField(20);
		hostField.setText("localhost");
		hostPanel.add(hostLabel);
		hostPanel.add(hostField);
		
		y_repeat.add(hostPanel);
		y_repeat.add(Box.createVerticalStrut(5));
		
		JPanel portPanel = new JPanel();
		JLabel portLabel = new JLabel("端口号");
		JTextField portField = new JTextField(20);
		portField.setText("8088");
		portPanel.add(portLabel);
		portPanel.add(portField);
		
		y_repeat.add(portPanel);
		y_repeat.add(Box.createVerticalStrut(5));
		
		JPanel btnPanel = new JPanel();
		JButton restBtn = new JButton("重置");
		JButton connBtn = new JButton("连接");
//		为connBtn绑定事件
		connBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("按钮被单击");
				String username = userNameField.getText();
				System.out.println(username);			
				}
		});
		btnPanel.add(restBtn);
		btnPanel.add(connBtn);
		
		y_repeat.add(btnPanel);
		
		this.setSize(350,280);
		
		this.add(y_repeat);
		this.setVisible(true);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	public static void main(String[] args) {
		new LoginFrame().init();
	}
}

