package frol;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = MyEntityValidator.class)
@Documented
public @interface ValidMyEntity {
    String message () default "total price must be 50 or greater for online order. " +
            "Found: ${validatedValue.totalPrice}";

    Class<?>[] groups () default {};

    Class<? extends Payload>[] payload () default {};
}
