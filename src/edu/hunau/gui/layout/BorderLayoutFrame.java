package edu.hunau.gui.layout;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

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
		
//		将topPanel添加到JFrame中北部
		this.add(topPanel(),BorderLayout.NORTH);
		this.add(centerPanel());
		this.add(bottomPanel(),BorderLayout.SOUTH);
		
		this.setSize(500,300);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public JPanel bottomPanel() {
		JPanel jPanel = new JPanel();
		JButton sendBtn = new JButton("提交");
		JButton resetBtn = new JButton("重置");
		
		jPanel.add(resetBtn);
		jPanel.add(sendBtn);
		
		return jPanel;
	}
	
	public JScrollPane centerPanel() {
		JScrollPane jScrollPane = new JScrollPane();
		jScrollPane.setBorder(new EmptyBorder(5,15,5,15));
		JTextArea centerTextArea = new JTextArea(2,3);
		jScrollPane.setViewportView(centerTextArea);
		return jScrollPane;
	}
	
//	顶部容器
	public JPanel topPanel() {
		JPanel topPanel = new JPanel();
		JTextField topTextField = new JTextField(20);
		topTextField.setPreferredSize(new Dimension(0,30));
		JButton topBtn = new JButton("启动");
		topPanel.add(topTextField);
		topPanel.add(topBtn);
		return topPanel;
	}
	
	public static void main(String[] args) {
		new BorderLayoutFrame().init();
	}
}
