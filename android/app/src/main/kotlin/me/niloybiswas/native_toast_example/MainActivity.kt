package me.niloybiswas.native_toast_example

import android.widget.Toast
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.MethodChannel

class MainActivity: FlutterActivity() {

    private val channelName = "MY_CHANNEL_NAME"

    override fun configureFlutterEngine(flutterEngine: FlutterEngine) {
        super.configureFlutterEngine(flutterEngine)

        var channel = MethodChannel(flutterEngine.dartExecutor.binaryMessenger, channelName);

        channel.setMethodCallHandler { call, result ->

            val args = call.arguments as Map<*, *>
            val message = args["message"]

            if (call.method == "SHOW_TOAST_FROM_NATIVE_SIDE") {
                //Toast.makeText(this, "Toast from Native Android Side", Toast.LENGTH_LONG).show();
                Toast.makeText(this, message.toString(), Toast.LENGTH_LONG).show();
            }

        }
    }
}
