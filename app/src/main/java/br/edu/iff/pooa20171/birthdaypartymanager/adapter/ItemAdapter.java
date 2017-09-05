package br.edu.iff.pooa20171.birthdaypartymanager.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import br.edu.iff.pooa20171.birthdaypartymanager.R;
import br.edu.iff.pooa20171.birthdaypartymanager.model.Item;

public class ItemAdapter extends RecyclerView.Adapter {

    private List<Item> itens;
    private Context context;
    private static ClickRecyclerViewListener clickRecyclerViewListener;

    public ItemAdapter(List<Item> itens, Context context, ClickRecyclerViewListener clickRecyclerViewListener) {

        this.itens = itens;
        this.context = context;
        this.clickRecyclerViewListener = clickRecyclerViewListener;
        }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent,
        int viewType) {
        View view = LayoutInflater.from(context)
        .inflate(R.layout.item_item, parent, false);
        ItemAdapter.ItemViewHolder itemViewHolder = new ItemAdapter.ItemViewHolder(view);
        return itemViewHolder;
        }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder,
        int position) {

        ItemAdapter.ItemViewHolder holder = (ItemAdapter.ItemViewHolder) viewHolder;

        Item item = itens.get(position);

        holder.nome.setText(item.getNome());
        holder.quantidade.setText(item.getQuantidade());
        holder.valor.setText(item.getValor());
        }

    @Override
    public int getItemCount() {

            return itens.size();
            }

    private void updateItem(int position) {

            }

    // Método responsável por remover um usuário da lista.
    private void removerItem(int position) {

    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {

        private final TextView nome;
        private final TextView quantidade;
        private final TextView valor;


        public ItemViewHolder(View itemView) {
            super(itemView);
            nome = (TextView) itemView.findViewById(R.id.tvNome);
            quantidade = (TextView) itemView.findViewById(R.id.tvQtd);
            valor = (TextView) itemView.findViewById(R.id.tvValor);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickRecyclerViewListener.onClick(itens.get(getLayoutPosition()));

                }
            });


        }
    }
    }

