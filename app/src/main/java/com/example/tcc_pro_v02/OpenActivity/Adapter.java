package com.example.tcc_pro_v02.OpenActivity;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tcc_pro_v02.R;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {
    private List<String> filesList;
    public Adapter(List<String> lista) {
        this.filesList = lista;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemLista = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adapter_lista, viewGroup, false);
        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        String file = filesList.get(i);
        myViewHolder.fileName.setText(file);
    }

    @Override
    public int getItemCount() {
        return filesList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView fileName;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            fileName = itemView.findViewById(R.id.file_name_list);
        }
    }
}
