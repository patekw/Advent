
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Problem_2 implements Problem {

    private ArrayList<String> input;
    private String answerA;
    private String answerB;
    private Long startTimeA;
    private Long stopTimeA;
    private Long startTimeB;
    private Long stopTimeB;

    public Problem_2() {
        init();
        solver_2a();
        solver_2b();
        //getResult();
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
        for (int i = 0; i < input.size(); i++){

        }
    }

    private void solver_2b() {

    }

    @Override
    public String getResult(){
        return "";
        // return "Answer_1a: " + answerA + " Time: " + (stopTimeA - startTimeA) + "ms" + "\n" + "Answer_1b: " + answerB + " Time: " + (stopTimeB - startTimeB) + "ms";
    }

}
