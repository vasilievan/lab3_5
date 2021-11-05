package aleksey.vasiliev.lab3_5

import aleksey.vasiliev.lab3_5.Shared.BottomNavigationBar
import aleksey.vasiliev.lab3_5.ui.theme.Lab3_5Theme
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment

class FirstFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(
                ViewCompositionStrategy.DisposeOnLifecycleDestroyed(viewLifecycleOwner)
            )
            setContent {
                Lab3_5Theme {
                    Scaffold(
                        topBar = { TopAppBar(title = { Text("First") }) },
                        bottomBar = { BottomNavigationBar(activity = requireActivity()) },
                        content = { Layout() })
                }
            }
        }
    }

    @Composable
    fun Layout() {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Button(onClick = {
                parentFragmentManager.beginTransaction()
                    .replace(android.R.id.content, SecondFragment()).commit()
            }) {
                Text("Second")
            }
        }
    }
}