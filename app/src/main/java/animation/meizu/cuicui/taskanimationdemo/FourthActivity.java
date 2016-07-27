package animation.meizu.cuicui.taskanimationdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FourthActivity extends AppCompatActivity {

    //views
    private TextView fourth_taskID;
    private TextView fourth_actMSG;
    private TextView fourth_currentAct;
    private Button fourth_But;

    private Button fourth_Third_But;
    private Button fourth_Background;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);

        initView();

        initTextView(FourthActivity.this.getTaskId(), FourthActivity.this.toString());

        fourth_But.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //taskToFrontAnimation
                butClick(FourthActivity.class);
            }
        });

        fourth_Third_But.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                butClick(ThirdActivity.class);
            }
        });

        fourth_Background.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveTaskToBack(true);
            }
        });
    }

    //初始化控件
    private void initView() {
        fourth_actMSG = (TextView) findViewById(R.id.fourth_act_msg);
        fourth_taskID = (TextView) findViewById(R.id.fourth_taskid);
        fourth_currentAct = (TextView) findViewById(R.id.fourth_current);
        fourth_But = (Button) findViewById(R.id.fourth_next_but);

        fourth_Third_But = (Button) findViewById(R.id.fourth_third_but);

        fourth_Background = (Button) findViewById(R.id.fourth_act_back);

    }

    //点击事件
    private void butClick(Class classname) {
        Intent intent = new Intent();
        intent.setClass(FourthActivity.this, classname);
        startActivity(intent);
        //intent.setFlags(Intent.FLAG_ACTIVITY_LAUN)
    }

    //初始化TextView显示
    private void initTextView(int id, String msg) {
        int pos = msg.indexOf("@");
        String substr = msg.substring(pos + 1, msg.length() - 1);
        fourth_taskID.setText(fourth_taskID.getText().toString() + String.valueOf(id));
        fourth_actMSG.setText(fourth_actMSG.getText().toString() + substr);
        fourth_currentAct.setText(fourth_currentAct.getText().toString() + "FourthActivity");
    }

}
