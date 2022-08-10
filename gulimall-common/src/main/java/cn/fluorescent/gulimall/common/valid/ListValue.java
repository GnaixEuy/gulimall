package cn.fluorescent.gulimall.common.valid;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * <img src="http://blog.gnaixeuy.cn/wp-content/uploads/2022/06/bug.png"/>
 *
 * <p>项目： gulimall </p>
 *
 * @author GnaixEuy
 * @date 2022/8/10
 * @see <a href="https://github.com/GnaixEuy"> GnaixEuy的GitHub </a>
 */


@Documented
//指定校验器 这里指定我们自定义的ListValueConstraintValidator
@Constraint(validatedBy = {ListValueConstraintValidator.class})
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
public @interface ListValue {
    //使用我们自己定义的错误信息 在common模块下的resources中
//    String message() default "{com.atguigu.common.valid.ListValue.message}";
    String message() default "值必须是0或者1";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    //预先准备的值 vals={0,1}
    int[] vals() default {};
}

//对应实体类的注解
//@ListValue(vals={0,1},groups = {AddGroup.class, UpdateStatusGroup.class})

