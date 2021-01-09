package kz.adamant.hrmanagement.models.tableview;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.evrencoskun.tableview.sort.ISortableModel;

public class RowHeader implements ISortableModel {
    private String mData;

    public RowHeader(String mData) {
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