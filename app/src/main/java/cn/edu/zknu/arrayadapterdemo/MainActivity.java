package cn.edu.zknu.arrayadapterdemo;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements CheckBox.OnCheckedChangeListener,
        RadioGroup.OnCheckedChangeListener,AdapterView.OnItemSelectedListener,View.OnClickListener {

    private CheckBox cbSleep, cbEat, cbBuy;
    private RadioGroup rgEmotion;
    private Spinner spinEducation, spinSex;
    private Button btConfirm;
    private String[] emotionChioce = new String[]{"男", "女"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cbSleep=(CheckBox)findViewById(R.id.cb_sleep);
        cbEat=(CheckBox)findViewById(R.id.cb_eat);
        cbBuy=(CheckBox)findViewById(R.id.cb_buy);
        rgEmotion=(RadioGroup) findViewById(R.id.rg_emotion);
        spinEducation=(Spinner)findViewById(R.id.spin_education);
        spinSex=(Spinner) findViewById(R.id.spin_sex);
        btConfirm=(Button)findViewById(R.id.bt_confirm);
        SpinnerAdapter adapter=new ArrayAdapter<String>(this,R.layout.adapter_array,R.id.tv_array,emotionChioce);
        spinSex.setAdapter(adapter);

        cbSleep.setOnCheckedChangeListener(this);
        cbEat.setOnCheckedChangeListener(this);
        cbBuy.setOnCheckedChangeListener(this);
        rgEmotion.setOnCheckedChangeListener(this);
        spinEducation.setOnItemSelectedListener(this);
        btConfirm.setOnClickListener(this);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        Toast.makeText(this,buttonView.getText().toString()+":"+isChecked,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        String str=((RadioButton)findViewById(checkedId)).getText().toString();
        Toast.makeText(this,str,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String[] arr=getResources().getStringArray(R.array.education_name);
        Toast.makeText(this,arr[position],Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onClick(View v) {
        Toast.makeText(this,"你点击了按钮",Toast.LENGTH_SHORT).show();
    }

}
