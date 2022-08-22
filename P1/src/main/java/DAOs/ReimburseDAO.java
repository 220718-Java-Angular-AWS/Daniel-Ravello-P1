package DAOs;

import pojos.Reimburse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class ReimburseDAO implements CRUD<Reimburse> {

    Connection connection;
    public ReimburseDAO(){

        connection = ConnectionManager.getConnection();

    }
    @Override
    public void create(Reimburse reimburse) {
        String sql = "INSERT INTO reimbursement (reason, cost, user_id , approved) VALUES (?, ?, ?, false)";

        try {
            PreparedStatement pstmt= connection.prepareStatement(sql);
            pstmt.setString(1, reimburse.getReason());
            pstmt.setDouble(2, reimburse.getCost());
            pstmt.setInt(3, reimburse.getUserID());


            pstmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Reimburse read(int id) {
        String sql = "SELECT * FROM reimbursement WHERE user_id= ?";
        Reimburse reimburse = new Reimburse();

        try {
            PreparedStatement pstmt= connection.prepareStatement(sql);
            pstmt.setInt(1,id);

            ResultSet results= pstmt.executeQuery();

            if(results.next()){
                reimburse.setReimbursementID(results.getInt("reimbursement_id"));
                reimburse.setReason(results.getString("reason"));
                reimburse.setCost(results.getDouble("cost"));
                reimburse.setUserID(results.getInt("user_id"));
                reimburse.setApproved(results.getBoolean("approved"));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return reimburse;
    }

    @Override
    public List<Reimburse> readAll() {

        List<Reimburse> reimburseList = new LinkedList<>();
        String sql = "SELECT * FROM reimbursement";

        try {
            PreparedStatement pstmt= connection.prepareStatement(sql);
            ResultSet results= pstmt.executeQuery();

            while(results.next()) {
                Reimburse reimburse = new Reimburse();
                reimburse.setReimbursementID(results.getInt("reimbursement_id"));
                reimburse.setReason(results.getString("reason"));
                reimburse.setCost(results.getDouble("cost"));
                reimburse.setUserID(results.getInt("user_id"));
                reimburse.setApproved(results.getBoolean("approved"));
                reimburseList.add(reimburse);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reimburseList;
    }

    @Override
    public void update(Reimburse reimburse) {

        String sql = "UPDATE reimbursement SET reason= ?, cost= ?, user_id= ?, approved= ? WHERE reimbursement_id= ?";

        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, reimburse.getReason());
            pstmt.setDouble(2, reimburse.getCost());
            pstmt.setInt(3,reimburse.getUserID());
            pstmt.setBoolean(4, reimburse.getApproved());
            pstmt.setInt(5, reimburse.getReimbursementID());

            pstmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM reimbursement WHERE reimbursement_id= ?";

        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, id);

            pstmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
