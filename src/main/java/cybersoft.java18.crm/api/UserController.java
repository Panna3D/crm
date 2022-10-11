package api;

import com.google.gson.Gson;
import cybersoft.java18.crm.utils.UrlUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "user",urlPatterns = {
        UrlUtils.URL_USER,
        UrlUtils.URL_USER_ADD
})
public class UserController extends HttpServlet {
    private Gson gson = new Gson();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("kiem tra do get user");

        List<UserModel> listRoles =  UserServices.getInstance().getAllRole();

        String json = gson.toJson(listRoles);
        PrintWriter printWriter = resp.getWriter();
        printWriter.print(json);
        printWriter.flush();

    }


}
