package Services;

import DAOs.ReimburseDAO;
import pojos.Reimburse;

import java.util.List;


public class ReimburseService {

    private ReimburseDAO dao;


    public ReimburseService(){
        this.dao = new ReimburseDAO();

    }

    public void saveReimbursement (Reimburse reimburse){
        dao.create(reimburse);

    }

    public List <Reimburse> getAllReimbursements(){
        return dao.readAll();
    }

        public List<Reimburse> getReimbursementsForUser(Integer userID){
        List<Reimburse> reimbursementList = dao.readAll();

            reimbursementList.removeIf(reimburse -> !reimburse.getUserID().equals(userID));

        return reimbursementList;
    }

    public void update(Reimburse reimburse){
        dao.update(reimburse);

    }

    public void delete(int id){

        dao.delete(id);
    }

}
