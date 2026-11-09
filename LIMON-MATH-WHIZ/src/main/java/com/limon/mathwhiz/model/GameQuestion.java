
package com.limon.mathwhiz.model;

public class GameQuestion {

    private String question;
    private String type;
    private double value1;
    private double value2;
    private String operation;
    private int marks;

    public GameQuestion(String question, String type,
                        double value1, double value2,
                        String operation, int marks) {

        this.question = question;
        this.type = type;
        this.value1 = value1;
        this.value2 = value2;
        this.operation = operation;
        this.marks = marks;
    }

    public String getQuestion() {
        return question;
    }

    public String getType() {
        return type;
    }

    public double getValue1() {
        return value1;
    }

    public double getValue2() {
        return value2;
    }

    public String getOperation() {
        return operation;
    }

    public int getMarks() {
        return marks;
    }
}
