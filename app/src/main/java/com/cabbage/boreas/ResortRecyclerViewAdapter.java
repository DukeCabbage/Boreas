package com.cabbage.boreas;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cabbage.boreas.model.CountryEnum;
import com.cabbage.boreas.model.Resort;

import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ResortRecyclerViewAdapter extends RecyclerView.Adapter<ResortRecyclerViewAdapter.ViewHolder> {

    private final List<Resort> mValues;
    private final ItemActionCallback mCallback;

    public ResortRecyclerViewAdapter(List<Resort> items, ItemActionCallback callback) {
        mValues = items;
        mCallback = callback;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_resort, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Resort item = mValues.get(position);
        holder.tvName.setText(item.displayName);
        String strLatLng = String.format(Locale.CANADA, "%f, %f", item.latitude, item.longitude);
        holder.tvLatLng.setText(strLatLng);
        CountryEnum countryEnum = CountryEnum.codeToEnum(item.country);
        holder.tvCountry.setText(countryEnum == null ? "" : countryEnum.getName());
        holder.itemView.setOnClickListener(view -> mCallback.action(item, "short"));
        holder.itemView.setOnLongClickListener(view -> {
            mCallback.action(item, "long");
            return true;
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public interface ItemActionCallback {
        void action(Resort resort, String action);
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_name) TextView tvName;
        @BindView(R.id.tv_latlng) TextView tvLatLng;
        @BindView(R.id.tv_country) TextView tvCountry;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
