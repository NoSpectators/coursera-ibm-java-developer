import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

public class Mood {
    private final UUID id; // can't ever change once set
    private final String name;
    private LocalDate date = LocalDate.now();
    private LocalTime time = LocalTime.MIDNIGHT;
    private String notes;

    // Overload the constructors below with various arguments
    public Mood(String name) {
        this(name, LocalDate.now(), LocalTime.MIDNIGHT, null);
    }

    public Mood(String name, String notes) {
        this(name, LocalDate.now(), LocalTime.MIDNIGHT, notes);
    }

    public Mood(String name, LocalDate date) {
        this(name, date, LocalTime.MIDNIGHT, null);
    }

    public Mood(String name, LocalDate date, LocalTime time) {
        this(name, date, time, null);
    }

    public Mood(String name, LocalDate date, String notes) {
        this(name, date, LocalTime.MIDNIGHT, notes);
    }

    public Mood(String name, LocalDate date, LocalTime time, String notes) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.date = date;
        this.time = time;
        this.notes = notes;
    }

    // getters and setters
    public UUID getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public LocalDate getDate() {
        return this.date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return this.time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public String getNotes() {
        return this.notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return name + " - " + date + "  " + time + "\n" + notes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // same reference - equal
        if (!(o instanceof Mood)) return false; // null or different type
        Mood mood = (Mood) o;
        return this.id.equals(mood.id);
    }
    // required for above override
    @Override
    public int hashCode() {
        return id.hashCode();
    }

}

