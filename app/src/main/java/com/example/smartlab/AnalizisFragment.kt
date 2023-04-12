package com.example.smartlab

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.smartlab.models.LoadCatalog
import com.example.smartlab.utils.Utils
import retrofit2.Call
import retrofit2.Response

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AnalizisFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AnalizisFragment : Fragment() {
    lateinit var LoadCatalogRecycler: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_analizis, container, false)
        val retrofit = Utils.retroInst
        LoadCatalogRecycler = root.findViewById(/* id = */ R.id.catalog)

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