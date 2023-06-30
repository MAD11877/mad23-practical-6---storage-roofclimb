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

    @Override
    public int getItemViewType(int position) {

        String username = list_objects.get(position).getName();
        String description = list_objects.get(position).getDescription();

        if (username.charAt(username.length() - 1) != '7') {
            return 0;
        }
        return 1;
    }

    @Override
    public myCustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view;
        if (viewType == 0) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.new_layout, viewGroup, false);
            return new myCustomViewHolder(view);
        }
        if (viewType == 1) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.customlayout, viewGroup, false);
            return new myCustomViewHolder(view);
        }
        return null;
    }

    public void onBindViewHolder(myCustomViewHolder holder, int position){
        String TAG="View Holder";
        myObject list_items=list_objects.get(position);
        holder.txt.setText(list_items.getName()+"\n"+list_items.getDescription());

        holder.img.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                AlertDialog alert=list_items.getBuilder().create();
                alert.show();
            }
        });
    }




    public int getItemCount(){
        return list_objects.size();
    }

}
