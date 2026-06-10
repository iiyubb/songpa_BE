package com.ohgiraffers.section02.crud;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class EntityManagerCrud {

    private EntityManager entityManager;

    /* 특정 메뉴 코드로 메뉴 조회 */
    public Menu findMenuByMenuCode(int menuCode) {
        entityManager = EntityManagerGenerator.getInstance();
        // find (엔티티타입, PK)
        return entityManager.find(Menu.class, menuCode);
    }

    /* 새로운 메뉴 저장 */
    public Long saveAndReturnAllCount(Menu newMenu){

        entityManager = EntityManagerGenerator.getInstance();

        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        entityManager.persist(newMenu);

        entityTransaction.commit();

        return getCount(entityManager);
    }

    public Long getCountBeforeSave(){
        entityManager = EntityManagerGenerator.getInstance();
        return getCount(entityManager);
    }

    /* 메뉴 개수 조회하는 기능 */
    private Long getCount(EntityManager entityManager) {
        /* JPQL 문법 -> 나중에 별도의 챕터에서 다룰 예정 */
        return entityManager.createQuery("SELECT COUNT(*) FROM Section02Menu", Long.class).getSingleResult();
    }
}
