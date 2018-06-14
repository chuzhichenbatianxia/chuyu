package com.yu.utils;



import java.util.List;

public class StringHelper {

	/**
	 * 判断字符串是否为空
	 * @param str
	 * @return
	 */
	public static boolean isNullOrEmpty(Object str) {
		return str==null || str.toString().trim().length()==0;
	}

	/**
	 * 将列表转换为带分隔符的字符串
	 * @param list
	 * @param separator
	 * @return
	 */
	public static String listToString(List list, char separator)
	{
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < list.size(); i++)
		{
			sb.append(list.get(i)).append(separator);
		}
		String s = sb.toString();
		return s.substring(0,s.length()-1);
	}

	public static boolean IsAllNullOrEmpty(Object... str)
	{
		for(Object obj : str)
		{
			if(!StringHelper.isNullOrEmpty(str))
			{
				return false;
			}
		}
		return true;
	}

	public static boolean existNullOrEmpty(Object... str)
	{
		for(Object obj : str)
		{
			if(StringHelper.isNullOrEmpty(str))
			{
				return true;
			}
		}
		return false;
	}
}
