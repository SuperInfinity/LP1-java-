import java.util.*;


public class sjf {

    static void sortIt(int process[][]) {
        for (int i = 0; i < process.length; i++) {
            int in = i;
            for (int j = i + 1; j < process.length; j++) {
                if (process[in][1] > process[j][1]) {
                    in = j;
                }
            }
            int tmp = process[i][0];
            process[i][0] = process[in][0];
            process[in][0] = tmp;
            tmp = process[i][1];
            process[i][1] = process[in][1];
            process[in][1] = tmp;
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
         
        int n, totalWt = 0, totalTat = 0;
        System.out.println("Enter the no. of proces: ");
        n = s.nextInt();

        int process[][] = new int[n][4];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter Pid: ");
            process[i][0] = s.nextInt();

            System.out.println("Burst time: ");
            process[i][1] = s.nextInt();
        }

        sortIt(process);

        process[0][2] = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                process[i][2] += process[j][1];
            }
            totalWt += process[i][2];
        }

        for (int i = 0; i < n; i++) {
            process[i][3] = process[i][1] + process[i][2];
            totalTat += process[i][3];
            
            System.out.println("P\tBT\tWT\tTAT");
            System.out.println("P" + process[i][0] + "\t" + process[i][1] + "\t" + process[i][2] + "\t" + process[i][3]);
        }



    }     
}
