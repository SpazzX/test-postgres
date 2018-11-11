package com.ngu.postgresing.utility;

import java.util.Properties;

/**
 * Application Cache that will be populated on startup.  All application features with their respective settings
 * will be loaded into a Properties on startup for retrieval throughout the application.
 *
 * @author modonnell
 */
public interface AppCache
{
    public Properties getApplicationSettings();
}
