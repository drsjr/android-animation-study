package tour.donnees.animationstudy

import android.animation.*
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationSet
import android.view.animation.BounceInterpolator
import android.view.animation.OvershootInterpolator
import kotlinx.android.synthetic.main.activity_choreographing_animation.*

class ChoreographingAnimationActivity : BaseActivity() {

    private var scaleObjectAnimator: ObjectAnimator? = null
    private var rotateObjectAnimator: ObjectAnimator? = null
    private var translateObjectAnimator: ObjectAnimator? = null
    private var fadeObjectAnimator: ObjectAnimator? = null

    private val fadeAnimator: Animator by lazy { AnimatorInflater.loadAnimator(this, R.animator.alpha) }
    private val rotateAnimator: Animator by lazy { AnimatorInflater.loadAnimator(this, R.animator.rotate) }
    private val scaleAnimator: Animator by lazy { AnimatorInflater.loadAnimator(this, R.animator.scale) }
    private val translateAnimator: Animator by lazy { AnimatorInflater.loadAnimator(this, R.animator.translate) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choreographing_animation)


        view_pro_ani.setOnClickListener {
            viewPropertyAnimator(hello_ca)
        }

        pro_vle_hol.setOnClickListener {
            propertyValueHolder(hello_ca)
        }

        set_ca_c.setOnClickListener {
            setByCode(hello_ca)
        }

        set_ca_x.setOnClickListener {
            setByXML(hello_ca)
        }

        scale_ca_c.setOnClickListener {
            scaleAnimation(hello_ca)
        }

        rotate_ca_c.setOnClickListener {
            rotateAnimation(hello_ca)
        }

        translate_ca_c.setOnClickListener {
            translateAnimation(hello_ca)
        }

        fade_ca_c.setOnClickListener {
            fadeAnimation(hello_ca)
        }

        fade_ca_x.setOnClickListener {
            fadeAnimator.apply {
                setTarget(hello_ca)
                start()
            }
        }

        rotate_ca_x.setOnClickListener {
            rotateAnimator.apply {
                setTarget(hello_ca)
                start()
            }
        }

        scale_ca_x.setOnClickListener {
            scaleAnimator.apply {
                setTarget(hello_ca)
                start()
            }
        }

        translate_ca_x.setOnClickListener {
            translateAnimator.apply {
                setTarget(hello_ca)
                start()
            }
        }
    }

    fun viewPropertyAnimator(view: View) {
        val vpa = view.animate()
        vpa.apply {
            duration = 1000
            rotationX(360.0f)
            scaleX(1.5f)
            scaleY(1.5f)
            translationX(200.0f)
            alpha(.5f)
            interpolator = OvershootInterpolator()
            start()
        }
    }

    fun propertyValueHolder(view: View) {
        val rotateX = PropertyValuesHolder.ofFloat("rotationX", 360.0f)
        val scaleX = PropertyValuesHolder.ofFloat("scaleX", 2.0f)
        val scaleY = PropertyValuesHolder.ofFloat("scaleY", 2.0f)

        val objAni = ObjectAnimator.ofPropertyValuesHolder(view, rotateX, scaleX, scaleY)
        objAni.apply {
            duration = 500
            interpolator = OvershootInterpolator()
            start()
        }

    }

    fun setByXML(view: View) {
        val animator = AnimatorInflater.loadAnimator(this, R.animator.set)
        animator.apply {
            setTarget(view)
            start()
        }
    }

    fun setByCode(view: View) {

        val rootSet = AnimatorSet()

        val flip = ObjectAnimator.ofFloat(view, "rotationX", 0.0f, 360.0f)
        flip.duration = 500

        val childSet = AnimatorSet()

        val scaleX = ObjectAnimator.ofFloat(view, "scaleX", 1.0f, 1.5f)
        scaleX.duration = 500
        scaleX.interpolator = OvershootInterpolator()

        val scaleY = ObjectAnimator.ofFloat(view, "scaleY", 1.0f, 1.5f)
        scaleY.duration = 500
        scaleY.interpolator = OvershootInterpolator()

        //rootSet.playSequentially(flip, childSet)
        //childSet.playTogether(scaleX, scaleY)

        rootSet.play(flip).before(childSet)
        childSet.play(scaleX).with(scaleY)

        rootSet.start()

    }

    private fun scaleAnimation(view: View?) {
        rotateObjectAnimator = ObjectAnimator.ofFloat(view, "scaleX", 1.0f, 3.0f)
        rotateObjectAnimator?.apply {
            duration = 1000
            repeatCount = 1
            repeatMode = ValueAnimator.REVERSE
            addListener(this@ChoreographingAnimationActivity)
            start()
        }
    }

    private fun rotateAnimation(view: View?) {
        rotateObjectAnimator = ObjectAnimator.ofFloat(view, "rotation", 0.0f, -180.0f)
        rotateObjectAnimator?.apply {
            duration = 1000
            repeatCount = 1
            repeatMode = ValueAnimator.REVERSE
            addListener(this@ChoreographingAnimationActivity)
            start()
        }

    }

    private fun translateAnimation(view: View?) {
        rotateObjectAnimator = ObjectAnimator.ofFloat(view, "translationX", 0.0f, 200.0f)
        rotateObjectAnimator?.apply {
            duration = 1000
            repeatCount = 1
            repeatMode = ValueAnimator.REVERSE
            addListener(this@ChoreographingAnimationActivity)
            start()
        }
    }

    private fun fadeAnimation(view: View?) {
        fadeObjectAnimator = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f)
        fadeObjectAnimator?.apply {
            duration = 1000
            repeatCount = 1
            repeatMode = ValueAnimator.REVERSE
            addListener(this@ChoreographingAnimationActivity)
            start()
        }
    }

    override fun message(message: String, animation: Animator?) {
        when(animation) {
            rotateAnimator -> message("Rotate $message: ${animation.hashCode()}")
            translateAnimator -> message("Translate $message: ${animation.hashCode()}")
            scaleAnimator -> message("Scale $message: ${animation.hashCode()}")
            fadeAnimator -> message("Fade $message: ${animation.hashCode()}")

            rotateObjectAnimator -> message("Rotate $message: ${animation.hashCode()}")
            translateObjectAnimator -> message("Translate $message: ${animation.hashCode()}")
            scaleObjectAnimator -> message("Scale $message: ${animation.hashCode()}")
            fadeObjectAnimator -> message("Fade $message: ${animation.hashCode()}")
        }
    }
}

