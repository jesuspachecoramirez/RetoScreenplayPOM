package co.com.sofka.util;

public enum SubjectHeading {
    CUSTOMER_SERVICE(2),
    WEBMASTER(1);

    private final int value;

    SubjectHeading(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
