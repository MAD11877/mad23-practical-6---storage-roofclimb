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
    String TAG = "RecyclerVieww";
    ArrayList<myObject> myObject_list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        for(int i =0;i<21;i++){
            String name="Name"+getRandomNumber();
            String description="Description "+getRandomNumber();

            List<Boolean> listSource = new ArrayList<>();

            listSource.add(true);
            listSource.add(false);

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Profile");
            builder.setMessage(name);
            builder.setPositiveButton("Close", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Log.v(TAG,"User declines!");
                }
            });
            builder.setNegativeButton("View", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    int index=choose1or2();
                    boolean followed=listSource.get(index);
                    Log.v(TAG,"Index? "+index);

                    Log.v(TAG,"Followed? "+followed);
                    String username=name;
                    String desc=description;
                    Intent myIntent = new Intent(MainActivity.this, MainActivity2.class);
                    myIntent.putExtra("username",username);
                    myIntent.putExtra("description",desc);
                    myIntent.putExtra("followed",followed);
                    startActivity(myIntent);
                    Log.v(TAG,"User views!");
                }
            });
            builder.setCancelable(true);


            myObject obj = new myObject();
            obj.setName(name);
            obj.setDescription(description);
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