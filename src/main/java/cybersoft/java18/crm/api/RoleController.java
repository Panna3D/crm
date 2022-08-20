package cybersoft.java18.crm.api;



//api/role -> Get
//@WebServlet(name = "role", urlPatterns = {
//        UrlUtils.URL_ROLE,
//        UrlUtils.URL_ROLE_ADD
//})

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import cybersoft.java18.crm.jdbc.MySqlConnection;
import cybersoft.java18.crm.model.*;
import cybersoft.java18.crm.utils.UrlUtils;
import lombok.SneakyThrows;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static cybersoft.java18.crm.jdbc.MySqlConnection.*;

@WebServlet(name = "authServlet", urlPatterns = {
        UrlUtils.URL_ROLE,
        UrlUtils.URL_ROLE_ADD,
        UrlUtils.URL_STATUS,
        UrlUtils.URL_STATUS_ADD,
        UrlUtils.URL_USER,
        UrlUtils.URL_USER_ADD
})
public class RoleController extends HttpServlet {
    private Gson gson = new Gson();
    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        resp.addHeader("Access-Control-Allow-Origin", "*");

        PrintWriter printWriter = resp.getWriter();

        // Get role model API
        getApiRoleModel(printWriter);

        // Get status model API
//        getApiStatusModel(printWriter);
        // Get user model API
//        getApiUserModel(printWriter);

        // close
        resp.getWriter().flush(); // clear threat
    }

    private void getApiRoleModel (PrintWriter printWriter) throws SQLException {
        List<RoleModel> roleModelList = getRoleList();
        RoleModelData roleModelData = new RoleModelData();
        roleModelData.setModel(roleModelList);

        // Convert
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .serializeNulls()
                .create();

        String api = gson.toJson(roleModelData);
        printWriter.println(api);
//        return api;
    }

    private void getApiStatusModel (PrintWriter printWriter) throws SQLException {
        List<StatusModel> statusModelList = getStatusList();
        StatusModelData statusModelData = new StatusModelData();
        statusModelData.setStatus(statusModelList);

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .serializeNulls()
                .create();

        String api = gson.toJson(statusModelData);
        printWriter.println(api);
//        return api;
    }

    private void getApiUserModel (PrintWriter printWriter) throws SQLException{
        List<UserModel> userModelList = getUserList();
        UserModelData userModelData = new UserModelData();
        userModelData.setUser(userModelList);

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .serializeNulls()
                .create();

        String api = gson.toJson(userModelData);
        printWriter.println(api);
    }

}
