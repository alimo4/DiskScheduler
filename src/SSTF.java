import java.util.ArrayList;
import java.util.Collections;

public class SSTF extends Scheduler{

    SSTF(int first, ArrayList<Integer> s, ArrayList<Integer> t) {
        super("SSTF", first, s, t);
    }

    /**
     * Remove request from pending list and update both previous target and current target according to SSTF
     * @param time Needed for printing
     * @param head Needed for printing
     * @param request to be updated
     */
    protected void servicing(int time, int head, int request) {
        pending.remove((Integer) head);
        Printer.print(time, head, request, target, pending.toArray(new Integer[0]), true);

        if(!pending.isEmpty()) {
            target = getTarget();
        }
    }

    // get next target with the shortest seek time
    private int getTarget() {
        ArrayList<Integer> distances = new ArrayList<>();

        // calculate the distance to each request
        for(int i : pending) {
            // target here represents head location
            distances.add(Math.abs(target - i));
        }

        // get index of target with minimum distance
        int indexOfNextTarget = distances.indexOf(Collections.min(distances));

        return pending.get(indexOfNextTarget);
    }
}
