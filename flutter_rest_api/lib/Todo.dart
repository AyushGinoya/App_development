import 'dart:convert';

import 'package:http/http.dart';

class Todo {
  String id;
  String title = "";
  bool completed = false;

  Todo({required this.id});

  Future<void> getApiData() async {
    try {
      var url = Uri.https('jsonplaceholder.typicode.com', '/todos/$id');
      Response response = await get(url);
      Map todo = jsonDecode(response.body);
      title = todo['title'];
      completed = todo['completed'];
    } catch (e) {
      print("Error : $e");
      title = 'Error in API called';
    }
  }
}
