import java.util.ArrayList;

public class LOOK extends Scheduler{

    LOOK(int first, ArrayList<Integer> s, ArrayList<Integer> t) {
        super("LOOK", first, s, t);
    }

    @Override
    protected int getTarget() {
        return 0;
    }
}
