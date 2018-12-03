package com.linjingc.io.controller;

import com.linjingc.io.service.ByteStreamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * 字节流
 *
 * @author cxc
 * @date 2018/12/3 11:38
 */
@RestController
@RequestMapping("byteStream")
public class ByteStreamController {

    @Autowired
    private ByteStreamService byteStreamService;

    /**
     * 基础字节流读取
     */
    @RequestMapping("basic")
    public void basicByteStream() throws IOException {
        byteStreamService.basicByteStream();
    }

    /**
     * 字节缓冲流读取输出
     */
    @RequestMapping("buffer")
    public void bufferByteStream() throws IOException {
        byteStreamService.bufferByteStream();
    }

    /**
     * 数据输出流读取输出
     */
    @RequestMapping("data")
    public void dataByteStream() {
        byteStreamService.dataByteStream();
    }


}

