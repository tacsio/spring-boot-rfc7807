# Spring Boot 3 :: RFC 7807

Implementing simple API to
show [ProblemDetail](https://docs.spring.io/spring-framework/docs/6.0.0-M3/javadoc-api/org/springframework/http/ProblemDetail.html)
class.

### Call API

Making a request with capital name works fine!

> ```http :8080/greeting/Tarcisio```

```
HTTP/1.1 200 
Connection: keep-alive
Content-Length: 15
Content-Type: text/plain;charset=UTF-8
Date: Fri, 25 Nov 2022 18:34:04 GMT
Keep-Alive: timeout=60

Hello, Tarcisio
```
Making a request without capital name throws error, that will be handled by controller advice

> ```http :8080/greeting/tarcisio``` 

```
HTTP/1.1 400 
Connection: close
Content-Type: application/problem+json
Date: Fri, 25 Nov 2022 18:35:28 GMT
Transfer-Encoding: chunked

{
    "detail": "Invalid arguments. Must start with capital letter",
    "instance": "/greeting/tarcisio",
    "status": 400,
    "title": "Bad Request",
    "type": "parameters"
}

```