package seedu.duke.category;

public enum Category {
    FOOD("Food"),
    EDUCATION("Education"),
    ENTERTAINMENT("Entertainment"),
    HEALTH("Health"),
    TRANSPORTATION("Transportation"),
    UTILITIES("Utilities"),
    OTHER("Other");

    private String category;
    Category(String category) {
        this.category = category;
    }

    public static boolean hasCategory(String name) {
        for (Category c: values()) {
            if (name.equals(c.category)) {
                return true;
            }
        }
        return false;
    }
}
