public class Evento {

    private String eventCode;
    private String eventMessage;
    private String eventDate;

    public Evento(String eventCode, String eventMessage, String eventDate) {
        this.eventCode = eventCode;
        this.eventMessage = eventMessage;
        this.eventDate = eventDate;
    }

    public String getEventCode() {
        return eventCode;
    }

    public String getEventMessage() {
        return eventMessage;
    }

    public String getEventDate() {
        return eventDate;
    }

    @Override
    public String toString() {
        return (this.eventMessage + "\n(" + this.eventDate + ")");
    }
}
