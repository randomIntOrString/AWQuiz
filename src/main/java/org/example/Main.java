package org.example;

public class Main {
    public static void main(String[] args) {

        Questions[] questions = new Questions[2];

        questions[0] = new Questions("Fråga 1", "Svar A", "Svar B", "Svar C", Answer.C);
        questions[1] = new Questions("Fråga 2", "Svar A", "Svar B", "Svar C", Answer.B);
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