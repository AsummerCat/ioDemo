package com.linjingc.io.controller;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * 管道输出流
 *
 * @author cxc
 * @date 2018/12/3 15:37
 */
public class PipedInputStreamDemo {
    /**
     * 10  * 管道字节流
     * 11  * 管道用来把程序、线程或程序块的输出连接到另一个程序、线程或者程序块作为它的输入。
     * 12  * java.io提供了类PipedInputSteramh和PipedOutputStream 作为管道的输入/输出流。
     * 13  * 管道输入流作为一个通信管道接收端，管道输出流作为发送端。管道流必须是输入流输出流同时并用，即在使用管道前，两者必须进行连接。
     * 14  * 无论PipedInputStream还是PipdeOutputStream类都提供了connect()方法可以使用connect()方法建立一个管道进行数据传输。
     * 15  * 管道输入/输出流可以用两种方式进行连接，一种方式是使用connect()方法：
     * 16  *         PipedInputStream pis  = new PipedInputStream();
     * 17  *        PipedOutputStream pos = new PipedOutputStream();
     * 18  *        pis.connect(pos);
     * 19  *        pos.connect(pis);
     * 20  *        另外一种是直接使用构造方法进行连接：
     * 21  *        PipedInputStream pis = new PipedInputStream();
     * 22  *        PipedOutputStream pos = new PipedOutputStream(pis);
     * 23  *
     * 24  *     除了connect()方法PipedInputStream类还继承了InputStream类的read()方法。另外又增加了receive()方法
     * 25  *     PipedOutputStream类也继承自OutputStream类的write()方法。
     * 26  * @throws IOException
     * 27
     */
    public static void main(String[] args) throws IOException {
        int ch1 = 0;
        PipedInputStream pis = new PipedInputStream();
        PipedOutputStream pos = new PipedOutputStream(pis);
        //也可以使用connect()方法
        //    PipedOutputStream pos = new PipedOutputStream();
        //        pos.connect(pis);
        System.out.println("请输入一个字符，按#结束程序！");
        while ((ch1 = System.in.read()) != '#') {
            pos.write(ch1);
            System.out.println((char) pis.read());
        }
    }
}
