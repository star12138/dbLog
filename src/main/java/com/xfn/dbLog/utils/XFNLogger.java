package com.xfn.dbLog.utils;

import org.slf4j.Logger;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Created by po on 8/20/16.
 */
public class XFNLogger {
	public static void warn (final String s1, final String s2, Logger logger) {
		logger.warn(s1);
		logger.warn(s2);
	}

	public static void warnWithStack (Exception e, Logger logger) {
		StringWriter sw = new StringWriter();
		e.printStackTrace(new PrintWriter(sw, true));
		logger.warn(sw.toString());
	}

	public static void warnWithStack (final String s1, Exception e, Logger logger) {
		logger.warn(s1);
		StringWriter sw = new StringWriter();
		e.printStackTrace(new PrintWriter(sw, true));
		logger.warn(sw.toString());
	}

	public static void warnWithStack (final String s1, final String s2, Exception e, Logger logger) {
		logger.warn(s1);
		logger.warn(s2);
		StringWriter sw = new StringWriter();
		e.printStackTrace(new PrintWriter(sw, true));
		logger.warn(sw.toString());
	}

	public static void errorWithStack (final String s1, final String s2, Exception e, Logger logger) {
		logger.error(s1);
		logger.error(s2);
		StringWriter sw = new StringWriter();
		e.printStackTrace(new PrintWriter(sw, true));
		logger.error(sw.toString());
	}
}
