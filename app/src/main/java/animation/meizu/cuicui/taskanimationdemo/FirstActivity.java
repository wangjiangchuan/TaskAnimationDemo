package animation.meizu.cuicui.taskanimationdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FirstActivity extends AppCompatActivity {

    //views
    private TextView first_taskID;
    private TextView first_actMSG;
    private Button first_But;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        initView();

        initTextView(FirstActivity.this.getTaskId(), FirstActivity.this.toString());

        first_But.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                butClick(SecondActivity.class);
            }
        });
    }

    //初始化控件
    private void initView() {
        first_actMSG = (TextView) findViewById(R.id.first_act_msg);
        first_taskID = (TextView) findViewById(R.id.first_taskid);
        first_But = (Button) findViewById(R.id.act_next_but);

    }

    //点击事件
    private void butClick(Class classname) {
        Intent intent = new Intent();
        intent.setClass(FirstActivity.this, classname);
        startActivity(intent);
    }

    //初始化TextView显示
    private void initTextView(int id, String msg) {
        int pos = msg.indexOf("@");
        String substr = msg.substring(pos + 1, msg.length() - 1);
        first_taskID.setText(first_taskID.getText().toString() + String.valueOf(id));
        first_actMSG.setText(first_actMSG.getText().toString() + substr);
    }
}
