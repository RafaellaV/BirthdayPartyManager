package br.edu.iff.pooa20171.birthdaypartymanager.activity;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import br.edu.iff.pooa20171.birthdaypartymanager.R;
import br.edu.iff.pooa20171.birthdaypartymanager.adapter.FestaAdapter;
import io.realm.Realm;
import br.edu.iff.pooa20171.birthdaypartymanager.adapter.ClickRecyclerViewListener;
import  br.edu.iff.pooa20171.birthdaypartymanager.model.Festa;


public class InicialActivity extends AppCompatActivity implements ClickRecyclerViewListener {

    private Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicial);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);


        realm = Realm.getDefaultInstance();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InicialActivity.this,CadastroFestaActivity.class);
                intent.putExtra("id",0);
                startActivity(intent);
            }
        });
    }

    private List<Festa> getFestas(){

        return (List)realm.where(Festa.class).findAll();

    }

    @Override
    public void onClick(Object object) {
        Festa festa = (Festa) object;
        Intent intent = new Intent (InicialActivity.this,CadastroFestaActivity.class);
        intent.putExtra("id",festa.getId());
        startActivity(intent);

    }

    protected void onResume() {
        super.onResume();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rvFestas);

        recyclerView.setAdapter(new FestaAdapter(getFestas(),this,this));
        RecyclerView.LayoutManager layout = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);

        recyclerView.setLayoutManager(layout);


    }

    @Override
    public void finish(){
        realm.close();

    }



}
