package sg.edu.np.mad.week4practical;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AlertDialog;
import android.content.DialogInterface;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class myCustomAdapter  extends RecyclerView.Adapter<myCustomViewHolder> {
    private ArrayList<myObject> list_objects;


    public myCustomAdapter(ArrayList<myObject> list_objects){
        this.list_objects=list_objects;
    }

    public myCustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.customlayout,parent,false);
        myCustomViewHolder holder=new myCustomViewHolder(view);
        return holder;
    }

    public void onBindViewHolder(myCustomViewHolder holder, int position){
        String TAG="View Holder";
        myObject list_items=list_objects.get(position);
        holder.txt.setText(list_items.getName()+"\n"+list_items.getDescription());

        holder.img.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Log.v("Adapter","Image pressed");
                Log.v("Adapter","Name: "+list_items.getName());
                String last=list_items.getName().substring(list_items.getName().length() - 1);
                Log.v("Adapter","Last character: "+last);
                if(last.equals("7"))
                {

                    Log.v("Adapter","7");
                }
                else
                {
                    AlertDialog alert=list_items.getBuilder().create();
                    alert.show();
                }
            }
        });
    }

    public int getItemCount(){
        return list_objects.size();
    }

}
