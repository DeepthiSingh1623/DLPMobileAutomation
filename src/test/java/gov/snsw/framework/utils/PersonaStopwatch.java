package gov.snsw.framework.utils;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.remote.RemoteWebDriver;


/**
 * A simple stopwatch used for timing and reporting of transactions in the
 * Perfecto Persona report with millisecond accuracy.
 */
public class PersonaStopwatch {
	RemoteWebDriver driver;
	
  /**
   * The name as shown in the logs.
   */
  final String stopwatchName;

  /**
   * The
   */
  final String stopwatchDescription;

  /**
   * The error threshold. If the duration exceeds this, it is flagged in the
   * log as a failure.
   */
  final long stopwatchErrorThreshold;

  /**
   * The start time, in milliseconds.
   */
  long startTime;

  /**
   *
   * @param name
   * @param description
   */
  public PersonaStopwatch(final RemoteWebDriver theDriver, final String name, final String description) {
    this(theDriver, name, description, 300000);
  }

  /**
   * Create a new stopwatch.
 * @param theDriver 
   *
   * @param name
   *          The name as shown in the perfecto and Test NG logs.
   * @param description
   *          The description as shown in the perfecto and Test NG logs.
   * @param errorThreshold
   *          An error threshold, above which, the duration is flagged as an
   *          error.
   */
  public PersonaStopwatch(RemoteWebDriver theDriver, final String name, final String description, final long errorThreshold) {
    driver = theDriver;
	stopwatchName = name;
    stopwatchDescription = description;
    stopwatchErrorThreshold = errorThreshold;
    reset();
  }

  /**
   * Log this timer. This can be called multiple times and will add a .
   *
   * @return this timer.
   */
  public PersonaStopwatch log() {
    final long endTime = System.currentTimeMillis();
    final long duration = endTime - startTime;

    final Map<String, Object> params = new HashMap<>(7);
    params.put("result", duration);
    params.put("threshold", stopwatchErrorThreshold);
    params.put("description", stopwatchDescription);
    params.put("name", stopwatchName);
    driver.executeScript("mobile:status:timer", params);

    return this;
  }

  /**
   * Reset the timer, starting it again from the current time.
   *
   * @return this timer.
   */
  public PersonaStopwatch reset() {
    startTime = System.currentTimeMillis();
    return this;
  }
}

