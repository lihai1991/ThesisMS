# Task 1: Code Management System

## Git Source Code Management

Git is a popular source code management system.
Every Git working directory is a full-fledged repository, with complete history and full version tracking capabilities, not dependent on network access or a central server.
In this sense, it trades off space for speed.
Git is primarily developed on Linux, although it also supports most major operating systems including BSD, OS X, and Microsoft Windows.
Pertinent information about Git can be found on the project website.

* http://git-scm.com/

### Action Items

* __Read:__ Git documentation.
http://git-scm.com/doc/
* __Complete:__ Try git tutorial.
https://try.github.io/levels/1/challenges/1
* __Download and Install:__ Git (if needed).
http://git-scm.com/downloads


## GitHub

GitHub is a web-based hosting service for source code management (SCM).
It is built on the Git revision control system and offers free accounts for open source projects.
According to the terms of service, if bandwidth usage of an account significantly exceeds the average of other GitHub customers, the associated file hosting service may be immediately disabled.
To facilitate integration of our projects, we will employ a Git archive.
Your master Git repository is hosted on GitHub.

* https://github.com/lihai1991/ThesisMS.git

You will find below a short list of frequently used commands.

### Common Actions

* __Init:__ The init command creates a new local repository.
* __Clone:__ Use clone to instantiate a working copy from a master repository. This is usually the first command employed to establish a local working hierarchy under this paradigm. Within Eclipse, you may use the Git Repository Exploring perspective to clone a master repository.
* __Add:__ The add command is used to add one or more files to staging. Only add pertinent files to the repository.
* __Push:__ The push command sends changes to the master branch, typically a remote repository.
* __Pull:__ The pull command fetches and merges changes on the remote server to the local working directory.
* __Mergetool:__ Sometimes, there may be a discrepancy between the latest version of a file and its working copy on a given host. In such cases, the developer may need to take action to resolve these issues. This can be achieve through normal editing, followed by the Git add command. Alternatively, one can use the mergetool command, which initiates a visual tool.
* __Status:__ The status command lists the status of working files and directories.

