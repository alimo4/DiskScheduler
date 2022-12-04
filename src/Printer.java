public class Printer {
    public static void printTitle(String name) {
        System.out.println("=======" + name + " SCHEDULER=========================");
    }

    public static void print(int time, int head, int request, int target, Integer[] pRequests, boolean isServicing) {
        if(isServicing) {
            System.out.printf("[Time=%d] >>>>SERVICING track %d.\n", time, target);
        } else {
            System.out.printf("[Time=%d] Adding request %d.\n", time, request);
        }

        System.out.printf("Head @ %d. Current target = %d Pending requests " +
                "are now [%s]\n", head, target, getPendingRequests(pRequests));
    }

    private static String getPendingRequests(Integer[] pRequests) {
        // empty pending list
        if(pRequests.length == 0)
            return "";

        String s = "";
        s += pRequests[0];
        for(int i = 1; i < pRequests.length; i++) {
            s += ", " + pRequests[i];
        }
        return s;
    }

    public static void printFinal(int time) {
        System.out.println("\nTotal run-time was " + time + "\n");
    }
}
