LaunchCanDoGram - Hello World Edition
----

This is a super minimal example of a bot that has two commands. To use this bot, you'll need the actual CanDoGram artifacts, which you can find [here](https://github.com/EvanKnowles/CanDoGram).

The `/hello` command takes no parameters and greets the user politely, then as a bonus sends the user a picture of a cat.

The `/dice` command takes one parameter of the form `XdY`, where X is a number representing how many dice should be rolled, and Y represents how many dice should be rolled.

This bot can be launched by deploying it into a Java EE compatible container. It's only been tested on WIldfly 13 though.

But it works fine. 