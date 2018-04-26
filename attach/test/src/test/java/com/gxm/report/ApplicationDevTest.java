package com.gxm.report;

import com.Application;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * Created by vincent on 2018/1/29.
 */
public class ApplicationDevTest {
    public static void main(String[] args) throws Exception {
        new SpringApplicationBuilder().sources(Application.class).profiles("dev").run(args);
    }
}
