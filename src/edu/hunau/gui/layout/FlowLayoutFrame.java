package edu.hunau.gui.layout;

import java.awt.LayoutManager;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import edu.hunau.gui.utils.BaseFrame;

/**     
*  
* @author 龙翔宇  
* @date 2022年6月9日  新建  
*/
public class FlowLayoutFrame extends BaseFrame{

	
	public void init() {
		this.setTitle("FlowLayout");
		this.setSize(500,400);
		
		JPanel jPanel = new JPanel();
		for(int i = 0; i < 10; i++) {
			JButton btn = new JButton("按钮"+1);
			jPanel.add(btn);
		}
		this.add(jPanel);
//		窗口大小不可调整
		this.setResizable(false);
		LayoutManager layout = this.getLayout();
		System.out.println(layout);
		
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new FlowLayoutFrame().init();
	}
}
