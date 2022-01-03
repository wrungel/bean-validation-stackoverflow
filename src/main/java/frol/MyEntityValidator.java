package frol;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class MyEntityValidator implements ConstraintValidator<ValidMyEntity, MyEntity> {
    @Inject
    EntityManager em;

    @Override
    public boolean isValid(MyEntity myEntity, ConstraintValidatorContext constraintValidatorContext) {
        List<MyEntity> resultList = em.createQuery("select t from MyEntity t where t.name = ?1",
                        MyEntity.class).setParameter(1, myEntity.getName())
                .getResultList();
        return resultList.isEmpty();
    }
}
