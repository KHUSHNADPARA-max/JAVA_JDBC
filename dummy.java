import java.util.Scanner;

public class dummy {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    // Read the size of the array
    int n = scanner.nextInt();

    // Read the elements of the array
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = scanner.nextInt();
    }

    // Calculate the minimum number of tasks needed to complete all top priority tasks
    int tasksNeeded = calculateTasksNeeded(a);

    // Print the result
    System.out.println(tasksNeeded);
  }

  // Calculate the minimum number of tasks needed to complete all top priority tasks
  public static int calculateTasksNeeded(int[] a) {
    // Initialize the counter for top priority tasks
    int topPriorityTasks = 0;

    // Iterate over the array and count the top priority tasks
    for (int i = 0; i < a.length; i++) {
      if (a[i] <= 7) {
        topPriorityTasks++;
      }
    }

    // Return the minimum number of tasks needed to complete all top priority tasks
    return Math.min(a.length, topPriorityTasks);
  }
}
