package jpabook;

import jpabook.jpashop.domain.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("hello");
        EntityManager em=emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {

//            Order order = new Order();
//            order.addOrderItem(new OrderItem());

//            Book book = new Book();
//            book.setName("JPA");
//            book.setAuthor("김영한");
//            em.persist(book);

//        Member member = new Member();
//        member.setUsername("hello");
//        member.setHomeAddress(new Address("city", "street", "10800"));
//        member.setWorkPeriod(new Period());
//
//        em.persist(member);

            //Criteria 사용 준비
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Member> query = cb.createQuery(Member.class);

            Root<Member> m = query.from(Member.class);

            CriteriaQuery<Member> cq = query.select(m).where(cb.equal(m.get("username"),"kim"));
            List<Member> resultList = em.createQuery(cq)
                    .getResultList();

            tx.commit();
        }catch(Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }

}
