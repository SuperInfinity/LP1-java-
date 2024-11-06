import java.util.*;
import java.util.prefs.PreferenceChangeEvent;



public class test {
    public static void main(String[] args) {
        // Fcfs obj = new Fcfs();
        // obj.fcfs();

        Sjf o = new Sjf();
        o.sjfNP();
    }
    
}


class Fcfs {
    private LinkedList<Process> readyQ = new LinkedList<>();

    public void fcfs() {
        int n, tTat = 0, tWt = 0;
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter no. of process: ");
        n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            int at, bt;
            String name;
            
            System.out.println("Enter name: ");
            name = scanner.next();

            System.out.println("Enter A.T: ");
            at = scanner.nextInt();

            System.out.println("Enter B.T: ");
            bt = scanner.nextInt();

            readyQ.add(new Process(name, at, bt));
        }

        // Processsing 
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                readyQ.get(i).wt = 0;
            }
            else {
                readyQ.get(i).wt = readyQ.get(i - 1).wt + readyQ.get(i - 1).bt;
                tWt += readyQ.get(i).wt;
            }
            readyQ.get(i).tat = readyQ.get(i).bt + readyQ.get(i).wt;
            tTat += readyQ.get(i).tat;

        }

        System.out.println("TWT: " + tWt);
        System.out.println("TAT: " + tTat);
        scanner.close();
    }
    
}

class Process {
    int at, bt, rm, tat, wt, ct;
    String name;

    public Process(String name, int at, int bt) {
        this.at = at;
        this.bt = bt;
        this.rm = bt;
        this.tat = 0;
        this.wt = 0;
        this.ct = 0;
        this.name = name;
    }

}


class Sjf {
    // SJF Non-Preemptive
    public void sjfNP() {
        int n;
        Scanner scanner = new Scanner(System.in);

        LinkedList<Process> readyQ = new LinkedList<>();
        
        System.out.println("Enter no of processes: ");
        n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            int at, bt;
            String name;

            System.out.println("Enter name: ");
            name = scanner.next();

            System.out.println("Enter AT: ");
            at = scanner.nextInt();

            System.out.println("Enter BT: ");
            bt = scanner.nextInt();

            readyQ.offer(new Process(name, at, bt));
        }

        Collections.sort(readyQ, (Process p1, Process p2) -> Integer.compare(p1.at, p2.at));

        int time = 0, curr = 0;
        
        LinkedList<Process> waiting = new LinkedList<>();
        waiting.offer(readyQ.get(curr));

        while (!waiting.isEmpty()) {
            Process p = waiting.poll();
            p.wt = time - p.at;
            time += p.bt;
            p.ct = time;
            p.tat = p.wt + p.bt;
            for (int i = curr + 1; i < n; i++) {
                if (readyQ.get(i).at <= time && !waiting.contains(readyQ.get(i))) {
                    waiting.offer(readyQ.get(i));
                    curr++;
                }
            }
            Collections.sort(waiting, (p1, p2) -> Integer.compare(p1.bt, p2.bt));
        }

        System.out.printf("| %-10s | %-10s | %-10s | %-10s | %-10s | %-10s |\n", "Process", "AT", "BT", "WT", "TAT", "CT");

        for (Process i:  readyQ) {
            System.out.printf("| %-10s | %-10d | %-10d | %-10d | %-10d | %-10d |\n", i.name, i.at, i.bt, i.wt, i.tat, i.ct);
        }

        scanner.close();

    }
    // SJF Preemptive
    public void sjfP() {
        int n;
        Scanner scanner = new Scanner(System.in);

        LinkedList<Process> readyQ = new LinkedList<>();
        
        System.out.println("Enter no of processes: ");
        n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            int at, bt;
            String name;

            System.out.println("Enter name: ");
            name = scanner.next();

            System.out.println("Enter AT: ");
            at = scanner.nextInt();

            System.out.println("Enter BT: ");
            bt = scanner.nextInt();

            readyQ.offer(new Process(name, at, bt));
        }

        Collections.sort(readyQ, (Process p1, Process p2) -> Integer.compare(p1.at, p2.at));
        
        LinkedList<Process> waiting = new LinkedList<>();
        int completed = 0, time = 0, curr = 0;
        boolean flag = false;


        while (completed < n) {
            for (Process i: readyQ) {
                if (i.at <= time) {
                    waiting.offer(i);
                }
            }
            Collections.sort(waiting, (Process p1, Process p2) -> Integer.compare(p1.))
        }


        scanner.close(); 
    }

}

