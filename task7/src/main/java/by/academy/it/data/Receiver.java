package by.academy.it.data;

import java.util.Objects;

public class Receiver {
    private int num;
    private String receiverName;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Receiver receiver = (Receiver) o;
        return num == receiver.num && Objects.equals(receiverName, receiver.receiverName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(num, receiverName);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Receiver{");
        sb.append("num=").append(num);
        sb.append(", receiverName='").append(receiverName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
