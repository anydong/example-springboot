package com.example.demo;

import org.springframework.util.StreamUtils;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * <a href="https://fullstackdeveloper.guru/2021/09/21/how-to-read-a-json-request-inside-a-spring-boot-filter/">How to read a JSON request inside a Spring Boot filter?</a>
 *
 * @author VIJAY SRJ
 * @since SEPTEMBER 21, 2021
 */
public class RequestWrapper extends HttpServletRequestWrapper {
    private final byte[] body;

    public RequestWrapper(HttpServletRequest request) throws IOException {
        super(request);

        this.body = StreamUtils.copyToByteArray(request.getInputStream());
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {
        InputStream inputStream = new ByteArrayInputStream(this.body);
        return new ServletInputStream() {
            @Override
            public boolean isFinished() {
                try {
                    return inputStream.available() == 0;
                } catch (Exception e) {
                    return false;
                }
            }

            @Override
            public boolean isReady() {
                return true;
            }

            @Override
            public void setReadListener(ReadListener readListener) {

            }

            @Override
            public int read() throws IOException {
                return inputStream.read();
            }
        };
    }
}