import java.util.ArrayList;

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

    }
}
