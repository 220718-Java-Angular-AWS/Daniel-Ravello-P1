package servlets;

import Services.ReimburseService;
import com.fasterxml.jackson.databind.ObjectMapper;
import pojos.Reimburse;
import pojos.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

public class ReimburseServlet extends HttpServlet {
    private ReimburseService service;
    private ObjectMapper mapper;

    @Override
    public void init() throws ServletException {
        this.service = new ReimburseService();
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

        Reimburse reimburse = mapper.readValue(json, Reimburse.class);

        service.saveReimbursement(reimburse);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String param = req.getParameter("user-id");
        if(param == null) {
            List<Reimburse> reimburseList = service.getAllReimbursements();
            String json = mapper.writeValueAsString(reimburseList);
            resp.getWriter().println(json);
        } else {

            Integer userID = Integer.parseInt(req.getParameter("user-id"));

            List<Reimburse> reimburseList = service.getReimbursementsForUser(userID);

            String json = mapper.writeValueAsString(reimburseList);

            resp.getWriter().print(json);
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

        Reimburse updateReimbursement = mapper.readValue(json, Reimburse.class);

        service.update(updateReimbursement);

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer reimbursementID = Integer.parseInt(req.getParameter("reimbursement-id"));

        service.delete(reimbursementID);

    }
}
