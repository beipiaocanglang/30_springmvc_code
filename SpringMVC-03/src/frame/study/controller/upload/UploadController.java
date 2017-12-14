package frame.study.controller.upload;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.UUID;

/**
 * Created by canglang on 2017/5/30.
 * 异步上传图片
 */
@Controller
public class UploadController {

    //跳转到图片上传页面
    @RequestMapping("/uploadImage")
    public String uploadImage(){
        return "uploadImage/uploadImage";
    }

    /**
     * 图片上传
     */
    @RequestMapping("/ajaxUploadPic")
    public void upload(String fileName, HttpServletRequest request, PrintWriter out){
        //把request转换多部件请求
        MultipartHttpServletRequest mh = (MultipartHttpServletRequest) request;
        //获取文件对象：根据文件名称获取文件流对象：request.getParameter(name属性值)
        //返回的是配置文件中的对象
        CommonsMultipartFile cm = (CommonsMultipartFile) mh.getFile(fileName);

        //文件重命名
        //使用UUID生成文件名称
        String filename = UUID.randomUUID().toString();
        //获取文件扩展名
        //a。获取文件名称
        String originalFilename = cm.getOriginalFilename();
        //b.获取文件扩展名
        String extName = originalFilename.substring(originalFilename.lastIndexOf("."));
        //文件相对路径
        filename = filename+extName;
        //跨服务上传图片
        //创建jersy客户端
        Client client = Client.create();
        //关联上传图片服务器地址
        WebResource resource = client.resource(Commons.PIC_PATH+"upload/"+filename);
        //上传图片
        resource.put(String.class, cm.getBytes());

        /**
         * 返回图片地址
         * 1.返回图片绝对路径：用来图片回显
         * 2.返回相对路径：保存数据库
         */
        String fullPath = Commons.PIC_PATH+"upload/"+filename;
        String relitivePath = "image/upload/"+filename;
        //构造一个json字符串
        String result = "{\"fullPath\":\""+fullPath+"\",\"relitivePath\":\""+relitivePath+"\"}";
        out.print(result);
    }

}
