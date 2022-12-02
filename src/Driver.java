import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) throws FileNotFoundException {
        String sampleInput = "";

        ArrayList<Integer> s = new ArrayList<>();
        ArrayList<Integer> t = new ArrayList<>();

        Scanner inFile = new Scanner(new File("input.txt"));
        int first = inFile.nextInt();
        System.out.println(first);
        while(inFile.hasNext()) {
            s.add(inFile.nextInt());
            t.add(inFile.nextInt());
        }

        FCFS fcfs = new FCFS(first, s, t);
        fcfs.run();
    }
}
