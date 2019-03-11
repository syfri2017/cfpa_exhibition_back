package com.syfri.gatewayservice.utils;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.util.ResourceUtils;
import sun.misc.BASE64Decoder;

import java.io.*;


public class Base64ImageUtil {
    /**
     * 二进制流转Base64字符串
     * <p>Title: byteArr2String</p>
     * @author dongbo
     * @date   2018年4月19日 下午3:04:47
     * @param byteArr
     * @return String
     * @throws IOException
     */
    public static String byteArr2String(byte[] byteArr) throws Exception {
        String stringBase64 = null;
        try {
            Base64 encoder = new Base64();
            stringBase64 =(byteArr != null ? encoder.encodeToString(byteArr) : "");
        } catch (Exception e) {
            throw new Exception("byteArr2String转换异常:"+e);
        }
        return stringBase64;
    }

    /**
     * 将Base64位编码的图片进行解码，并保存到指定目录
     *
     * @param base64
     *            base64编码的图片信息
     * @return
     */
    public static File decodeBase64ToImage(String base64, String imgName, String path) {
        BASE64Decoder decoder = new BASE64Decoder();

        try {
            if(path==null){
                File sfile1 = ResourceUtils.getFile("classpath:temp");
                path = sfile1.toPath().toString();
            }
            File refile=new File(path + imgName);
            FileOutputStream write = new FileOutputStream(refile);
            byte[] decoderBytes = decoder.decodeBuffer(base64);
            write.write(decoderBytes);
            write.close();
            return refile;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static File decodeBase64ToImage(String base64, String imgName) {
        return decodeBase64ToImage(base64,null,null);
    }

}