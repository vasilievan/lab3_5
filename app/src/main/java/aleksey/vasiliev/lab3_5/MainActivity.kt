package aleksey.vasiliev.lab3_5

import android.os.Bundle
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.FragmentActivity

class MainActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            setContentView(
                ComposeView(this).apply {
                    id = R.id.activity_main
                }
            )
            supportFragmentManager.beginTransaction().add(android.R.id.content, FirstFragment())
                .commit()
        }
    }

    override fun onBackPressed() {
        finish()
        super.onBackPressed()
    }
}