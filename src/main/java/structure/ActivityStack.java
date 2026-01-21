package structure;

import java.util.ArrayList;
import java.util.List;

public class ActivityStack {
    private List<String> stack = new ArrayList<>();

    public void push(String activity) {
        stack.add(activity);
    }

    public String pop() {
        if (!stack.isEmpty()) return stack.remove(stack.size() - 1);
        return null;
    }

    public String peek() {
        if (!stack.isEmpty()) return stack.get(stack.size() - 1);
        return null;
    }

    public void display() {
        if (stack.isEmpty()) {
            System.out.println("- Aucune activité");
            return;
        }
        for (int i = stack.size() - 1; i >= 0; i--) {
            System.out.println("- " + stack.get(i));
        }
    }
}
