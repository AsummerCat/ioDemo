package com.linjingc.io.controller;

import com.linjingc.io.service.WriterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 字符流
 *
 * @author cxc
 * @date 2018/12/3 11:38
 */
@RequestMapping("writer")
@RestController
public class WriterController {
    @Autowired
    private WriterService writerService;

    /**
     * 基础字符流输入
     */
    @RequestMapping("basicWriter")
    public void basicWriter() throws Exception {
        writerService.basicWriter();
    }

    /**
     * 基础字符流输出
     */
    @RequestMapping("basicReader")
    public void basicReader() throws Exception {
        writerService.basicReader();
    }


    /**
     * 字符缓冲流包装 换行输入
     */
    @RequestMapping("newLineWriter")
    public void newLineWriter() throws Exception {
        writerService.newLineWriter();
    }

    /**
     * 字符缓冲流包装 换行输出
     */
    @RequestMapping("newLineReader")
    public void newLineReader() throws Exception {
        writerService.newLineReader();
    }

    /**
     * 转换流 读取字节流 输出字符流
     */
    @RequestMapping("inputStreamWriterTest")
    public void inputStreamWriterTest() {
        writerService.inputStreamWriterTest();
    }

}
