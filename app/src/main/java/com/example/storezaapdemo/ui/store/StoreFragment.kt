package com.example.storezaapdemo.ui.store

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.storezaapdemo.R
import com.example.storezaapdemo.databinding.FragmentStoreBinding

class StoreFragment : Fragment() {

    private var _binding: FragmentStoreBinding? = null

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MyAdapter
    private lateinit var dataList: MutableList<MyData>

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view = inflater.inflate(R.layout.fragment_store, container, false)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        // initialize adapter
        dataList = mutableListOf()
        dataList.add(MyData(R.drawable.amazon, "Amazon"))
        dataList.add(MyData(R.drawable.amazon, "Amazon"))
        dataList.add(MyData(R.drawable.amazon, "Amazon"))
        adapter = MyAdapter(dataList)


        // set adapter
        recyclerView.adapter = adapter

        _binding = FragmentStoreBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private inner class MyAdapter(private val dataList: List<MyData>) :
        RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_layout, parent, false)
            return MyViewHolder(view)
        }

        override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
            val data = dataList[position]
            holder.imageView.setImageResource(data.image)
            holder.textView.text = data.text
        }

        override fun getItemCount(): Int {
            return dataList.size
        }

        inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val imageView: ImageView = itemView.findViewById(R.id.image_view)
            val textView: TextView = itemView.findViewById(R.id.text_view)
        }

    }
}

data class MyData(val image: Int, val text: String)