package tour.donnees.animationstudy

import android.animation.Animator
import android.animation.AnimatorInflater
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_base_animation.*

class BaseAnimationActivity : AppCompatActivity() {

    private val fadeAnimator: Animator by lazy { AnimatorInflater.loadAnimator(this, R.animator.alpha) }
    private val rotateAnimator: Animator by lazy { AnimatorInflater.loadAnimator(this, R.animator.rotate) }
    private val scaleAnimator: Animator by lazy { AnimatorInflater.loadAnimator(this, R.animator.scale) }
    private val translateAnimator: Animator by lazy { AnimatorInflater.loadAnimator(this, R.animator.translate) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base_animation)

        fade_animation.setOnClickListener {
            fadeAnimator.apply {
                setTarget(hello)
                start()
            }
        }

        rotate_animation.setOnClickListener {
            rotateAnimator.apply {
                setTarget(hello)
                start()
            }
        }

        scale_animation.setOnClickListener {
            scaleAnimator.apply {
                setTarget(hello)
                start()
            }
        }

        translate_animation.setOnClickListener {
            translateAnimator.apply {
                setTarget(hello)
                start()
            }
        }

        events_activity.setOnClickListener {
            startActivity(Intent(this, AnimationEventActivity::class.java))
        }
    }

}
