package br.edu.iff.pooa20171.birthdaypartymanager.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.edu.iff.pooa20171.birthdaypartymanager.R;
import br.edu.iff.pooa20171.birthdaypartymanager.model.Item;
import io.realm.Realm;

public class CadastroItemActivity extends AppCompatActivity {

    EditText nome, quantidade, valor;
    Button btsalvar, btalterar, btdeletar;

    int id;
    Item item;
    private Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_item);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        nome = (EditText) findViewById(R.id.etNome);
        quantidade = (EditText) findViewById(R.id.etQtd);
        valor = (EditText) findViewById(R.id.etValor);

        btsalvar = (Button) findViewById(R.id.btSalvar);
        btalterar = (Button) findViewById(R.id.btEditar);
        btdeletar = (Button) findViewById(R.id.btExcluir);

        Intent intent    = getIntent();
        id = (int) intent.getSerializableExtra("id");
        realm = Realm.getDefaultInstance();

        if (id !=0) {
            btsalvar.setEnabled(false);
            btsalvar.setClickable(false);
            btsalvar.setVisibility(View.INVISIBLE);

            item = realm.where(Item.class).equalTo("id",id).findFirst();

            nome.setText(item.getNome());
            quantidade.setText(item.getQuantidade());
            valor.setText(item.getValor());

        }else{
            btalterar.setEnabled(false);
            btalterar.setClickable(false);
            btalterar.setVisibility(View.INVISIBLE);
            btdeletar.setEnabled(false);
            btdeletar.setClickable(false);
            btdeletar.setVisibility(View.INVISIBLE);
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

    public void deletar(){
        realm.beginTransaction();
        item.deleteFromRealm();
        realm.commitTransaction();
        realm.close();

        Toast.makeText(this,"Item deletado!",Toast.LENGTH_LONG).show();
        this.finish();

    }

    public void salvar() {


        int proximoID = 1;
        if(realm.where(Item.class).max("id") !=null)
            proximoID = realm.where(Item.class).max("id").intValue()+1;

        realm.beginTransaction();
        Item item = new Item();
        item.setId(proximoID);
        item.setNome(nome.getText().toString());
        item.setQuantidade(quantidade.getText().toString());
        item.setValor(valor.getText().toString());

        realm.copyToRealm(item);
        realm.commitTransaction();
        realm.close();

        Toast.makeText(this,"Item Cadastrado!",Toast.LENGTH_LONG).show();
        this.finish();

    }
    public void alterar() {

        realm.beginTransaction();

        item.setNome(nome.getText().toString());
        item.setQuantidade(quantidade.getText().toString());
        item.setValor(valor.getText().toString());

        realm.copyToRealm(item);
        realm.commitTransaction();
        realm.close();

        Toast.makeText(this,"Item alterado!",Toast.LENGTH_LONG).show();
        this.finish();

    }
}


