import java.util.ArrayList;

public class FCFS extends Scheduler{

    FCFS(int first, ArrayList<Integer> s, ArrayList<Integer> t) {
        super("FCFS", first, s, t);
    }

    /**
     * Remove request from pending list and update both previous target and current target according to FCFS
     * @param time Needed for printing
     * @param head Needed for printing
     * @param request to be updated
     */
    protected void servicing(int time, int head, int request) {
        pending.remove((Integer) head);
        Printer.print(time, head, request, target, pending.toArray(new Integer[0]), true);

        if(!pending.isEmpty()) {
            target = pending.get(0);
        }
    }
}
