package br.edu.iff.pooa20171.birthdaypartymanager.adapter;

import br.edu.iff.pooa20171.birthdaypartymanager.R;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;
import br.edu.iff.pooa20171.birthdaypartymanager.model.Festa;

public class FestaAdapter extends RecyclerView.Adapter {

    private List<Festa> festas;
    private Context context;
    private static ClickRecyclerViewListener clickRecyclerViewListener;

    public FestaAdapter(List<Festa> festas, Context context,ClickRecyclerViewListener clickRecyclerViewListener) {

        this.festas = festas;
        this.context = context;
        this.clickRecyclerViewListener = clickRecyclerViewListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                      int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.item_festa, parent, false);
        FestaViewHolder festaViewHolder = new FestaViewHolder(view);
        return festaViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder,
                                 int position) {

        FestaViewHolder holder = (FestaViewHolder) viewHolder;

        Festa festa  = festas.get(position) ;

        holder.descricao.setText(festa.getDescricao());
        holder.tema.setText(festa.getTema());
        holder.local.setText(festa.getLocal());
        holder.cidade.setText(festa.getCidade());
        holder.estado.setText(festa.getEstado());
        holder.data.setText(festa.getData());
        holder.horario.setText(festa.getHorario());
        holder.traje.setText(festa.getTraje());
    }

    @Override
    public int getItemCount() {

        return festas.size();
    }

    private void updateItem(int position) {

    }

    // Método responsável por remover um usuário da lista.
    private void removerItem(int position) {

    }

    public class FestaViewHolder extends RecyclerView.ViewHolder {

        private final TextView descricao;
        private final TextView tema;
        private final TextView local;
        private final TextView cidade;
        private final TextView estado;
        private final TextView data;
        private final TextView horario;
        private final TextView traje;



        public FestaViewHolder(View itemView) {
            super(itemView);
            descricao = (TextView) itemView.findViewById(R.id.tvDescricao);
            tema = (TextView) itemView.findViewById(R.id.tvTema);
            local = (TextView) itemView.findViewById(R.id.tvLocal);
            cidade = (TextView) itemView.findViewById(R.id.tvCidade);
            estado = (TextView) itemView.findViewById(R.id.tvEstado);
            data = (TextView) itemView.findViewById(R.id.tvData);
            horario = (TextView) itemView.findViewById(R.id.tvHorario);
            traje = (TextView) itemView.findViewById(R.id.tvTraje);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickRecyclerViewListener.onClick(festas.get(getLayoutPosition()));

                }
            });


        }
    }
}