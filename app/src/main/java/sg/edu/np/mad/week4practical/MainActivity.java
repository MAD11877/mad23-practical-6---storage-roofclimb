package sg.edu.np.mad.week4practical;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.content.DialogInterface;
import java.util.ArrayList;

import java.util.List;
import java.util.Random;


public class MainActivity extends AppCompatActivity {
    String TAG = "RecyclerView";
    ArrayList<myObject> myObject_list = new ArrayList<>();
    DBHandler dbHandler=new DBHandler(this,null,null,1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        List<User> users=dbHandler.getUsers();

        if(users==null)
        {
            for(int i =0;i<21;i++) {
                String name = "Name " + getRandomNumber();
                String description = "Description " + getRandomNumber();

                List<Boolean> listSource = new ArrayList<>();

                listSource.add(true);
                listSource.add(false);

                int index = choose1or2();

                User user = new User(name, description, i, listSource.get(index));
                dbHandler.addUser(user);
                Log.v("Main","user1"+ user.getName());
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Profile");
                builder.setMessage(user.getName());
                builder.setPositiveButton("Close", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.v(TAG,"User declines!");
                    }
                });
                builder.setNegativeButton("View", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent myIntent = new Intent(MainActivity.this, MainActivity2.class);
                        myIntent.putExtra("username",user.getName());
                        myIntent.putExtra("description",user.getDescription());
                        myIntent.putExtra("followed",user.isFollowed());
                        startActivity(myIntent);
                        Log.v(TAG,"User views!");
                    }
                });
                builder.setCancelable(true);


                myObject obj = new myObject();
                obj.setUser(user);
                obj.setBuilder(builder);
                myObject_list.add(obj);
            }
            RecyclerView recyclerView=findViewById(R.id.recyclerview);
            myCustomAdapter myCustomAdapter = new myCustomAdapter(myObject_list);
            LinearLayoutManager myLayoutManager=new LinearLayoutManager(this);
            recyclerView.setLayoutManager(myLayoutManager);
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.setAdapter(myCustomAdapter);
        }
        else
        {
            for(int i =0;i<users.size();i++){
                Log.v("Main","Username: "+users.get(i).getName());
                User user=users.get(i);
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Profile");
                builder.setMessage(user.getName());
                builder.setPositiveButton("Close", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.v(TAG,"User declines!");
                    }
                });
                builder.setNegativeButton("View", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent myIntent = new Intent(MainActivity.this, MainActivity2.class);
                        myIntent.putExtra("username",user.getName());
                        myIntent.putExtra("description",user.getDescription());
                        myIntent.putExtra("followed",user.isFollowed());
                        startActivity(myIntent);
                        Log.v(TAG,"User views!");
                    }
                });
                builder.setCancelable(true);



                myObject obj = new myObject(user,builder);
                myObject_list.add(obj);
            }
            Log.v("Main","List: "+myObject_list.get(0).getUser().getName());
            RecyclerView recyclerView=findViewById(R.id.recyclerview);
            myCustomAdapter myCustomAdapter = new myCustomAdapter(myObject_list);
            LinearLayoutManager myLayoutManager=new LinearLayoutManager(this);
            recyclerView.setLayoutManager(myLayoutManager);
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.setAdapter(myCustomAdapter);
        }


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