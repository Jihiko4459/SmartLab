package com.example.smartlab

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.smartlab.models.LoadCatalog
import com.example.smartlab.models.LoadNews
import com.example.smartlab.utils.Utils
import retrofit2.Call
import retrofit2.Response

class AnalizisFragment : Fragment() {
    lateinit var LoadCatalogRecycler: RecyclerView
    lateinit var LoadNewsRecycler:RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_analizis, container, false)
        val retrofit = Utils.retroInst
        LoadCatalogRecycler = root.findViewById(/* id = */ R.id.catalog)
        LoadNewsRecycler=root.findViewById(R.id.news)

        retrofit.loadNewsSheet().enqueue(object : retrofit2.Callback<List<LoadNews>> {
            override fun onResponse(call: Call<List<LoadNews>>, response: Response<List<LoadNews>>) {
                LoadNewsRecycler.adapter = response.body()?.let {NewsAdapter(requireContext(), it) }
            }

            override fun onFailure(call: Call<List<LoadNews>>, t: Throwable) {
                Log.d("error", t.localizedMessage.toString())
            }
        })

        retrofit.loadCatalogList().enqueue(object : retrofit2.Callback<List<LoadCatalog>> {
            override fun onResponse(call: Call<List<LoadCatalog>>, response: Response<List<LoadCatalog>>) {
                LoadCatalogRecycler.adapter = response.body()?.let { CatalogAdapter(requireContext(), it) }
            }

            override fun onFailure(call: Call<List<LoadCatalog>>, t: Throwable) {
                Log.d("error", t.localizedMessage.toString())
            }
        })
        return root
    }

}