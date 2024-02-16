package androidx.test.experiments.app4

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.test.experiments.app4.theme.AppTheme

@Composable
fun MainView(modifier: Modifier = Modifier,
             onShowCountActivityRequest: () -> Unit) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text(text = "This is the main view")
        Button(onClick = { onShowCountActivityRequest() }) {
            Text(text = "Show count view")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainViewPreview() {
    AppTheme {
        MainView(onShowCountActivityRequest = {})
    }
}
