package com.yoyo.gamecenter.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.*;

/**
 * Created by Administrator on 2017/6/20 0020.
 */
public class FileUtil {

    /**
     * 获取扩展名
     * @param filename
     * @return
     */
    public static String getExtensionName(String filename) {
        if ((filename != null) && (filename.length() > 0)) {
            int dot = filename.lastIndexOf('.');
            if ((dot >-1) && (dot < (filename.length() - 1))) {
                return filename.substring(dot + 1);
            }
        }
        return filename;
    }

    /**
     * 获取不带扩展名的文件名
     * @param filename
     * @return
     */
    public static String getFileNameNoEx(String filename) {
        if ((filename != null) && (filename.length() > 0)) {
            int dot = filename.lastIndexOf('.');
            if ((dot >-1) && (dot < (filename.length()))) {
                return filename.substring(0, dot);
            }
        }
        return filename;
    }

    public static boolean copyFile(MultipartFile srcFile , File destFile){
        if(!destFile.getParentFile().exists()){
            destFile.getParentFile().mkdirs();
        }
        InputStream in = null;
        FileOutputStream out = null;
        try {
            byte[] b = srcFile.getBytes();

            out = new FileOutputStream(destFile);
            out.write(b);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }finally {
            try {
                if(out != null){
                    out.close();
                }
                if (in != null){
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * 向文件写入数据
     *
     * @param path
     * @param content
     * @throws IOException
     */
    public static void writeToFile(String path, String content) throws IOException {
        File file = new File(path);
        File parent = file.getParentFile();
        if (!parent.exists()) {
            parent.mkdirs();
        }
        if (!file.exists()) {
            file.createNewFile();
        }
        //FileWriter fw = new FileWriter(file);
        //fw.write(content);
        //fw.flush();
        //fw.close();
        OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(file),"utf-8");
        out.write(content.toCharArray());
        out.flush();
        out.close();
    }
}
