package frame.study.controller.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * Created by canglang on 2017/5/30.
 * 验证拦截器
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    //跳转到登录页面
    @RequestMapping("/login")
    public String login(){
        return "login/login";
    }

    //提交登录
    @RequestMapping("/loginSubmit")
    public String loginSubmit(HttpSession session, String username, String password){

        session.setAttribute("user", username);

        return "redirect:/itemList.do";

    }

    //注销登录
    @RequestMapping("/loginOut")
    public String loginOut(HttpSession session){

        session.invalidate();

        return "redirect:/itemList.do";

    }
}
