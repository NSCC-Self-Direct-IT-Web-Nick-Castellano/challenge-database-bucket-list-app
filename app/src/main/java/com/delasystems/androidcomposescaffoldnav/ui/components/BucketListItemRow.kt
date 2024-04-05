package com.delasystems.androidcomposescaffoldnav.ui.components

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Checkbox
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.delasystems.androidcomposescaffoldnav.data.models.BucketListItem

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BucketListItemRow(
    item: BucketListItem,
    onCheckboxChange: (BucketListItem) -> Unit,
    onItemClick: (BucketListItem) -> Unit,
) {


    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)

    ) {
        Text(
            text = item.title,
            style = MaterialTheme.typography.subtitle1.copy(fontSize = 20.sp),

            modifier = Modifier
                .weight(1f)
                .padding(end = 8.dp)
                .clickable {
                    Log.d("UI_Event", "Clicked on a list item")
                    onItemClick(item)
                }
                .align(Alignment.CenterVertically)
        )
        Checkbox(
            checked = item.isCompleted,
            onCheckedChange = { onCheckboxChange(item) }
        )
    }



}