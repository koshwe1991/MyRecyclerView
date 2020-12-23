package com.example.myrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myrecyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(){
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val productList:ArrayList<Product> = ArrayList()
        productList.add(Product("Coke","500-Ks",R.drawable.coke))
        productList.add(Product("Cake","200-Ks",R.drawable.cake))
        productList.add(Product("Rose","300-Ks",R.drawable.rose))

        val productAdapter = ProductAdapter(productList){item ->
            Toast.makeText(this,item.productName,Toast.LENGTH_LONG).show()
        }
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = productAdapter
        //binding.recyclerView.layoutManager = GridLayoutManager(this,3)
        //binding.recyclerView.adapter = productAdapter



    }



}