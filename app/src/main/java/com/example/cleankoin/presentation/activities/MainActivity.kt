package com.example.cleankoin.presentation.activities

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cleankoin.R
import com.example.cleankoin.presentation.adapters.UserAdapter
import com.example.cleankoin.presentation.viewmodel.MainViewModel
import com.example.cleankoin.presentation.viewmodel.viewstate.MainVS
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.viewmodel.ext.android.getViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel:MainViewModel
    private lateinit var userAdapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModelDocumentFunction()

        userAdapter = UserAdapter()

        rv.apply {
            val linearLayoutManager = LinearLayoutManager(context)
            layoutManager = linearLayoutManager
            adapter = userAdapter
        }

    }

    private fun viewModelDocumentFunction() {
        mainViewModel = getViewModel()
        mainViewModel.state.observe(this, Observer {
            when (it) {
                is MainVS.Error -> {
                    Toast.makeText(this,it.reason,Toast.LENGTH_SHORT).show()
                }
                is MainVS.Loading -> {
                    pb.visibility= View.VISIBLE
                }
                is MainVS.GetData->{
                    /*it.mutableList.forEach {
                        tvHello.text="${tvHello.text} ${it}"
                    }*/
                    userAdapter.addAll(it.mutableList)
                }
            }
        })
        mainViewModel.sayHello()
    }
}
