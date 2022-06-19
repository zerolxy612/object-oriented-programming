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
	
	/**
	 * 消息类型为群发消息
	 */
	public static final String SEND_ALL_MESSAGE="■■";
	
	/**
	 * 解析原始信息
	 * @param data ♦♦张三
	 * @param messageType
	 * @return 战三
	 */
	public static String originMessage(String data,String messageType) {
		
		
		return data.replace(messageType,"");
	}
	
	public static String sendLoginMessage(String username) {
		return CLIENT_LOGIN + username;
	}
	/**
	 * 判断消息的类型
	 * @param message
	 * @return
	 */
	public static String checkMessageType(String message) {
		if(message.startsWith(CLIENT_LOGIN)) {
			return "login";
		}else if(message.startsWith(SEND_ALL_MESSAGE)) {
			return "sendAll";
		}
		return "";
	}

}
