/**
* Protocol.java
* Defines the communication protocol used between the 
* Math server and its clients.
*/
public class Protocol {

  /** Client to Server*/
  public static final String JOIN = “JOIN”;
  /** Server to Client*/
  public static final String ACK = “ACK”;
  /** Client to Server*/
  public static final String REQUEST = “REQUEST”;
  /** Server to Client*/
  public static final String RESPONSE = “RESPONSE”;
  /** Server to Client*/
  public static final String ERROR = “ERROR”;
  /** Client to Server*/
  public static final String QUIT = “QUIT”;
  
  private static final String SEPARATOR = “|”;

  /** Building a JOIN message.
  * @param the client's display name
  * @return formatted JOIN message
  */
  public static String joinMessage(String name) {
    return build(JOIN, name);
    }
  
  /** Building a ACK message.
  * @param the acknowledgment text shown to the client
  * @return formatted ACK message
  */
  public static String ackMessage(String text) {
    return build(ACK, text);
    }

  /** Building a REQUEST message.
  * @param the math expression requested by the client
  * @return formatted REQUEST message
  */
  public static String requestMessage(String expression) {
    return build(REQUEST, expression);
    }

  /** Building a RESPONSE message.
  * @param the evaluated result string
  * @return formatted RESPONSE message
  */  
  public static String responseMessage(String result) {
    return build(RESPONSE, result);
    }

  /** Building a ERROR message.
  * @param the error message of what went wrong
  * @return formatted ERROR message
  */
  public static String errorMessage(String reason) {
    return build(ERROR, reason);
    }
  
  /** Building a QUIT message.
  * @param the client's display name
  * @return formatted QUIT message
  */
  public static String quitMessage(String name) {
    return build(QUIT, name);
    }

  //-----------------------------------------------
  // Parsing helpers
  //-----------------------------------------------

  /**
  * Extracting the TYPE section from a raw message line.
  * @param rawMessage the complete msg string from the socket
  * @return the type token of the message or the full string 
  * if no '|' is found.
  */
  public static String getType(String rawMessage) {
    if (rawMessage == null) return “”;
    int idx = rawMessage.indexOf(SEPARATOR);
    if (idx == -1) {
    return rawMessage.trim();   // no separator
    }
    return rawMessage.substring(0, idx).trim();
    }

  /**
  * Extracting the PAYLOAD section from a raw message line.
  * @param rawMessage the complete msg string from the socket
  * @return the payload after the first '|', if absent then empty string
  */
  public static String getPayload(String rawMessage) {
    if (rawMessage == null) return “”;
    int idx = rawMessage.indexOf(SEPARATOR);
    if (idx == -1 || idx == rawMessage.length() - 1) {
    return “”;   // no separator
    }
    return rawMessage.substring(idx + 1).trim();
    }

  /** 
  * Private helper
  * Combines a type and a payload into a single formatted string.
  * @param the message type constant
  * @param the message body
  * @return formatted message to be sent over the socket
  */
  private static String build(String type, String payload) {
    return type + SEPARATOR + payload;
    }
  }
