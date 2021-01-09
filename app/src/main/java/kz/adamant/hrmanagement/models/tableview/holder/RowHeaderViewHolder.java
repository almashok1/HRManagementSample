package kz.adamant.hrmanagement.models.tableview.holder;

import androidx.core.content.ContextCompat;
import android.view.View;
import android.widget.TextView;

import com.evrencoskun.tableview.adapter.recyclerview.holder.AbstractViewHolder;

import kz.adamant.hrmanagement.R;


public class RowHeaderViewHolder extends AbstractViewHolder {
    public final TextView row_header_textview;

    public RowHeaderViewHolder(View itemView) {
        super(itemView);
        row_header_textview = itemView.findViewById(R.id.row_header_textview);
    }

    @Override
    public void setSelected(SelectionState selectionState) {
        super.setSelected(selectionState);

        int nBackgroundColorId;
        int nForegroundColorId;

        if (selectionState == SelectionState.SELECTED) {
            nBackgroundColorId = R.color.selected_background_color;
            nForegroundColorId = R.color.selected_text_color;

        } else if (selectionState == SelectionState.UNSELECTED) {
            nBackgroundColorId = R.color.unselected_header_background_color;
            nForegroundColorId = R.color.unselected_text_color;

        } else { // SelectionState.SHADOWED

            nBackgroundColorId = R.color.shadow_background_color;
            nForegroundColorId = R.color.unselected_text_color;
        }

        itemView.setBackgroundColor(ContextCompat.getColor(itemView.getContext(),
                nBackgroundColorId));
        row_header_textview.setTextColor(ContextCompat.getColor(row_header_textview.getContext(),
                nForegroundColorId));
    }
}