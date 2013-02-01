monster-mash-team-effort
========================

Getting the project to run
--------------------------

- Create new Netbeans Java Web project from existing sources
- Set Location to N06/src/Main
- Make sure project name is Main
- Set Web Pages to N06/src/Main/web
- Set WEB-INF to N06/src/Main/web/WEB-INF
- Set Libraries to N06/lib
- Finish
- Switch to services tab, right click JavaDB and create database
- Call it monsters with username/password APP
- Switch back to Project tab
- Delete META-INF folder in Source Packages
- Right click project, create New > Persistence > Persistence Unit
- Change name to monsters
- Change Provider to Hibernate (JPA 1.0)
- Click arrow on right hand side for new data source, name to MMDB5
- Change connection to monsters [APP on APP]
- Finish
- Edit the persistence.xml with transaction-type="RESOURCE_LOCAL"
- Add underneath jta-data-source:

&lt;class&gt;databaseManagement.MyUser&lt;/class&gt;

&lt;class&gt;databaseManagement.Monster&lt;/class&gt;

&lt;class&gt;databaseManagement.Friends&lt;/class&gt;

&lt;class&gt;databaseManagement.Requests&lt;/class&gt;

- Run project

Read this first
---------------

The RESOURCES FOLDER is for things that might be useful that don't
go in the project directory because they are either compiled code, not
our work or PDFs/JARs etc.

Directory structure as established, I've merged the ref folder into 
the resources folder ben made, because it seemed pointless to have
two folders for what I'm pretty sure is the same thing.

Anything else outside the N06 directory will also not be included in
the final project.
This README is also not part of the project, just an easy way to
leave everyone notes.

Using Git from the command line
-------------------------------

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
   You then need to tell git what you want to commit to your repository.
   If you want to add the changes from a particular file you need to add them to 
   git. To do this you use the 
   "git add <file>" command. (you may find "git add ." useful to add all of the changes.
   The changes that are added are called "staged". The changes that are not added are called
   "unstaged".
   Then type "git commit" this will take a snapshot of the staged changes in the repository 
   and save it to your personal repository.
   You will then have to type a commit message. These changes will only affect you at the
   moment!

7) When you are ready to share your code with the rest of the group. (ie. it is working 
   with something new added.)
   Open a terminal and change directory into the monster-mash-team-effort directory. Then
   type "git commit", and describe the changes as above. (If you haven't already!). Then type
   "git push" this will save all of your changes (code and commit messages) to the central 
   server!


Good luck everyone!
