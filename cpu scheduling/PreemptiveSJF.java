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

public class PreemptiveSJF {

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

        // Sort processes based on arrival time
        Arrays.sort(processes, Comparator.comparingInt(p -> p.arrivalTime));

        int time = 0;
        int completed = 0;
        int totalWt = 0, totalTat = 0;

        while (completed < n) {
            // Find the process with the smallest remaining time
            int idx = -1;
            int minRemainingTime = Integer.MAX_VALUE;

            for (int i = 0; i < n; i++) {
                if (processes[i].arrivalTime <= time && processes[i].remainingTime > 0) {
                    if (processes[i].remainingTime < minRemainingTime) {
                        minRemainingTime = processes[i].remainingTime;
                        idx = i;
                    }
                }
            }

            if (idx != -1) { // If there is a process ready to execute
                processes[idx].remainingTime--;
                time++;

                // If the process is completed
                if (processes[idx].remainingTime == 0) {
                    processes[idx].turnaroundTime = time - processes[idx].arrivalTime;
                    processes[idx].waitingTime = processes[idx].turnaroundTime - processes[idx].burstTime;
                    totalWt += processes[idx].waitingTime;
                    totalTat += processes[idx].turnaroundTime;
                    completed++;
                }
            } else {
                time++; // No process is ready, just increment time
            }
        }

        // Print results
        System.out.println("P\tBT\tAT\tWT\tTAT");
        for (Process p : processes) {
            System.out.println("P" + p.pid + "\t" + p.burstTime + "\t" + p.arrivalTime + "\t" + p.waitingTime + "\t" + p.turnaroundTime);
        }

        System.out.println("Average Waiting Time: " + (double) totalWt / n);
        System.out.println("Average Turnaround Time: " + (double) totalTat / n);
        s.close();
    }
}