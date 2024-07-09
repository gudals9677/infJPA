package hellojpa;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        //트랜잭션 처리 해줘야 오류가 안뜸
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            Member member = new Member();
            member.setUsername("member1");
            member.setHomeAddress(new Address("homeCity", "street", 10000));

            member.getFavoriteFoods().add("치킨");
            member.getFavoriteFoods().add("족발");
            member.getFavoriteFoods().add("피자");

            em.persist(member);

            em.flush();
            em.clear();
            System.out.println("====================================");
            Member findMember = em.find(Member.class, member.getId());

            Address a = findMember.getHomeAddress();
            findMember.setHomeAddress(new Address("newCity", "street",20000));
            
            findMember.getFavoriteFoods().remove("족발");
            findMember.getFavoriteFoods().add("짜장면");

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
