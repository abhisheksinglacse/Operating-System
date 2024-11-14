import java.util.*;

class Process {
    int processId;
    int arrivalTime;
    int burstTime;
    int remainingTime;

    public Process(int processId, int arrivalTime, int burstTime) {
        this.processId = processId;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
    }
}

public class SRTF {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of processes: ");
        int n = sc.nextInt();

        ArrayList<Process> processes = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            System.out.println("Enter details for Process " + (i + 1));
            System.out.print("Arrival Time: ");
            int arrivalTime = sc.nextInt();
            System.out.print("Burst Time: ");
            int burstTime = sc.nextInt();
            processes.add(new Process(i + 1, arrivalTime, burstTime));
        }

        int currentTime = 0;
        int completedProcesses = 0;

        while (completedProcesses < n) {
            Process shortestRemainingTimeProcess = null;
            int shortestRemainingTime = Integer.MAX_VALUE;

            for (Process process : processes) {
                if (process.arrivalTime <= currentTime && process.remainingTime < shortestRemainingTime && process.remainingTime > 0) {
                    shortestRemainingTime = process.remainingTime;
                    shortestRemainingTimeProcess = process;
                }
            }

            if (shortestRemainingTimeProcess == null) {
                currentTime++;
            } else {
                shortestRemainingTimeProcess.remainingTime--;
                currentTime++;

                if (shortestRemainingTimeProcess.remainingTime == 0) {
                    completedProcesses++;
                    int completionTime = currentTime;
                    int turnaroundTime = completionTime - shortestRemainingTimeProcess.arrivalTime;
                    int waitingTime = turnaroundTime - shortestRemainingTimeProcess.burstTime;

                    System.out.println("Process " + shortestRemainingTimeProcess.processId +
                            " (Arrival Time: " + shortestRemainingTimeProcess.arrivalTime +
                            ", Burst Time: " + shortestRemainingTimeProcess.burstTime +
                            ") completed at time " + completionTime +
                            " | Turnaround Time: " + turnaroundTime +
                            " | Waiting Time: " + waitingTime);
                }
            }
        }
    }
}
