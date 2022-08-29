Libraries Used
==============

DAGGER 2
------
Many Android apps rely on instantiating objects that often require other dependencies. For instance,
a Twitter API client may be built using a networking library such as Retrofit. To use this library,
you might also need to add parsing libraries such as Gson. In addition, classes that implement
authentication or caching may require accessing shared preferences or other common storage,
requiring instantiating them first and creating an inherent dependency chain.

I have used Dagger 2 as it analyzes these dependencies for you and generates code to help wire them
together. While there are other Java dependency injection frameworks, many of them suffered
limitations in relying on XML, required validating dependency issues at run-time, or incurred
performance penalties during startup. Dagger 2 relies purely on using Java annotation processors and
compile-time checks to analyze and verify dependencies. It is considered to be one of the most
efficient dependency injection frameworks built to date.


Coroutines
----------
On Android, it's essential to avoid blocking the main thread. The main thread is a single thread
that handles all updates to the UI. It's also the thread that calls all click handlers and other UI
callbacks. As such, it has to run smoothly to guarantee a great user experience.

Overall, Coroutines make multitasking very easy.

So, we can say that Coroutines and the threads, both are multitasking. But the difference is that
threads are managed by the OS and coroutines managed by the users as it can execute a few lines of
function by taking advantage of the cooperation contained within a coroutine

It's an optimised framework written over the actual threading by taking advantage of the cooperative
nature of functions to make it light and yet powerful. So, we can say that Coroutines are
lightweight threads, a pool of threads if you will. A lightweight thread means it doesn’t map on the
native thread, so it doesn’t require context switching on the processor, so they are faster.

Retrofit
--------
Networking is a crucial factor in mobile development. Most, if not all mobile applications
incorporate networking on some level. Applications are either sending or receiving information.
Initially, developers did networking on the main thread. This made applications less user-friendly
since screens would “freeze”.

Retrofit is a type-safe HTTP networking library used for Android and Java. Retrofit was even better
since it was super fast, offered better functionality, and even simpler syntax. Most developers
since then have switched to using Retrofit to make API requests.

ViewModel
---------
The ViewModel is essential when we want a separation of concerns between your DomainModel
(DataModel) and the rest of your code. The less dependencies I have between the Model, View and
Controller the easier down the line it will be to make changes to the DomainModel without breaking
the interface contracts in the View and Controller. But once again it's something to be
pragmatic. I like the approach as code re-factoring is a big part of general Android development -
refactoring may include a simple spelling mistake on a property of a Model - that change could ripple
through the code to the Contract level if the dependencies are not separated


