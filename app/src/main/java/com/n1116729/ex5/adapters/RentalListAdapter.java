package com.n1116729.ex5.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.n1116729.ex5.R;
import com.n1116729.ex5.RentalRecord;

import java.text.MessageFormat;
import java.util.List;

public class RentalListAdapter extends BaseAdapter {
    private final Context context;
    private final List<RentalRecord> rentalRecords;

    public RentalListAdapter(Context context, List<RentalRecord> rentalRecords) {
        this.context = context;
        this.rentalRecords = rentalRecords;
    }

    @Override
    public int getCount() {
        return rentalRecords.size();
    }

    @Override
    public Object getItem(int position) {
        return rentalRecords.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item_rental, parent, false);

            viewHolder = new ViewHolder();
            viewHolder.rentalCountTextView = convertView.findViewById(R.id.rentalCountTextView);
            viewHolder.rentalPriceTextView = convertView.findViewById(R.id.rentalPriceTextView);
            viewHolder.vehicleTypeTextView = convertView.findViewById(R.id.vehicleTypeTextView);
            viewHolder.attendanceRatesTextView = convertView.findViewById(R.id.attendanceRatesTextView);
            viewHolder.totalEarningsTextView = convertView.findViewById(R.id.totalEarningsTextView);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        RentalRecord rentalRecord = rentalRecords.get(position);

        viewHolder.rentalCountTextView.setText(MessageFormat.format("第{0}次模擬的次數(序號): {1}", rentalRecord.getRentalCount(), rentalRecord.getRentalCount()));
        viewHolder.rentalPriceTextView.setText(MessageFormat.format("產生的租金是多少: {0}", rentalRecord.getRentalPrice()));
        viewHolder.vehicleTypeTextView.setText(MessageFormat.format("租到的交通工具是什麼: {0}", rentalRecord.getVehicleType()));
        viewHolder.attendanceRatesTextView.setText(MessageFormat.format("到當前為止交通工具出勸率: {0}", rentalRecord.getAttendanceRates()));
        viewHolder.totalEarningsTextView.setText(MessageFormat.format("累計的租金金額是多少: {0}", rentalRecord.getTotalEarnings()));

        return convertView;
    }

    private static class ViewHolder {
        TextView rentalCountTextView;
        TextView rentalPriceTextView;
        TextView vehicleTypeTextView;
        TextView attendanceRatesTextView;
        TextView totalEarningsTextView;
    }
}
