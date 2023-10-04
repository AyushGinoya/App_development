import 'package:flutter/material.dart';
import 'package:flutter_rest_api/Todo.dart';

void main() => runApp(const MyApp());

class MyApp extends StatelessWidget {
  const MyApp({super.key});
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      theme: ThemeData(
        colorScheme: ColorScheme.fromSeed(seedColor: Colors.deepPurple),
        useMaterial3: true,
      ),
      home: const MyHomePage(title: 'Flutter Demo Home Page'),
    );
  }
}

class MyHomePage extends StatefulWidget {
  const MyHomePage({super.key, required this.title});

  final String title;

  @override
  State<MyHomePage> createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  String title = "Loading.........";
  String completed = "Loading...........";
  void getApiData() async {
    await Future.delayed(const Duration(seconds: 3), () {
      print("Tell my friend to Walk up me After 3 Hour(API called)");
    });

    Future.delayed(const Duration(seconds: 6), () {
      print('Tell my friend After 2 hour turn off AC(API 2 called)');
    });

    print('I am going to drink water(After API called)');
  }

  void getStateInfo() async {
    String state = await Future.delayed(const Duration(seconds: 5), () {
      return "Gujrat";
    }) as String;

    int highTemp = await Future.delayed(const Duration(seconds: 3), () {
      return 43;
    }) as int;

    print("State = ${state}      highTemp = ${highTemp}");
  }

//body responce that we get is String not a object.It is JSON object as String.
//so we need to convert into Object.=========> use decode method
  // getJsonData() async {
  //   var url = Uri.https('jsonplaceholder.typicode.com', '/todos/1');
  //   Response response = await get(url);
  //   print('Response is............. ');
  //   //print(response.body);
  //   Map todo = jsonDecode(response.body);
  //   //print(todo);
  //   print(todo['id']);
  //   print(todo['title']);
  //   print(todo['completed'].toString()); //needed convert bool into string
  // }

  void setTodo() async {
    Todo todo = Todo(id: '2');
    await todo.getApiData();
    setState(() {
      //========>change the state of variable
      title = todo.title;
      completed = todo.completed.toString();
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Flatteriyo'),
        centerTitle: true,
      ),
      body: Column(
        children: [
          Padding(
            padding: const EdgeInsets.all(8.0),
            child: Text('Title = ${title}'),
          ),
          Padding(
            padding: const EdgeInsets.all(8.0),
            child: Text('Completed = ${completed}'),
          )
        ],
      ),
    );
  }

  @override
  void initState() {
    // TODO: implement initState
    super.initState();
    //getApiData();
    //getStateInfo();   //async and non-blocking
    //print('After getStateInfo()');
    //getJsonData();
    setTodo();
  }
}
