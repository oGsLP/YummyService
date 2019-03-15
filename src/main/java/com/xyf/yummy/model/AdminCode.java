package com.xyf.yummy.model;

/**
 * @你大爷: XYF
 * @author: lenovo XYF
 * @Date: 2019/3/5
 * @Time: 22:10
 * @Package: com.xyf.yummy.model
 */
public class AdminCode {
    private String codeA;
    private String codeB;
    private String codeC;
    private String codeD;
    private String password;

    public AdminCode(String codeA, String codeB, String codeC, String codeD, String password) {
        this.codeA = codeA;
        this.codeB = codeB;
        this.codeC = codeC;
        this.codeD = codeD;
        this.password = password;
    }

    public String getCodeA() {
        return codeA;
    }

    public void setCodeA(String codeA) {
        this.codeA = codeA;
    }

    public String getCodeB() {
        return codeB;
    }

    public void setCodeB(String codeB) {
        this.codeB = codeB;
    }

    public String getCodeC() {
        return codeC;
    }

    public void setCodeC(String codeC) {
        this.codeC = codeC;
    }

    public String getCodeD() {
        return codeD;
    }

    public void setCodeD(String codeD) {
        this.codeD = codeD;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
