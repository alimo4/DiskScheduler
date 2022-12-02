public class Printer {
    public static void printTitle(String name) {
        System.out.println("=======" + name + " SCHEDULER=========================");
    }

    public static void print(int time, int request, int target, Integer[] pRequests, boolean isServicing) {
        if(isServicing) {
            System.out.printf("[Time=%d] >>>>SERVICING track %d.\n", time, target);
        } else {
            System.out.printf("[Time=%d] Adding request %d.\n", time, request);
        }

        System.out.printf("Head @ %d. Current target = %d Pending requests " +
                "are now [%s]\n", time, target, getPendingRequests(pRequests));
    }

    private static String getPendingRequests(Integer[] pRequests) {
        StringBuilder s = new StringBuilder();
        s.append(pRequests[0]);
        for(int i = 1; i < pRequests.length; i++) {
            s.append(", " + pRequests[i]);
        }
        return s.toString();
    }
}
