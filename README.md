# Milestone 1 - Sanctuary (Unit 7)
## User Features (Required and Optional)


**Required features:**
1. Users can create a create a new account. The profile should contain information such as name, contact details, and information pertaining to an animal(lost/found/seen).
2. User authentication to ensure that user data and lost pet listings are secure.
3.  Pet owners can upload details about their lost pet including pet’s name, photo of pet, description of the pet, date lost, area lost.
5. Pet owners/Pet discoverers can upload details about a pet  (lost/found/seen) such as photos of the pet, descriptions, specifying the date and area the pet was (lost/found/seen), and the info of animal local animal services involved(Animal shelters/rescues,ASPCA).
    
7. Users can scroll feed of missing pets.
    *  Users  search for pet based on parameters such as animal type, animal color, location found/lost,without.
    *  Users can view details screen with more information about pet. 
8. Pet owners can provide proof of ownership such as vet records, photos, or ownership documents.
10. User update post if pet had been found.
12. Privacy control – users can decide if their contact information is visible to everyone.

**Optional features:**
1.* Pet discoverers are required to turn animal over to local animal rescue/shelter, and provide information of such
2.  Chat/messaging System – pet owners and discoverers can communicate within the app to share additional information and arrange meetings for pet return.
3. Users can be alerted about new pet listings that match their criteria.
4. Multi-language - Users can view posts in English, Spanish, Chinese or French (most popular US languages).
5. Reward system – implement a monetary reward system to encourage users to help find missing pets. Pet owners can choose the reward amount and pay using the app.
6. Users can leave reviews and ratings for successful or unsuccessful reunions. This helps identify reliable and helpful persons when dealing with lost pet situations.


## Screen Archetypes
**1. Login Screen** - User can login(screen is also shown when they log out.)  
* phone number/ email
* password

**2. Registration Screen** - User can create a new account.
* username 
* phone number/ email 
* password

**3. Lost Animal Feed** -  User can see a chronological feed of lost animals, yet to be found, updated by owners of lost pets.
* photo of animal 
* pet's name 
* date lost
* location lost


**4. Found Animal Stream** - User can see a  chronological feed of animals found, updated by users who have found pets.
* photo of animal 
* Area found
* Animal service used
* pet's name (if animal has a name/tag or collar)

**5. Search Animal Screen** - users can search for lost pets to filter found and lost stream.
* what can be filtered
    * type of pet
    * color of pet
    * date lost/found
    * location lost/found

**6. Pet Information Upload Screen** - pet owners/discoverers can upload necessary details about lost/found pets to add to display in appropriate stream stream.


**7. Proof of Ownership Upload Screen** - This screen allows pet owners to upload proof of ownership documents such as text describing their lost pet, additional photos of pet, vet records. *Stretch Features: videos of pet and map for geotagging.)

**9.Proof Ownership Screen** - Pet discoverer can view proof of ownership by possible owners. They can also add additional information to help pet owner verify their missing(Pictures/Videos of animal, details for identifying animal, *Stretch feature: Map displaying approximate location of found animal??* )
  
**10. Profile Screen** - user can view and edit profile information including name, photo, contact details, additional details. Privacy controls can be edited here.

**11. Update Lost Pet Status Screen** - Pet owners can update the status of their lost pet to indicate if they have been found.(Can add details such as where and when found and by who)


**12. Detail Screen** - The user will see all the details of both the owner and the lost pet
* included details
    * user
        * name 
        * perferred way of contact
        * desired ownership proof for pet
    * pet
        * name/collar/tag
        * last seen location (address)
        * date lost
        * pictures of pet
        * pet type 
        * lost/Found Status
        * Animal rescue service/Shelter/Practice if applicable

## Documenting Navigation Flows

> [name=IsaiahB: I think these 3 should all be one screen. Like the user would be able to upload all the details of the pet including rather its found or lost. All that will show up in the Search Animal screen. Then after tapping in the Search Animal screen the user will be directed to the Detail screen for more in depth details of the pet.]
* Lost Pet Listing Screen
* Found Pet Listing Screen
* Discover Pet Listing Screen


**Tab Navigation (Tab to Screen)**
* Profile Screen
* Review/Ratings Screen
* Discover Pet Listing Screen
* Search Animal Screen

**Flow Navigation (Screen to Screen)**
* Login Screen
    * Register Screen
    * Search Animal Screen
* Registration Screen
    * Login Screen
    * Search Animal Screen
* Profile Screen
    * Update Lost Pet Status Screen
    * Proof of Ownership Upload Screen
    * Proof Verification Screen
    * Lost Pet Listing Screen
    * Found Pet Listing Screen
* Search Animal Screen
    * Detail Screen
## WireFrame

![Hand-Drawn-Frames](https://i.imgur.com/E3Xdg5E.jpeg)
(https://imgur.com/2qP0yfp.png)
(https://imgur.com/ro16cOL.png)


# Milestone 2 - Build Sprint 1 (Unit 8)
## GitHub Project board
[https://imgur.com/cBAG8QS]

## Issue cards
**Completed**
[https://imgur.com/YBdusg7]

**To Do**
[https://imgur.com/l3wlLPh]

## Issues worked on this sprint
* Created Pet object
* Created Recycler view for listing basic pet info
* Created a form for uploading pet info
* Created a screen for showing more details about pets
  
[https://imgur.com/a/uIAYlru]

<br>

# Milestone 3 - Build Sprint 2 (Unit 9)

## GitHub Project board

[Add screenshot of your Project Board with the updated status of issues for Milestone 3. Note that these should include the updated issues you worked on for this sprint and not be a duplicate of Milestone 2 Project board.] <img src="https://imgur.com/a/A4bMvqR.png" width=600>
![image](https://github.com/Android-App-Dev-Fall-23/Sanctuary/assets/104771992/4efb1792-9a95-43ff-b6b7-87bbc2f6627f)
![image](https://github.com/Android-App-Dev-Fall-23/Sanctuary/assets/104771992/fc50d905-4619-497d-ab67-d357d1c0083a)



## Completed user stories

- List the completed user stories from this unit
- List any pending user stories / any user stories you decided to cut
from the original requirements
-Completed Found Animal Screen. However, decided to cut from original requirements. There is one stream of lost pets. When an animal is found it will be deleted from the screen.
- Created a separate screen to search for lost pets. But this was cut from original requirements.
- Added search functionality to Lost Screen.
- Added ability to delete a pet from Lost screen once it is found.
- Added Data Persistence to Sanctuary app so lost pets will be displayed even when app is closed, unless deleted.
- Added styling and coloring to customize app.

[Add video/gif of your current application that shows build progress]
<img src="https://i.imgur.com/thDL3ln.gif" width=600>

## App Demo Video

- Embed the YouTube/Vimeo link of your Completed Demo Day prep video
