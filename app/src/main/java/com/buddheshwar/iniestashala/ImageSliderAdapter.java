package com.buddheshwar.iniestashala;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.smarteist.autoimageslider.SliderViewAdapter;

import java.util.List;

public class ImageSliderAdapter extends SliderViewAdapter<SliderViewHolder> {


    Context context;
    List<ImageSliderModel> imageSliderModelList;

    public ImageSliderAdapter(Context context, List<ImageSliderModel> imageSliderModelList) {
        this.context = context;
        this.imageSliderModelList = imageSliderModelList;
    }

    @Override
    public SliderViewHolder onCreateViewHolder(ViewGroup parent) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.slider_item_layout,parent,false);
        return new SliderViewHolder(v);
    }

    @Override
    public void onBindViewHolder(SliderViewHolder viewHolder, int position) {

        viewHolder.sliderimageview.setImageResource(imageSliderModelList.get(position).getImage());


    }

    @Override
    public int getCount() {
        return imageSliderModelList.size();
    }
}
class SliderViewHolder extends SliderViewAdapter.ViewHolder{
    ImageView sliderimageview;

    public SliderViewHolder(View itemview){
        super(itemview);
        sliderimageview=itemview.findViewById(R.id.iv);
    }

}