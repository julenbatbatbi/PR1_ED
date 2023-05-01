package uoc.ds.pr;

import java.time.LocalDate;

public class EventRequest {

    private String id;
    private String eventId;
    private String description;
    private UniversityEvents.InstallationType installationType;
    private byte resources;
    private int max;
    private LocalDate startDate;
    private LocalDate endDate;

    private boolean allowRegister;


   public EventRequest(String id, String eventId, String description, UniversityEvents.InstallationType installationType, byte resources, int max, LocalDate startDate, LocalDate endDate, boolean allowRegister){
        this.allowRegister = allowRegister;
        this.eventId = eventId;
        this.description = description;
        this.id = id;
        this.endDate = endDate;
        this.startDate = startDate;
        this.max = max;
        this.resources = resources;
        this.installationType = installationType;
   }

   public String getRequestId(){
       return this.id;
   }
    public boolean isAllowRegister() {
        return allowRegister;
    }

    public String getDescription() {
        return description;
    }

    public byte getResources() {
        return resources;
    }

    public UniversityEvents.InstallationType getInstallationType() {
        return installationType;
    }

    public int getMax() {
        return max;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public String getEventId() {
        return eventId;
    }

    public String getId() {
        return id;
    }
}
