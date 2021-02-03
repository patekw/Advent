
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Problem_2 implements Problem {

    private ArrayList<String> input;
    private int answerA;
    private String answerB;
    private Long startTimeA;
    private Long stopTimeA;
    private Long startTimeB;
    private Long stopTimeB;

    public Problem_2() {
        init();
        solver_2a();
        solver_2b();
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

    private void solver_2a() {
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

    private void solver_2b() {
        startTimeB = System.currentTimeMillis();
        answerB = "N/A";
        stopTimeB = System.currentTimeMillis();
    }

    @Override
    public String getResult(){
        return "Answer_1a: " + answerA + " Time: " + (stopTimeA - startTimeA) + "ms" + "\n" + "Answer_1b: " + answerB + " Time: " + (stopTimeB - startTimeB) + "ms";
    }

}
