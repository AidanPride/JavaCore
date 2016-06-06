package lesson8.reflection;

import java.lang.annotation.*;
@Documented
@Inherited
@Target({ElementType.TYPE , ElementType.METHOD , ElementType.CONSTRUCTOR})
@Retention(RetentionPolicy.RUNTIME)
public @interface Service {
    String name();
    boolean what() default true;
}
