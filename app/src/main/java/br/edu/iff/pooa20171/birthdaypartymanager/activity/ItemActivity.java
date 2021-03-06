package br.edu.iff.pooa20171.birthdaypartymanager.activity;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.List;

import br.edu.iff.pooa20171.birthdaypartymanager.R;
import br.edu.iff.pooa20171.birthdaypartymanager.adapter.ClickRecyclerViewListener;
import br.edu.iff.pooa20171.birthdaypartymanager.adapter.ItemAdapter;
import br.edu.iff.pooa20171.birthdaypartymanager.model.Item;
import io.realm.Realm;

public class ItemActivity extends AppCompatActivity implements ClickRecyclerViewListener {

    private Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        realm = Realm.getDefaultInstance();


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ItemActivity.this,CadastroItemActivity.class);
                intent.putExtra("id",0);
                startActivity(intent);
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private List<Item> getItens(){

        return (List)realm.where(Item.class).findAll();

    }

    @Override
    public void onClick(Object object) {
        Item item = (Item) object;
        Intent intent = new Intent(ItemActivity.this,CadastroItemActivity.class);
        intent.putExtra("id",item.getId());
        startActivity(intent);

    }

    protected void onResume() {
        super.onResume();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rvItens);

        recyclerView.setAdapter(new ItemAdapter(getItens(),this,this));
        RecyclerView.LayoutManager layout = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);

        recyclerView.setLayoutManager(layout);


    }

    @Override
    public void finish(){
        realm.close();

    }

}
