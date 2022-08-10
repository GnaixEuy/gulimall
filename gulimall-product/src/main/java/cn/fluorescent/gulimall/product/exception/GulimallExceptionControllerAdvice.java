package cn.fluorescent.gulimall.product.exception;

import cn.fluorescent.gulimall.common.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * <img src="http://blog.gnaixeuy.cn/wp-content/uploads/2022/06/bug.png"/>
 *
 * <p>项目： gulimall </p>
 * 集中处理所有异常
 *
 * @author GnaixEuy
 * @date 2022/8/10
 * @see <a href="https://github.com/GnaixEuy"> GnaixEuy的GitHub </a>
 */
@Slf4j
@RestControllerAdvice(basePackages = "cn.fluorescent.gulimall.product.controller")
public class GulimallExceptionControllerAdvice {

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public R handleVaildException(MethodArgumentNotValidException e) {
        log.error("数据校验出现问题{}，异常类型：{}", e.getMessage(), e.getClass());
        BindingResult bindingResult = e.getBindingResult();

        Map<String, String> errorMap = new HashMap<>();
        bindingResult.getFieldErrors().forEach((fieldError) -> {
            errorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
        });
        return R.error(BizCodeEnum.VALID_EXCEPTION.getCode(), BizCodeEnum.VALID_EXCEPTION.getMsg()).put("data", errorMap);
    }


    @ExceptionHandler(value = Throwable.class)
    public R handleException(Throwable throwable) {
        log.error("未知异常{},异常类型{}", throwable.getMessage(), throwable.getClass());
        return R.error(BizCodeEnum.UNKNOW_EXEPTION.getCode(), BizCodeEnum.UNKNOW_EXEPTION.getMsg());
    }
}