import java.util.ArrayList;
import java.util.Collections;

public class SSTF extends Scheduler{

    SSTF(int first, ArrayList<Integer> s, ArrayList<Integer> t) {
        super("SSTF", first, s, t);
    }

    /**
     * Calculate seek time from head location to each request
     * @return request with minimum seek time
     */
    @Override
    protected int getTarget() {
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
