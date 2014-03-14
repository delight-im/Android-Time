# Android-Time

Library for displaying locale-specific time in Android

## Installation

 * Create a new library project from this repository and reference it in your project

## Usage

### RelativeTime

```
String formattedTime;

formattedTime = RelativeTime.fromTimestamp(getResources(), 1394804793000L);
// formattedTime could now be <45 minutes ago>

formattedTime = RelativeTime.fromMilliseconds(getResources(), -435000);
// formattedTime is now <7 minutes ago>

formattedTime = RelativeTime.fromSeconds(getResources(), 15300);
// formattedTime is now <in 4 hours>

formattedTime = RelativeTime.fromMinutes(getResources(), -3240);
// formattedTime is now <2 days ago>
```

## Contribute

If you want to translate existing phrases or add new ones, please do so on our platform for managed translations:

[Android-Time on Localize](http://www.localize.io/v/3p)

## License

```
Copyright 2014 www.delight.im <info@delight.im>

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

  http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```