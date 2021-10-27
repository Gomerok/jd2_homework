package by.academy.it.data;

import java.io.Serializable;
import java.rmi.server.UID;
import java.util.Objects;

public class Expense implements Serializable {
    private static final long SerialVersionUID = 1L;
    private int num;
    private String payDate;
    private int receiverId;
    private double amount;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getPayDate() {
        return payDate;
    }

    public void setPayDate(String payDate) {
        this.payDate = payDate;
    }

    public int getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(int receiverId) {
        this.receiverId = receiverId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Expense expense = (Expense) o;
        return num == expense.num && receiverId == expense.receiverId && Double.compare(expense.amount, amount) == 0 && Objects.equals(payDate, expense.payDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(num, payDate, receiverId, amount);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Expense{");
        sb.append("num=").append(num);
        sb.append(", payDate='").append(payDate).append('\'');
        sb.append(", receiverId=").append(receiverId);
        sb.append(", amount=").append(amount);
        sb.append('}');
        return sb.toString();
    }
}
