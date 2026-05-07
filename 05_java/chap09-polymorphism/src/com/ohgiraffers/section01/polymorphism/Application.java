package com.ohgiraffers.section01.polymorphism;

public class Application {
    public static void main(String[] args) {

        // 다형성이 없을 떄
        Zookeeper badZookeeper = new Zookeeper();
        badZookeeper.feed(new Cat());
        badZookeeper.feed(new Tiger());

        // 다형성 적용 (upcasting): 자식 객체를 부모 타입의 변수에 할당
        Animal a1 = new Cat();
        Animal a2 = new Tiger();

        // [동적 바인딩]
        // 컴파일 시점에는 부모(Animal)의 메서드를 호출하는 것으로 보이지만
        // 런타임 시점에는 실제 가리키는 객체의 오버라이딩 된 메서드가 실행됨
        a1.cry();
        a2.cry();

//        a1.jump();    // Animal 참조 변수이기 떄문에 Cat만 가진 jump 호출 불가

        ((Cat) a1).jump(); // down casting: 명시적으로 타입 강제 변환
//        ((Cat) a2).jump(); // 런타임 에러! Tiger -> Cat으로 형변환 불가

        // instanceof: 실제 객체 타입 확인 (다운캐스팅 전 안전 확인)
        System.out.println(a1 instanceof Tiger);
        System.out.println(a1 instanceof Cat);

        if (a1 instanceof Cat) {
            System.out.println("a1 고양이 점프!!");
            ((Cat) a1).jump();
        }

        // 다형성 배열: Animal 배열 하나에 Cat, Tiger 섞어 담기
        Animal[] animals = new Animal[5];
        animals[0] = new Cat();
        animals[1] = new Tiger();
        animals[2] = new Tiger();
        animals[3] = new Cat();
        animals[4] = new Tiger();

        // 모든 동물들아 울어봐 (동적 바인딩 확인)
        for (Animal animal : animals) {
            animal.cry();
        }

        for  (Animal animal : animals) {
            if (animal instanceof Cat) {
                ((Cat) animal).jump();
            } else if (animal instanceof Tiger) {
                ((Tiger) animal).bite();
            }
        }

        Zookeeper keeper = new Zookeeper();
        for (Animal animal : animals) {
            keeper.feed(animal);
        }


    }
}
