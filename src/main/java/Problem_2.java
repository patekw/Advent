
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Problem_2 implements Problem {

    private ArrayList<String> input;
    private int answerA;
    private int answerB;
    private Long startTimeA;
    private Long stopTimeA;
    private Long startTimeB;
    private Long stopTimeB;

    public Problem_2() {
        init();
        solverA();
        solverB();
        getResult();
    }

    private void init() {
        try {
            input = new ArrayList<>();
            Scanner s = new Scanner(new File("src/main/resources/input_2.txt"));
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
        String [] parts;
        String lower = "";
        String upper = "";
        String letter = "";
        String password;
        answerA = 0;
        for (int i = 0; i < input.size(); i++){

            if(i % 3 == 0){
                parts = input.get(i).split("-");
                lower = parts[0];
                upper = parts[1];
            } else if(i % 3 == 1){
                parts = input.get(i).split(":");

                letter = parts[0];
            } else if(i % 3 == 2){
                password = input.get(i);
                int numberChar = 0;
                for (int j = 0; j < password.length(); j++) {

                    if(String.valueOf(password.charAt(j)).equals(letter)) {
                        numberChar++;
                    }
                }
                //System.out.println(lower + "-" + upper + " " + letter + " " + password + " :: " + numberChar);
                if(numberChar >= Integer.parseInt(lower) && numberChar <= Integer.parseInt(upper)){
                    answerA++;
                }
            }
        }
        stopTimeA = System.currentTimeMillis();
    }

    private void solverB() {
        startTimeB = System.currentTimeMillis();
        String [] parts;
        String firstIndex = "";
        String secondIndex = "";
        String letter = "";
        String password;
        answerB = 0;
        for (int i = 0; i < input.size(); i++){

            if(i % 3 == 0){
                parts = input.get(i).split("-");
                firstIndex = parts[0];
                secondIndex = parts[1];
            } else if(i % 3 == 1){
                parts = input.get(i).split(":");

                letter = parts[0];
            } else if(i % 3 == 2){
                password = input.get(i);
                int isCorrect = 0;
                for (int j = 0; j < password.length(); j++) {
                    if(j+1 == Integer.parseInt(firstIndex)|| j+1 == Integer.parseInt(secondIndex)){
                        if(String.valueOf(password.charAt(j)).equals(letter)) {
                            isCorrect++;
                        }
                    }
                }
                System.out.println(firstIndex + "-" + secondIndex + " " + letter + " " + password + " :: " + isCorrect);
                if (isCorrect == 1){
                    answerB++;
                }
            }
        }
        stopTimeB = System.currentTimeMillis();
    }

    @Override
    public String getResult(){
        return "Answer_2a: " + answerA + " Time: " + (stopTimeA - startTimeA) + "ms" + "\n" + "Answer_2b: " + answerB + " Time: " + (stopTimeB - startTimeB) + "ms";
    }

}
