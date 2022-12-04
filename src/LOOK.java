import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LOOK extends Scheduler{
    boolean greater = true;

    LOOK(int first, ArrayList<Integer> s, ArrayList<Integer> t) {
        super("LOOK", first, s, t);
    }

    @Override
    protected int getTarget() {
        Map<Integer, Integer> distances = new HashMap<>();

        // calculate the distance to each request that is greater than the current head
        if(greater) {
            for(int i : pending) {
                // target here represents head location
                // place distance along with corresponding request
                if (target < i)
                    distances.put(Math.abs(target - i), i);
            }
            if (distances.isEmpty()) {
                // switch to state of seeking lesser requests
                greater = false;
                return getTarget();
            }
        }
        // calculate the distance to each request that is less than the current head
        else {
            for(int i : pending) {
                // target here represents head location
                // place distance along with corresponding request
                if (target > i)
                    distances.put(Math.abs(target - i), i);
            }
            if (distances.isEmpty()) {
                // switch to state of seeking greater requests
                greater = true;
                return getTarget();
            }
        }

        // previous recursive calls made to skip this call
        return getNextTarget(distances);
    }

    // get key of request with minimum distance
    private int getNextTarget(Map<Integer, Integer> distances) {
        int keyOfNextTarget = Collections.min(distances.keySet());
        return distances.get(keyOfNextTarget);
    }
}
