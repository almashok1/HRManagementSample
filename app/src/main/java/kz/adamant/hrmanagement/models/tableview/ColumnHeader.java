package kz.adamant.hrmanagement.models.tableview;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.evrencoskun.tableview.sort.ISortableModel;

import kz.adamant.hrmanagement.models.HRData;

public class ColumnHeader implements ISortableModel {
    private String mData;

    public ColumnHeader(String mData) {
        this.mData = mData;
    }

    public String getData() {
        return mData;
    }

    @NonNull
    @Override
    public String getId() {
        return mData;
    }

    @Nullable
    @Override
    public Object getContent() {
        return mData;
    }
}