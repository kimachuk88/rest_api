package com.epam.mentorship.service.utilities;

/**
 * Created by Uliana Pizhanska on 27/04/2017.
 */

import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.Layout;
import org.apache.log4j.spi.LoggingEvent;
import org.testng.Reporter;

public class ReportAppender extends AppenderSkeleton {


    @Override
    protected void append(LoggingEvent event) {

        String log = getLayout().format(event);
        log = log.replace("\n", "</br>");
        Reporter.log(log, false);

    }

   /* @Override
    protected void append(final LoggingEvent event)
    {
        Reporter.log(eventToString(event));
    }*/

    private String eventToString(final LoggingEvent event)
    {
        final StringBuilder result = new StringBuilder(layout.format(event));

        if(layout.ignoresThrowable())
        {
            final String[] s = event.getThrowableStrRep();
            if (s != null)
            {
                for (final String value : s)
                {
                    result.append(value).append(Layout.LINE_SEP);
                }
            }
        }
        return result.toString() + "</br>";
    }

    public void close() {

    }

    public boolean requiresLayout() {
        return true;
    }
}
