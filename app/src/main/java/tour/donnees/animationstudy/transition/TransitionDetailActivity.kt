package tour.donnees.animationstudy.transition

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.Scene
import android.transition.Transition
import android.transition.TransitionInflater
import android.transition.TransitionManager
import android.view.View
import android.view.Window
import kotlinx.android.synthetic.main.activity_transition.*
import tour.donnees.animationstudy.R

class TransitionDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transition_detail)
    }

    fun onClickBack(v: View) {
        finishAfterTransition()
    }
}
