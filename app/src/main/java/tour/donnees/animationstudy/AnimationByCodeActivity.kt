package tour.donnees.animationstudy

import android.animation.Animator
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_animation_by_code.*

class AnimationByCodeActivity : AppCompatActivity(), Animator.AnimatorListener {

    private var scaleObjectAnimator: ObjectAnimator? = null
    private var rotateObjectAnimator: ObjectAnimator? = null
    private var translateObjectAnimator: ObjectAnimator? = null
    private var fadeObjectAnimator: ObjectAnimator? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation_by_code)

        scale_animation_code.setOnClickListener {
            scaleAnimation(hello_code)
        }
        rotate_animation_code.setOnClickListener {
            rotateAnimation(hello_code)
        }
        translate_animation_code.setOnClickListener {
            translateAnimation(hello_code)
        }
        fade_animation_code.setOnClickListener {
            fadeAnimation(hello_code)
        }

    }

    private fun scaleAnimation(view: View?) {
        rotateObjectAnimator = ObjectAnimator.ofFloat(view, "scaleX", 1.0f, 3.0f)
        rotateObjectAnimator?.apply {
            duration = 1000
            repeatCount = 1
            repeatMode = ValueAnimator.REVERSE
            addListener(this@AnimationByCodeActivity)
            start()
        }
    }

    private fun rotateAnimation(view: View?) {
        rotateObjectAnimator = ObjectAnimator.ofFloat(view, "rotation", 0.0f, -180.0f)
        rotateObjectAnimator?.apply {
            duration = 1000
            repeatCount = 1
            repeatMode = ValueAnimator.REVERSE
            addListener(this@AnimationByCodeActivity)
            start()
        }

    }

    private fun translateAnimation(view: View?) {
        rotateObjectAnimator = ObjectAnimator.ofFloat(view, "translationX", 0.0f, 200.0f)
        rotateObjectAnimator?.apply {
            duration = 1000
            repeatCount = 1
            repeatMode = ValueAnimator.REVERSE
            addListener(this@AnimationByCodeActivity)
            start()
        }
    }

    private fun fadeAnimation(view: View?) {
        fadeObjectAnimator = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f)
        fadeObjectAnimator?.apply {
            duration = 1000
            repeatCount = 1
            repeatMode = ValueAnimator.REVERSE
            addListener(this@AnimationByCodeActivity)
            start()
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
            rotateObjectAnimator -> message("Rotate $message: ${animation.hashCode()}")
            translateObjectAnimator -> message("Translate $message: ${animation.hashCode()}")
            scaleObjectAnimator -> message("Scale $message: ${animation.hashCode()}")
            fadeObjectAnimator -> message("Fade $message: ${animation.hashCode()}")
        }
    }

    private fun message(message: String) {
        Log.d(TAG, message)
    }

    companion object {
        const val TAG = "AnimationByCodeActivity"
    }
}
