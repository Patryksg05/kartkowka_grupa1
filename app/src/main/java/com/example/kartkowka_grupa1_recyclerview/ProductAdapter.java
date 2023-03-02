package com.example.kartkowka_grupa1_recyclerview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.transition.Hold;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    LayoutInflater inflater;
    private ArrayList<Product> products = new ArrayList<Product>();

    public ProductAdapter(Context context, ArrayList<Product> products) {
        this.inflater = LayoutInflater.from(context);
        this.products = products;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.one_item_row, parent, false);
        return new ProductViewHolder(itemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder,@SuppressLint("RecyclerView")
            final int position) {
        holder.productNameTextView.setText(products.get(position).getName());
//        products.get(getItemViewType(position)).setTextFlag(false);
        products.get(getItemViewType(position)).setTextFlag(false);
//        products.get(position).setTextFlag(false);
//        /*Toast.makeText(inflater.getContext(), Integer.toString(position), Toast.LENGTH_SHORT).show();*/
        holder.productNameTextView.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(inflater.getContext(),
                                String.valueOf(products.get(getItemViewType(position))),
                                Toast.LENGTH_SHORT).show();
                        if(holder.productNameTextView.getCurrentTextColor()
                         == Color.BLACK) {
                            holder.productNameTextView.setPaintFlags(
                                    holder.productNameTextView.getPaintFlags() |
                                            Paint.STRIKE_THRU_TEXT_FLAG
                            );
//                        holder.
                            products.get(getItemViewType(position)).setTextFlag(true);
                            Toast.makeText(inflater.getContext(),
                                    String.valueOf(products.get(getItemViewType(position)).isTextFlag()),
                                    Toast.LENGTH_SHORT).show();
                            holder.productNameTextView.setTextColor(Color.rgb(255, 0, 0));
                        }

                        else if(holder.productNameTextView.getCurrentTextColor() ==
                            Color.rgb(255,0,0))
                        {
                            holder.productNameTextView.setPaintFlags(
                                    holder.productNameTextView.getPaintFlags() &
                                                ~Paint.STRIKE_THRU_TEXT_FLAG
                            );
                            Toast.makeText(inflater.getContext(), "red", Toast.LENGTH_SHORT).show();
                            holder.productNameTextView.setTextColor(Color.BLACK);
                            products.get(getItemViewType(position)).setTextFlag(false);
                        }
                        else
                        {
                            products.get(getItemViewType(position)).setTextFlag(false);
                        }
                    }
                }
        );
    }

    public void removeChecked()
    {
        products.removeIf(Product::isTextFlag);
        notifyDataSetChanged();
    }

    public int getItemViewType(int position) {return position;}

    @Override
    public int getItemCount() {
        return products.size();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder {
        ProductAdapter productAdapter;
        private final TextView productNameTextView;

        public ProductViewHolder(@NonNull View itemView, ProductAdapter productAdapter)
        {
            super(itemView);
            this.productAdapter = productAdapter;
            this.productNameTextView = itemView.findViewById(R.id.productNameItem);

//            productNameTextView.setOnClickListener(this);
        }

//        @Override
//        public void onClick(View view) {
//            int pos = getLayoutPosition();
//            Product product = products.get(pos);
//            products.get(pos).setTextFlag(false);
//
//            if(!product.isTextFlag())
//            {
//                product.setTextFlag(true);
//                productNameTextView.setPaintFlags(
//                        productNameTextView.getPaintFlags() &
//
//                );
//            }
//        }
    }
}
