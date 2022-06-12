package edu.hunau.gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import edu.hunau.gui.utils.BaseFrame;
import server.Server;

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
		JPanel jPanel =  new JPanel(new FlowLayout(FlowLayout.RIGHT));
		
		JTextField messageField = new JTextField(15);
		messageField.setPreferredSize(new Dimension(0,28));
		
		JButton sendBtn = new JButton("发送");
		
		jPanel.add(messageField);
		jPanel.add(sendBtn);
		return jPanel;
	}
	
	
//	中间的组件
	private Component middlePanel() {
		JPanel jPanel =  new JPanel();
		
//		获得分割组件为水平摆放的切分面板
		JSplitPane jSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		
		jSplitPane.setDividerSize(5);
		jSplitPane.setDividerLocation(150);
//		设置切分线位置不可移动
		jSplitPane.setEnabled(false);
		
	    JScrollPane leftPane = new JScrollPane();
//	    表格中的数据模型
//	    提供字段名称
	    Vector<String> colNames = new Vector<>();
	    colNames.add("客户端名称");
	    
	    DefaultTableModel clientInfoTableModel = new DefaultTableModel(colNames,0);
	    JTable clientTable = new JTable(clientInfoTableModel);
		leftPane.setViewportView(clientTable);
	    
        jSplitPane.setLeftComponent(leftPane);
        
        JScrollPane rightPane = new JScrollPane();
		
		JTextArea messageArea = new JTextArea();
		rightPane.setViewportView(messageArea);
		
		jSplitPane.setRightComponent(rightPane);
		
		return jSplitPane;
	}

//	顶部的组件
	private JPanel topPanel() {
		JPanel jPanel = new JPanel();
		
		JLabel jLabel = new JLabel("服务器端口");
		JTextField portField = new JTextField();
		portField.setPreferredSize(new Dimension(50,28));
		
//		设置内容在文本框居中
		portField.setHorizontalAlignment(JTextField.CENTER);
//		设置默认值
		portField.setText("8088");
		
//		设置按钮的图标
		JButton excuteBtn = new JButton(new ImageIcon("start.png"));
		// TODO: 启动服务器
		excuteBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String btnStatus = excuteBtn.getIcon().toString();
				if (btnStatus.startsWith("start")) {
					//启动服务器 Server必须由线程进行处理
					new Thread(new Server()).start();
					//设置图标
					excuteBtn.setIcon(new ImageIcon("stop.png"));
				}else {
					//关闭服务器
					excuteBtn.setIcon(new ImageIcon("start.png"));
				}
				
			}
		});
		
		jPanel.add(jLabel);
		jPanel.add(portField);
		jPanel.add(excuteBtn);
		
		return jPanel;
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable(){
			
			@Override
			public void run() {
				new ServerFrame().init();
			}
		});
		
	}
}
