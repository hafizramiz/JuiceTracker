package com.example.juicetracker

import android.graphics.Color
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScopeInstance.weight
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.juicetracker.ui.bottomsheet.InputRow

fun main() {

}

@Composable
fun Deneme(
    a: Int,
    b: String,
    content: @Composable ()->Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "inputLabel",
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.weight(1f)
        )
        content()
    }
}


@Preview(showBackground = true)
@Composable
fun ShowDeneme(){
    Deneme(a = 10, b = "11") {
            Text(text = "aaa",fontWeight = FontWeight.SemiBold,)
            Text(text = "bbb",fontWeight = FontWeight.SemiBold,)
    }

//    InputRow(inputLabel = "bos") {
//
//    }
}






