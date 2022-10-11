package api;

import com.google.gson.Gson;
import cybersoft.java18.crm.model.ResponseData;
import cybersoft.java18.crm.model.RoleModel;
import cybersoft.java18.crm.services.RoleServices;
import cybersoft.java18.crm.utils.UrlUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

// api/role
@WebServlet(name = "role",urlPatterns = {
        UrlUtils.URL_ROLE,
        UrlUtils.URL_ROLE_ADD
})
public class RoleController extends HttpServlet {

    private Gson gson = new Gson();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("kiemtra do get");

        List<RoleModel> listRoles =  RoleServices.getInstance().getAllRole();

        String json = gson.toJson(listRoles);
        PrintWriter printWriter = resp.getWriter();
        printWriter.print(json);
        printWriter.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader br = new BufferedReader(req.getReader());
        StringBuilder builder = new StringBuilder();
        String line;
        while((line = br.readLine()) != null){
            builder.append(line);
        }
        String data = builder.toString();
        RoleModel roleModel = gson.fromJson(data,RoleModel.class);
        Integer result = RoleServices.getInstance().createRole(roleModel);
        System.out.println("Insert: " + result);

        ResponseData responseData = new ResponseData();
        responseResult(result, "Tạo mới thành công !", "Tạo thất bại !");

        PrintWriter printWriter = resp.getWriter();
        printWriter.print(gson.toJson(responseData));
        printWriter.flush();
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader br = new BufferedReader(req.getReader());
        StringBuilder builder = new StringBuilder();
        String line;
        while((line = br.readLine()) != null){
            builder.append(line);
        }
        String data = builder.toString();

        RoleModel roleModel = gson.fromJson(data,RoleModel.class);
        Integer result = RoleServices.getInstance().updateRoleById(roleModel);
        System.out.println("update: " + result);
        ResponseData responseData = new ResponseData();
        responseResult(result, "Cập nhật thành công !", "Cập nhật thất bại !");

        PrintWriter printWriter = resp.getWriter();
        printWriter.print(gson.toJson(responseData));
        printWriter.flush();
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Integer result = RoleServices.getInstance().deleteRoleById(id);

        ResponseData responseData = new ResponseData();
        responseResult(result, "Xóa thành công !", "Xóa thất bại !");

        PrintWriter printWriter = resp.getWriter();
        printWriter.print(gson.toJson(responseData));
        printWriter.flush();
    }

    public void responseResult (Integer result, String messageOK, String messageNG) {
        ResponseData responseData = new ResponseData();
        if(result == 1){
            responseData.setStatusCode(200);
            responseData.setSuccess(true);
            responseData.setMesssage(messageOK);
        } else {
            responseData.setStatusCode(200);
            responseData.setSuccess(false);
            responseData.setMesssage(messageNG);
        }
    }


}
