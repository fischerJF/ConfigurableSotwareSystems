//

package net.sf.zipme;



import java.io.IOException;

import specifications.Configuration;



/**
 * Thrown during the creation or input of a zip file.
 * 
 * @author Jochen Hoenicke
 * @author Per Bothner
 * @status updated to 1.4
 */
public class ZipException extends IOException {
  /**
   * Compatible with JDK 1.0+.
   */
  private static final long serialVersionUID = 8000196834066748623L;

  /**
   * Create an exception without a message.
   */
  public ZipException() {
  if (Configuration.BASE){
    }
  }

  /**
   * Create an exception with a message.
   * 
   * @param msg
   *            the message
   */
  public ZipException(String msg) {
    super(msg);
  if (Configuration.BASE){
    }
  }
}
