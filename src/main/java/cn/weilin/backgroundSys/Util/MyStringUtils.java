package cn.weilin.backgroundSys.Util;

import org.springframework.util.DigestUtils;

public class MyStringUtils {

	/**
	 * �������ַ�������md5����
	 * @param string
	 * @return
	 */
	public static String md5(String string) {
		return DigestUtils.md5DigestAsHex(string.getBytes());
	}
}
