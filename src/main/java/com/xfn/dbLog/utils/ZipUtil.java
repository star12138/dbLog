package com.xfn.dbLog.utils;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 *
 * Created by xiaobai on 17/2/20.
 */
public class ZipUtil {
    private ZipUtil() {
    }

    public static void doCompress(String srcFile, String zipFile) throws IOException {
        doCompress(new File(srcFile), new File(zipFile));
    }

    /**
     * 文件压缩
     *
     * @param srcFile 目录或者单个文件
     * @param zipFile 压缩后的ZIP文件
     */
    public static void doCompress(File srcFile, File zipFile) throws IOException {
        ZipOutputStream out = null;
        try {
            out = new ZipOutputStream(new FileOutputStream(zipFile));
            doCompress(srcFile, out);
        } catch (Exception e) {
            throw e;
        } finally {
            out.close();//记得关闭资源
        }
    }

    public static void doCompress(String filelName, ZipOutputStream out) throws IOException {
        doCompress(new File(filelName), out);
    }

    public static void doCompress(File file, ZipOutputStream out) throws IOException {
        doCompress(file, out, "");
    }

    public static void doCompress(File inFile, ZipOutputStream out, String dir) throws IOException {
        if (inFile.isDirectory()) {
            File[] files = inFile.listFiles();
            if (files != null && files.length > 0) {
                for (File file : files) {
                    String name = inFile.getName();
                    if (!"".equals(dir)) {
                        name = dir + "/" + name;
                    }
                    ZipUtil.doCompress(file, out, name);
                }
            }
        } else {
            ZipUtil.doZip(inFile, out, dir);
        }
    }

    public static void doZip(File inFile, ZipOutputStream out, String dir) throws IOException {
        String entryName = null;
        if (!"".equals(dir)) {
            entryName = dir + "/" + inFile.getName();
        } else {
            entryName = inFile.getName();
        }
        ZipEntry entry = new ZipEntry(entryName);
        out.putNextEntry(entry);

        int len = 0;
        byte[] buffer = new byte[1024];
        FileInputStream fis = new FileInputStream(inFile);
        while ((len = fis.read(buffer)) > 0) {
            out.write(buffer, 0, len);
            out.flush();
        }
        out.closeEntry();
        fis.close();
    }

    public static void main(String[] args) throws IOException {
        doCompress("D:/java/", "D:/java.zip");
    }

    public static byte[] readInputStream(InputStream inputStream) throws IOException {
        byte[] buffer = new byte[1024];
        int len = 0;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        while ((len = inputStream.read(buffer)) != -1) {
            bos.write(buffer, 0, len);
        }
        bos.close();
        return bos.toByteArray();
    }


    public static String doZIP(String zipname, File[] files) throws Exception {
        //doZIP(命名的打包文件名，传递过来的File数组)
        byte[] buffer = new byte[1024];

        String strZipName = zipname;
        ZipOutputStream out = null;

        out = new ZipOutputStream(new FileOutputStream(strZipName));

        for (int i = 0; i < files.length; i++) {

            FileInputStream fis = new FileInputStream(files[i]);

            out.putNextEntry(new ZipEntry(files[i].getName()));

            int len;

            //读入需要下载的文件的内容，打包到zip文件

            while ((len = fis.read(buffer)) > 0) {

                out.write(buffer, 0, len);

            }

            out.closeEntry();

            fis.close();

        }
        out.close();


//        } finally {
//            if (out != null) {
//                out.close();
//            }
//
//        }
        return strZipName;

    }


    public static void zip(String zipName, HttpServletResponse response) throws Exception {
        InputStream inputStreamZip = null;
        OutputStream os = null;
        File tempFile = new File(zipName);
        try {

            inputStreamZip = new FileInputStream(tempFile);//通过zip路径实例化inputStream流

            os = response.getOutputStream();
            byte[] b = new byte[2048];
            int length;
            while ((length = inputStreamZip.read(b)) > 0) {
                os.write(b, 0, length);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (os != null) {
                os.close();
            }
            if (inputStreamZip != null) {
                inputStreamZip.close();
            }
        }

    }


    public static  void toZip(File[] tarFile, ZipOutputStream out, byte[] buffer) throws Exception {
        for (int i = 0; i < tarFile.length; i++) {
            FileInputStream fis = new FileInputStream(tarFile[i]);
            out.putNextEntry(new ZipEntry(tarFile[i].getName()));
            int len;
            while ((len = fis.read(buffer)) > 0) {
                out.write(buffer, 0, len);
            }
            out.closeEntry();
            if (fis != null) {
                fis.close();
            }
        }
        if (out != null) {
            out.close();
        }
    }

}
