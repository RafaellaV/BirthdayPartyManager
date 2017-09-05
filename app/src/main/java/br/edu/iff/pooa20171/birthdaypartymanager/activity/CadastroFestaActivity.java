package br.edu.iff.pooa20171.birthdaypartymanager.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.edu.iff.pooa20171.birthdaypartymanager.R;
import io.realm.Realm;
import  br.edu.iff.pooa20171.birthdaypartymanager.model.Festa;


public class CadastroFestaActivity extends AppCompatActivity {

    EditText descricao, tema, local, cidade, estado, data, horario, traje;
    Button btsalvar, btalterar, btdeletar, btconvidados, btitens;

    int id;
    Festa festa;
    private Realm realm;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_festa);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        descricao = (EditText) findViewById(R.id.etDescricao);
        tema = (EditText) findViewById(R.id.etTema);
        local = (EditText) findViewById(R.id.etLocal);
        cidade = (EditText) findViewById(R.id.etCidade);
        estado = (EditText) findViewById(R.id.etEstado);
        data = (EditText) findViewById(R.id.etData);
        horario = (EditText) findViewById(R.id.etHorario);
        traje = (EditText) findViewById(R.id.etTraje);

        btsalvar = (Button) findViewById(R.id.btSalvar);
        btalterar = (Button) findViewById(R.id.btEditar);
        btdeletar = (Button) findViewById(R.id.btExcluir);

        btconvidados = (Button) findViewById(R.id.btConvidados);
        btitens = (Button) findViewById(R.id.btItens);

        //btconvidados = (Button) findViewById(R.id.btConvidados);
        btconvidados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(getContext(), ConvidadoActivity.class);
                startActivity(intent3);
            }
        });

        btitens.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), ItemActivity.class);
                startActivity(intent);
            }
        });


        Intent intent    = getIntent();
        id = (int) intent.getSerializableExtra("id");
        realm = Realm.getDefaultInstance();

        if (id !=0) {
            btsalvar.setEnabled(false);
            btsalvar.setClickable(false);
            btsalvar.setVisibility(View.INVISIBLE);

            festa = realm.where(Festa.class).equalTo("id",id).findFirst();

            descricao.setText(festa.getDescricao());
            tema.setText(festa.getTema());
            local.setText(festa.getLocal());
            cidade.setText(festa.getCidade());
            estado.setText(festa.getEstado());
            data.setText(festa.getData().toString());
            horario.setText(festa.getHorario());
            traje.setText(festa.getTraje());

        }else{
            btalterar.setEnabled(false);
            btalterar.setClickable(false);
            btalterar.setVisibility(View.INVISIBLE);
            btdeletar.setEnabled(false);
            btdeletar.setClickable(false);
            btdeletar.setVisibility(View.INVISIBLE);
            btconvidados.setEnabled(false);
            btconvidados.setClickable(false);
            btconvidados.setVisibility(View.INVISIBLE);
            btitens.setEnabled(false);
            btitens.setClickable(false);
            btitens.setVisibility(View.INVISIBLE);
        }



        btsalvar.setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                salvar();
            }
        });
        btalterar.setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                alterar();
            }
        });
        btdeletar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                deletar();
            }
        });


    }

    private Context getContext(){

        return this;
    }

    public void deletar(){
        realm.beginTransaction();
        festa.deleteFromRealm();
        realm.commitTransaction();
        realm.close();

        Toast.makeText(this,"Festa deletada!",Toast.LENGTH_LONG).show();
        this.finish();

    }

    public void salvar() {


        int proximoID = 1;
        if(realm.where(Festa.class).max("id") !=null)
            proximoID = realm.where(Festa.class).max("id").intValue()+1;

        realm.beginTransaction();
        Festa festa = new Festa();
        festa.setId(proximoID);
        festa.setDescricao(descricao.getText().toString());
        festa.setTema(tema.getText().toString());
        festa.setLocal(local.getText().toString());
        festa.setCidade(cidade.getText().toString());
        festa.setEstado(estado.getText().toString());
        festa.setData(data.getText().toString());
        festa.setHorario(horario.getText().toString());
        festa.setTraje(traje.getText().toString());


        realm.copyToRealm(festa);
        realm.commitTransaction();
        realm.close();

        Toast.makeText(this,"Festa Cadastrada!",Toast.LENGTH_LONG).show();
        this.finish();

    }
    public void alterar() {

        realm.beginTransaction();

        festa.setDescricao(descricao.getText().toString());
        festa.setTema(tema.getText().toString());
        festa.setLocal(local.getText().toString());
        festa.setCidade(cidade.getText().toString());
        festa.setEstado(estado.getText().toString());
        festa.setData(data.getText().toString());
        festa.setHorario(horario.getText().toString());
        festa.setTraje(traje.getText().toString());

        realm.copyToRealm(festa);
        realm.commitTransaction();
        realm.close();

        Toast.makeText(this,"Festa alterada!",Toast.LENGTH_LONG).show();
        this.finish();

    }
}
