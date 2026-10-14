package TestRail;

public class TestRequestDTO {
    private int status_id;

    public TestRequestDTO(int status_id) {
        this.status_id = status_id;
    }

    public int getStatus_id() {
        return status_id;
    }

    public void setStatus_id(int status_id) {
        this.status_id = status_id;
    }
}
