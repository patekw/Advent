
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Problem_3 implements Problem {

    private ArrayList<String> input;
    private int answerA;
    private long answerB;
    private Long startTimeA;
    private Long stopTimeA;
    private Long startTimeB;
    private Long stopTimeB;

    public Problem_3() {
        init();
        solverA();
        solverB();
        getResult();
    }

    private void init() {
        try {
            input = new ArrayList<>();
            Scanner s = new Scanner(new File("src/main/resources/input_3.txt"));
            while (s.hasNext()) {
                input.add(s.next());
            }
            s.close();
        } catch (FileNotFoundException exception){
            exception.printStackTrace();
        }
    }

    private void solverA() {
        startTimeA = System.currentTimeMillis();
        int currentIndex = 0;
        for (int i = 1; i < input.size(); i++) {
            if (currentIndex == 30) {
                currentIndex = 2;
            } else if (currentIndex == 29) {
                currentIndex = 1;
            } else if (currentIndex == 28) {
                currentIndex = 0;
            } else {
                currentIndex = currentIndex + 3;
            }
            if (input.get(i).charAt(currentIndex) == '#') {
                answerA++;
            }
        }
        stopTimeA = System.currentTimeMillis();
    }

    private void solverB() {
        startTimeB = System.currentTimeMillis();
        int currentIndex1 = 0;
        int currentIndex2 = 0;
        int currentIndex3 = 0;
        int currentIndex4 = 0;
        int currentIndex5 = 0;

        int rule5down = 2;

        int rule1Counter = 0;
        int rule2Counter = 0;
        int rule3Counter = 0;
        int rule4Counter = 0;
        int rule5Counter = 0;

        for (int i = 1; i < input.size(); i++){
            // RULE 1
            if (currentIndex1 == 30){
                currentIndex1 = 0;
            } else {
                currentIndex1++;
            }
            if(input.get(i).charAt(currentIndex1) == '#'){
                rule1Counter++;
            }

            // RULE 2
            if (currentIndex2 == 30){
                currentIndex2 = 2;
            } else if (currentIndex2 == 29){
                currentIndex2 = 1;
            } else if (currentIndex2 == 28){
                currentIndex2 = 0;
            } else {
                currentIndex2 = currentIndex2 + 3;
            }
            if(input.get(i).charAt(currentIndex2) == '#'){
                rule2Counter++;
            }

            // RULE 3
            if (currentIndex3 == 30){
                currentIndex3 = 4;
            } else if (currentIndex3 == 29){
                currentIndex3 = 3;
            } else if (currentIndex3 == 28){
                currentIndex3 = 2;
            } else if (currentIndex3 == 27) {
                currentIndex3 = 1;
            } else if (currentIndex3 == 26) {
                currentIndex3 = 0;
            } else {
                currentIndex3 = currentIndex3 + 5;
            }
            if(input.get(i).charAt(currentIndex3) == '#'){
                rule3Counter++;
            }

            // RULE 4
            if (currentIndex4 == 30){
                currentIndex4 = 6;
            } else if (currentIndex4 == 29){
                currentIndex4 = 5;
            } else if (currentIndex4 == 28){
                currentIndex4 = 4;
            } else if (currentIndex4 == 27) {
                currentIndex4 = 3;
            } else if (currentIndex4 == 26) {
                currentIndex4 = 2;
            } else if (currentIndex4 == 25) {
                currentIndex4 = 1;
            } else if (currentIndex4 == 24) {
                currentIndex4 = 0;
            } else {
                currentIndex4 = currentIndex4 + 7;
            }
            if(input.get(i).charAt(currentIndex4) == '#'){
                rule4Counter++;
            }

            // RULE 5
            if(rule5down < input.size()) {
                if (currentIndex5 == 30) {
                    currentIndex5 = 0;
                } else {
                    currentIndex5++;
                }
                if (input.get(rule5down).charAt(currentIndex5) == '#') {
                    rule5Counter++;
                }
                rule5down = rule5down + 2;
            }
        }

        long mult = rule1Counter*rule2Counter;
        mult = mult*rule3Counter;
        mult = mult*rule4Counter;
        mult = mult*rule5Counter;
        answerB = mult;
        stopTimeB = System.currentTimeMillis();
    }

    @Override
    public String getResult(){
        return "Answer_3a: " + answerA + " Time: " + (stopTimeA - startTimeA) + "ms" + "\n" + "Answer_3b: " + answerB + " Time: " + (stopTimeB - startTimeB) + "ms";
    }

}
