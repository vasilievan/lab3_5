package aleksey.vasiliev.lab3_5

import android.os.Bundle
import androidx.fragment.app.FragmentActivity

class FirstActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().add(android.R.id.content, FirstFragment())
                .commit()
        }
    }

    override fun onBackPressed() {
        finish()
        super.onBackPressed()
    }
}