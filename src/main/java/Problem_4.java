
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Problem_4 implements Problem {

    private ArrayList<String> input;
    private String answerA;
    private String answerB;
    private Long startTimeA;
    private Long stopTimeA;
    private Long startTimeB;
    private Long stopTimeB;

    public Problem_4() {
        init();
        solverA();
        solverB();
        getResult();
    }

    private void init() {
        try {
            input = new ArrayList<>();
            Scanner s = new Scanner(new File("src/main/resources/input_4.txt"));
            while (s.hasNext()) {
                input.add(s.next());
            }
            s.close();
        } catch (FileNotFoundException exception){
            exception.printStackTrace();
        }
    }

    private void solverA() {

    }

    private void solverB() {

    }

    @Override
    public String getResult(){

        return "";//"Answer_1a: " + answerA + " Time: " + (stopTimeA - startTimeA) + "ms" + "\n" + "Answer_1b: " + answerB + " Time: " + (stopTimeB - startTimeB) + "ms";
    }

}
