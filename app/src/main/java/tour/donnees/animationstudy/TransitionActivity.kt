package tour.donnees.animationstudy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.Scene
import android.transition.Transition
import android.transition.TransitionInflater
import android.transition.TransitionManager
import android.view.View
import kotlinx.android.synthetic.main.activity_transition.*

class TransitionActivity : AppCompatActivity() {

    private lateinit var scene1: Scene
    private lateinit var scene2: Scene
    private lateinit var currentScene: Scene
    private lateinit var transition: Transition

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transition)

        // Step 1: Create a Scene object for both the starting ending layout
        scene1 = Scene.getSceneForLayout(sceneRoot, R.layout.scene1, this)
        scene2 = Scene.getSceneForLayout(sceneRoot, R.layout.scene2, this)

        // Step 2: Create a Transition object to define what type of animation you want
        //transition = TransitionInflater.from(this).inflateTransition(R.transition.change_bounds)
        //transition = TransitionInflater.from(this).inflateTransition(R.transition.slide)
        transition = TransitionInflater.from(this).inflateTransition(R.transition.explore)
        //transition = TransitionInflater.from(this).inflateTransition(R.transition.transition_set)

        scene1.enter()
        currentScene = scene1

    }

    fun onClick(v: View) {
        currentScene = if (currentScene === scene1) {
            TransitionManager.go(scene2, transition)
            scene2
        } else {
            TransitionManager.go(scene1, transition)
            scene1
        }
    }
}
