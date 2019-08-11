package com.osornet.estudioandroidudemy.reciclerView;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.osornet.estudioandroidudemy.R;
import com.osornet.estudioandroidudemy.reciclerView.RestauranteFragment.OnListFragmentInteractionListener;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.List;


public class MyRestauranteRecyclerViewAdapter extends RecyclerView.Adapter<MyRestauranteRecyclerViewAdapter.ViewHolder> {

    private final List<Restaurante> mValues;
    private final OnListFragmentInteractionListener mListener;

    public MyRestauranteRecyclerViewAdapter(List<Restaurante> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_restaurante, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        //obtenenos el restaurante
        holder.mItem = mValues.get(position);

        holder.tvNombre.setText(holder.mItem.getNombre());
        holder.tvDireccion.setText(holder.mItem.getDireccion());
        holder.rbValoracion.setRating(holder.mItem.getValoracion());
        Picasso.get()
                .load(holder.mItem.getUrlPhoto())
                .resize(1000,350)
                .centerCrop()
                .into(holder.ivPhoto);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView tvNombre;
        public final TextView tvDireccion;
        public final ImageView ivPhoto;
        public final RatingBar rbValoracion;
        public Restaurante mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            tvNombre = view.findViewById(R.id.tvNombre);
            tvDireccion = view.findViewById(R.id.tvDireccion);
            ivPhoto = view.findViewById(R.id.ivPhoto);
            rbValoracion = view.findViewById(R.id.rbValoracion);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + tvNombre.getText() + "'";
        }
    }
}
