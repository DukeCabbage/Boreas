package com.cabbage.boreas;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cabbage.boreas.model.BoreasDataPoint;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WeatherRecyclerViewAdapter extends RecyclerView.Adapter<WeatherRecyclerViewAdapter.ViewHolder> {

    private final String CELECIUS = "\u2103";
    private final String FAHRENHEIT = "\u2109";

    private List<BoreasDataPoint> mItems;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_weather, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        BoreasDataPoint item = mItems.get(position);

        SimpleDateFormat format = new SimpleDateFormat("k:mm a (EEE)", Locale.getDefault());
        String timeStr = format.format(item.getDate());
        holder.tvTime.setText(timeStr);

        DecimalFormat format1 = new DecimalFormat("0.0" + CELECIUS);
        holder.tvTemperature.setText(format1.format(item.temperature));

        NumberFormat format2 = NumberFormat.getPercentInstance();
        holder.tvRainChance.setText(format2.format(item.rainChance));

        DecimalFormat format3 = new DecimalFormat("0.0" + "mm/hr");
        holder.tvRainPrecip.setText(format3.format(item.precipitation));
        holder.tvSnowPrecip.setText(format3.format(item.snowPrecipitation));

        DecimalFormat format4 = new DecimalFormat("0.0" + "cm");
        holder.tvSnowPrecipAccumulated
                .setText(format4.format(item.accumulatedSnowPrecipitation));
    }

    @Override
    public int getItemCount() {
        return mItems == null ? 0 : mItems.size();
    }

    public void setItems(List<BoreasDataPoint> items) {
        if (mItems == null) mItems = new ArrayList<>();
        mItems = items;
        notifyDataSetChanged();
    }

    public void addItem(BoreasDataPoint item) {
        if (mItems == null) mItems = new ArrayList<>();
        mItems.add(item);
        notifyItemChanged(getItemCount() - 1);
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_time) TextView tvTime;
        @BindView(R.id.tv_temperature) TextView tvTemperature;
        @BindView(R.id.tv_rain_chance) TextView tvRainChance;
        @BindView(R.id.tv_rain_precip) TextView tvRainPrecip;
        @BindView(R.id.tv_snow_precip) TextView tvSnowPrecip;
        @BindView(R.id.tv_snow_precip_accumulated) TextView tvSnowPrecipAccumulated;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
