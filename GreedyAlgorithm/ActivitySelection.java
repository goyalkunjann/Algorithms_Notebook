import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Activity {
    int start, finish;

    public Activity(int start, int finish) {
        this.start = start;
        this.finish = finish;
    }
}

public class GreedyActivitySelection {
    public static List<Activity> selectActivities(List<Activity> activities) {
        List<Activity> selectedActivities = new ArrayList<>();

        // Sort activities by finish time
        Collections.sort(activities, Comparator.comparingInt(a -> a.finish));

        // Select the first activity
        selectedActivities.add(activities.get(0));

        // Iterate through the remaining activities
        for (int i = 1; i < activities.size(); i++) {
            Activity currentActivity = activities.get(i);
            Activity lastSelected = selectedActivities.get(selectedActivities.size() - 1);

            // If the current activity's start time is after or equal to the last selected activity's finish time, select it
            if (currentActivity.start >= lastSelected.finish) {
                selectedActivities.add(currentActivity);
            }
        }

        return selectedActivities;
    }

    public static void main(String[] args) {
        List<Activity> activities = new ArrayList<>();
        activities.add(new Activity(1, 4));
        activities.add(new Activity(3, 5));
        activities.add(new Activity(0, 6));
        activities.add(new Activity(5, 7));
        activities.add(new Activity(8, 9));
        activities.add(new Activity(5, 9));

        List<Activity> selectedActivities = selectActivities(activities);

        System.out.println("Selected Activities:");
        for (Activity activity : selectedActivities) {
            System.out.println("[" + activity.start + ", " + activity.finish + "]");
        }
    }
}
