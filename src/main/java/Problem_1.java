
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Problem_1 implements Problem {

    private ArrayList<String> input;
    private String answerA;
    private String answerB;
    private Long startTimeA;
    private Long stopTimeA;
    private Long startTimeB;
    private Long stopTimeB;

    public Problem_1() {
        init();
        solver_1a();
        solver_1b();
        getResult();
    }

    private void init() {
        try {
            input = new ArrayList<>();
            Scanner s = new Scanner(new File("src/main/resources/input_1.txt"));
            while (s.hasNext()) {
                input.add(s.next());
            }
            s.close();
        } catch (FileNotFoundException exception){
            exception.printStackTrace();
        }
    }

    private void solver_1a() {
        startTimeA = System.currentTimeMillis();
        for (int i = 0; i < input.size(); i++){
            for (int j = 0; j < input.size(); j++) {
            //for (int j = i; j < input.size()-i; j++) {
                if (Integer.valueOf(input.get(i)) + Integer.valueOf(input.get(j)) == 2020){
                    //System.out.println(input.get(i) + " " + input.get(j));
                    answerA = String.valueOf(Integer.valueOf(input.get(i)) * Integer.valueOf(input.get(j)));
                    stopTimeA = System.currentTimeMillis();
                    return;
                }
            }
        }
    }

    private void solver_1b() {
        startTimeB = System.currentTimeMillis();
        for (int i = 0; i < input.size(); i++){
            //System.out.print(i);
            for (int j = 0; j < input.size(); j++) {
                //for (int j = i; j < input.size()-i; j++) {
                for(int k = 0; k < input.size(); k++) {
                    if (Integer.valueOf(input.get(i)) + Integer.valueOf(input.get(j)) + Integer.valueOf(input.get(k)) == 2020) {
                        //System.out.println(input.get(i) + " " + input.get(j));
                        answerB = String.valueOf(Integer.valueOf(input.get(i)) * Integer.valueOf(input.get(j)) * Integer.valueOf(input.get(k)));
                        stopTimeB = System.currentTimeMillis();
                        return;
                    }
                }
            }
        }
    }

    @Override
    public String getResult(){

        return "Answer_1a: " + answerA + " Time: " + (stopTimeA - startTimeA) + "ms" + "\n" + "Answer_1b: " + answerB + " Time: " + (stopTimeB - startTimeB) + "ms";
    }

}
