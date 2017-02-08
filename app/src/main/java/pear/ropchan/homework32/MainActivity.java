package pear.ropchan.homework32;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MyAdapter adapter;
    private List<RecyclerItem> listItems;

    public String[] fruit = {
            "Абрикос",
            "Айва",
            "Авокадо",
            "Алыча",
            "Ананас",
            "Апельсин",
            "Банан",
            "Бергамот",
            "Гранат",
            "Грейпфрут",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        listItems = new ArrayList<>();
        //Generate sample data

        for (int i = 0; i<10; i++) {
            listItems.add(new RecyclerItem(fruit[i], null));
        }

        //Set adapter
        adapter = new MyAdapter(listItems, this);
        recyclerView.setAdapter(adapter);
    }
    protected void clickBtn (View view){
        EditText eText = (EditText)findViewById(R.id.editText);
        String eTextStr = eText.getText().toString();

        listItems.add(new RecyclerItem(eTextStr, null));

        adapter = new MyAdapter(listItems, this);
        recyclerView.setAdapter(adapter);
    }
}
