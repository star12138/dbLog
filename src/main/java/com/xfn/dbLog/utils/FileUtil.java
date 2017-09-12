package com.xfn.dbLog.utils;


import com.xfn.dbLog.exception.XFNException;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

/**
 * Created by xiaobai on 17/2/20.
 */
public class FileUtil {

    public static void checkMapQueue(Map<String, String> taskMap, String taskKey, String uuid) {
        if (null == taskMap.get(taskKey)) {
            taskMap.put(taskKey, uuid);
        } else {
            throw new XFNException(16830);
        }
    }

    public static void checkMapQueueDelete(Map<String, String> taskMap, String taskKey, String uuid, File tempDir) {
        String taskValue = taskMap.get(taskKey);
        if (taskValue != null && taskValue.equals(uuid)) {
            if (!FileUtil.deleteDir(tempDir)) {
                System.out.println("删除文件夹异常");
            } else {
                System.out.println("删除文件夹成功！");
            }
            taskMap.remove(taskKey);
        }
    }

    public static boolean deleteDir(File dir) {
        if (dir.isDirectory()) {
            String[] children = dir.list();
            if (null != children) {
                for (String child : children) {
                    if (!deleteDir(new File(dir, child))) {
                        return false;
                    }
                }
            }
        }
        // 目录此时为空，可以删除
        return dir.delete();
    }

    public static void createFile(File tempFile) throws IOException {
        if (!tempFile.exists()) {
            if (tempFile.createNewFile()) {
                System.out.println("创建临时文件夹成功");
            } else {
                throw new XFNException(1, "创建临时文件异常！");
            }
        }
    }

    public static void mkDir(File tempDir) {
        if (!tempDir.exists()) {
            if (tempDir.mkdirs()) {// 创建目标目录
                System.out.println("创建目录成功！" + tempDir);
            } else {
                System.out.println("创建目录失败！目录已存在");
            }
        }
    }

    /**
     * 压缩图片指定大小
     *
     * @param w
     * @param h
     * @param file
     * @throws IOException
     */
    public static void resize(int w, int h, File file) throws IOException {
        // SCALE_SMOOTH 的缩略算法 生成缩略图片的平滑度的 优先级比速度高 生成的图片质量比较好 但速度慢


//        BufferedImage image = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
//        Graphics2D g2d = image.createGraphics();
//        image = g2d.getDeviceConfiguration().createCompatibleImage(w, h,
//                Transparency.TRANSLUCENT);
//        g2d.dispose();
//        g2d = image.createGraphics();
//
//        Image from = image.getScaledInstance(w, h, BufferedImage.SCALE_AREA_AVERAGING);
//
//        g2d.drawImage(from, 0, 0, w, h, Color.red, null); // 绘制缩小后的图
//
//        FileOutputStream out = new FileOutputStream(file); // 输出到文件流
//        ImageIO.write(image, "jpg", out);

        BufferedImage image = ImageIO.read(file);
        BufferedImage toImage = new BufferedImage(w, h,

                BufferedImage.TYPE_INT_RGB);

        Graphics2D g2d = toImage.createGraphics();

        toImage = g2d.getDeviceConfiguration().createCompatibleImage(w, h,

                Transparency.TRANSLUCENT);

        g2d.dispose();

        g2d = toImage.createGraphics();

        Image from = image.getScaledInstance(w, h, 16);
        g2d.drawImage(from, 0, 0, null);
        g2d.dispose();
        FileOutputStream out = new FileOutputStream(file); // 输出到文件流

        ImageIO.write(toImage, "png", out);


        out.close();


//        // 可以正常实现bmp、png、gif转jpg
//        JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
//        encoder.encode(image); // JPEG编码
//        out.close();
    }
}
