package com.ohgiraffers.section01.time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Application {
    public static void main(String[] args) {
        /*
         * - LocalDate: 날짜 정보면 표현 (2025-12-25)
         * - LocalTime: 시간 정보만 표현 (13:08:00)
         * - LocalDateTime: 날짜와 시간 모두 펴현(2025-12-25T13:08:00)
         */

        LocalDate departureDate = LocalDate.of(2026, 12, 25);
        LocalTime departureTime = LocalTime.of(13, 8);

        LocalDateTime trainDeparture = LocalDateTime.of(departureDate, departureTime);
        System.out.println("부산행 KTX 출발 시각: " + trainDeparture);

        System.out.println(trainDeparture.getYear());
        System.out.println(trainDeparture.getMonth());
        System.out.println(trainDeparture.getMonthValue());
        System.out.println(trainDeparture.getDayOfWeek());
        System.out.println(trainDeparture.getHour());

        LocalDateTime arrivalDeadline = trainDeparture.minusMinutes(20);
        System.out.println(arrivalDeadline);

        // trainDeparture 시간이 now 시간보다 isBefore인가?
        boolean isPast = trainDeparture.isBefore(LocalDateTime.now());
        System.out.println(isPast);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시 mm분 출발");
        String formattedDate = trainDeparture.format(formatter);
        System.out.println("ticket = " + formattedDate);

        // 반대로 특정 형식의 문자열을 날짜 객체로 변환(분석, Parse)
        String christmasInput = "261225"; // yyMMdd

        DateTimeFormatter christmasParser = DateTimeFormatter.ofPattern("yyMMdd");

        // LocalDate.parse()에 문자열과 패턴 전달
        LocalDate parsedChristmas = LocalDate.parse(christmasInput, christmasParser);
        System.out.println("parsedChristmas = " + parsedChristmas);

    }
}
