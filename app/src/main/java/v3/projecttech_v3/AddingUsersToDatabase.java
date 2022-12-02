package v3.projecttech_v3;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static v3.projecttech_v3.Activity_Login.dataBaseSQLUser;
import static v3.projecttech_v3.Activity_Register.tmpstatusID;

import android.os.Build;

import v3.projecttech_v3.db.entity.Data5;

public class AddingUsersToDatabase {

    static ArrayList<ArrayList<String>> exampleUsers = new ArrayList<>();
    static Data5 tmpData;
    static ArrayList<String> list1;
    static ArrayList<String> list2;
    static ArrayList<String> list3;
    static ArrayList<String> list4;

    public static void addingUser() {

        list1 = new ArrayList<String>();
        list2 = new ArrayList<String>();
        list3 = new ArrayList<String>();
        list4 = new ArrayList<String>();

        list1.add("Ola");
        list1.add("Kwasniewska");
        list1.add("ola@test.pl");
        list1.add("123");
        list1.add("123");
        list1.add("123");
        list1.add("123");
        list1.add("Ola1234@");
        list1.add("Ola1234@");

        list2.add("Kasia");
        list2.add("Kopernik");
        list2.add("kasia@test.pl");
        list2.add("123");
        list2.add("123");
        list2.add("123");
        list2.add("123");
        list2.add("Kasia1234@");
        list2.add("Kasia1234@");

        list3.add("Tomek");
        list3.add("Belka");
        list3.add("tomek@test.pl");
        list3.add("123");
        list3.add("123");
        list3.add("123");
        list3.add("123");
        list3.add("Tomek1234@");
        list3.add("Tomek1234@");

        list4.add("Piotr");
        list4.add("Smiały");
        list4.add("piotr@test.pl");
        list4.add("123");
        list4.add("123");
        list4.add("123");
        list4.add("123");
        list4.add("Piotr1234@");
        list4.add("Piotr1234@");

        exampleUsers.add(list1);
        exampleUsers.add(list2);
        exampleUsers.add(list3);
        exampleUsers.add(list4);

        int j = 0;
        for (int i=0; i < exampleUsers.size(); i++) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    tmpData = new Data5(
                            exampleUsers.get(i).get(j),
                            exampleUsers.get(i).get(j + 1),
                            exampleUsers.get(i).get(j + 2),
                            exampleUsers.get(i).get(j + 3),
                            exampleUsers.get(i).get(j + 4),
                            exampleUsers.get(i).get(j + 5),
                            exampleUsers.get(i).get(j + 6),
                            LocalDateTime.now().toString(),             // addDate
                            "1",                                           // statusID
                            exampleUsers.get(i).get(j + 7),
                            exampleUsers.get(i).get(j + 8)
                    );
                }
                dataBaseSQLUser.insertData(tmpData);

        }
    }
}
