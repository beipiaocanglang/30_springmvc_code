package frame.study.customExcetpion;

/**
 * Created by canglang on 2017/5/30.
 * 自定义全局异常处理器消息
 */
public class CustomException extends Exception{

    //定义全局异常消息变量
    private String message;

    public CustomException(String message) {
        super(message);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
