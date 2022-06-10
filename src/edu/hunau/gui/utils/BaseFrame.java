package edu.hunau.gui.utils;

import java.awt.Dimension;

import java.awt.Toolkit;
import java.awt.Window;

import javax.swing.JFrame;

/**     
*  
* @author 龙翔宇  
* @date 2022年6月9日  新建  
*/
public class BaseFrame extends JFrame{
	
	@Override
	public void setVisible(boolean b) {
		center(this);
		super.setVisible(b);
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
