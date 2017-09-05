package br.edu.iff.pooa20171.birthdaypartymanager.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import br.edu.iff.pooa20171.birthdaypartymanager.R;
import br.edu.iff.pooa20171.birthdaypartymanager.model.Convidado;

public class ConvidadoAdapter extends RecyclerView.Adapter {

    private List<Convidado> convidados;
    private Context context;
    private static ClickRecyclerViewListener clickRecyclerViewListener;

    public ConvidadoAdapter(List<Convidado> convidados, Context context, ClickRecyclerViewListener clickRecyclerViewListener) {

        this.convidados = convidados;
        this.context = context;
        this.clickRecyclerViewListener = clickRecyclerViewListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                      int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.item_convidado, parent, false);
        ConvidadoAdapter.ConvidadoViewHolder convidadoViewHolder = new ConvidadoAdapter.ConvidadoViewHolder(view);
        return convidadoViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder,
                                 int position) {

        ConvidadoAdapter.ConvidadoViewHolder holder = (ConvidadoAdapter.ConvidadoViewHolder) viewHolder;

        Convidado convidado = convidados.get(position);

        holder.nome.setText(convidado.getNome());
        holder.email.setText(convidado.getEmail());
        holder.numAcompanhantes.setText(convidado.getNumAcompanhantes());
    }

    @Override
    public int getItemCount() {

        return convidados.size();
    }

    private void updateItem(int position) {

    }

    // Método responsável por remover um usuário da lista.
    private void removerItem(int position) {

    }

    public class ConvidadoViewHolder extends RecyclerView.ViewHolder {

        private final TextView nome;
        private final TextView email;
        private final TextView numAcompanhantes;


        public ConvidadoViewHolder(View itemView) {
            super(itemView);
            nome = (TextView) itemView.findViewById(R.id.tvNome);
            email = (TextView) itemView.findViewById(R.id.tvEmail);
            numAcompanhantes = (TextView) itemView.findViewById(R.id.tvNumAcompanhantes);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickRecyclerViewListener.onClick(convidados.get(getLayoutPosition()));

                }
            });


        }
    }
}
