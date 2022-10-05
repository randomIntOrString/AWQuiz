package org.example;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import javax.swing.*;

public class Main {

    public static void main(String[] args) throws Exception{
        TerminalSize ts = new TerminalSize(70, 20);
        DefaultTerminalFactory defaultTerminalFactory = new DefaultTerminalFactory();
        defaultTerminalFactory.setInitialTerminalSize(ts);
        Terminal terminal = defaultTerminalFactory.createTerminal();
        terminal.setCursorVisible(false);

        boolean continueReadingInput = true;
        Answer playerAnswer = null;

        Questions[] questions = new Questions[3];

        questions[0] = new Questions("Fråga 1", "Svar A", "Svar B", "Svar C", Answer.A);
        questions[1] = new Questions("Fråga 2", "Svar AA", "Svar BB", "Svar CC", Answer.B);
        questions[1] = new Questions("Fråga 3", "Svar AAA", "Svar BBB", "Svar CCC", Answer.C);

        while (continueReadingInput) {
            KeyStroke keyStroke = null;

            for (int i = 0; i < questions.length; i++) {

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
                    keyStroke = terminal.pollInput();
                } while(keyStroke == null);


                Character c = keyStroke.getCharacter();
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
                }
                
                if (playerAnswer.equals(questions[i].correctAnswer)){

                    String korrektsvar = "RÄTT!";
                    terminal.setCursorPosition(25 + i, 17);
                    terminal.putCharacter(korrektsvar.charAt(i));
                    terminal.flush();

                } else {
                    String felsvar = "FEL!";
                    terminal.setCursorPosition(25 + i, 17);
                    terminal.putCharacter(felsvar.charAt(i));
                    terminal.flush();
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