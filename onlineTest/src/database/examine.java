package database;

public class examine {
    private Integer eId;
    private String content;
    private String A;
    private String B;
    private String C;
    private String D;
    private String answer;

    public examine() {
    }

    public examine(Integer eId,String content, String a, String b, String c, String d, String answer) {
        this.eId=eId;
        this.content = content;
        A = a;
        B = b;
        C = c;
        D = d;
        this.answer = answer;
    }
    public examine(String content, String a, String b, String c, String d, String answer) {
        this.content = content;
        A = a;
        B = b;
        C = c;
        D = d;
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "examine{" +
                "eId=" + eId +
                ", content='" + content + '\'' +
                ", A='" + A + '\'' +
                ", B='" + B + '\'' +
                ", C='" + C + '\'' +
                ", D='" + D + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }

    public Integer geteId() {
        return eId;
    }

    public void seteId(Integer eId) {
        this.eId = eId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getA() {
        return A;
    }

    public void setA(String a) {
        A = a;
    }

    public String getB() {
        return B;
    }

    public void setB(String b) {
        B = b;
    }

    public String getC() {
        return C;
    }

    public void setC(String c) {
        C = c;
    }

    public String getD() {
        return D;
    }

    public void setD(String d) {
        D = d;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
