import java.util.ArrayList;

public abstract class Scheduler {
    String name;
    int first, target;
    ArrayList<Integer> s;
    ArrayList<Integer> t;
    ArrayList<Integer> pending = new ArrayList<>();

    Scheduler(String name, int first, ArrayList<Integer> s, ArrayList<Integer> t) {
        this.name = name;
        this.first = first;
        this.s = s;
        this.t = t;
    }

    public void run() {
        int time = s.get(0), request;
        target = t.get(0);
        int i = 0;

        Printer.printTitle(this.name);
//        for(int i = 0; i < t.size(); i++) {
        do {
            // set request -- add to pending
            request = t.get(i);
            pending.add(request);

            // print adding request
            Printer.print(time, request, target, pending.toArray(new Integer[0]), false);

            // scheduling algorithm
            servicing(time, i, request);

            // update time
            time += s.get(i);
            i++;
        } while(!pending.isEmpty());
    }

    // Unique scheduling algorithm
    protected abstract void servicing(int time, int i, int request);
}
