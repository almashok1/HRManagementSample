package kz.adamant.hrmanagement.view.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.evrencoskun.tableview.adapter.AbstractTableAdapter;
import com.evrencoskun.tableview.adapter.recyclerview.holder.AbstractSorterViewHolder;
import com.evrencoskun.tableview.adapter.recyclerview.holder.AbstractViewHolder;

import java.util.List;

import kz.adamant.hrmanagement.R;
import kz.adamant.hrmanagement.models.HRData;
import kz.adamant.hrmanagement.models.tableview.Cell;
import kz.adamant.hrmanagement.models.tableview.ColumnHeader;
import kz.adamant.hrmanagement.models.tableview.RowHeader;
import kz.adamant.hrmanagement.models.tableview.holder.CellViewHolder;
import kz.adamant.hrmanagement.models.tableview.holder.ColumnHeaderViewHolder;
import kz.adamant.hrmanagement.models.tableview.holder.RowHeaderViewHolder;
import kz.adamant.hrmanagement.viewmodel.TableViewModel;

public class TableViewAdapter extends AbstractTableAdapter<ColumnHeader, RowHeader, Cell> {

    private TableViewModel tableViewModel;

    public TableViewAdapter() {
        this.tableViewModel = new TableViewModel();
    }


    @Override
    public AbstractViewHolder onCreateCellViewHolder(ViewGroup parent, int viewType) {
        View layout;
        layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.table_view_cell_layout,
                parent, false);
        // Create a Cell ViewHolder
        return new CellViewHolder(layout);
    }

    @Override
    public void onBindCellViewHolder(@NonNull AbstractViewHolder holder, @Nullable Cell cellItemModel, int columnPosition, int rowPosition) {
        ((CellViewHolder) holder).setCellModel(cellItemModel);
    }

    @Override
    public AbstractSorterViewHolder onCreateColumnHeaderViewHolder(ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout
                .table_view_column_header, parent, false);

        return new ColumnHeaderViewHolder(layout, getTableView());
    }

    @Override
    public void onBindColumnHeaderViewHolder(@NonNull AbstractViewHolder holder, @Nullable ColumnHeader columnHeaderItemModel, int columnPosition) {
        // Get the holder to update cell item text
        ColumnHeaderViewHolder columnHeaderViewHolder = (ColumnHeaderViewHolder) holder;
        columnHeaderViewHolder.setColumnHeaderModel(columnHeaderItemModel);
    }

    @Override
    public AbstractViewHolder onCreateRowHeaderViewHolder(ViewGroup parent, int viewType) {

        // Get Row Header xml Layout
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.table_view_row_header_layout,
                parent, false);

        // Create a Row Header ViewHolder
        return new RowHeaderViewHolder(layout);
    }

    @Override
    public void onBindRowHeaderViewHolder(@NonNull AbstractViewHolder holder, @Nullable RowHeader rowHeaderItemModel, int rowPosition) {
        RowHeaderViewHolder rowHeaderViewHolder = (RowHeaderViewHolder) holder;
        rowHeaderViewHolder.row_header_textview.setText(rowHeaderItemModel.getData());

    }

    @Override
    public View onCreateCornerView(ViewGroup parent) {
        return LayoutInflater.from(parent.getContext()).inflate(R.layout.table_view_corner_layout, null, false);
    }

    @Override
    public int getColumnHeaderItemViewType(int position) {
        return 0;
    }

    @Override
    public int getRowHeaderItemViewType(int position) {
        return 0;
    }

    @Override
    public int getCellItemViewType(int position) {
        return 0;
    }

    public void setHRDataList(List<HRData> userList) {
        // Generate the lists that are used to TableViewAdapter
        tableViewModel.generateListForTableView(userList);

        // Now we got what we need to show on TableView.
        setAllItems(tableViewModel.getColumHeaderModeList(), tableViewModel
                .getRowHeaderModelList(), tableViewModel.getCellModelList());
    }

}