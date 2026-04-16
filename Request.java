/**
 * Request.java
 * Represents a single parsed protocol message received over the network.
 */
public class Request {

  /** The message type token. */
  private final String type;
  /** Everything that comes after the '|'. */
  private final String payload;
  /** The display name of the client that sent the message. */
  private final String sender;

  /** 
   * Private constructor
   *
   * The callers must gp through parse().
   *
   * @param the extracted message type
   * @param the extracted payload (can not be null)
   * @param the name of the client that sent the message
   */
  private Request(String type, String payload, String sender) {
    this.type    = type;
    this.payload = payload;
    this.sender  = sender;
}

  /**
   * Method to parse a raw message line into a Request object.
   *
   * Uses Protocol's helper methods to extract the type and payload
   * this allows the message format to be defined in one place only.
   */
  public static Request parse(String rawMessage, String sender) {
    String type    = Protocol.getType(rawMessage);
    String payload = Protocol.getPayload(rawMessage);
    return new Request(type, payload, sender);
}

  /**
   * Returns true if this message is a math calculation REQUEST.
   *
   */
  public boolean isRequest() {
    return Protocol.REQUEST.equals(type);
}
  /**
   * Returns true if this message is a QUIT signal.
   *
   */ 
  public boolean isQuit() {
    return Protocol.QUIT.equals(type);
}
  /**
   * Returns true if this message is the initial JOIN.
   *
   */
  public boolean isJoin() {
    return Protocol.JOIN.equals(type);
}
  /**
   * Returns the message type string.
   *
   */
  public String getType() {
    return type;
}
  /**
   * Returns the payload.
   * For REQUEST -> a math expression
   * For QUIT -> the client name
   */
  public String getPayload() {
    return payload;
}
  /**
   * Returns the display name of the client who sent the message.
   */
  public String getSender() {
    return sender;
}

/** 
 * Debug helper
 * Returns summary of the request
 */
@Override
public String toString() {
    return "Request{type=" + type
         + ", payload='" + payload + "'"
         + ", sender='" + sender + "'}";
}

}
