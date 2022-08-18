package edu.finki.gjoko.application.dto;

import java.io.Serializable;

public class Number implements Serializable {

    private String type;
    private String operand1;

    public Number(String type, String operand1) {
        this.type = type;
        this.operand1 = operand1;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOperand1() {
        return operand1;
    }

    public void setOperand1(String operand1) {
        this.operand1 = operand1;
    }
}
