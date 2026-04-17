# math-server-java
 
A multi-client math server built in Java using TCP sockets. The server accepts connections from multiple clients simultaneously, evaluates math expressions sent by clients, and returns the results. Built for CE/CS 4390 Computer Networks, Spring 2026.
 
## Features
- Multi-client support using multithreading (one thread per client)
- Interactive client prompt for sending math expressions
- Supports `+` `-` `*` `/` `%` `^` and parentheses with correct operator precedence
- Server logs all client activity (connect time, requests, disconnect time, session duration) to console and `server_log.txt`
## Files
- `Protocol.java` — message format and parsing
- `Request.java` — represents a parsed message
- `Calculator.java` — evaluates math expressions
- `ClientHandler.java` — manages a single client connection on its own thread
- `Server.java` — accepts connections and handles logging
- `Client.java` — interactive client that connects to the server
## How to Run
 
Compile:
```
javac Protocol.java Request.java Calculator.java ClientHandler.java Server.java Client.java
```
Start the server:
```
java Server
```
Start a client:
```
java Client <name>
```
Type a math expression at the prompt and press Enter. Type `quit` to disconnect.
