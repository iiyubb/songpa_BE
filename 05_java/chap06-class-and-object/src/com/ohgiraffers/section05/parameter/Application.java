package com.ohgiraffers.section05.parameter;

import java.util.Arrays;public class Application {
    public static void main(String[] args) {

        MethodParameterTest pt = new MethodParameterTest();

        // 기본 자료형 테스트
        int num = 20;
        System.out.println("호출 전 main의 num : " + num);
        pt.testPrimitiveType(num);
        System.out.println("호출 후 main의 num : " + num);

        // 배열 테스트
        int[] arr = {1,2,3,4,5};
        System.out.println("호출 전 main의 arr : " + Arrays.toString(arr));
        pt.testArrayParameter(arr);
        System.out.println("호출 전 main의 arr : " + Arrays.toString(arr));

        // 객체 테스트
        Rectangle r1 = new Rectangle(12.5, 25.5);
        System.out.println("호출 후 main의 너비 : " + r1.getWidth());
        pt.testObjectParameter(r1);
        System.out.println("호출 후 main의 너비 : " + r1.getWidth());

        // 가변인자 테스트
        pt.orderPizza("홍길동");
        pt.orderPizza("유관순", "불고기");
        pt.orderPizza("이순신", "치즈", "페퍼로니", "올리브");

    }
}
