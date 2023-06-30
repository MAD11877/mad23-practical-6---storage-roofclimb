package sg.edu.np.mad.week6prac;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    DBHandler dbHandler=new DBHandler(this,null,null,1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for(int i =1;i<21;i++) {
            String name = "Name" + getRandomNumber();
            String description = "Description " + getRandomNumber();

            List<Boolean> listSource = new ArrayList<>();

            listSource.add(true);
            listSource.add(false);
            int index=choose1or2();
            User user=new User(name,description,i,listSource.get(index));
            dbHandler.addUser(user);
        }

        List<User> users=dbHandler.getUsers();
    }
    private int getRandomNumber(){
        Random ran=new Random();
        int myRandomValue = ran.nextInt(999999);
        return myRandomValue;
    }


    private int choose1or2(){
        Random ran=new Random();
        int myRandomValue = ran.nextInt(2);
        return myRandomValue;
    }
}