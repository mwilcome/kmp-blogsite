package com.mikewilcome.kmp.content

object ContentCatalog {

    private val welcome: ContentDocument =
        ContentDocument(
            schemaVersion = 1,
            id = "welcome",
            title = "Welcome",
            meta = "Last updated: 2026-01-09",
            blocks = arrayOf(
                ContentBlock.paragraph("This project shares core logic in Kotlin Multiplatform."),
                ContentBlock.paragraph("Android renders UI with Compose. The web client will render UI with Angular."),
                ContentBlock.paragraph("Some content is easier to maintain in one place. This screen is an example: the same text is provided by shared-logic."),
                ContentBlock.paragraph("The goal here is consistency and reuse, not legal wording."),
                ContentBlock.paragraph("Select Continue to enter the app."),
            )
        )

    private val quickStart: ContentDocument =
        ContentDocument(
            schemaVersion = 1,
            id = "quick_start",
            title = "Quick Start",
            meta = null,
            blocks = arrayOf(
                ContentBlock.paragraph("Use this project like a playground: read the notes, then try the interactive pieces."),
                ContentBlock.numberedList(
                    arrayOf(
                        "Open Labs and pick a topic.",
                        "Read the description first.",
                        "Use the controls and observe how state changes.",
                        "Return to the hub and repeat.",
                    )
                )
            )
        )

    fun getDocument(id: String): ContentDocument? =
        when (id) {
            "welcome" -> welcome
            "quick_start" -> quickStart
            else -> null
        }
}
