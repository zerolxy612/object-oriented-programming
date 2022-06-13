package edu.hunau.gui.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**     
*  
* @author 龙翔宇  
* @date 2022年6月13日  新建  
*/
public class ChatRoomUtils {

	public static String showMessage(String message) {
		LocalDateTime now = LocalDateTime.now();
		String time = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		return time + ":" + message + "\n";
	}
}