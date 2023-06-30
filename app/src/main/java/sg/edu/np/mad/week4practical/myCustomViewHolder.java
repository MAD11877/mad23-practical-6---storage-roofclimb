package sg.edu.np.mad.week4practical;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class myCustomViewHolder extends RecyclerView.ViewHolder {
    TextView txt;
    ImageView img;
    public myCustomViewHolder(View itemView){
        super(itemView);
        if(itemView.findViewById(R.id.textView6)==null)
        {
            txt=itemView.findViewById(R.id.textView);
            img=itemView.findViewById(R.id.imageView2);
        }
        else{
            txt=itemView.findViewById(R.id.textView6);
            img=itemView.findViewById(R.id.imageView8);
        }

    }
}
