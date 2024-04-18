import java.io.Serializable;

public class Data implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String message;

    public Data(int id, String message) {
        this.id = id;
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    
    @Override
    public String toString() {
        return "Data{" +
                "id=" + id +
                ", message='" + message + '\'' +
                '}';
    }
}
