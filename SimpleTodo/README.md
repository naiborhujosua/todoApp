# Pre-work - *SimpleTodo*

**SimpleTodo** is an android app that allows building a todo list and basic todo items management functionality including adding new items, editing and deleting an existing item.

Submitted by: **Josua Antonius Naiborhu**

Time spent: **2** hours spent in total

## User Stories

The following **required** functionality is completed:
* [x] User can **successfully add and remove items** from the todo list
* [x] User can **tap a todo item in the list and bring up an edit screen for the todo item** and then have any changes to the text reflected in the todo list.
* [x] User can **persist todo items** and retrieve them properly on app restart

The following **optional** features are implemented:

* [ ] Persist the todo items [into SQLite](http://guides.codepath.com/android/Persisting-Data-to-the-Device#sqlite) instead of a text file
* [ ] Improve style of the todo items in the list [using a custom adapter](http://guides.codepath.com/android/Using-an-ArrayAdapter-with-ListView)
* [ ] Add support for completion due dates for todo items (and display within listview item)
* [ ] Use a [DialogFragment](http://guides.codepath.com/android/Using-DialogFragment) instead of new Activity for editing items
* [ ] Add support for selecting the priority of each todo item (and display in listview item)
* [ ] Tweak the style improving the UI / UX, play with colors, images or backgrounds
## Video Walkthrough

Here's a walkthrough of implemented user stories:

<img src='todoapp.gif' title='Gif Walkthrough' width='' alt='GIF Walkthrough' />

GIF created with [LiceCap](http://www.cockos.com/licecap/).
## Notes
Describe any challenges encountered while building the app.

*Building good UI/UX and implementing functional application for solving real problem surrounding us*

## Project Analysis

As part of your pre-work submission, please reflect on the app and answer the following questions below:

**Question 1:** "What are your reactions to the Android app development platform so far? Compare and contrast Android's approach to layouts and user interfaces in past platforms you've used."

**Answer:** I think Android development has been leading in the era of mobile first. The way of opening application all the time is using android app. Most of the users around thee world are using android and this is the opportunity for making impact through solving some real problem surrounding us.

**Question 2:** "Take a moment to reflect on the `ArrayAdapter` used in your pre-work. How would you describe an adapter in this context and what is its function in Android? Why do you think the adapter is important? Explain the purpose of the `convertView` in the `getView` method of the `ArrayAdapter`."

**Answer:** ArrayAdapter is the class provided by Android Framework for manipulating data. adapter is extremely important because it reduce the usage of memory because if there is a new data it will be created from the old one. The purpose of convertView as parameter in the getView is to reuse the old object for manipulating data with the new one.

## License

    Copyright [2017] [Josua Antonius Naiborhu]

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
