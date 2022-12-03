import java.util.ArrayList;

public class FCFS extends Scheduler{

    FCFS(int first, ArrayList<Integer> s, ArrayList<Integer> t) {
        super("FCFS", first, s, t);
    }

    /**
     * First come - first serve target will be first in pending list
     * @return first in pending list
     */
    @Override
    protected int getTarget() {
        return pending.get(0);
    }
}
