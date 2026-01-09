package com.mikewilcome.kmp.sharedui.content

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.mikewilcome.kmp.content.ContentBlock
import com.mikewilcome.kmp.content.ContentDocument

@Composable
fun ContentDocumentView(
    doc: ContentDocument,
    contentPadding: PaddingValues = PaddingValues(24.dp),
) {
    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        contentPadding = contentPadding
    ) {
        item {
            Text(
                text = doc.title,
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            doc.meta?.let {
                Text(
                    text = it,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
            }
        }

        itemsIndexed(doc.blocks) { _, block ->
            when (block.type) {
                "heading" -> HeadingBlock(block)
                "paragraph" -> ParagraphBlock(block)
                "numbered_list" -> NumberedListBlock(block)
                else -> {
                    // Unknown block type: ignore
                }
            }
        }
    }
}

@Composable
private fun HeadingBlock(block: ContentBlock) {
    val level = block.level ?: 2
    val style =
        when (level) {
            1 -> MaterialTheme.typography.headlineSmall
            2 -> MaterialTheme.typography.titleLarge
            else -> MaterialTheme.typography.titleMedium
        }

    Text(
        text = block.text.orEmpty(),
        style = style,
        modifier = Modifier.padding(top = 16.dp, bottom = 8.dp)
    )
}

@Composable
private fun ParagraphBlock(block: ContentBlock) {
    Text(
        text = block.text.orEmpty(),
        style = MaterialTheme.typography.bodyLarge,
        modifier = Modifier.padding(bottom = 12.dp)
    )
}

@Composable
private fun NumberedListBlock(block: ContentBlock) {
    val items = block.items ?: emptyArray()
    items.forEachIndexed { index, text ->
        Text(
            text = "${index + 1}. $text",
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Normal,
            modifier = Modifier.padding(bottom = 8.dp)
        )
    }
}
