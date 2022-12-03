import java.util.ArrayList;

public abstract class Scheduler {
    String name;
    int size, target;
    ArrayList<Integer> s;
    ArrayList<Integer> t;
    ArrayList<Integer> pending = new ArrayList<>();

    Scheduler(String name, int size, ArrayList<Integer> s, ArrayList<Integer> t) {
        this.name = name;
        this.size = size;
        this.s = s;
        this.t = t;
    }

    public void run() {
        // handle initial variables
        int time = s.get(0), request = 0;
        target = t.get(0);
        int i = 0, head = 0;

        // Print title
        Printer.printTitle(this.name);

        // Loop through requests
        do {
            // add requests every interval
            if(time % 15 == 0 && i < t.size()) {
                request = t.get(i);
                pending.add(request);
                i++;
                Printer.print(time, head, request, target, pending.toArray(new Integer[0]), false);
            }

            // target reached -- run algorithm
            if(head == target) {
                servicing(time, head, request);
            }
            // increment/decrement to reach target
            if(head < target) {
                head++;
            } else if(head > target) {
                head--;
            }

            // iterate time
            time++;
        } while(!pending.isEmpty());
    }

    // Unique scheduling algorithm
    protected abstract void servicing(int time, int head, int request);
}
