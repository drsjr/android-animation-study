package tour.donnees.animationstudy.transition

import android.app.ActivityOptions
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import tour.donnees.animationstudy.R

class TransitionListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        // Most be called before setContent
        window.requestFeature(Window.FEATURE_CONTENT_TRANSITIONS)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transition_list)
    }

    fun onClick(v: View) {
        val i = findViewById<View>(R.id.imgTaj)
        val t = findViewById<View>(R.id.txvTaj)

        val imagePair = android.util.Pair<View, String>(i, "sharedImage")
        val textPair = android.util.Pair<View, String>(t, "sharedTitle")

        val options = ActivityOptions.makeSceneTransitionAnimation(this@TransitionListActivity, imagePair, textPair)
        val intent =  Intent(this@TransitionListActivity, TransitionDetailActivity::class.java)
        startActivity(intent, options.toBundle())
    }
}
