package tour.donnees.animationstudy

import android.animation.Animator
import android.animation.AnimatorInflater
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_base_animation.*

class AnimationEventActivity : AppCompatActivity(), Animator.AnimatorListener {

    private val fadeAnimator: Animator by lazy { AnimatorInflater.loadAnimator(this, R.animator.alpha) }
    private val rotateAnimator: Animator by lazy { AnimatorInflater.loadAnimator(this, R.animator.rotate) }
    private val scaleAnimator: Animator by lazy { AnimatorInflater.loadAnimator(this, R.animator.scale) }
    private val translateAnimator: Animator by lazy { AnimatorInflater.loadAnimator(this, R.animator.translate) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation_event)

        fade_animation.setOnClickListener {
            fadeAnimator.apply {
                setTarget(hello)
                addListener(this@AnimationEventActivity)
                start()
            }
        }

        rotate_animation.setOnClickListener {
            rotateAnimator.apply {
                setTarget(hello)
                addListener(this@AnimationEventActivity)
                start()
            }
        }

        scale_animation.setOnClickListener {
            scaleAnimator.apply {
                setTarget(hello)
                addListener(this@AnimationEventActivity)
                start()
            }
        }

        translate_animation.setOnClickListener {
            translateAnimator.apply {
                setTarget(hello)
                addListener(this@AnimationEventActivity)
                start()
            }
        }
    }

    override fun onAnimationRepeat(animation: Animator?) {
        message("Animation repeat: ${animation.hashCode()}", animation)
    }

    override fun onAnimationEnd(animation: Animator?) {
        message("Animation Ended: ${animation.hashCode()}", animation)
    }

    override fun onAnimationCancel(animation: Animator?) {
        message("Animation Cancelled: ${animation.hashCode()}", animation)
    }

    override fun onAnimationStart(animation: Animator?) {
        message("Animation Started: ${animation.hashCode()}", animation)
    }

    private fun message(message: String, animation: Animator?) {
        when(animation) {
            rotateAnimator -> message("Rotate $message: ${animation.hashCode()}")
            translateAnimator -> message("Translate $message: ${animation.hashCode()}")
            scaleAnimator -> message("Scale $message: ${animation.hashCode()}")
            fadeAnimator -> message("Fade $message: ${animation.hashCode()}")
        }
    }

    private fun message(message: String) {
        Log.d(TAG, message)
    }

    companion object {
        const val TAG = "AnimationEventActivity"
    }
}
