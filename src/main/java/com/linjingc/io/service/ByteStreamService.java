package com.linjingc.io.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.Objects;

/**
 * 字节流
 *
 * @author cxc
 * @date 2018/12/3 11:38
 */
@Service
@Log4j2
public class ByteStreamService {
    private final static String UPLOADPATH = ByteStreamService.class.getClassLoader().getResource("").getPath() + "static" + File.separator + "file";

    /**
     * 基础字节流读取输出
     */
    public void basicByteStream() throws IOException {
        long startTime = System.currentTimeMillis();
        File file = new File(UPLOADPATH + File.separator + "student.jpeg");
        File file2 = new File(UPLOADPATH + File.separator + "studentOut.png");
        //输入流
        InputStream in = null;
        //输出流
        OutputStream out = null;
        try {
            //具体的内容
            in = new FileInputStream(file);
            //输出到的内容
            out = new FileOutputStream(file2);
            int len;
            //设置每次读取字节的大小
            byte[] buf = new byte[1024];
            while ((len = in.read(buf)) != -1) {
                out.write(buf, 0, len);
            }
            ////强制输出缓存  在使用缓存流的时候使用
            //out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //最终关闭流
            Objects.requireNonNull(in).close();
            Objects.requireNonNull(out).close();
            Long endTime = System.currentTimeMillis() - startTime;
            log.info("文件字节流读取时间->{}" + endTime);
        }
    }

    /**
     * 字节缓冲流读取输出
     */
    public void bufferByteStream() throws IOException {
        long startTime = System.currentTimeMillis();
        File file = new File(UPLOADPATH + File.separator + "3dVYP1bwQDk.jpg");
        File file2 = new File(UPLOADPATH + File.separator + "3dVYP1bwQDkOut.jpg");
        //输入流
        InputStream in = null;
        //输出流
        OutputStream out = null;
        try {
            //具体的内容  使用缓冲输入流包装下文件输入流
            in = new BufferedInputStream(new FileInputStream(file));
            //输出到的内容 使用缓冲输出流包装下文件输出流
            out = new BufferedOutputStream(new FileOutputStream(file2));
            int len;
            //设置每次读取字节的大小  (如果不设置每次读取字节大小 效率可能会下降)
            byte[] buf = new byte[1024];
            while ((len = in.read(buf)) != -1) {
                out.write(buf, 0, len);
            }
            //最近一次读取的数据可能达不到1024字节，这里强制清空缓冲区\
            //默认缓冲区大小是8K  强制输出缓冲  在使用缓冲流的时候使用
            out.flush();
            //这样可以保证输出的时候缓冲区中没有缓存的数据
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //最终关闭流
            Objects.requireNonNull(in).close();
            Objects.requireNonNull(out).close();
            Long endTime = System.currentTimeMillis() - startTime;
            log.info("缓冲流读取时间->{}" + endTime);
        }
    }

    /**
     * 数据字节流读取输出
     */
    public void dataByteStream() {
        File file = new File(UPLOADPATH + File.separator + "dataByteStream.txt");

        try {
            //输出到的内容 使用数据字节输出流包装下文件输出流
            DataOutputStream out = new DataOutputStream(new FileOutputStream(file));
            //手动输入数据
            out.writeBoolean(true);
            out.writeByte(1111);
            out.writeFloat(2222L);
            out.writeShort(3333);
            out.writeChar('A');
            //关闭流
            out.close();

            //现在读取
            //具体的内容  使用缓冲输入流包装下文件输入流
            DataInputStream in = new DataInputStream(new FileInputStream(file));
            System.out.println("读取Boolean数据 \t" + in.readBoolean());
            System.out.println("读取Byte数据 \t" + in.readByte());
            System.out.println("读取Float数据 \t" + in.readFloat());
            System.out.println("读取Short数据 \t" + in.readShort());
            System.out.println("读取Char数据 \t" + in.readChar());
            in.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
