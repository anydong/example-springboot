package com.example.demo.annotation.validator;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import javax.validation.constraints.NotBlank;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = Equals.EqualsValidator.class)
public @interface Equals {
    String message() default "属性不相等";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String[] properties() default {};

    @Slf4j
    class EqualsValidator implements ConstraintValidator<Equals, Object> {
        private String message;
        private String[] properties;

        @Override
        public void initialize(Equals constraintAnnotation) {
            this.message = constraintAnnotation.message();
            this.properties = constraintAnnotation.properties();
        }

        @SneakyThrows
        @Override
        public boolean isValid(Object value, ConstraintValidatorContext context) {
            Set<Object> tempFieldValue = new HashSet<>();
            if (this.properties != null) {
                for (String property : properties) {
                    Field field = value.getClass().getDeclaredField(property);
                    field.setAccessible(true);
                    tempFieldValue.add(field.get(value));
                }
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate(this.message)
                        .addPropertyNode(properties[0])
                        .addConstraintViolation();
                return tempFieldValue.size() == 1;
            }
            return false;
        }
    }
}
