package com.mikewilcome.kmp

import com.mikewilcome.kmp.content.ContentCatalog
import com.mikewilcome.kmp.content.ContentDocument
import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport

@OptIn(ExperimentalJsExport::class)
@JsExport
object SharedApi {
    fun add(a: Int, b: Int): Int = a + b
    fun subtract(a: Int, b: Int): Int = a - b

    /**
     * Shared-logic owned content accessible to both Compose and JS/Angular.
     */
    fun getDocument(id: String): ContentDocument? = ContentCatalog.getDocument(id)
}
