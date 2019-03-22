# game-scoreboard-ui

A Website in ClojureScript to consume data from the [Game Scoreboard API](https://github.com/practicalli/game-scoreboard) and visualise it.

## Overview

A project to show the different options for calling and consuming data from API's, specifically the [Game Scoreboard API](https://github.com/practicalli/game-scoreboard).

## Development

Open this project in your favourite Clojure editor/IDE and run the ClojureScript repl using `figwheel-main` and the `dev` profile

### Spacemacs

`, "` or `M-RET "` in a buffer with a ClojureScript file will start a ClojureScript REPL.

Choose `figwheel-main` when prompted to select the ClojureScript REPL type.

Enter `dev` when prompted to select the figwheel-main build.

Open the REPL buffer (use `SPC b b` to list the available buffers) and enter the following code to test the REPL connection is working well.

    (js/alert "Am I connected?")

### Command line

To get an interactive development environment run:

    lein fig:build

This will auto compile and send all changes to the browser without the
need to reload. After the compilation process is complete, you will
get a Browser Connected REPL. An easy way to try it is:

    (js/alert "Am I connected?")

and you should see an alert in the browser window.

To clean all compiled files:

    lein clean

To create a production build run:

    lein clean
    lein fig:min


## License

Copyright © 2018 Practicalli

Distributed under the Creative Commons Attribution Share-Alike 4.0 International
