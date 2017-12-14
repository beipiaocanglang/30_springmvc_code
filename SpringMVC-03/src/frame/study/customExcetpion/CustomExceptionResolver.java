package frame.study.customExcetpion;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by canglang on 2017/5/30.
 * 自定义异常处理器
 */
public class CustomExceptionResolver implements HandlerExceptionResolver{

    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object obj, Exception ex) {

        CustomException ce = null;
        if (ex instanceof CustomException){
            ce = (CustomException) ex;
        }else {
            ce = new CustomException("System Exception Please try again later");
        }

        ModelAndView model = new ModelAndView();

        model.addObject("message", ce.getMessage());
        model.setViewName("error/error");

        return model;
    }
}
