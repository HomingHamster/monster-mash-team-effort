monster-mash-team-effort
========================

Read this first
---------------

I've created all of the directories mentioned the the specification.
I've created a .gitignore file to ignore the build, bin and dist
directories that might be created by an IDE.
I've left the ref folder outside the project's root directory, this 
is for the simple reason that it should not be included in its
current state in the project itself.
Anything else outside the N06 directory will also not be included in
the final project.
This readme is also not part of the project, just an easy way to
leave everyone notes.

Using Git
---------

A few of the most useful functions are included below.

Install git first according to this guide.
https://help.github.com/articles/set-up-git

Take the crash course if necessarry.

Follow the set up section on the link above to make sure you have
put in all the correct information.

To begin using git for our project... (the command line way)

1) Open a terminal.

2) Change directory into the directory you want to keep your version of the program.

3) Use the command "git clone https://github.com/HomingHamster/monster-mash-team-effort.git".
   This will create a directory called monster-mash-team-effort. The root directory for the
   project is N06 which is inside!

4) You may have to input your username and password.

5) If I havn't missed anything you should then be able to edit the project folder. Before
   you start working on the project (every time you want the updated project). Open a 
   terminal and change directory into the monster-mash-team-effort directory. Then type 
   "git pull". This will update your personal repository and help you sort out any conflicts.

6) When you have achieved any small goal. Open a terminal and change directory into the
   monster-mash-team-effort directory.
   If you have ADDED FILES you need to add them to git (so it can manage them). use the 
   "git add <file>" command. (you may find "git add ." useful to add all of them.
   Then type "git commit" this will take a snapshot and save it to your personal repository.
   You will then have to type a commit message. These changes will only affect you!

7) When you are ready to share your code with the rest of the group. (ie. it is working 
   with something new added.)
   Open a terminal and change directory into the monster-mash-team-effort directory. Then
   type "git commit", and describe the changes as above. (If you haven't already!). Then type
   "git push" this will save all of your changes (code and commit messages) to the central 
   server!


Good luck everyone!