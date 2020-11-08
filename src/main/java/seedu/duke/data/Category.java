package seedu.duke.data;

public enum Category {
    FOOD("Food"),
    EDUCATION("Education"),
    ENTERTAINMENT("Entertainment"),
    HEALTH("Health"),
    TRANSPORTATION("Transportation"),
    UTILITIES("Utilities"),
    OTHERS("Others");

    private final String category;
    Category(String category) {
        this.category = category;
    }

    public static String categoryName(String name) {
        if (name == null) {
            return OTHERS.toString();
        }
        for (Category c: values()) {
            if (name.equalsIgnoreCase(c.category)) {
                return c.toString();
            }
        }
        return OTHERS.toString();
    }

    @Override
    public String toString() {
        return this.category;
    }
}
