package org.example;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import javax.swing.*;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws Exception{
        TerminalSize ts = new TerminalSize(70, 20);
        DefaultTerminalFactory defaultTerminalFactory = new DefaultTerminalFactory();
        defaultTerminalFactory.setInitialTerminalSize(ts);
        Terminal terminal = defaultTerminalFactory.createTerminal();
        terminal.setCursorVisible(false);
        terminal.setForegroundColor(TextColor.ANSI.GREEN);
        //terminal.setBackgroundColor(TextColor.ANSI.WHITE);
        terminal.enableSGR(SGR.BOLD);

        boolean continueReadingInput = true;
        Answer playerAnswer = null;
        int score = 0;

        Questions[] questions = new Questions[4];


        questions[0] = new Questions("Hur många äpplen finns det på jorden?", "Svar A", "Svar B", "Svar C", Answer.A);
        questions[1] = new Questions("Hur många hjul har en bil?", "Svar AA", "Svar BB", "Svar CC", Answer.B);
        questions[2] = new Questions("Vilket datum är julafton?", "Svar AAA", "Svar BBB", "Svar CCC", Answer.C);
        questions[3] = new Questions("När grundades Public Service?", "Svar AAA", "Svar BBB", "Svar CCC", Answer.C);

        while (continueReadingInput) {
            KeyStroke keyStroke = null;


            for (int i = 0; i < questions.length; i++) {
                String scoreString = String.format("Score: %01d", score);
                for (int j = 0; j < scoreString.length(); j++) {
                    terminal.setCursorPosition(2 + j,2);
                    terminal.putCharacter(scoreString.charAt(j));
                    terminal.flush();
                }

                for (int j = 0; j < questions[i].question.length(); j++) {
                    terminal.setCursorPosition(10 + j, 10);
                    terminal.putCharacter(questions[i].question.charAt(j));
                    terminal.flush();
                }

                for (int j = 0; j < questions[i].answerA.length(); j++) {
                    terminal.setCursorPosition(2 + j, 17);
                    terminal.putCharacter(questions[i].answerA.charAt(j));
                    terminal.flush();
                }

                for (int k = 0; k < questions[i].answerB.length(); k++) {
                    terminal.setCursorPosition(25 + k, 17);
                    terminal.putCharacter(questions[i].answerB.charAt(k));
                    terminal.flush();
                }

                for (int l = 0; l < questions[i].answerC.length(); l++) {
                    terminal.setCursorPosition(50 + l, 17);
                    terminal.putCharacter(questions[i].answerC.charAt(l));
                    terminal.flush();
                }

                do {
                    Thread.sleep(5);
                    keyStroke = terminal.pollInput();
                } while(keyStroke == null);

                Character c = keyStroke.getCharacter();
                //do {
                try {
                    switch (c) {
                        case 'a':
                            playerAnswer = Answer.A;
                            break;

                        case 'b':
                            playerAnswer = Answer.B;
                            break;

                        case 'c':
                            playerAnswer = Answer.C;
                            break;

                        default:
                            String felknapp = "Nej, nu klickade du fel.";
                            for (int j = 0; j < felknapp.length(); j++) {
                                terminal.setCursorPosition(30 + j, 5);
                                terminal.putCharacter(felknapp.charAt(j));
                            }
                            terminal.flush();
                            Thread.sleep(500);
                            for (int j = 0; j < felknapp.length(); j++) {
                                terminal.setCursorPosition(30 + j, 5);
                                terminal.putCharacter(' ');
                            }
                            break;
                    }
                } catch (NullPointerException e) {
                    String felknapp = "Nej, nu klickade du fel.";
                    for (int j = 0; j < felknapp.length(); j++) {
                        terminal.setCursorPosition(30 + j, 5);
                        terminal.putCharacter(felknapp.charAt(j));
                    }
                    terminal.flush();
                    Thread.sleep(500);
                    for (int j = 0; j < felknapp.length(); j++) {
                        terminal.setCursorPosition(30 + j, 5);
                        terminal.putCharacter(' ');
                    }
                }
                //} while (playerAnswer == null);

                try {
                    if (playerAnswer.equals(questions[i].correctAnswer)){

                        String korrektsvar = "RÄTT!";
                        for (int j = 0; j < korrektsvar.length(); j++) {
                            terminal.setCursorPosition(30 + j, 5);
                            terminal.putCharacter(korrektsvar.charAt(j));
                        }
                        terminal.flush();
                        Thread.sleep(500);
                        for (int j = 0; j < korrektsvar.length(); j++) {
                            terminal.setCursorPosition(30 + j, 5);
                            terminal.putCharacter(' ');
                        }
                        score += 1;
                        terminal.flush();


                    } else {
                        String felsvar = "FEL!";
                        for (int j = 0; j < felsvar.length(); j++) {
                            terminal.setCursorPosition(30 + j, 5);
                            terminal.putCharacter(felsvar.charAt(j));
                        }
                        terminal.flush();
                        Thread.sleep(500);
                        for (int j = 0; j < felsvar.length(); j++) {
                            terminal.setCursorPosition(30 + j, 5);
                            terminal.putCharacter(' ');
                        }
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } catch (NullPointerException e) {
                    break;
                }

            }
        }

        String svarsalternativ1 = "Ruta ett";
        String svarslaternativ2 = "Ruta två";
        String svarsalternativ3 = "Ruta tre";



        for (int i = 0; i < svarsalternativ1.length(); i++) {
            terminal.setCursorPosition(2 + i, 17);
            terminal.putCharacter(svarsalternativ1.charAt(i));
        }

        for (int i = 0; i < svarslaternativ2.length(); i++) {
            terminal.setCursorPosition(25 + i, 17);

            terminal.putCharacter(svarslaternativ2.charAt(i));
        }

        for (int i = 0; i < svarsalternativ3.length(); i++) {
            terminal.setCursorPosition(50 + i, 17);
            terminal.putCharacter(svarsalternativ3.charAt(i));
        }

    }

    public static void getQuestions(Questions question){

    }
}


//Frågesport
//
//- Textbox med frågor.
//- helst knappar (tänk Postkodsmiljonären) (så som vi gjorde quit-funktionen)
//- Bakgrund som visar rött (och gärna gör ljud) om det är fel svar.
//- Bakgrund som visar grön (och gärna gör ljud) om det är korrekt svar.
//- Score, både visuellt och i text. Säg att det är 10 frågor, vid start är de neutrala, och sen blir
//1/10 grön eller röd beroende på svar.
//- I slutet så sammanställer vi resultatet.
//- Spelaren får ange sitt namn (som sen presenteras i slutet).
//- (om tid finns, spela igen-funktion eftersom att vi inte kan databaser - än! :D )