package code.payload;

import javax.validation.constraints.NotBlank;

public class RequestRequest {

    private Long Id;

    private Long deadLine;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Long getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(Long deadLine) {
        this.deadLine = deadLine;
    }
}
