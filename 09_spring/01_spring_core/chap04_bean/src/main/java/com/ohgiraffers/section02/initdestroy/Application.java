package com.ohgiraffers.section02.initdestroy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {

        // Bean이 생성 및 초기화 됨
        ApplicationContext context = new AnnotationConfigApplicationContext(ContextConfiguration.class);

        ((AnnotationConfigApplicationContext)context).close(); // 컨테이너 종료
    }
}
