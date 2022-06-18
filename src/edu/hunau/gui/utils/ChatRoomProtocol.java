package edu.hunau.gui.utils;
/**     
*  聊天室的协议
*  
* @author 龙翔宇  
* @date 2022年6月18日  新建  
*/
public interface ChatRoomProtocol {
	/**
	 * 该消息为登录信息
	 */
	public static final String CLIENT_LOGIN="♦♦";
	
	public static String sendLoginMessage(String username) {
		return CLIENT_LOGIN + username;
	}

}
