package uoc.ds.pr.model;

import uoc.ds.pr.UniversityEvents;

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
    private String entityId;

    private boolean allowRegister;

    private UniversityEvents.Status status = UniversityEvents.Status.PENDING;


   public EventRequest(String id, String eventId, String entityId, String description, UniversityEvents.InstallationType installationType, byte resources, int max, LocalDate startDate, LocalDate endDate, boolean allowRegister){
        this.allowRegister = allowRegister;
        this.entityId = entityId;
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

    public String getEntityId(){
       return this.entityId;
    }

    public String getId() {
        return id;
    }

    public String getDescription(){
       return this.description;
    }

    public void setStatus(UniversityEvents.Status newStatus){
       this.status = status;
    }

    public void setStartDate(LocalDate newDate){
       this.startDate = newDate;
    }
}
