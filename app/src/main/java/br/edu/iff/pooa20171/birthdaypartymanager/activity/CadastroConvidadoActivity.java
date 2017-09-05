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
import br.edu.iff.pooa20171.birthdaypartymanager.model.Convidado;
import io.realm.Realm;

public class CadastroConvidadoActivity extends AppCompatActivity {

    EditText nome, email, numAcompanhantes;
    Button btsalvar, btalterar, btdeletar;

    int id;
    Convidado convidado;
    private Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_convidado);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        nome = (EditText) findViewById(R.id.etNome);
        email = (EditText) findViewById(R.id.etEmail);
        numAcompanhantes = (EditText) findViewById(R.id.etNumAcompanhantes);

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

            convidado= realm.where(Convidado.class).equalTo("id",id).findFirst();

            nome.setText(convidado.getNome());
            email.setText(convidado.getEmail());
            numAcompanhantes.setText(convidado.getNumAcompanhantes());

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
        convidado.deleteFromRealm();
        realm.commitTransaction();
        realm.close();

        Toast.makeText(this,"Convidado deletado!",Toast.LENGTH_LONG).show();
        this.finish();

    }

    public void salvar() {


        int proximoID = 1;
        if(realm.where(Convidado.class).max("id") !=null)
            proximoID = realm.where(Convidado.class).max("id").intValue()+1;

        realm.beginTransaction();
        Convidado convidado = new Convidado();
        convidado.setId(proximoID);
        convidado.setNome(nome.getText().toString());
        convidado.setEmail(email.getText().toString());
        convidado.setNumAcompanhantes(numAcompanhantes.getText().toString());

        realm.copyToRealm(convidado);
        realm.commitTransaction();
        realm.close();

        Toast.makeText(this,"Convidado Cadastrado!",Toast.LENGTH_LONG).show();
        this.finish();

    }
    public void alterar() {

        realm.beginTransaction();

        convidado.setNome(nome.getText().toString());
        convidado.setEmail(email.getText().toString());
        convidado.setNumAcompanhantes(numAcompanhantes.getText().toString());

        realm.copyToRealm(convidado);
        realm.commitTransaction();
        realm.close();

        Toast.makeText(this,"Convidado alterado!",Toast.LENGTH_LONG).show();
        this.finish();

    }
}

