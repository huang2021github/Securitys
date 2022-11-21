package com.security.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class OpenBrowser implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("开始自动加载指定页面");
        Runtime.getRuntime().exec("cmd /c start http://localhost:8080/backend/security/indexTo/pc");
    }
}
