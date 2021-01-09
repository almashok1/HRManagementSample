package kz.adamant.hrmanagement.models.tableview.popup;

import android.content.Context;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.widget.PopupMenu;

import com.evrencoskun.tableview.ITableView;
import com.evrencoskun.tableview.sort.SortState;

import kz.adamant.hrmanagement.R;
import kz.adamant.hrmanagement.models.tableview.holder.ColumnHeaderViewHolder;


public class ColumnHeaderLongPressPopup extends PopupMenu implements PopupMenu.OnMenuItemClickListener {
    private static final String LOG_TAG = ColumnHeaderLongPressPopup.class.getSimpleName();
    // Sort states
    private static final int ASCENDING = 1;
    private static final int DESCENDING = 2;
    private static final int CLEAR = 3;
    // Test menu items for showing / hiding row
    private static final int ROW_HIDE = 4;
    private static final int ROW_SHOW = 3;

    //
    private static final int TEST_ROW_INDEX = 4;


    private ColumnHeaderViewHolder columnHeaderViewHolder;
    private ITableView iTableView;
    private Context mContext;
    private int mXPosition;

    public ColumnHeaderLongPressPopup(ColumnHeaderViewHolder columnHeaderViewHolder, ITableView
            iTableView) {
        super(columnHeaderViewHolder.itemView.getContext(), columnHeaderViewHolder.itemView);
        this.columnHeaderViewHolder = columnHeaderViewHolder;
        this.iTableView = iTableView;
        this.mContext = columnHeaderViewHolder.itemView.getContext();
        this.mXPosition = columnHeaderViewHolder.getAdapterPosition();

        // find the view holder
        this.columnHeaderViewHolder = (ColumnHeaderViewHolder) iTableView.getColumnHeaderRecyclerView()
                .findViewHolderForAdapterPosition(mXPosition);

        initialize();
    }

    private void initialize() {
        createMenuItem();
        changeMenuItemVisibility();

        this.setOnMenuItemClickListener(this);
    }

    private void createMenuItem() {
        this.getMenu().add(Menu.NONE, ASCENDING, 0, mContext.getString(R.string.sort_ascending));
        this.getMenu().add(Menu.NONE, DESCENDING, 1, mContext.getString(R.string.sort_descending));
    }

    private void changeMenuItemVisibility() {
        // Determine which one shouldn't be visible
        SortState sortState = iTableView.getSortingStatus(mXPosition);
        if (sortState == SortState.UNSORTED) {
            // Show others
        } else if (sortState == SortState.DESCENDING) {
            // Hide DESCENDING menu item
            getMenu().getItem(1).setVisible(false);
        } else if (sortState == SortState.ASCENDING) {
            // Hide ASCENDING menu item
            getMenu().getItem(0).setVisible(false);
        }
    }


    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        // Note: item id is index of menu item..
        switch (menuItem.getItemId()) {
            case ASCENDING:
                iTableView.sortColumn(mXPosition, SortState.ASCENDING);
                break;
            case DESCENDING:
                iTableView.sortColumn(mXPosition, SortState.DESCENDING);
                break;
        }

        // Recalculate of the width values of the columns
        try {
            iTableView.remeasureColumnWidth(mXPosition);
        } catch (Exception ignored) {

        }
        return true;
    }

}
