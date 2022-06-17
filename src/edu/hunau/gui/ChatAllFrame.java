package edu.hunau.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Objects;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import edu.hunau.gui.client.Client;
import edu.hunau.gui.utils.BaseFrame;

/**     
*  
* @author 龙翔宇  
* @date 2022年6月14日  新建  
*/
public class ChatAllFrame extends BaseFrame{
	
	private String username;
	private JTextArea messageSendArea;
	
	private Client client;
	private JTextArea messageShowArea;
	
	public ChatAllFrame(String username, Client client) {
		this.username = username;
		this.client = client;
	}
	public ChatAllFrame() {
		
	}
	public ChatAllFrame(String username) {
		this.username = username;
	}
	
	public void init() {
		if(Objects.nonNull(username)) {
			this.setTitle(username);
		} else {
			this.setTitle("匿名");
		}
		
		this.setSize(550,450);
		
		JSplitPane jSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		jSplitPane.setBorder(new EmptyBorder(5,10,5,10));
		jSplitPane.setDividerLocation(150);
		jSplitPane.setDividerSize(5);
		jSplitPane.setEnabled(false);
		
		jSplitPane.setLeftComponent(leftPanel());
		jSplitPane.setRightComponent(rightPanel());
		
		this.add(jSplitPane);
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				int result = JOptionPane.showConfirmDialog(ChatAllFrame.this, "确认退出吗?");
				if(result==JOptionPane.YES_OPTION) {
					// 退出
					System.exit(0);
				}
			}
		});
	}
	
	public JTextArea getMessageSendArea() {
		return messageSendArea;
	}

	private JPanel rightPanel() {
		JPanel jPanel = new JPanel(new BorderLayout(0,5));
		
		JScrollPane messageShowPane = new JScrollPane();
		messageShowPane.setPreferredSize(new Dimension(0,260));
		messageShowArea = new JTextArea();
		messageShowPane.setViewportView(messageShowArea);
		
		JScrollPane messageSendPane = new JScrollPane();
		messageSendArea = new JTextArea();
		messageSendPane.setViewportView(messageSendArea);
		
		JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JButton sendBtn = new JButton("发送");
		sendBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 获得消息
				String message = messageSendArea.getText();
				// TODO: 将message对象,传入到Client中的messageQueue中
				client.addMessage(message);
				messageSendArea.setText("");
				
			}
	});
		btnPanel.add(sendBtn);
		
		jPanel.add(messageShowPane, BorderLayout.NORTH);
		jPanel.add(messageSendPane);
		jPanel.add(btnPanel, BorderLayout.SOUTH);
		
		return jPanel;
	}
	
	/**
	 * 
	 * @return the messageShowArea
	 */
	public JTextArea getMessageShowArea() {
		return messageShowArea;

	}
	private JScrollPane leftPanel() {
		JScrollPane jScrollPane = new JScrollPane();
		DefaultTableModel userInfoModel = new DefaultTableModel(new String[] { "在线用户" },0);
		
		JTable userTable = new JTable(userInfoModel) ;
		jScrollPane.setViewportView(userTable);
		return jScrollPane;
	}
	public static void main(String[] args) {
		
		new ChatAllFrame().init();
	}
}
