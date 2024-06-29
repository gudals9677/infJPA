package hellojpa;

import jakarta.persistence.*;

import java.util.List;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        //트랜잭션 처리 해줘야 오류가 안뜸
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            Member member = new Member();
            member.setUsername("C");

            em.persist(member);

            tx.commit();
        } catch(Exception e){
            tx.rollback();
        } finally {
            //code
            em.close();
        }
        emf.close();
    }
}
