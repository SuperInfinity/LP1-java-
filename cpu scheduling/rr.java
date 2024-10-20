import java.util.*;

class Process {
    int pid; // Process ID
    int burstTime; // Burst time
    int arrivalTime; // Arrival time
    int remainingTime; // Remaining time
    int waitingTime; // Waiting time
    int turnaroundTime; // Turnaround time

    Process(int pid, int burstTime, int arrivalTime) {
        this.pid = pid;
        this.burstTime = burstTime;
        this.arrivalTime = arrivalTime;
        this.remainingTime = burstTime;
        this.waitingTime = 0;
        this.turnaroundTime = 0;
    }
}


public class rr {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the number of processes: ");
        int n = s.nextInt();

        Process[] processes = new Process[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter Pid: ");
            int pid = s.nextInt();
            System.out.println("Burst time: ");
            int burstTime = s.nextInt();
            System.out.println("Arrival time: ");
            int arrivalTime = s.nextInt();
            processes[i] = new Process(pid, burstTime, arrivalTime);
        }

        System.out.println("Enter time quantum: ");
        int timeQuantum = s.nextInt();

        int time = 0;
        int completed = 0;
        int totalWt = 0, totalTat = 0;

        Queue<Process> queue = new LinkedList<>();

        while (completed < n) {
            for (Process p : processes) {
                if (p.arrivalTime <= time && p.remainingTime > 0 && !queue.contains(p)) {
                    queue.add(p);
                }
            }

            if (!queue.isEmpty()) {
                Process current = queue.poll();
                int timeSlice = Math.min(current.remainingTime, timeQuantum);
                current.remainingTime -= timeSlice;
                time += timeSlice;

                // If the process is completed
                if (current.remainingTime == 0) {
                    current.turnaroundTime = time - current.arrivalTime;
                    current.waitingTime = current.turnaroundTime - current.burstTime;
                    totalWt += current.waitingTime;
                    totalTat += current.turnaroundTime;
                    completed++;
                } else {
                    queue.add(current); // Re-add the process to the queue
                }
            } else {
                time++; // No process is ready, just increment time
            }
        }
        System.out.println("P\tBT\tAT\tWT\tTAT");
        for (Process p : processes) {
            System.out.println("P" + p.pid + "\t" + p.burstTime + "\t" + p.arrivalTime + "\t" + p.waitingTime + "\t" + p.turnaroundTime);
        }

        System.out.println("Average Waiting Time: " + (double) totalWt / n);
        System.out.println("Average Turnaround Time: " + (double) totalTat / n);

        s.close();

    }
}
