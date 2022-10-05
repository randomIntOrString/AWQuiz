package org.example;

public class Questions {
    String question;
    String answerA;
    String answerB;
    String answerC;
    Answer correctAnswer;

    public Questions(String question, String answerA, String answerB, String answerC, Answer correctAnswer) {
        this.question = question;
        this.answerA = answerA;
        this.answerB = answerB;
        this.answerC = answerC;
        this.correctAnswer = correctAnswer;
    }


}
