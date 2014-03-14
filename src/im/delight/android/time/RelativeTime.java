package im.delight.android.time;

/**
 * Copyright 2014 www.delight.im <info@delight.im>
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import android.content.res.Resources;

/** Returns relative time in locale-specific format */
public class RelativeTime {

	/**
	 * Returns a locale-specific string indicating the relative time
	 * 
	 * @param resources the Resources reference to get the strings from
	 * @param timeInMillis the timestamp in milliseconds since January 1, 1970
	 * @return the relative time in locale-specific format
	 */
	public static String fromTimestamp(Resources resources, long timeInMillis) {
		int minutes = (int) ((timeInMillis - System.currentTimeMillis()) / 1000 / 60);
		return fromMinutes(resources, minutes);
	}
	
	/**
	 * Returns a locale-specific string indicating the relative time
	 * 
	 * @param resources the Resources reference to get the strings from
	 * @param milliseconds the number of milliseconds to display
	 * @return the relative time in locale-specific format
	 */
	public static String fromMilliseconds(Resources resources, int milliseconds) {
		return fromSeconds(resources, milliseconds / 1000);
	}
	
	/**
	 * Returns a locale-specific string indicating the relative time
	 * 
	 * @param resources the Resources reference to get the strings from
	 * @param seconds the number of seconds to display
	 * @return the relative time in locale-specific format
	 */
	public static String fromSeconds(Resources resources, int seconds) {
		return fromMinutes(resources, seconds / 60);
	}
	
	/**
	 * Returns a locale-specific string indicating the relative time
	 * 
	 * @param resources the Resources reference to get the strings from
	 * @param minutes the number of minutes ago to display
	 * @return the relative time in locale-specific format
	 */
	public static String fromMinutes(Resources resources, int minutes) {
		// prepare variables keeping the quantity string's resource ID and the number value to fill in
		final int pluralResourceID;
		final int numberValue;

		// time in the past (x minutes ago)
		if (minutes < 0) {
			if (-minutes < 60) {
				pluralResourceID = R.plurals.x_minutes_ago;
				numberValue = -minutes;
			}
			else if (-minutes < 1440) {
				pluralResourceID = R.plurals.x_hours_ago;
				numberValue = -minutes / 60;
			}
			else {
				pluralResourceID = R.plurals.x_days_ago;
				numberValue = -minutes / 1440;
			}
		}
		// time in the future (in x minutes)
		else {
			if (minutes < 60) {
				pluralResourceID = R.plurals.in_x_minutes;
				numberValue = minutes;
			}
			else if (minutes < 1440) {
				pluralResourceID = R.plurals.in_x_hours;
				numberValue = minutes / 60;
			}
			else {
				pluralResourceID = R.plurals.in_x_days;
				numberValue = minutes / 1440;
			}
		}

		// return the proper quantity string with the number value filled in
		return resources.getQuantityString(pluralResourceID, numberValue, numberValue);
	}

}
