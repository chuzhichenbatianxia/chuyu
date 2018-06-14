package com.yu.utils;

/**
 * Created by Administrator on 2016/9/26.
 */

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.security.SecureRandom;

/**
 * Created by Administrator on 2016/9/26.
 */


public class DES {
    private static String strDefaultKey = "makebsky";
    private Cipher encryptCipher = null;
    private Cipher decryptCipher = null;

    /**
     * 将byte数组转换为表示16进制值的字符串， 如：byte[]{8,18}转换为：0813， 和public static byte[] hexStr2ByteArr(String strIn) 互为可逆的转换过程
     * @param arrB 需要转换的byte数组
     * @return 转换后的字符串
     * @throws Exception 本方法不处理任何异常，所有异常全部抛出
     */
    private static String byteArr2HexStr(byte[] arrB) {
        int iLen = arrB.length;
        // 每个byte用两个字符才能表示，所以字符串的长度是数组长度的两倍
        StringBuffer sb = new StringBuffer(iLen * 2);
        for (int i = 0; i < iLen; i++) {
            int intTmp = arrB[i];
            // 把负数转换为正数
            while (intTmp < 0) {
                intTmp = intTmp + 256;
            }
            // 小于0F的数需要在前面补0
            if (intTmp < 16) {
                sb.append("0");
            }
            sb.append(Integer.toString(intTmp, 16));
        }
        return sb.toString();
    }

    /**
     * 将表示16进制值的字符串转换为byte数组， 和public static String byteArr2HexStr(byte[] arrB)互为可逆的转换过程
     *
     * @param strIn 需要转换的字符串
     * @return 转换后的byte数组
     * @throws Exception 本方法不处理任何异常，所有异常全部抛出
     * @author <a href="mailto:leo841001@163.com" mce_href="mailto:leo841001@163.com">LiGuoQing</a>
     */
    private static byte[] hexStr2ByteArr(String strIn){
        byte[] arrB = strIn.getBytes();
        int iLen = arrB.length;
        // 两个字符表示一个字节，所以字节数组长度是字符串长度除以2
        byte[] arrOut = new byte[iLen / 2];
        for(int i = 0; i < iLen; i = i + 2){
            String strTmp = new String(arrB, i, 2);
            arrOut[i / 2] = (byte) Integer.parseInt(strTmp, 16);
        }
        return arrOut;
    }


    /**
     * 从指定字符串生成密钥，密钥长度必须为8的倍数
     *
     * @param key 待处理的密钥
     * @return 生成的密钥
     * @throws Exception
     */
    private static String getKey(String key)
    {
        if(key==null || key.length()==0)
        {
            key=strDefaultKey;
        }
        if(key.length() == 8)
        {
            return key;
        }
        return Encrypt.MD5(key);
    }


    public static String Encrypt(String data)
    {
        return Encrypt(data,null);
    }

     public static String Encrypt(String data, String key)
     {
         if(data==null || data.length()==0)
         {
             return null;
         }
         return  byteArr2HexStr(Encrypt(data.getBytes(),key));
     }

    public static byte[] Encrypt(byte[] data, String key) {
        try{
            SecureRandom random = new SecureRandom();
            DESKeySpec desKey = new DESKeySpec(getKey(key).getBytes());
            //创建一个密匙工厂，然后用它把DESKeySpec转换成
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey securekey = keyFactory.generateSecret(desKey);
            //Cipher对象实际完成加密操作
            Cipher cipher = Cipher.getInstance("DES");
            //用密匙初始化Cipher对象
            cipher.init(Cipher.ENCRYPT_MODE, securekey, random);
            //现在，获取数据并加密
            //正式执行加密操作
            return cipher.doFinal(data);
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static String Decrypt(String data)
    {
        return Decrypt(data,null);
    }

    public static String Decrypt(String data, String key)
    {
        if(data==null || data.length()==0)
        {
            return null;
        }
        return new String(Decrypt(hexStr2ByteArr(data),key));
    }

    public static byte[] Decrypt(byte[] data, String key){
        try{
            // DES算法要求有一个可信任的随机数源
            SecureRandom random = new SecureRandom();
            // 创建一个DESKeySpec对象
            DESKeySpec desKey = new DESKeySpec(getKey(key).getBytes());
            // 创建一个密匙工厂
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            // 将DESKeySpec对象转换成SecretKey对象
            SecretKey securekey = keyFactory.generateSecret(desKey);
            // Cipher对象实际完成解密操作
            Cipher cipher = Cipher.getInstance("DES");
            // 用密匙初始化Cipher对象
            cipher.init(Cipher.DECRYPT_MODE, securekey, random);
            // 真正开始解密操作
            return cipher.doFinal(data);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
