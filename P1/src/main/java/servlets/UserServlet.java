package servlets;

import Services.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import pojos.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

public class UserServlet extends HttpServlet {
    UserService service;
    ObjectMapper mapper;

    @Override
    public void init() throws ServletException {
        this.service = new UserService();
        this.mapper = new ObjectMapper();
    }


    @Override
    public void destroy(){
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StringBuilder builder = new StringBuilder();
        BufferedReader buffer = req.getReader();
        while(buffer.ready()){
            builder.append(buffer.readLine());
        }
        String json = builder.toString();

        User newUser = mapper.readValue(json, User.class);

        service.save(newUser);


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String param = req.getParameter("user-id");
        if(param == null){
            List<User> userList = service.getAllUsers();
            String json = mapper.writeValueAsString(userList);
            resp.getWriter().println(json);

        } else {

            Integer userID = Integer.parseInt(req.getParameter("user-id"));

            User user = service.getUser(userID);
            String json = mapper.writeValueAsString(user);
            resp.getWriter().println(json);
        }

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            StringBuilder builder = new StringBuilder();
            BufferedReader buffer = req.getReader();
            while (buffer.ready()) {
                builder.append(buffer.readLine());
            }
            String json = builder.toString();

            User updateUser = mapper.readValue(json, User.class);

            service.update(updateUser);

        resp.getWriter().println("updated");

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer userID = Integer.parseInt(req.getParameter("user-id"));

        service.delete(userID);

    }
}
