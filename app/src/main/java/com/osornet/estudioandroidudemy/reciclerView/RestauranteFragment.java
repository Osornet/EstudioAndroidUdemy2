package com.osornet.estudioandroidudemy.reciclerView;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.osornet.estudioandroidudemy.R;


import java.util.ArrayList;
import java.util.List;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class RestauranteFragment extends Fragment {

    private RecyclerView recyclerView;
    private MyRestauranteRecyclerViewAdapter adapterRestaurantes;
    private List<Restaurante> restauranteList;

    // TODO: Customize parameters
    private int mColumnCount = 1;

    private OnListFragmentInteractionListener mListener;


    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public RestauranteFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_restaurante_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }

            //lista de restaurantes
            restauranteList = new ArrayList<>();

            //llenado de la lista de restaurantes
            llenarRestaurantes(restauranteList);

            adapterRestaurantes = new MyRestauranteRecyclerViewAdapter(restauranteList, mListener);
            recyclerView.setAdapter(adapterRestaurantes);
        }
        return view;
    }

    /**
     * Metodo que llena la lista de restaurantes
     */
    private  void llenarRestaurantes(List<Restaurante> restaurantes) {
        restaurantes.add(new Restaurante("Pizzeria Carlos", "https://hoteljaizkibel.com/wp-content/uploads/2018/09/restaurante-jaizkibel-1.jpg", 4.0f, "Madrid, España"));
        restaurantes.add(new Restaurante("Restaurante Rapido", "https://www.recetasdesbieta.com/wp-content/uploads/2018/09/Como-hacer-pizza-casera-rapida-con-masa-de-pizza-sin-repos-1.jpg", 3.0f, "Cucuta, Colombia"));
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(Restaurante item);
    }
}
