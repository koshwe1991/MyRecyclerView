package com.example.myrecyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myrecyclerview.databinding.ItemViewBinding

class ProductAdapter(val productList: ArrayList<Product>,private val listener:(Product)->Unit):RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {


    inner class ProductViewHolder(val binding: ItemViewBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {

        val binding = ItemViewBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.binding.txtView.text = productList.get(position).productName
        holder.binding.image.setImageResource(productList.get(position).image)
        holder.binding.txtPrice.text = productList.get(position).price.toString()

        val item = productList[position]
       holder.itemView.setOnClickListener {
           listener(item)
       }

    }

    override fun getItemCount(): Int = productList.size



}