package edu.hunau.gui.layout;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import edu.hunau.gui.utils.BaseFrame;

/**     
*  
* @author 龙翔宇  
* @date 2022年6月10日  新建  
*/
public class BorderLayoutFrame extends BaseFrame{

	public void init() {
		this.setTitle("BorderLayout");
//		JFrame默认为BorderLayout
		this.setLayout(new BorderLayout());
		
		JPanel topPanel = new JPanel();
		JTextField topTextField = new JTextField(20);
		JButton topBtn = new JButton("启动");
		topPanel.add(topTextField);
		topPanel.add(topBtn);
		
		JPanel centerPanel = new JPanel();
		JTextArea centerTextArea = new JTextArea(5,10);
		centerPanel.add(centerTextArea);
		
//		将topPanel添加到JFrame中北部
		this.add(topPanel,BorderLayout.NORTH);
		this.add(centerPanel,BorderLayout.CENTER);
		
		this.setSize(500,300);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new BorderLayoutFrame().init();
	}
}
