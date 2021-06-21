package models;
import lombok.Data;
import lombok.ToString;


@Data
@ToString
public class Facts {
    private String _id;
    private int _v;
    private String type;
    private String text;
    private String updatedAt;
    private boolean deleted;
    private String source;
    private int SentCount;
}

