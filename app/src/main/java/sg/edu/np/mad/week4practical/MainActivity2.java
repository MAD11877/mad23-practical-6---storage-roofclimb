package sg.edu.np.mad.week4practical;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    String TAG = "Mobile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.v(TAG, "on start!!");
        Intent myRecvIntent = getIntent();
        String recvUsername;
        String recvUserDesc;
        boolean followed;
        recvUsername = myRecvIntent.getStringExtra("username");
        recvUserDesc = myRecvIntent.getStringExtra("description");
        followed = myRecvIntent.getBooleanExtra("followed",true);

        Log.v(TAG, "username" + recvUsername);
        Log.v(TAG, "description" + recvUserDesc);

        TextView username = findViewById(R.id.username);
        username.setText(recvUsername);
        TextView description = findViewById(R.id.description);
        description.setText(recvUserDesc);


        Button buttonA = findViewById(R.id.button6);
        if(followed)
        {
            buttonA.setText("UnFollow");

        }else{
            buttonA.setText("Follow");
        }
        buttonA.setOnClickListener(new View.OnClickListener() {
            boolean followed;
            @Override
            public void onClick(View v) {

                Log.v(TAG,"Button A clicked");
                if(followed)
                {
                    buttonA.setText("UnFollow");
                    Toast.makeText(getApplicationContext(),"Followed",Toast.LENGTH_SHORT).show();
                    followed=false;
                }else{
                    buttonA.setText("Follow");
                    Toast.makeText(getApplicationContext(),"Unfollowed",Toast.LENGTH_SHORT).show();
                    followed=true;
                }
            }

        });
    }
}