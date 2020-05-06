package tour.donnees.animationstudy

import android.animation.Animator
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity: AppCompatActivity(), Animator.AnimatorListener {

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

    abstract fun message(message: String, animation: Animator?) /*{
        when(animation) {
            rotateAnimator -> message("Rotate $message: ${animation.hashCode()}")
            translateAnimator -> message("Translate $message: ${animation.hashCode()}")
            scaleAnimator -> message("Scale $message: ${animation.hashCode()}")
            fadeAnimator -> message("Fade $message: ${animation.hashCode()}")
        }
    }*/

    fun message(message: String) {
        Log.d(AnimationEventActivity.TAG, message)
    }

}