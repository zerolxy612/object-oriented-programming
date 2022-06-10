package edu.hunau.gui;

import java.awt.BorderLayout;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import edu.hunau.gui.utils.BaseFrame;

/**
 * 
 * @author 龙翔宇
 * @date 2022年6月10日 新建
 */
public class LoginFrame extends BaseFrame {
	public void init() {
		Box y_repeat = Box.createVerticalBox();
		Box x_repeat = Box.createHorizontalBox();
		
		JLabel userNameLabel = new JLabel();
		x_repeat.add(new JLabel("用户名"));
		x_repeat.add(new JTextField(20));
		y_repeat.add(Box.createVerticalStrut(25));
		
		this.setSize(300,200);
		
		this.add(x_repeat,BorderLayout.CENTER);this.add(y_repeat,BorderLayout.SOUTH);
		this.setVisible(true);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new LoginFrame().init();
	}
}

