package com.mikewilcome.kmp.content

import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport

/**
 * JS-friendly: primitives + String + Array + nullable fields.
 */
@OptIn(ExperimentalJsExport::class)
@JsExport
class ContentDocument(
    val schemaVersion: Int,
    val id: String,
    val title: String,
    val meta: String?,
    val blocks: Array<ContentBlock>,
)

@OptIn(ExperimentalJsExport::class)
@JsExport
class ContentBlock(
    /**
     * "heading" | "paragraph" | "numbered_list"
     */
    val type: String,

    // for heading + paragraph
    val text: String?,

    // for heading
    val level: Int?,

    // for numbered_list
    val items: Array<String>?,
) {
    companion object {
        fun heading(text: String, level: Int = 2): ContentBlock =
            ContentBlock(type = "heading", text = text, level = level, items = null)

        fun paragraph(text: String): ContentBlock =
            ContentBlock(type = "paragraph", text = text, level = null, items = null)

        fun numberedList(items: Array<String>): ContentBlock =
            ContentBlock(type = "numbered_list", text = null, level = null, items = items)
    }
}
