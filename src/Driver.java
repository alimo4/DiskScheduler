import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) throws FileNotFoundException {
        // lists to hold intervals and requests
        ArrayList<Integer> s = new ArrayList<>();
        ArrayList<Integer> t = new ArrayList<>();

        // file scanner
        Scanner inFile = new Scanner(new File("input.txt"));
        // read disk size
        int first = inFile.nextInt();

        // read intervals and requests into lists
        while(inFile.hasNext()) {
            s.add(inFile.nextInt());
            t.add(inFile.nextInt());
        }

        // run each operation
        FCFS fcfs = new FCFS(first, s, t);
        fcfs.run();

        SSTF SSTF = new SSTF(first, s, t);
        SSTF.run();
    }
}
