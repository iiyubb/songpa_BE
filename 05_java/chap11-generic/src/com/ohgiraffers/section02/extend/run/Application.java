package com.ohgiraffers.section02.extend.run;

import com.ohgiraffers.section02.extend.*;

public class Application {
    public static void main(String[] args) {

        // snake는 rabbit을 상속받지 않기 때문에 불가능
//        RabbitFarm<Snake> rabbitFarm = new RabbitFarm<>();    // <T extends Rabbit> 규칙 위반
        RabbitFarm<Rabbit> farm1 = new RabbitFarm<>(new Rabbit());
        RabbitFarm<Bunny> farm2 = new RabbitFarm<>(new Bunny());
        RabbitFarm<DrunkenBunny> farm3 = new RabbitFarm<>(new DrunkenBunny());

        FramManager farmManager = new FramManager();

        farmManager.managerAnyFarm(farm1);
        farmManager.managerAnyFarm(farm2);
        farmManager.managerAnyFarm(farm3);

//        farmManager.managerBunnyFarm(farm1);
        farmManager.managerBunnyFarm(farm2);
        farmManager.managerBunnyFarm(farm3);

    }
}
