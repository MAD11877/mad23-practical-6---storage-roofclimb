package sg.edu.np.mad.week4practical;
import androidx.appcompat.app.AlertDialog;
public class myObject {
    private String name;
    private String description;

    private AlertDialog.Builder builder;
    public myObject() {
    }

    public myObject(String name, String description, AlertDialog.Builder builder) {
        this.name = name;
        this.description = description;
        this.builder=builder;
    }

    public AlertDialog.Builder getBuilder() {
        return builder;
    }

    public void setBuilder(AlertDialog.Builder builder) {
        this.builder = builder;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}