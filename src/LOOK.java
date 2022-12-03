import java.util.ArrayList;

public class LOOK extends Scheduler{

    LOOK(int first, ArrayList<Integer> s, ArrayList<Integer> t) {
        super("LOOK", first, s, t);
    }

    /**
     * Remove request from pending list and update both previous target and current target according to LOOK
     * @param time Needed for printing
     * @param head Needed for printing
     * @param request to be updated
     */
    protected void servicing(int time, int head, int request) {

    }
}
