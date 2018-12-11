package code.payload;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

/**
 * Created by rajeevkumarsingh on 02/08/17.
 */
public class CreateBook {
    @NotBlank
    @NotEmpty
    private String name;

    @NotBlank
    @NotEmpty
    private String author;

    @Positive
    private Integer number;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
