package Adapter;

public class Main {
    public static void main(String[] args) {
        CalendarToNewDateAdapter customCalendar = new CalendarToNewDateAdapter();
        customCalendar.setDay(19);
        customCalendar.setMonth(9);

        customCalendar.advanceDays(12);

        System.out.println(customCalendar);
    }
}
