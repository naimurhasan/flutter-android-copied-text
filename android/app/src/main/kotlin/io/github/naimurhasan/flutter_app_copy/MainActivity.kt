package io.github.naimurhasan.flutter_app_copy

import androidx.annotation.NonNull
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.MethodChannel
import android.content.Intent

class MainActivity: FlutterActivity() {
    private val CHANNEL = "samples.flutter.dev/battery"

    override fun configureFlutterEngine(@NonNull flutterEngine: FlutterEngine) {
        super.configureFlutterEngine(flutterEngine)
        MethodChannel(flutterEngine.dartExecutor.binaryMessenger, CHANNEL).setMethodCallHandler {
            call, result ->

            if (intent.action == Intent.ACTION_PROCESS_TEXT) {
                val selectedText = intent.getStringExtra(Intent.EXTRA_PROCESS_TEXT) ?: ""
                result.success(selectedText)
            }else{
                result.success("25")
            }


            // Note: this method is invoked on the main thread.
            // TODO
        }
    }
}