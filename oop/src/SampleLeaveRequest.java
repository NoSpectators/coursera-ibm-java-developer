public class SampleLeaveRequest {
    private int requestId;
    private SampleEmployee sampleEmployee;
    private String startDate;
    private String endDate;
    private String status; // "Pending", "Approved", "Denied"
    private String reason;

    // Constructor
    public SampleLeaveRequest(int requestId, SampleEmployee sampleEmployee, String startDate,
                             String endDate, String reason) {
        this.requestId = requestId;
        this.sampleEmployee = sampleEmployee;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = "Pending"; // Default status
        this.reason = reason;
    }
    // Methods will be added here
}
