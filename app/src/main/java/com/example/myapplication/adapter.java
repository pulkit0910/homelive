package com.example.myapplication;


import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.zip.Inflater;

public class adapter extends RecyclerView.Adapter<adapter.imageviewholder> {


    public ArrayList<gitdescription> arrayList;
    public Context context;
    public adapter(ArrayList<gitdescription> arrayList, Context context){
        this.arrayList = arrayList;
        this.context = context;
    }
    @NonNull
    @Override
    public imageviewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.layout_list,viewGroup,false);
        return new imageviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final imageviewholder imageviewholder, final int i) {

        imageviewholder.tv1.setText(arrayList.get(i).getFullname());
        imageviewholder.tv2.setText(arrayList.get(i).getHtmlurl());
        imageviewholder.tv3.setText(arrayList.get(i).getDescrition());
        imageviewholder.tv4.setText(arrayList.get(i).getLanguage());
        imageviewholder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), details.class);
                intent.putExtra("htmlurl",arrayList.get(i).getHtmlurl());
                intent.putExtra("fullname",arrayList.get(i).getFullname());
                context.startActivity(intent);

            }
        });



    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class imageviewholder extends RecyclerView.ViewHolder

    {
        TextView tv1;
        TextView tv2;
        TextView tv3;
        TextView tv4;
        public imageviewholder(View itemview){

            super(itemview);
            tv1 = itemview.findViewById(R.id.tv1);
            tv2 = itemview.findViewById(R.id.tv2);
            tv3 = itemview.findViewById(R.id.tv3);
            tv4 = itemview.findViewById(R.id.tv4);
        }
    }
}
