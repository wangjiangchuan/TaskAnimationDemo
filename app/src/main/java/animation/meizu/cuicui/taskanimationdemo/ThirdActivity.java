package animation.meizu.cuicui.taskanimationdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {

    //views
    private TextView third_taskID;
    private TextView third_actMSG;
    private TextView third_currentAct;
    private Button third_But;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        initView();

        initTextView(ThirdActivity.this.getTaskId(), ThirdActivity.this.toString());

        third_But.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //taskToFrontAnimation
                butClick(FourthActivity.class);
            }
        });
    }

    //初始化控件
    private void initView() {
        third_actMSG = (TextView) findViewById(R.id.third_act_msg);
        third_taskID = (TextView) findViewById(R.id.third_taskid);
        third_currentAct = (TextView) findViewById(R.id.third_current);
        third_But = (Button) findViewById(R.id.third_next_but);

    }

    //点击事件
    private void butClick(Class classname) {
        Intent intent = new Intent();
        intent.setClass(ThirdActivity.this, classname);
        startActivity(intent);
    }

    //初始化TextView显示
    private void initTextView(int id, String msg) {
        int pos = msg.indexOf("@");
        String substr = msg.substring(pos + 1, msg.length() - 1);
        third_taskID.setText(third_taskID.getText().toString() + String.valueOf(id));
        third_actMSG.setText(third_actMSG.getText().toString() + substr);
        third_currentAct.setText(third_currentAct.getText().toString() + "ThirdActivity");
    }

}
