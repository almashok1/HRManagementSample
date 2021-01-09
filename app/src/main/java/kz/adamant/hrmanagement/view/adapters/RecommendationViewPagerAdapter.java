package kz.adamant.hrmanagement.view.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.card.MaterialCardView;
import com.tbuonomo.creativeviewpager.adapter.CreativePagerAdapter;

import java.util.List;

import kz.adamant.hrmanagement.R;
import kz.adamant.hrmanagement.models.HRData;
import kz.adamant.hrmanagement.models.MaterialColorPalette;
import kz.adamant.hrmanagement.models.Position;

public class RecommendationViewPagerAdapter implements CreativePagerAdapter {
    private Context context;
    private List<HRData> recommendedEmps;
    private List<Position> recommendedPos;

    public RecommendationViewPagerAdapter(Context context, List<HRData> recommendedEmps, List<Position> recommendedPos){
        this.context = context;
        this.recommendedEmps = recommendedEmps;
        this.recommendedPos = recommendedPos;
    }

    @Override
    public int getCount() {

        if (recommendedEmps == null) {
            Log.d("TAG", "getCount: " + recommendedPos.size());
            return recommendedPos.size();
        }
        else return recommendedEmps.size();
    }

    @Override
    public View instantiateContentItem(LayoutInflater inflater, ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.viewpager_content_layout, viewGroup, false);
        TextView initials = view.findViewById(R.id.tv_initials);;
        if (recommendedEmps != null) {
            String[] initialsArr = recommendedEmps.get(i).getEmployee_Name().split(", ");
            if (initialsArr.length > 1)
                initials.setText(initialsArr[0].charAt(0) + "" + initialsArr[1].charAt(0));
            else if (initialsArr.length == 1)
                initials.setText(initialsArr[0].charAt(0) + "");
            else
                initials.setText("-");
        }
        else {
            String[] posSplit = recommendedPos.get(i).getPosition().split(" ");
            String initial = "";
            for (String pos : posSplit) {
                initial+=pos.charAt(0);
            }
            initials.setText(initial);
        }
        int randomColor = MaterialColorPalette.getRandomColor("A200");
        MaterialCardView initialsCircle = view.findViewById(R.id.initials_circle);
        initialsCircle.setCardBackgroundColor(randomColor);
        return view;
    }

    @Override
    public View instantiateHeaderItem(LayoutInflater inflater, ViewGroup viewGroup, int i) {
        View view;
        if (recommendedEmps != null) {
            view = inflater.inflate(R.layout.viewpager_header_layout_of_emps, viewGroup, false);
            TextView fullname = view.findViewById(R.id.fullname);
            TextView position = view.findViewById(R.id.PositionName);
            TextView department = view.findViewById(R.id.DepartmentName);
            TextView salary = view.findViewById(R.id.Salary);
            TextView index = view.findViewById(R.id.index_rec);

            HRData data = recommendedEmps.get(i);
            fullname.setText(data.getEmployee_Name().replace(",", ""));
            position.setText(data.getPosition());
            department.setText(data.getDepartment());
            salary.setText("$"+data.getSalary());
            index.setText((i+1)+"");
        } else {
            view = inflater.inflate(R.layout.viewpager_header_layout_of_pos, viewGroup, false);
            TextView position = view.findViewById(R.id.position);
            TextView avgSalary = view.findViewById(R.id.avg_salary);
            TextView index = view.findViewById(R.id.index_rec);
            position.setText(recommendedPos.get(i).getPosition());
            index.setText((i+1)+"");
            avgSalary.setText("$"+((int)recommendedPos.get(i).getAverageSalary()));
        }
        return view;
    }

    @Override
    public boolean isUpdatingBackgroundColor() {
        return false;
    }

    @Override
    public Bitmap requestBitmapAtPosition(int i) {
        return null;
    }
}
