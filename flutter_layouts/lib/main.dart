import 'package:flutter/material.dart';

void main() {
  runApp(const MaterialApp(
    home: Center(child: Hone()),
  ));
}

//Container()
/*
 a Container is a widely used widget that allows you to create a box model UI design.
 #)key properties 
 -Decoration
 -Width and Height: 
 -Color
 -Padding
 -Alignment
 -Child
*/
class Hone extends StatelessWidget {
  const Hone({super.key});

  @override
  Widget build(BuildContext context) {
    // Widget build method defines the structure of your widget
    return Scaffold(
      appBar: AppBar(
        title: const Text("Flutter Boy"),
        centerTitle: true,
      ),
      body: Row(
        //mainAxisAlignment: MainAxisAlignment.end,
        mainAxisAlignment: MainAxisAlignment.center,
        //mainAxisAlignment: MainAxisAlignment.spaceBetween,
        //mainAxisAlignment: MainAxisAlignment.spaceAround,
        //mainAxisAlignment: MainAxisAlignment.spaceEvenly,
        //crossAxisAlignment: CrossAxisAlignment.stretch,
        crossAxisAlignment: CrossAxisAlignment.end,
        //crossAxisAlignment: CrossAxisAlignment.start,
        //crossAxisAlignment: CrossAxisAlignment.center,
        children: [
          Expanded(
            flex: 1, // This widget takes 1 part of the available space
            child: Container(
              width: 200,
              height: 100,
              color: Colors.red,
              child: const Text('1'),
            ),
          ),
          Expanded(
            flex: 4, // This widget takes 4 part of the available space
            child: Container(
              width: 200,
              height: 80,
              color: Colors.green,
              child: const Text('2'),
            ),
          ),
          Expanded(
            flex: 3, // This widget takes 3 part of the available space
            child: Container(
              width: 200,
              height: 120,
              color: Colors.blue,
              child: const Text('3'),
            ),
          ),
          Expanded(
            flex: 4, // This widget takes 4 part of the available space.
            child: Container(
              width: 200,
              height: 60,
              color: Colors.orange,
              child: const Text('4'),
            ),
          ),
        ],
      ),

      // Center(
      //   child: Container(
      //     color: const Color.fromRGBO(8, 4, 228, 0.904),
      //     //padding: const EdgeInsets.symmetric(vertical: 200, horizontal: 100.0),
      //     //padding: EdgeInsets.fromLTRB(10.0, 20.0, 40.0, 50.0),
      //     padding: const EdgeInsets.all(30.0),
      //     margin: const EdgeInsets.all(30.0),
      //     child: const Text("Hello Flutter"),
      //   ),
      // ),
      floatingActionButton: FloatingActionButton(
        onPressed: () {
          print('Button pressed');
        },
        child: const Text("❤️"),
      ),
    );
  }
}
