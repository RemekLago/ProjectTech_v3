package v3.projecttech_v3.formularze;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import v3.projecttech_v3.CustomizedExpandableListAdapter;
import v3.projecttech_v3.ExpandableListDataItems;
import v3.projecttech_v3.Photo_Activity;
import v3.projecttech_v3.R;

public class Formularz5_Maszyna_Pracownik_Skarga extends AppCompatActivity {



//    ExpandableListView expandableListView1;
//    ExpandableListView expandableListView2;
//    ExpandableListView expandableListView3;
//    ExpandableListView expandableListView4;
//    ExpandableListAdapter expandableListAdapter1;
//    ExpandableListAdapter expandableListAdapter2;
//    ExpandableListAdapter expandableListAdapter3;
//    ExpandableListAdapter expandableListAdapter4;
//    List<String> expandableTitleList1;
//    List<String> expandableTitleList2;
//    List<String> expandableTitleList3;
//    List<String> expandableTitleList4;
//    HashMap<String, List<String>> expandableDetailList1;
//    HashMap<String, List<String>> expandableDetailList2;
//    HashMap<String, List<String>> expandableDetailList3;
//    HashMap<String, List<String>> expandableDetailList4;
//
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formularz5_maszyna_magazyn_skarga2);

        ImageView image1 = findViewById(R.id.imageView1);
        ImageView image2 = findViewById(R.id.imageView2);
        ImageView image3 = findViewById(R.id.imageView3);


//        TextView textViewMaszyna = findViewById(R.id.textViewMaszyna);
//        TextView textViewOperator = findViewById(R.id.textViewOperator);
//        TextView textViewZmiana = findViewById(R.id.textViewGodzinyZmiana);
//        TextView textViewTelefon = findViewById(R.id.textViewTelefon);
//        TextView textViewKomentarz = findViewById(R.id.textViewKomentarz);
//        Button buttonZdjecie = findViewById(R.id.buttonZdjecie);
//        Button buttonWyslij = findViewById(R.id.buttonWyslij);
//
//        expandableListView1 = (ExpandableListView) findViewById(R.id.expandableListView1);
//        expandableListView2 = (ExpandableListView) findViewById(R.id.expandableListView2);
//        expandableListView3 = (ExpandableListView) findViewById(R.id.expandableListView3);
//        expandableListView4 = (ExpandableListView) findViewById(R.id.expandableListView4);
//
//
//        expandableDetailList1 = ExpandableListDataItems.getData1();
//        expandableDetailList2 = ExpandableListDataItems.getData2();
//        expandableDetailList3 = ExpandableListDataItems.getData3();
//        expandableDetailList4 = ExpandableListDataItems.getData4();
//        expandableTitleList1 = new ArrayList<String>(expandableDetailList1.keySet());
//        expandableTitleList2 = new ArrayList<String>(expandableDetailList2.keySet());
//        expandableTitleList3 = new ArrayList<String>(expandableDetailList3.keySet());
//        expandableTitleList4 = new ArrayList<String>(expandableDetailList4.keySet());
//
//        expandableListAdapter1 = new CustomizedExpandableListAdapter(this, expandableTitleList1, expandableDetailList1);
//        expandableListView1.setAdapter(expandableListAdapter1);
//
//        expandableListAdapter2 = new CustomizedExpandableListAdapter(this, expandableTitleList2, expandableDetailList2);
//        expandableListView2.setAdapter(expandableListAdapter2);
//
//        expandableListAdapter3 = new CustomizedExpandableListAdapter(this, expandableTitleList3, expandableDetailList3);
//        expandableListView3.setAdapter(expandableListAdapter3);
//
//        expandableListAdapter4 = new CustomizedExpandableListAdapter(this, expandableTitleList4, expandableDetailList4);
//        expandableListView4.setAdapter(expandableListAdapter4);
//
//        // This method is called when the group is expanded
//        expandableListView1.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
//            @Override
//            public void onGroupExpand(int groupPosition) {
//                Toast.makeText(getApplicationContext(), expandableTitleList1.get(groupPosition) + " List Expanded.", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        expandableListView2.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
//            @Override
//            public void onGroupExpand(int groupPosition) {
//                Toast.makeText(getApplicationContext(), expandableTitleList2.get(groupPosition) + " List Expanded.", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        expandableListView3.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
//            @Override
//            public void onGroupExpand(int groupPosition) {
//                Toast.makeText(getApplicationContext(), expandableTitleList3.get(groupPosition) + " List Expanded.", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        expandableListView4.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
//            @Override
//            public void onGroupExpand(int groupPosition) {
//                Toast.makeText(getApplicationContext(), expandableTitleList4.get(groupPosition) + " List Expanded.", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//
//
//
//        // This method is called when the group is collapsed
//        expandableListView1.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
//            @Override
//            public void onGroupCollapse(int groupPosition) {
//                Toast.makeText(getApplicationContext(), expandableTitleList1.get(groupPosition) + " List Collapsed.", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        expandableListView2.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
//            @Override
//            public void onGroupCollapse(int groupPosition) {
//                Toast.makeText(getApplicationContext(), expandableTitleList2.get(groupPosition) + " List Collapsed.", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        expandableListView3.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
//            @Override
//            public void onGroupCollapse(int groupPosition) {
//                Toast.makeText(getApplicationContext(), expandableTitleList3.get(groupPosition) + " List Collapsed.", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        expandableListView4.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
//            @Override
//            public void onGroupCollapse(int groupPosition) {
//                Toast.makeText(getApplicationContext(), expandableTitleList4.get(groupPosition) + " List Collapsed.", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        // This method is called when the child in any group is clicked
//        // via a toast method, it is shown to display the selected child item as a sample
//        expandableListView1.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
//            @Override
//            public boolean onChildClick(ExpandableListView parent, View v,
//                                        int groupPosition, int childPosition, long id) {
//
//                textViewMaszyna.setText(expandableDetailList1.get(
//                        expandableTitleList1.get(groupPosition)).get(
//                        childPosition));
//
//                for (int i = 0; i < expandableListAdapter1.getGroupCount(); i++) {
//                        expandableListView1.collapseGroup(i);
//                }
//
//                return false;
//            }
//        });
//
//        expandableListView2.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
//            @Override
//            public boolean onChildClick(ExpandableListView parent, View v,
//                                        int groupPosition, int childPosition, long id) {
//                textViewZmiana.setText(expandableDetailList2.get(
//                        expandableTitleList2.get(groupPosition)).get(
//                        childPosition));
//
//                for (int i = 0; i < expandableListAdapter2.getGroupCount(); i++) {
//                    expandableListView2.collapseGroup(i);
//                }
//
//                return false;
//            }
//        });
//
//        expandableListView3.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
//            @Override
//            public boolean onChildClick(ExpandableListView parent, View v,
//                                        int groupPosition, int childPosition, long id) {
//                textViewOperator.setText(expandableDetailList3.get(
//                        expandableTitleList3.get(groupPosition)).get(
//                        childPosition));
//
//                textViewTelefon.setText("0000000000");
//
//                for (int i = 0; i < expandableListAdapter3.getGroupCount(); i++) {
//                    expandableListView3.collapseGroup(i);
//                }
//
//                return false;
//            }
//        });
//
//        expandableListView4.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
//            @Override
//            public boolean onChildClick(ExpandableListView parent, View v,
//                                        int groupPosition, int childPosition, long id) {
//                textViewKomentarz.setText(expandableDetailList4.get(
//                        expandableTitleList4.get(groupPosition)).get(
//                        childPosition));
//
//                for (int i = 0; i < expandableListAdapter4.getGroupCount(); i++) {
//                    expandableListView4.collapseGroup(i);
//                }
//
//                return false;
//            }
//        });
//
//        buttonZdjecie.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intentZdjecie = new Intent(getApplicationContext(), Photo_Activity.class);
//                startActivity(intentZdjecie);
//            }
//        });
//
//        buttonWyslij.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
    }

}