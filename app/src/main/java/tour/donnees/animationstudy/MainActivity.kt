package tour.donnees.animationstudy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import tour.donnees.animationstudy.transition.TransitionListActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        label_other_0.setOnClickListener {
            startActivity(Intent(this, BaseAnimationActivity::class.java))
        }

        label_other_1.text = "Transition"
        label_other_1.setOnClickListener {
            startActivity(Intent(this, TransitionActivity::class.java))
        }

        label_other_2.text = "Transition\nWithout Scene"
        label_other_2.setOnClickListener {
            startActivity(Intent(this, TransitionWithoutSceneActivity::class.java))
        }

        label_other_3.text = "Activity\nTransition"
        label_other_3.setOnClickListener {
            startActivity(Intent(this, TransitionListActivity::class.java))
        }
    }
}
