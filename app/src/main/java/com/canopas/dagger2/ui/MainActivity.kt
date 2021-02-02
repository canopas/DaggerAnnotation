package com.canopas.dagger2.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.canopas.dagger2.R
import com.canopas.dagger2.databinding.ActivityMainBinding
import com.canopas.dagger2.model.User
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainPresenter.View {

    @Inject
    lateinit var presenter: MainPresenter
    private lateinit var binding: ActivityMainBinding
    private var adapter: UserAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = UserAdapter()
        binding.recyclerView.adapter = adapter
    }

    override fun onStart() {
        super.onStart()
        presenter.attachView(this)
    }

    override fun onStop() {
        super.onStop()
        presenter.detachView()
    }

    override fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun setUser(users: List<User>) {
        adapter?.users = users
    }
}