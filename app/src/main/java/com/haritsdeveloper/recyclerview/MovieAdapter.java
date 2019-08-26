package com.haritsdeveloper.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieHolder> implements Filterable {

    private ArrayList<ModelMovie> listData;
    private ArrayList<ModelMovie> filterdata;

    public MovieAdapter(ArrayList<ModelMovie> dataList) {
        listData = dataList;
        filterdata = dataList;
    }

    @NonNull
    @Override
    public MovieHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.raw_list, viewGroup, false);
        return new MovieHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieHolder movieHolder, int i) {

        movieHolder.binView(filterdata.get(i));

    }

    @Override
    public int getItemCount() {
        return filterdata.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String charString = constraint.toString();
                if (charString.isEmpty()){
                    filterdata = listData;
                }else {
                    ArrayList<ModelMovie> filterList = new ArrayList<>();
                    for (ModelMovie modelMovie: listData){
                        if (modelMovie.getJudul().toLowerCase().contains(charString)| modelMovie.getSubJudul().toLowerCase().contains(charString)){
                            filterdata.add(modelMovie);
                        }
                    }

                    filterdata = filterList;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = filterdata;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                filterdata = (ArrayList<ModelMovie>) results.values;
                notifyDataSetChanged();

            }
        };
    }

    public class MovieHolder extends RecyclerView.ViewHolder {
        private TextView tvJudul, tvSubJudul;
        private ImageView ivCover, ivLogo;

        public MovieHolder(@NonNull View itemView) {
            super(itemView);

            tvJudul = itemView.findViewById(R.id.tvJudul);
            tvSubJudul = itemView.findViewById(R.id.tvSubJudul);

            ivCover = itemView.findViewById(R.id.ivRaw);
            ivLogo = itemView.findViewById(R.id.ivLogo);
        }

        private void binView(ModelMovie data){

            tvJudul.setText(data.getJudul());
            tvSubJudul.setText(data.getSubJudul());
            ivCover.setImageResource(data.getGambar());
            ivLogo.setImageResource(data.getGambar());
            final String idMov = data.getId();

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemView.getContext().startActivity(new Intent(itemView.getContext(), detailActivity.class)
                            .putExtra(detailActivity.KEY_MOVIE, idMov));
                }
            });


        }
    }
}
