package kz.adamant.hrmanagement.models.tableview;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;

import com.evrencoskun.tableview.ITableView;
import com.evrencoskun.tableview.adapter.recyclerview.holder.AbstractViewHolder;
import com.evrencoskun.tableview.listener.ITableViewListener;

import kz.adamant.hrmanagement.models.tableview.holder.CellViewHolder;
import kz.adamant.hrmanagement.models.tableview.holder.ColumnHeaderViewHolder;
import kz.adamant.hrmanagement.models.tableview.popup.ColumnHeaderLongPressPopup;


public class TableViewListener implements ITableViewListener {
    private static final String LOG_TAG = TableViewListener.class.getSimpleName();

    private ITableView mTableView;

    public TableViewListener(ITableView pTableView) {
        this.mTableView = pTableView;
        Log.d(LOG_TAG, "TableViewListener: CREATED");
    }

    @Override
    public void onCellClicked(@NonNull RecyclerView.ViewHolder cellView, int column, int row) {
        Log.d("TAG", "onCellClicked: ");
        ((CellViewHolder) cellView).setSelected(AbstractViewHolder.SelectionState.SELECTED);
    }

    @Override
    public void onCellDoubleClicked(@NonNull RecyclerView.ViewHolder cellView, int column, int row) {

    }

    @Override
    public void onCellLongPressed(@NonNull RecyclerView.ViewHolder cellView, int column, int row) {

    }

    @Override
    public void onColumnHeaderClicked(@NonNull RecyclerView.ViewHolder columnHeaderView, int column) {

    }

    @Override
    public void onColumnHeaderDoubleClicked(@NonNull RecyclerView.ViewHolder columnHeaderView, int column) {

    }

    @Override
    public void onColumnHeaderLongPressed(@NonNull RecyclerView.ViewHolder columnHeaderView, int column) {
        if (columnHeaderView instanceof ColumnHeaderViewHolder) {
            Log.d(LOG_TAG, "onColumnHeaderLongPressed: " + "IM HEREREREREREREREREREREREERERERERER");
            // Create Long Press Popup
            ColumnHeaderLongPressPopup popup = new ColumnHeaderLongPressPopup(
                    (ColumnHeaderViewHolder) columnHeaderView, mTableView);

            // Show
            popup.show();
        }
    }

    @Override
    public void onRowHeaderClicked(@NonNull RecyclerView.ViewHolder rowHeaderView, int row) {

    }

    @Override
    public void onRowHeaderDoubleClicked(@NonNull RecyclerView.ViewHolder rowHeaderView, int row) {

    }

    @Override
    public void onRowHeaderLongPressed(@NonNull RecyclerView.ViewHolder rowHeaderView, int row) {

    }
}