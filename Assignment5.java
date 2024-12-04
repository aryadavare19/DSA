import java.util.*;
/*
Name - Arya Davare
U no.-UCE2023514
batch-B1

Given an array of jobs where every job has a deadline and associated profit if the job is
finished before the deadline. It is also given that every job takes a single unit of time,
so the minimum possible deadline for any job is 1. Maximize the total profit if only one job
 can be scheduled at a time.


JobID      Deadline     Profit
  a            2          100
  b            1          19
  c            2          27
  d            1          25
  e            3          15
*/

import java.util.Arrays;
class Job {
    int id;        // Job ID
    int deadline;  // Deadline of the job
    int profit;    // Profit if the job is completed before or on the deadline
    // Constructor
    public Job(int id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}



class Scheduling{

    Job[] array;


    Scheduling(int numberofjobs){
        this.array=new Job[numberofjobs];
    }
    Scanner sc=new Scanner(System.in);
    void accept() {
        for(int i=0;i<array.length;i++) {
            System.out.println();
            System.out.print("Enter job id :" );
            int id=sc.nextInt();
            sc.nextLine();
            System.out.print("Enter job deadline:" );
            int deadline=sc.nextInt();
            sc.nextLine();
            System.out.print("Enter job profit :" );
            int profit=sc.nextInt();
            sc.nextLine();
            Job obj=new Job(id,deadline,profit);
            array[i]=obj;
        }
    }
    void display() {
        System.out.println("Jobs to be scheduled : \n");
        for(int i=0;i<array.length;i++) {
            System.out.println("job id : "+array[i].id);
            System.out.println("job deadline : "+array[i].deadline);
            System.out.println("job profit : "+array[i].profit);
            System.out.println();
        }
    }
    int maxDeadline() {
        int max=array[0].deadline;
        for(int i=0;i<array.length;i++) {
            if(max<array[i].deadline) {
                max=array[i].deadline;
            }
        }
        return max;
    }
    // Function to schedule jobs to maximize profit using greedy approach
    int[] jobScheduling(Job[] jobs) {
        // Sort jobs in descending order of profit
        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);
        int n=maxDeadline();
        // To store result (sequence of jobs)
        int[] result = new int[n]; // result[i] will store the job id if job is assigned to time slot i+1
        // To keep track of free time slots
        boolean[] slot = new boolean[n]; // Initially all time slots are free
        // Initialize result and slot array
        int maxProfit = 0;  // To store the maximum profit obtained
        int countJobs = 0;  // To count the total number of jobs done
        // Iterate through all the jobs
        for (int i = 0; i < array.length; i++) {
            // Find a free slot for this job, starting from the last possible slot
            for (int j = Math.min(n, jobs[i].deadline) - 1; j >= 0; j--) {
                // If the slot is free, assign this job to the slot
                if (!slot[j]) {

                    result[j] = jobs[i].id; // Assign job id to the slot
                    slot[j] = true;         // Mark this slot as occupied
                    maxProfit += jobs[i].profit;
                    countJobs++;                  // Increment the job count
                    break; // Job is assigned no need to check further
                }
            }
        }
        // Output the total number of jobs done and the maximum profit
        System.out.println("Total jobs done: " + countJobs);
        System.out.println("Maximum profit: " + maxProfit);
        // Return the result array containing the job sequence
        return result;
    }
}

public class Assignment5 {
    public static void main(String[] args) {
        // Array of jobs, each job has an id, deadline, and profit
        Scanner sc=new Scanner(System.in);

        System.out.print("Enter number of jobs to be scheduled : ");
        int n=sc.nextInt();
        Scheduling obj=new Scheduling(n);
        obj.accept();
        obj.display();
        
        int[] result= obj.jobScheduling(obj.array);
        System.out.print("Job id sequence : ");
        for(int i=0;i< result.length;i++) {
            if (result[i] != 0) {
                System.out.print("Job" + result[i] + " ");
            }
        }
        System.out.println();
    }
}
/*
Enter number of jobs to be scheduled : 5

Enter job id :1
Enter job deadline:2
Enter job profit :100

Enter job id :2
Enter job deadline:1
Enter job profit :19

Enter job id :3
Enter job deadline:2
Enter job profit :27

Enter job id :4
Enter job deadline:1
Enter job profit :25

Enter job id :5
Enter job deadline:3
Enter job profit :15

Jobs to be scheduled :

job id : 1
job deadline : 2
job profit : 100

job id : 2
job deadline : 1
job profit : 19

job id : 3
job deadline : 2
job profit : 27

job id : 4
job deadline : 1
job profit : 25

job id : 5
job deadline : 3
job profit : 15

Total jobs done: 3
Maximum profit: 142
Job id sequence : Job3 Job1 Job5

Process finished with exit code 0

 */
