import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

class HomeScreen extends StatefulWidget {
  const HomeScreen({super.key});

  @override
  State<HomeScreen> createState() => _HomeScreenState();
}

class _HomeScreenState extends State<HomeScreen> {
  var channel = const MethodChannel('MY_CHANNEL_NAME');

  Future<void> showToast() async {
    await channel.invokeMethod(
      "SHOW_TOAST_FROM_NATIVE_SIDE",
      {"message": "My message from Flutter side!"},
    );
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Native Toast'),
        centerTitle: true,
      ),
      body: Center(
        child: ElevatedButton(
          onPressed: showToast,
          child: const Text('Show Toast'),
        ),
      ),
    );
  }
}
