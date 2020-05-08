package tour.donnees.animationstudy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.*
import android.view.Gravity
import android.view.View
import kotlinx.android.synthetic.main.activity_transition_without_scene.*

class TransitionWithoutSceneActivity : AppCompatActivity() {

    private var visibility = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transition_without_scene)

    }

    fun fadeAnimation(view: View) {
        val transition = Fade()
        TransitionManager.beginDelayedTransition(sceneRoot, transition)
        txvDescription.visibility = if (visibility) View.INVISIBLE else View.VISIBLE
        visibility = !visibility
    }

    fun slideEffect(view: View) {
        val transition = Slide(Gravity.START)
        TransitionManager.beginDelayedTransition(sceneRoot, transition)
        txvDescription.visibility = if (visibility) View.INVISIBLE else View.VISIBLE
        visibility = !visibility
    }
}
