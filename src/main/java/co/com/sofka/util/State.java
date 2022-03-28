package co.com.sofka.util;

public enum State {

    ALABAMA(1),
    ALASKA(2),
    ARIZONA(3),
    ARKANSAS(4),
    CALIFORNIA(5),
    COLORADO(6),
    CONNECTICUT(7),
    DELAWARE(8),
    DISTRICT_OF_COLUMBIA(9),
    FLORIDA(10),
    GEORGIA(11),
    HAWAII(12),
    IDAHO(13),
    ILLINOIS(14),
    INDIANA(15),
    IOWA(16),
    KANSAS(17),
    KENTUCKY(18),
    LOUISIANA(19),
    MAINE(20),
    MARYLAND(21),
    MASSACHUSETTS(22),
    MICHIGAN(23),
    MINNESOTA(24),
    MISSISSIPPI(25),
    MISSOURI(26),
    MONTANA(27),
    NEBRASKA(28),
    NEVADA(29),
    NEW_HAMPSHIRE(30),
    NEW_JERSEY(31),
    NEW_MEXICO(32),
    NEW_YORK(33),
    NORTH_CAROLINA(34),
    NORTH_DAKOTA(35),
    OHIO(36),
    OKLAHOMA(37),
    OREGON(38),
    PENNSYLVANIA(39),
    PUERTO_RICO(40),
    RHODE_ISLAND(41),
    SOUTH_CAROLINA(42),
    SOUTH_DAKOTA(43),
    TENNESSEE(44),
    TEXAS(45),
    US_VIRGIN_ISLANDS(46),
    UTAH(47),
    VERMONT(48),
    VIRGINIA(49),
    WASHINGTON(50),
    WEST_VIRGINIA(51),
    WISCONSIN(52),
    WYOMING(53);

    private final int value;

    State(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
