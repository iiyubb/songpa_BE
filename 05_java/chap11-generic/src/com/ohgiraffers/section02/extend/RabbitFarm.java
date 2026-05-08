package com.ohgiraffers.section02.extend;

// T는 Rabbit 또는 Rabbit의 자손이어야만 한다. (제한된 타입 파라미터)
public class RabbitFarm<T extends Rabbit> {

    private T animal;

    public RabbitFarm(T animal) {
        this.animal = animal;
    }

    public T getAnimal() {
        return animal;
    }

    public void setAnimal(T animal) {
        this.animal = animal;
    }
}
