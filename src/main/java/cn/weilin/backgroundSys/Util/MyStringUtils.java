package cn.weilin.backgroundSys.Util;

import org.springframework.util.DigestUtils;

public class MyStringUtils {

	/**
	 * 对输入字符串进行md5加密
	 * @param string
	 * @return
	 */
	public static String md5(String string) {
		return DigestUtils.md5DigestAsHex(string.getBytes());
	}
}
