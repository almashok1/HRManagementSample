package kz.adamant.hrmanagement.models.tableview;

import androidx.annotation.Nullable;

import com.evrencoskun.tableview.sort.ISortableModel;


public class Cell implements ISortableModel {
    @Nullable
    private String id;
    @Nullable
    private Object mData;

    public Cell(@Nullable String id, @Nullable Object data) {
        this.id = id;
        this.mData = data;
    }

    @Nullable
    public Object getData() {
        return mData;
    }

    @Nullable
    public String getId() {
        return id;
    }

    @Nullable
    @Override
    public Object getContent() {
        return mData;
    }
}