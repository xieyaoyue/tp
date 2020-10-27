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

    public static String categoryName(String name) {
        for (Category c: values()) {
            if (name.equalsIgnoreCase(c.category)) {
                return c.toString();
            }
        }
        return OTHER.toString();
    }

    public String toString() {
        return this.category;
    }
}
