# TestVagrantAssignment
Create an in-memory store for recently played songs that can accommodate N songs per user, with a fixed initial capacity. This store must have the capability to store a list of song-user pairs, with each song linked to a user. It should also be able to fetch recently played songs based on the user and eliminate the least recently played songs when the store becomes full.
EXAMPLE
Illustration, when 4 different songs were played by a user & Initial capacity is 3: 
Let's assume that the user has played 3 songs - S1, S2 and S3.
The playlist would look like -> S1,S2,S3
When S4 song is played -> S2,S3,S4 
When S2 song is played -> S3,S4,S2 
When S1 song is played -> S4,S2,S1g Assignment

#Test Cases


Core Functionality Testing: 

TC1:
Initial capability:-1

TC2:
Initial capability:0

TC3:
Initial capbility: 1

TC4:
Playing songs > initial capability

TC5:
Playing songs = initial capability

TC6:
Playing songs < initial capability

Code Workflow Testing:

Positive Test Cases:
TC7: 
Step 1:Entering users and songs
Step 2:Querying all users recent songs
Step 3:Querying single user recent songs
Step 4:Exit

TC8: 
Step 1:Entering users and songs
Step 2:Querying all users recent songs
Step 3:Querying single user recent songs
Step 4:Repeat step 1 to step 3 (Without changing initial capability)
Step 5:Exit

TC9:
Step 1:Entering users and songs
Step 2:Querying all users recent songs
Step 3:Querying single user recent songs
Step 4:Repeat step 1 to step 3 (Changing initial capability)
Step 5:Exit

Negative Testing:
TC10:
Step 1:Querying all users or single user recent songs(without giving any entries)
Step 2:Exit

TC11:
Step 1:Entering users and songs
Step 2:Querying single user recent songs(Wrong user name)


TC12: 
Step 1:Giving TypeMismatch input

TC13: 
Step 1:Giving wrong choice as input from the menu
