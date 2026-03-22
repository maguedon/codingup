package codingup;

public class ResultTest2 {
    private int c;
    private String signature;

    ResultTest2(int c, String signature) {
        this.c = c;
        this.signature = signature;
    }

    ResultTest2() {}

    void setC(int c) {
        this.c = c;
    }

    void setSignature(String signature) {
        this.signature = signature;
    }

    int getC() {
        return this.c;
    }

    String getSignature() {
        return this.signature;
    }
}
