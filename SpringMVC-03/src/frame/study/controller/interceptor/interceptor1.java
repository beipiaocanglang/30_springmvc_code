package frame.study.controller.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by canglang on 2017/5/30.
 * 自定义第一个拦截器
 */
public class interceptor1 implements HandlerInterceptor {

    /**
     * controller执行前调用此方法
     * 返回true表示继续执行，返回false中止执行
     * 这里可以加入登录校验、权限拦截等
     */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {
        System.out.println("这是第一个拦截器interceptor1---中的preHandle方法");

        /**
         * 跳转到登录页面或者提交登录信息，放行
         * 已经登录过放行
         * 其它情况拦截，跳转到登录页面
         */
        //跳转到登录页面或者提交登录信息，放行
        if (request.getRequestURI().contains("login")){
            return true;
        }

        //已经登录过
        HttpSession session = request.getSession();
        if(session.getAttribute("user") != null){
            return true;
        }

        //拦截
        //转发
        //request.getRequestDispatcher("/WEB-INF/jsps/login/login.jsp").forward(request, response);
        request.getRequestDispatcher("/login/login.do").forward(request, response);
        //重定向
        //response.sendRedirect("/login/login.do");

        return false;
    }

    /**
     * controller执行后但未返回视图前调用此方法
     * 这里可在返回用户前对模型数据进行加工处理，比如这里加入公用信息以便页面显示
     */
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object obj, ModelAndView modelAndView) throws Exception {
        System.out.println("这是第一个拦截器interceptor1---中的postHandle方法");

    }

    /**
     * controller执行后且视图返回后调用此方法
     * 这里可得到执行controller时的异常信息
     * 这里可记录操作日志，资源清理等
     */
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object obj, Exception exs) throws Exception {
        System.out.println("这是第一个拦截器interceptor1---中的afterCompletion方法");

    }
}
