# MyWebFluxSample
- Used SpringWebFlux default with Netty Server

## LinkedHashMap
Coded as test file. JUnit test cases notes the difference between HashMap and LinkedHasMap
Please run the test cases in
```
src/test/java/com/chandra/mywebfluxsamples/LinkedHashMapTest.java
```

## Reflection
1. Created a Runtime annotation InjectHelloHuman
2. Set that annotation to src/main/java/com/chandra/mywebfluxsamples/model/Message.java
3. Set the value read from annotation to the Pojo using reflection. Code present in src/main/java/com/chandra/mywebfluxsamples/services/impl/MessagesFromOtherWorldImpl.java
4. Please see the method readAnnotations

## CSV File
1. Used a csv file available for download on the Internet. File name is "100 Records.csv"
2. To stream the employees
```
GET method
http://localhost:8080/streamEmployees
```

3. To get all employees in a bulk
```
GET method
http://localhost:8080/bulkReadEmployees
```

```
Note: To check the stream in action, do not use Postman, you need to use curl command to read 
the stream. You can still see the output in Postman but time lapse is high as Postman pools the 
result and displays it
```

## Consuming a third party api
1. Created a mock api
```
GET methods
http://demo2852868.mockable.io/
```

2. Consumed the mock api using WebFlux client
```
src/main/java/com/chandra/mywebfluxsamples/services/impl/MessagesFromOtherWorldImpl.java
```

3. Use the below end point in Postman to see the result
```
GET method
http://localhost:8080/getMessageFromMockIO
```
