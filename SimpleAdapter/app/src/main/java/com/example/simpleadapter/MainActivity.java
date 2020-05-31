package com.example.simpleadapter;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MainActivity extends AppCompatActivity {
    private ListView mListView;
    private String[] names = new String[]{"Lion","Tiger","Monkey","Dog","Cat","Elephant"};
    private int[] icons = new int[]{R.drawable.lion,R.drawable.tiger,
            R.drawable.monkey,R.drawable.dog,R.drawable.cat,R.drawable.elephant};
    List<Map<String,Object>> ListItems=new ArrayList<Map<String, Object>>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final int color1=0xFFC5B5FF;
        final int color2=0xFFFFFFFF;
        for (int i=0;i<names.length;i++){
            Map<String,Object> listItem=new HashMap<String,Object>();
            listItem.put("name",names[i]);
            listItem.put("icon",icons[i]);
            //加入list集合
            ListItems.add(listItem);
        }
        ListView list=(ListView)findViewById(R.id.lv);
        SimpleAdapter simpleAdapter=new SimpleAdapter(this,ListItems,
                R.layout.list_item,new String[]{"name","icon"},
                new int[]{R.id.name,R.id.icon});

        //为ListView设置Adapter
        list.setAdapter(simpleAdapter);


        list.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                int flag=0;
                System.out.println(names[position]+position+"被单击");
                //点击则改变状态，改变颜色
                switch (flag){
                    case 0:
                        //view.setBackgroundColor(color1);
                        //此处对应上面布局文件的点击函数
                        view.setSelected(true);
                        CharSequence text=names[position];
                        //定义一个Toast表示哪一个图片所在item被点击
                        int duration= Toast.LENGTH_SHORT;
                        Toast toast=Toast .makeText(MainActivity.this,text,duration);
                        toast.show();
                        flag=1;
                        break;
                    case 1:
                        //view.setBackgroundColor(color2);
                        view.setSelected(false);
                        CharSequence text1=names[position];
                        int duration1= Toast.LENGTH_SHORT;
                        Toast toast1=Toast .makeText(MainActivity.this,text1,duration1);
                        toast1.show();
                        flag=0;
                        break;
                }
            }
        });
        //选中函数
        list.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id){
                System.out.println(names[position]+"选中");
            }
            public void onNothingSelected(AdapterView<?> parent){

            }
        });

    }

}
