import java.util.*;


public class fcfs {

    static void calcWaiting(int process[], int burst[], int wt[]) {
        wt[0] = 0;

        for (int i = 1; i < process.length; i++) {
            wt[i] = burst[i - 1] + wt[i - 1];
        }
    }

    static void calcTat(int process[],int burst[] ,int wt[], int tat[]) {
        for (int i = 0; i < process.length; i++) {
            tat[i] = wt[i] + burst[i];
        }
    }

    static void avgTime(int process[], int burst[]) {
        int wt[] = new int[process.length], tat[] = new int[process.length];
        int total_wt = 0, total_tat = 0;

        calcWaiting(process, burst, wt);
        calcTat(process, burst, wt, tat);

        System.out.println("Processes Burst time Waiting time Turn around time\n");

        for (int i = 0; i < process.length; i++) {
            total_wt = total_wt + wt[i];
            total_tat = total_tat + tat[i];
            System.out.printf(" %d ", (i + 1));
            System.out.printf("     %d ", burst[i]);
            System.out.printf("     %d", wt[i]);
            System.out.printf("     %d\n", tat[i]);
        }

        float s = (float)total_wt /(float) process.length;
        int t = total_tat / process.length;
        System.out.printf("Average waiting time = %f", s);
        System.out.printf("\n");
        System.out.printf("Average turn around time = %d ", t);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n;
        System.out.println("No. of Processes: ");
        n = scanner.nextInt();
        
        int process[] = new int[n];
        int brst[] = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Process id: ");
            process[i] = scanner.nextInt();

            System.out.print("Enter burst time: ");
            brst[i] = scanner.nextInt();
        }

        avgTime(process, brst);

        scanner.close();

    }
    
}