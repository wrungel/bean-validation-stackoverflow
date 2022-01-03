package frol;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@QuarkusTest
public class BeanValidationTest {
    @Inject
    EntityManager em;

    @Test
    @Transactional
    void test() {
        MyEntity myEntity = new MyEntity();
        myEntity.setName("foo");
        em.persist(myEntity);
        em.flush();
    }
}
