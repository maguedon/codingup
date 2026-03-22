package codingup;

public class DataTest2 {
    private int a;
    private int b;
    private String signature;
    private String status;

    public DataTest2(int a, int b, String signature, String status) {
        this.a = a;
        this.b = b;
        this.signature = signature;
        this.status = status;
    }

    public DataTest2() {
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
