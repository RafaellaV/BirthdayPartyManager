package br.edu.iff.pooa20171.birthdaypartymanager.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import br.edu.iff.pooa20171.birthdaypartymanager.R;

public class MainActivity extends AppCompatActivity {

    private ImageView bolas;
    private TextView texto1;
    private Button btCP, btE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bolas = (ImageView) findViewById(R.id.ivBolas);

        texto1 = (TextView) findViewById(R.id.tvSolicitar);
        texto1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NovaSenhaActivity.class); startActivity(intent); }
        });

        btCP = (Button) findViewById(R.id.btCadastroInicial);
        btCP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(MainActivity.this, CadastroPromoterActivity.class); startActivity(intent2); }
        });

        btE = (Button) findViewById(R.id.btEntrar);
        btE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(getContext(), InicialActivity.class); startActivity(intent3); }
        });
        }

    private Context getContext(){

        return this;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
