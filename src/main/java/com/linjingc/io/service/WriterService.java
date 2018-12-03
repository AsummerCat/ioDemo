package com.linjingc.io.service;

import org.springframework.stereotype.Service;

import java.io.*;

/**
 * 字符流
 *
 * @author cxc
 * @date 2018/12/3 11:38
 */
@Service
public class WriterService {
    private final static String UPLOADPATH = ByteStreamService.class.getClassLoader().getResource("").getPath() + "static" + File.separator + "file";


    /**
     * 基础字符流输入
     */
    public void basicWriter() throws IOException {
        Writer fileWriter = new FileWriter(new File(UPLOADPATH, "Writer.txt"));
        fileWriter.write("哈哈哈哈字符流输入");
        //换行
        fileWriter.write("\r\n");
        fileWriter.write("哈哈哈哈字符流输入");
        fileWriter.write("\r\n");
        fileWriter.write("哈哈哈哈字符流输入");
        fileWriter.flush();
        fileWriter.close();
    }

    /**
     * 基础字符流输出
     */
    public void basicReader() throws IOException {
        Reader fileReader = new FileReader(new File(UPLOADPATH, "Writer.txt"));
        char[] c = new char[1024];
        int temp;
        int len = 0;
        while ((temp = fileReader.read()) != -1) {
            c[len] = (char) temp;
            len++;
        }
        fileReader.close();
        System.out.println(new String(c, 0, len));
    }

    /**
     * 字符缓冲流包装 换行输入
     */
    public void newLineWriter() throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(UPLOADPATH, "Writer.txt"), true));
        //换行
        bufferedWriter.newLine();
        bufferedWriter.write("再来一行");
        bufferedWriter.flush();
        bufferedWriter.close();
    }


    /**
     * 字符缓冲流包装 换行输出
     */
    public void newLineReader() throws IOException {
        BufferedReader fileReader = new BufferedReader(new FileReader(new File(UPLOADPATH, "Writer.txt")));
        String tempString;
        int line = 1;
        // 一次读入一行，直到读入null为文件结束 换行输出
        while ((tempString = fileReader.readLine()) != null) {
            // 显示行号
            System.out.println("line " + line + ": " + tempString);
            line++;
        }
        fileReader.close();
    }


    /**
     * 转换流 读取字节流 输出字符流
     */
    public void inputStreamWriterTest() {
        File src = new File(UPLOADPATH, "Writer.txt");
        File dest = new File(UPLOADPATH, "Reee.txt");
        BufferedWriter bw = null;
        BufferedReader br = null;
        FileInputStream fis;
        FileOutputStream fos;
        try {
            fis = new FileInputStream(src);
            fos = new FileOutputStream(dest);
            InputStreamReader ir = new InputStreamReader(fis, "UTF-8");
            OutputStreamWriter ow = new OutputStreamWriter(fos, "UTF-8");
            br = new BufferedReader(ir);
            bw = new BufferedWriter(ow);
            String str;
            while ((str = br.readLine()) != null) {
                bw.write(str);
                bw.newLine();
                bw.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            if (bw != null) {
                bw.close();
            }
            if (br != null) {
                br.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
