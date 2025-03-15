package com.kp.documentscanner

import android.os.Bundle
import android.widget.Button
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.IntentSenderRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.contract.ActivityResultContracts.*
import androidx.appcompat.app.AppCompatActivity
import com.google.mlkit.vision.documentscanner.GmsDocumentScannerOptions
import com.google.mlkit.vision.documentscanner.GmsDocumentScannerOptions.RESULT_FORMAT_JPEG
import com.google.mlkit.vision.documentscanner.GmsDocumentScannerOptions.RESULT_FORMAT_PDF
import com.google.mlkit.vision.documentscanner.GmsDocumentScannerOptions.SCANNER_MODE_FULL
import com.google.mlkit.vision.documentscanner.GmsDocumentScanning
import com.google.mlkit.vision.documentscanner.GmsDocumentScanningResult


class MainActivity : AppCompatActivity() {
    private var scannerLauncher: ActivityResultLauncher<IntentSenderRequest>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var button = findViewById<Button>(R.id.clickButton);
        button.setOnClickListener { openDocumentScanner() }
        scannerLauncher =
            registerForActivityResult(StartIntentSenderForResult(), this::handleActivityResult)
    }

    fun openDocumentScanner()
    {
        val options = GmsDocumentScannerOptions.Builder()
            .setGalleryImportAllowed(false)
            .setPageLimit(2)
            .setResultFormats(RESULT_FORMAT_JPEG, RESULT_FORMAT_PDF)
            .setScannerMode(SCANNER_MODE_FULL)
            .build()

        val scanner = GmsDocumentScanning.getClient(options)
        scanner.getStartScanIntent(this)
            .addOnSuccessListener { intentSender ->
                scannerLauncher?.launch(IntentSenderRequest.Builder(intentSender).build())
            }
    }

    fun handleActivityResult(activityResult: ActivityResult) {
        if (activityResult.resultCode == RESULT_OK) {
            val result =
                GmsDocumentScanningResult.fromActivityResultIntent(activityResult.data)
            result?.getPages()?.let { pages ->
                for (page in pages) {
                    val imageUri = pages.get(0).getImageUri()
                }
            }
            result?.getPdf()?.let { pdf ->
                val pdfUri = pdf.getUri()
                val pageCount = pdf.getPageCount()
            }
        }
    }
}