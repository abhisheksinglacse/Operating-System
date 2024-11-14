import java.util.Scanner;

public class RoundRobin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of processes: ");
        int n = sc.nextInt();

        int[] processes = new int[n];
        int[] burstTime = new int[n];
        int[] waitingTime = new int[n];
        int quantum;

        System.out.println("Enter the burst times for each process:");
        for (int i = 0; i < n; i++) {
            System.out.print("Process " + (i + 1) + ": ");
            burstTime[i] = sc.nextInt();
            processes[i] = i + 1;
        }

        System.out.print("Enter the time quantum: ");
        quantum = sc.nextInt();

        int[] remainingTime = new int[n];
        for (int i = 0; i < n; i++) {
            remainingTime[i] = burstTime[i];
        }

        int currentTime = 0;
        boolean flag = true;

        System.out.println("\nProcess\t| Burst Time\t| Completion Time\t| Turnaround Time\t| Waiting Time");
        System.out.println("--------------------------------------------------------------------------------------------------");

        while (flag) {
            flag = false;
            for (int i = 0; i < n; i++) {
                if (remainingTime[i] > 0) {
                    flag = true;

                    if (remainingTime[i] > quantum) {
                        currentTime += quantum;
                        remainingTime[i] -= quantum;
                    } else {
                        currentTime += remainingTime[i];
                        waitingTime[i] = currentTime - burstTime[i];
                        remainingTime[i] = 0;
                    }

                    int turnaroundTime = currentTime;
                    System.out.println("P" + processes[i] + "\t|\t" + burstTime[i] + "\t\t|\t" + currentTime + "\t\t|\t"
                            + (turnaroundTime - burstTime[i]) + "\t\t|\t" + waitingTime[i]);
                }
            }
        }

        int totalWaitingTime = 0;
        int totalTurnaroundTime = 0;
        for (int i = 0; i < n; i++) {
            totalWaitingTime += waitingTime[i];
            totalTurnaroundTime += waitingTime[i] + burstTime[i];
        }

        float avgWaitingTime = (float) totalWaitingTime / n;
        float avgTurnaroundTime = (float) totalTurnaroundTime / n;

        System.out.println("\nAverage Waiting Time: " + avgWaitingTime);
        System.out.println("Average Turnaround Time: " + avgTurnaroundTime);
        sc.close();
    }
}
