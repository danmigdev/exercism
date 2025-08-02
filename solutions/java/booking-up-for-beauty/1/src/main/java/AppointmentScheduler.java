import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class AppointmentScheduler {
    
    public LocalDateTime schedule(String appointmentDateDescription) {
        return LocalDateTime.parse(appointmentDateDescription, DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss"));
    }

    public boolean hasPassed(LocalDateTime appointmentDate) {
        return LocalDateTime.now().isAfter(appointmentDate);
    }

    public boolean isAfternoonAppointment(LocalDateTime appointmentDate) {
        return appointmentDate.getHour() >= 12 && appointmentDate.getHour() < 18;
    }

    public String getDescription(LocalDateTime appointmentDate) {
        return "You have an appointment on " + appointmentDate.format(DateTimeFormatter.ofPattern("EEEE, LLLL d, yyyy, ")) + "at " + appointmentDate.format(DateTimeFormatter.ofPattern("h:mm a."));
    }

    public LocalDate getAnniversaryDate() {
        return LocalDate.of(2023, 9, 15);
    }
    
}
