package aleksey.vasiliev.lab3_5

import android.content.Intent
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.fragment.app.FragmentActivity

object Shared {
    @Composable
    fun BottomNavigationBar(activity: FragmentActivity) {
        BottomNavigation(
            backgroundColor = colorResource(id = R.color.design_default_color_primary),
            contentColor = Color.White
        ) {
            BottomNavigationItem(
                icon = { Icon(Icons.Rounded.Menu, contentDescription = "About") },
                label = { Text(text = "About") },
                selectedContentColor = Color.White,
                unselectedContentColor = Color.White.copy(0.4f),
                alwaysShowLabel = true,
                selected = false,
                onClick = {
                    activity.startActivity(Intent(activity, About::class.java))
                }
            )
        }
    }
}