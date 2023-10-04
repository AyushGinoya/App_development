import 'package:flutter/material.dart';

//runApp()
/* runApp function is the entry point for the Flutter application. 
It takes a Widget as a parameter and starts the application, 
rendering the specified widget as the root of the widget tree. */

//MaterialApp()
/* MaterialApp is a widget that implements the basic material design visual structure. 
key Properties and Functionalities of MaterialApp:
1)home - It's the first screen users see when they launch the app. - in given file we use Text widget
2)routes
3)theme
4)title
*/

//Scaffold ()
/* 
It implement basic material Design visual layout structure.
--->Properties
1)AppBar
  -title
  -center title (boolean)
2)Drawer
3)BottomNavigationBar
4)FloatingActionButton
*/

void main() {
  runApp(MaterialApp(
    home: Center(child: Hone()),
  ));
}

//StatelessWidget Vs StatefulWidget
/* 
1)StatelessWidget
-StatelessWidget is a widget that does not require mutable state. 
 It means that once a StatelessWidget is built, it cannot change its internal state or appearance. 
 It's immutable. Stateless widgets are used for parts of the user interface that don't 
 change dynamically based on user interactions or other factors.
-state of widget can not change over time
-any of the following or other things are final and cannot change
  -Layout
  -Color
  -Data
#)When to Use StatelessWidget:
I)If a part of your UI doesn't change based on user input or other events.
II)When you have a simple, static UI component that doesn't need to be redrawn over time.
III)Stateless widgets are typically more efficient than stateful widgets because they don't 
    need to rebuild when the parent widget rebuilds.

2)StatefulWidget
-StatefulWidget can be rebuilt multiple times, and its appearance can change based on user
 interactions, animations, or other events. Stateful widgets are used for UI components that
 need to be updated dynamically.

#)When to Use StatefulWidget:
I)If a part of your UI needs to change based on user input, data changes, or any other events.
II)When you want to manage and update the widget's state over time.
-state of widget can change over time
-Layout or data inside widget can change over time
*/

//build method
/* 
-It's where you define the structure of your widget and
 return the widget tree that represents the component's UI.

##StatelessWidget
-StatelessWidget doesn't have mutable state, the UI components
 it builds remain static after the initial rendering

##StatefulWidget
-the build method is called whenever the widget's state changes. 
-You define the mutable state in the associated State class and update it within this class.
-When you call setState(), it triggers a rebuild of the widget, causing the build method to be called again.
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
      body: const Padding(
        padding: EdgeInsets.all(4.0),
        child: Center(
          child: Column(
            children: [
              Padding(
                  padding: EdgeInsets.all(16.0),
                  child: Text("Hello Flutteriya")),
              Padding(
                padding: EdgeInsets.all(16.0),
                child: Image(
                  image: NetworkImage(
                      "https://tse4.mm.bing.net/th?id=OIP.rvSWtRd_oPRTwDoTCmkP5gHaE8&pid=Api&P=0&h=180"),
                ),
              ),
              Padding(
                padding: EdgeInsets.all(16.0),
                child: SingleChildScrollView(
                  child: Image(
                    image: AssetImage('assets/th.jpeg'),
                    // width: 300,
                    // height: 300,
                    fit: BoxFit.cover,
                  ),
                ),
              ),
            ],
          ),
        ),
      ),
      floatingActionButton: FloatingActionButton(
        onPressed: () {
          print('Button pressed');
        },
        child: const Text("❤️"),
      ),
    );
  }
}
