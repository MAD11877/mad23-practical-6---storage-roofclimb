package sg.edu.np.mad.week4practical;
import androidx.appcompat.app.AlertDialog;
public class myObject {

    private User user;

    private AlertDialog.Builder builder;
    public myObject() {
    }

    public myObject(User user, AlertDialog.Builder builder) {
        this.user = user;
        this.builder = builder;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public AlertDialog.Builder getBuilder() {
        return builder;
    }

    public void setBuilder(AlertDialog.Builder builder) {
        this.builder = builder;
    }
}