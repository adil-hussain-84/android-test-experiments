package androidx.test.experiments.app4

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.test.experiments.app4.theme.AppTheme

@Composable
fun CountView(modifier: Modifier = Modifier) {
    var count by rememberSaveable { mutableIntStateOf(0) }

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(4.dp),
    ) {
        Text(text = "This is the count view")
        Text(
            text = "Count is $count",
            style = MaterialTheme.typography.bodyLarge,
        )
        Button(onClick = { count++ }) {
            Text(text = "Increment count")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CountViewPreview() {
    AppTheme {
        CountView()
    }
}
