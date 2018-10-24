package com.hpmcor.legal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.hpmcor.legal.R;

public class telphonecontent extends AppCompatActivity {

    TextView tx;
    public int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telphonecontent);

        tx = (TextView) findViewById(R.id.text);

        this.id = this.getIntent().getIntExtra("id", 0);

        switch (this.id) {
            case 0: {
                tx.setText("  غرفة محكمة جنوب القاهرة  5103104 -5106629   : \n" +
                        "محكمة باب الخلق  5121816 \n" +
                        "محكمة شمال القاهرة ( العباسية ) 4020026 ـ 4020036 \n" +
                        "غرفة مجمع الجلاء 5785308 ـ 5769368 \n" +
                        "محكمة عابدين 3919265 \n" +
                        "محكمة مصر الجديدة 6373617 ـ 6370508 \n" +
                        "محكمة مصر القديمة 3626002 \n" +
                        "المحكمة العسكرية 617149 \n" +
                        "محكمة حلوان 5562573 \n" +
                        "محكمة زنانيرى شبرا 5743014 \n" +
                        "محكمة المعاد 5180474 \n" +
                        "مجلس الدولة 4962253 \n" +
                        "مدينة نصر 2607333 \n");
                break;
            }
            case 1: {
                tx.setText("مجمع محاكم الجيزه ( الدور الثالث ) 5706880 \n" +
                        "الجيزه الكلية 5706881 \n" +
                        "مجمع محاكم الجيزة ( الدور الثانى ) 5688816 \n" +
                        "مجمع محاكم الجيزة ( الدور الأرضى ) 5706881 \n" +
                        "محكمة بولاق ( المهندسين ـ كيت كات ) 3028874 \n" +
                        "محكمة الدقى 3474569 \n" +
                        "محكمة بندر الجيزة ( شارع السودان ) 3140059 \n" +
                        "محكمة بندر إمبابه 3142540 \n" +
                        "محكمة البدرشين 225741/018 \n" +
                        "محكمة الصف 620512/018 \n" +
                        "محكمة العياط 601109/018 \n" +
                        "محكمة أسيم 406480/018 \n" +
                        "النادى النهرى 3058780 \n");
                break;
            }

            case 2: {
                tx.setText("مقرها شارع بطل السلام ( 084 )  \n" +
                        "مقر النقابة بالفيوم 6311740 \n" +
                        "نادى الفيوم 6306691 \n" +
                        "غرفة محكمة الفيوم 6307714 \n" +
                        "غرفة المحامين الكبرى بالمحكمة 6301740 \n" +
                        "محكمة أبشواى 6710627 \n" +
                        "محكمة سنورس 6900344 \n" +
                        "محكمة إطسا 6410519 \n" +
                        "محكمة طامية 6611101 \n" +
                        "\n");

                break;
            }
            case 3: {
                tx.setText("مقرها شارع الجمهورية برج البترول ( 088 ) \n" +
                        "غرفة المجمع 2325147 \n" +
                        "غرفة المحكمة الإدارية 2325147 \n" +
                        "محكمة ديروط 4770702 \n" +
                        "محكمة القوصية 4750561 \n" +
                        "محكمة منفلوط 4700727 \n" +
                        "محكمة أبو تيج 2480750 \n" +
                        "محكمة أبنوب500340 \n" +
                        "محكمة البدارى 600570 \n" +
                        "محكمة صدفا 670412 \n" +
                        "محكمة الوادى الجديد 925201/092 \n" +
                        "محكمة ساحل سليم 2630215 \n");

                break;
            }
            case 4: {
                tx.setText("مقرها مبنى مجمع المحاكم بقنا ( 096 ) \n" +
                        "5324618  \n" +
                        "محكمة قوص 410751 \n" +
                        "محكمة دشنا 6510419 \n" +
                        "محكمة أرمنت 5420581 \n" +
                        "محكمة فقط 5401639 \n" +
                        "محكمة نقادة 6600303 \n" +
                        "محكمة نجع حمادى 6580458 \n" +
                        "محكمة أبو تشت 6710201 \n" +
                        "محكمة الأقصر 5372075 \n" +
                        "محكمة أسنا 5400820 \n" +
                        "محكمة فرشوط 6500856 \n" +
                        "نادى فرشوط 6502808 \n");
                break;
            }case 5: {
                tx.setText("مقرها مبنى محكمة أسوان ( 097 ) \n" +
                        "2302218 ـ 2303831  \n" +
                        "غرفة مكتب الخبراء بمدينة إدفو 4710531 \n" +
                        "محكمة إدفو 4710393 \n" +
                        "محكمة كوم أمبو 3500732 \n" +
                        "مكتب خبراء أسوان 2322208 \n");

                break;
            }
            case 6: {
                tx.setText("محكمة الإستئناف 2312225 \n" +
                        "المحكمة الإبتدائية الجديدة 2312745 \n" +
                        "المحكمة الكلية القديمة 2312255 \n" +
                        "محكمة قسم أول المنصورة 2245240 \n" +
                        "مجمع المحاكم 2218206 \n" +
                        "مجلس الدولة 2264043 \n" +
                        "محكمة طلخا 2524401 \n" +
                        "محكمة بلقاس 2794889 \n" +
                        "محكمة السنبلاوين 6690273 \n" +
                        "محكمة ميت غمر 6903671 \n" +
                        "محكمة مركز ميت غمر 6905694 \n" +
                        "محكمة أجا 6455605 \n" +
                        "محكمة شربين 7920226 \n" +
                        "نادى ميت غمر 6905698 \n" +
                        "محكمة المنزلة 7700129 \n" +
                        "محكمة دكرنس 7474185 \n" +
                        "محكمة مدينة النصر 940894 \n" +
                        "محكمة المطرية 750437 \n" +
                        "محكمة جمصة 760603 \n");

                break;
            }

        }
    }
}