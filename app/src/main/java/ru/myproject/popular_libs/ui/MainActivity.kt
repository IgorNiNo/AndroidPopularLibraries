package ru.myproject.popular_libs.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.myproject.popular_libs.databinding.ActivityMainBinding
import ru.myproject.popular_libs.model.CountersModel
import ru.myproject.popular_libs.presenter.MainPresenter
import ru.myproject.popular_libs.view.MainView

class MainActivity : AppCompatActivity(), MainView {

    private var vb: ActivityMainBinding? = null
    private val presenter = MainPresenter(this, model = CountersModel())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vb = ActivityMainBinding.inflate(layoutInflater)
        setContentView(vb?.root)

        vb?.btnCounter1?.setOnClickListener { presenter.counterClick1() }
        vb?.btnCounter2?.setOnClickListener { presenter.counterClick2() }
        vb?.btnCounter3?.setOnClickListener { presenter.counterClick3() }
    }

    override fun showCounter1(counter: String) {
        vb?.btnCounter1?.text = counter
    }

    override fun showCounter2(counter: String) {
        vb?.btnCounter2?.text = counter
    }

    override fun showCounter3(counter: String) {
        vb?.btnCounter3?.text = counter
    }
}