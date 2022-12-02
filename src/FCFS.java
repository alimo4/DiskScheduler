import java.util.ArrayList;

public class FCFS extends Scheduler{

    FCFS(int first, ArrayList<Integer> s, ArrayList<Integer> t) {
        super("FCFS", first, s, t);
    }

    protected void servicing(int time, int i, int request) {
        if(target - time < s.get(i)) {
            pending.remove(0);
            Printer.print(time, request, target, pending.toArray(new Integer[0]), true);
            target = pending.get(0);
        }
    }
}
