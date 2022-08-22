package pojos;

import java.util.Objects;

public class Reimburse {
    private Integer reimbursementID;
    private String reason;
    private Double cost;
    private Integer userID;
    private Boolean approved;

    public Reimburse() {
    }

    public Reimburse(Integer reimbursementID, String reason, Double cost, Integer userID, Boolean approved) {
        this.reimbursementID = reimbursementID;
        this.reason = reason;
        this.cost = cost;
        this.userID = userID;
        this.approved = approved;
    }

    public Integer getReimbursementID() {

        return reimbursementID;
    }

    public void setReimbursementID(Integer reimbursementID) {

        this.reimbursementID = reimbursementID;
    }

    public String getReason() {

        return reason;
    }

    public void setReason(String reason) {

        this.reason = reason;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {

        this.cost = cost;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {

        this.userID = userID;
    }

    public Boolean getApproved() {

        return approved;
    }

    public void setApproved(Boolean approved) {

        this.approved = approved;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reimburse reimburse = (Reimburse) o;
        return Objects.equals(reimbursementID, reimburse.reimbursementID) && Objects.equals(reason, reimburse.reason) && Objects.equals(cost, reimburse.cost) && Objects.equals(userID, reimburse.userID) && Objects.equals(approved, reimburse.approved);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reimbursementID, reason, cost, userID, approved);
    }

    @Override
    public String toString() {
        return "Reimburse{" +
                "reimbursementID=" + reimbursementID +
                ", reason='" + reason + '\'' +
                ", cost=" + cost +
                ", userID=" + userID +
                ", approved=" + approved +
                '}';
    }
}
