package com.example.smartlab

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.smartlab.models.LoadCatalog
import com.example.smartlab.models.LoadNews
import com.example.smartlab.utils.Utils
import com.google.android.material.bottomsheet.BottomSheetDialog
import retrofit2.Call
import retrofit2.Response

class AnalizisFragment : Fragment() {
    private lateinit var textLink:TextView
    private lateinit var dialog : BottomSheetDialog
    lateinit var LoadCatalogRecycler: RecyclerView
    lateinit var NewsRecycler:RecyclerView
    lateinit var CategoryRecycler:RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_analizis, container, false)
        val retrofit = Utils.retroInst
        textLink=root.findViewById(R.id.textView47)
        CategoryRecycler=root.findViewById(R.id.categor)
        NewsRecycler=root.findViewById(R.id.news)
        LoadCatalogRecycler = root.findViewById(/* id = */ R.id.catalog)
        retrofit.loadNewsSheet().enqueue(object  : retrofit2.Callback<List<LoadNews>>{
            override fun onResponse(
                call: Call<List<LoadNews>>,
                response: Response<List<LoadNews>>
            ) {
                NewsRecycler.adapter = response.body()?.let { NewsAdapter(requireContext(), it) }
            }

            override fun onFailure(call: Call<List<LoadNews>>, t: Throwable) {

            }
        })
        // обрабатывается нажатие
        textLink.setOnClickListener{
            showBottomSheet()
        }
        retrofit.loadCatalogList().enqueue(object : retrofit2.Callback<List<LoadCatalog>> {
            override fun onResponse(call: Call<List<LoadCatalog>>, response: Response<List<LoadCatalog>>) {
                CategoryRecycler.adapter =  response.body()?.let {CategoryAdapter(requireContext(), it)}
                LoadCatalogRecycler.adapter = response.body()?.let { CatalogAdapter(requireContext(), it) }
            }

            override fun onFailure(call: Call<List<LoadCatalog>>, t: Throwable) {
                Log.d("error", t.localizedMessage.toString())
            }
        })
        return root
    }
    private fun showBottomSheet() {
        val dialogView = layoutInflater.inflate(R.layout.bottom_sheeeet, null)
        dialog = BottomSheetDialog(requireContext(), R.style.BottomSheetDialogTheme)
        dialog.setContentView(dialogView)
        dialog.show()
    }



}