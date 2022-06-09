package edu.hunau.gui;

import javax.swing.JFrame;

import edu.hunau.gui.utils.BaseFrame;

/**     
*  
* @author 龙翔宇  
* @date 2022年6月9日  新建  
*/
public class DemoFrame extends BaseFrame{
	
	public void init() {
		this.setTitle("测试窗口");
		this.setSize(300,400);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new DemoFrame().init();

	}

}
