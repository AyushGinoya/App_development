import 'package:flutter/material.dart';

void main() {
  runApp(const MaterialApp(
    home: Home(),
  ));
}

class Home extends StatefulWidget {
  const Home({Key? key}) : super(key: key); // Corrected the constructor

  @override
  State<Home> createState() => _HomeState();
}

class _HomeState extends State<Home> {
  int count = 0;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('StatefulWidget'),
        centerTitle: true,
      ),
      body: Center(
        child: Row(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            ElevatedButton(
              onPressed: () {
                setState(() {
                  count--;
                });
              },
              child: const Text('-'),
              style: ButtonStyle(
                minimumSize: MaterialStateProperty.all(Size(20, 50)),
              ),
            ),
            const SizedBox(
              width: 20,
            ),
            Container(
              width: 200,
              height: 50,
              color: Color.fromARGB(200, 235, 83, 7),
              child: Center(child: Text("$count")),
            ),
            const SizedBox(
              width: 20,
            ),
            ElevatedButton(
              onPressed: () {
                setState(() {
                  count++;
                });
              },
              child: const Text('+'),
              style: ButtonStyle(
                minimumSize: MaterialStateProperty.all(Size(20, 50)),
              ),
            ),
          ],
        ),
      ),
    );
  }
}
