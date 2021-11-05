package aleksey.vasiliev.lab3_5

import aleksey.vasiliev.lab3_5.Shared.BottomNavigationBar
import aleksey.vasiliev.lab3_5.ui.theme.Lab3_5Theme
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

class About : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab3_5Theme {
                Scaffold(
                    topBar = { TopAppBar(title = { Text("About") }) },
                    bottomBar = { BottomNavigationBar(this) },
                    content = { Spacer(modifier = Modifier.fillMaxSize()) }
                )
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        Lab3_5Theme {
            BottomNavigationBar(this)
        }
    }

    override fun onBackPressed() {
        finish()
        super.onBackPressed()
    }
}