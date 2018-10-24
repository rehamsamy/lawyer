package com.hpmcor.legal;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
public class lawes extends AppCompatActivity {
Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lawes);

        bt=(Button) findViewById(R.id.num1);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(lawes.this,contents.class);

                String s="تساهم فيها الدولة وبين المعاش المستحق قبل التعيين فيها.\n" + ")19 )القانون رقم 89 لسنة 1123 بإصدار قانـون التأميـن والمعاشـات لموظفى الدولة ومستخدميها\n" + "وعمالها المدنيين.\n" + ")11 )القانون رقم 33 لسنة 1121 بمنح معاشات للموظفين والمستخدمين الـذين انتهت خدمتهم قبل\n" + "أول أكتوبر سنة 1182 ولم يحصلوا على معاش.\n" + ")16 )القانون رقم 23 لسنة 1121 بإصدار قانون التأمينات االجتماعية.\n" + ")13 )القانون رقم 88 لسنة 1121 فى شأن التأمين الصحى للعاملين فى الحكومة وهيئات االدارة\n" + "المحلية والهيئات العامة والمؤسسات العامة.\n" + ")11 )الئـحة صندوق المعاشات للمستخدمين الداخلين فـى هـيئة العمال ببلدية االسكندرية الصادرة\n" + "سنة 1139.\n" + ")18 )قرار رئيس الجمهورية رقم 158 لسنة 1125 بشأن قواعد الجمع بين المرتب أو المكافأة أو\n" + "المعاش.\n" + ")12 )قرار مجلس الوزراء الصادر فى 65/1/1165 بشأن معاشات أمراء دارفور.\n" + ")18 )الئحة المرتبات للعمال المصريين الذين كانوا بالسلطة العسكرية.\n" + ")15 )قرار وزير بورسعيد رقم 21 لسنة 1188 بشأن مدينة بورسعيد.\n" + ")المادة الثالثة(\n" + "تتولـى الجـهات التـى كانت تقوم بتطبيق التشـريعات المـشار إليها فـى المادة الثانية صرف الحقوق";

                intent.putExtra("id",s);

            }
        });
    }
}
