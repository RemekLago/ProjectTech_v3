package v3.projecttech_v3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExpandableListDataItems {

    public static HashMap<String, List<String>> getData1() {
        HashMap<String, List<String>> expandableDetailList = new HashMap<String, List<String>>();

        List<String> maszyny = new ArrayList<String>();
        maszyny.add("Maszyna_1");
        maszyny.add("Maszyna_2");
        maszyny.add("Maszyna_3");
        maszyny.add("Maszyna_4");
        maszyny.add("Maszyna_5");

        expandableDetailList.put("Maszyna", maszyny);

        return expandableDetailList;
    }

    public static HashMap<String, List<String>> getData2() {
        HashMap<String, List<String>> expandableDetailList = new HashMap<String, List<String>>();

        List<String> godzinyZmiana = new ArrayList<String>();
        godzinyZmiana.add("08:00 - 14:00");
        godzinyZmiana.add("14:00 - 22:00");
        godzinyZmiana.add("22:00 - 06:00");

        expandableDetailList.put("Zmiana", godzinyZmiana);

        return expandableDetailList;
    }

    public static HashMap<String, List<String>> getData3() {
        HashMap<String, List<String>> expandableDetailList = new HashMap<String, List<String>>();

        List<String> operator = new ArrayList<String>();
        operator.add("Operator_1");
        operator.add("Operator_2");
        operator.add("Operator_3");
        operator.add("Operator_4");
        operator.add("Operator_5");

        expandableDetailList.put("Operator", operator);

        return expandableDetailList;
    }

    public static HashMap<String, List<String>> getData4() {
        HashMap<String, List<String>> expandableDetailList = new HashMap<String, List<String>>();

        List<String> komentarz = new ArrayList<String>();
        komentarz.add("Komentarz_1");
        komentarz.add("Komentarz_2");
        komentarz.add("Komentarz_3");
        komentarz.add("Komentarz_4");
        komentarz.add("Komentarz_5");

        expandableDetailList.put("Komentarz", komentarz);

        return expandableDetailList;
    }
}
