package com.example.mvvmapp.ui.main.view

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmapp.R
import com.example.mvvmapp.data.api.ApiHelper
import com.example.mvvmapp.data.api.ApiServiceImpl
import com.example.mvvmapp.data.model.Acronym
import com.example.mvvmapp.data.model.AcronymBaseLf
import com.example.mvvmapp.data.model.AcronymLfs
import com.example.mvvmapp.ui.base.ViewModelFactory
import com.example.mvvmapp.ui.main.adapter.LfsAdapter
import com.example.mvvmapp.ui.main.adapter.MainAdapter
import com.example.mvvmapp.ui.main.adapter.VarsAdapter
import com.example.mvvmapp.ui.main.viewmodel.MainViewModel
import com.example.mvvmapp.utils.Network
import com.example.mvvmapp.utils.Status
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel
    private lateinit var adapter: MainAdapter
    private lateinit var adapterLfs: LfsAdapter
    private lateinit var adapterVars: VarsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setMainUpUI()
        setUpViewModel()
        setupObserver()

        til_search.editText?.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                if (Network().isNetworkAvailable(this@MainActivity)) {
                    mainViewModel.getNewAcronymResearch(s.toString())
                    setupObserver()
                    setMainUpUI()
                } else {
                    Toast.makeText(this@MainActivity, "Network Unavailable", Toast.LENGTH_SHORT)
                        .show()
                }
            }

        })
    }

    private fun setMainUpUI() {
        //Main Adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = MainAdapter(arrayListOf())
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                recyclerView.context,
                (recyclerView.layoutManager as LinearLayoutManager).orientation
            )
        )

        recyclerView.adapter = adapter

        adapter.setOnClickListener(object :
            MainAdapter.OnClickListener {
            override fun onclick(position: Int, acronym: ArrayList<Acronym>) {
                setSecondaryUpUI(position, acronym)
            }
        })
    }

    private fun setSecondaryUpUI(position: Int, acronym: ArrayList<Acronym>) {
        //SecondaryAdapter
        rcv_lfs.layoutManager = LinearLayoutManager(this)
        adapterLfs = LfsAdapter(acronym[position].lsfs as ArrayList<AcronymLfs>)
        rcv_lfs.addItemDecoration(
            DividerItemDecoration(
                rcv_lfs.context,
                (rcv_lfs.layoutManager as LinearLayoutManager).orientation
            )
        )
        rcv_lfs.adapter = adapterLfs

        adapterLfs.setOnClickListener(object : LfsAdapter.OnClickListener {
            override fun onclick(position: Int, lfs: ArrayList<AcronymLfs>) {
                setThirdUpUI(position, lfs)
            }

        })
    }

    private fun setThirdUpUI(position: Int, lfs: ArrayList<AcronymLfs>) {
        rcv_vars.layoutManager = LinearLayoutManager(this)
        adapterVars = VarsAdapter(lfs[position].vars as ArrayList<AcronymBaseLf>)
        rcv_vars.addItemDecoration(
            DividerItemDecoration(
                rcv_vars.context,
                (rcv_vars.layoutManager as LinearLayoutManager).orientation
            )
        )
        rcv_vars.adapter = adapterVars
    }

    private fun setupObserver() {
        mainViewModel.getAcronym().observe(this, Observer {
            when (it.status) {
                Status.SUCCESS -> {
                    progressBar.visibility = View.GONE
                    it.data?.let { acronyms ->
                        renderList(acronyms)
                    }
                    recyclerView.visibility = View.VISIBLE
                    rcv_lfs.visibility = View.VISIBLE
                    rcv_vars.visibility = View.VISIBLE
                }

                Status.LOADING -> {
                    progressBar.visibility = View.VISIBLE
                    recyclerView.visibility = View.GONE
                    rcv_lfs.visibility = View.GONE
                    rcv_vars.visibility = View.GONE
                    rcv_lfs.visibility = View.GONE
                }

                Status.ERROR -> {
                    progressBar.visibility = View.GONE
                    Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                }
            }
        })
    }

    private fun renderList(acronyms: List<Acronym>) {
        adapter.addDta(acronyms)
        adapter.notifyDataSetChanged()
    }

    private fun setUpViewModel() {
        mainViewModel = ViewModelProviders.of(
            this,
            ViewModelFactory(ApiHelper(ApiServiceImpl()))
        )
            .get(MainViewModel::class.java)
    }


}